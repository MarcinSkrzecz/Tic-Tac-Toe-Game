package com.kodilla.TTT.game;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.Random;

public class TTTApplication extends Application {

    public char player1_X_O;
    public char player2_X_O;
    public boolean X_MoveFirst;
    public boolean gameVsHuman;

    public char whoMoveNow;
    public Tile[][] tiles = new Tile[3][3];
    public int player1Points = 0;
    public int player2Points = 0;

    Button newGameButton = new Button("New Game");
    Button newGameYes = new Button("Yes");
    Button newGameNo = new Button("No");
    Button nextRoundButton = new Button("Next round");
    Button choseXOrO = new Button("Choose Your X or O");
    Button xStartGame = new Button("X");
    Button oStartGame = new Button("O");
    Button chooseWhoStart = new Button("Choose who start:");
    Button playerChooseX = new Button("X");
    Button playerChooseO = new Button("O");
    Button chooseRival = new Button("Chose Rival");
    Button vsPlayer = new Button("PvP");
    Button vsComputer = new Button("PvC");
    Button startGame = new Button("Start Game");
    GridPane gridPane = new GridPane();
    PlayersPointsTile playersPointsTile = new PlayersPointsTile();

    @Override
    public void start(Stage primaryStage) {
        Buttons buttons = new Buttons();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tiles[i][j] = new Tile();

                gridPane.add(tiles[i][j], i, j);
            }
        }

        gridPane.setDisable(true);

/*
        Set<Tile> tileStream = gridPane.getChildren().stream()
                .filter(node -> {
                    if (node instanceof Tile) {
                        return true;
                    }
                    return false;
                })
                .map(node -> (Tile) node)
                .collect(Collectors.toSet());
 */

//Buttony
        buttons.generateNewGameButton(newGameButton, newGameYes, newGameNo);

        buttons.generateChooseYesButton(newGameYes);
        newGameYes.setOnAction(click -> {
            clearBoard();
            player1Points = 0;
            player2Points = 0;
            playersPointsTile.changePoints();
            buttons.simplifyYesInside(gridPane,newGameYes,newGameNo,nextRoundButton,choseXOrO,playerChooseX,
                    playerChooseO,chooseWhoStart,xStartGame,oStartGame,chooseRival,vsPlayer,vsComputer,startGame);
        });
        buttons.generateChooseNoButton(newGameNo, newGameYes);
        HBox hBoxYesNo = new HBox(newGameYes, newGameNo);

        nextRoundButton.setPrefSize(175, 50);
        nextRoundButton.setDisable(true);
        nextRoundButton.setOnAction(click -> {
            clearBoard();
            gridPane.setDisable(false);
            nextRoundButton.setDisable(true);
            nextRoundButton.setStyle("-fx-stroke: 1");
        });

        buttons.generateUpperChooseButton(choseXOrO, 25,false);
        choseXOrO.setStyle("-fx-background-color: yellow");
        buttons.generateChooseButton(playerChooseX,50,50,25,0,false);
        playerChooseX.setOnAction(click -> {
            buttons.shortActionXOrOButtons(choseXOrO,playerChooseX,playerChooseO,chooseWhoStart,xStartGame,oStartGame);
            player1_X_O = 'X';
            player2_X_O = 'O';
        });
        buttons.generateChooseButton(playerChooseO,50,50,50,0,false);
        playerChooseO.setOnAction(click -> {
            buttons.shortActionXOrOButtons(choseXOrO,playerChooseO,playerChooseX,chooseWhoStart,xStartGame,oStartGame);
            player1_X_O = 'O';
            player2_X_O = 'X';
        });
        HBox hBoxForXO = new HBox(playerChooseX, playerChooseO);
        buttons.makeHbox(hBoxForXO, 25);

        buttons.generateUpperChooseButton(chooseWhoStart,50,true);
        buttons.generateChooseButton(xStartGame,50,50,25,25,true);
        xStartGame.setOnAction(click -> {
            buttons.shortActionWhoStartButtons(choseXOrO,playerChooseX,playerChooseO,chooseWhoStart,xStartGame,oStartGame,chooseRival,vsPlayer,vsComputer);
            X_MoveFirst = true;
        });
        buttons.generateChooseButton(oStartGame,50,50,50,25,true);
        oStartGame.setOnAction(click -> {
            buttons.shortActionWhoStartButtons(choseXOrO,playerChooseX,playerChooseO,chooseWhoStart,oStartGame,xStartGame,chooseRival,vsPlayer,vsComputer);
            X_MoveFirst = false;
        });
        HBox hBoxForWhoStart = new HBox(xStartGame, oStartGame);
        buttons.makeHbox(hBoxForWhoStart, 25);

        buttons.generateUpperChooseButton(chooseRival,75,true);
        buttons.generateChooseButton(vsPlayer,75,50,0,25,true);
        vsPlayer.setOnAction(click -> {
            buttons.shortActionEnemyButtons(chooseWhoStart,oStartGame,xStartGame,chooseRival,vsPlayer,vsComputer,startGame);
            gameVsHuman = true;
        });
        buttons.generateChooseButton(vsComputer,75,50,25,25,true);
        vsComputer.setOnAction(click -> {
            buttons.shortActionEnemyButtons(chooseWhoStart,oStartGame,xStartGame,chooseRival,vsComputer,vsPlayer,startGame);
            gameVsHuman = false;
        });
        HBox hBoxForChooseOpponent = new HBox(vsPlayer, vsComputer);
        buttons.makeHbox(hBoxForChooseOpponent, 50);

        buttons.generateStartGameButton(startGame,chooseRival,vsPlayer,vsComputer,gridPane);



        VBox vBoxNaPrawe = new VBox(newGameButton, hBoxYesNo, nextRoundButton, choseXOrO, hBoxForXO, chooseWhoStart,
                                    hBoxForWhoStart, chooseRival, hBoxForChooseOpponent, startGame);
        buttons.makeVBox(vBoxNaPrawe,175,600,50,25);

        HBox hBoxForCount = new HBox(playersPointsTile);
        buttons.makeHbox(hBoxForCount,0);

        VBox vBoxNaLewe = new VBox(gridPane, hBoxForCount);
        buttons.makeVBox(vBoxNaLewe,600,600,25,25);

        HBox hBox = new HBox(vBoxNaLewe, vBoxNaPrawe);
        hBox.setStyle("-fx-background-color: LIGHTCYAN");

        Scene scene = new Scene(hBox, 850, 700);

        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);

        primaryStage.show();
    }

    public boolean winCondition(char move) {
        boolean ifWin = false;
        if ((tiles[0][0].getTileStatus() == move && tiles[1][1].getTileStatus() == move && tiles[2][2].getTileStatus() == move) ||
            (tiles[0][2].getTileStatus() == move && tiles[1][1].getTileStatus() == move && tiles[2][0].getTileStatus() == move)) {
            ifWin = true;
        }
        for (int x = 0; x < 3; x++) {
            if ((tiles[x][0].getTileStatus() == move && tiles[x][1].getTileStatus() == move && tiles[x][2].getTileStatus() == move) ||
                (tiles[0][x].getTileStatus() == move && tiles[1][x].getTileStatus() == move && tiles[2][x].getTileStatus() == move)) {
                ifWin = true;
                break;
            }
        }
        return ifWin;
    }

    public void addingColorSimplify(int x, int y) {
        tiles[x][y].getText().setFill(Color.GREEN);
        tiles[x][y].getRectangle().setFill(Color.LIMEGREEN);
    }
    public void addingColorToWinningTiles(char winner) {
        if ((tiles[0][0].getTileStatus() == winner && tiles[1][1].getTileStatus() == winner && tiles[2][2].getTileStatus() == winner) && winner != ' ') {
            addingColorSimplify(0,0);
            addingColorSimplify(1,1);
            addingColorSimplify(2,2);
            return;
        }
        if ((tiles[0][2].getTileStatus() == winner && tiles[1][1].getTileStatus() == winner && tiles[2][0].getTileStatus() == winner) && winner != ' ') {
            addingColorSimplify(0,2);
            addingColorSimplify(1,1);
            addingColorSimplify(2,0);
            return;
        }
        for (int lp = 0; lp < 3; lp++) {
            if ((tiles[lp][0].getTileStatus() == winner && tiles[lp][1].getTileStatus() == winner && tiles[lp][2].getTileStatus() == winner) && winner != ' ') {
                addingColorSimplify(lp,0);
                addingColorSimplify(lp,1);
                addingColorSimplify(lp,2);
                return;
            }
        }
        for (int pl = 0; pl < 3; pl++) {
            if ((tiles[0][pl].getTileStatus() == winner && tiles[1][pl].getTileStatus() == winner && tiles[2][pl].getTileStatus() == winner) && winner != ' ') {
                addingColorSimplify(0,pl);
                addingColorSimplify(1,pl);
                addingColorSimplify(2,pl);
                return;
            }
        }
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tiles[i][j].getTileStatus() == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBoardEmpty() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tiles[i][j].getTileStatus() == 'X' || tiles[i][j].getTileStatus() == 'O') {
                    return false;
                }
            }
        }
        return true;
    }

    public void clearBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tiles[i][j].tileStatus = ' ';
                tiles[i][j].text.setText(null);
                tiles[i][j].getRectangle().setFill(Color.GRAY);
                tiles[i][j].getText().setFont(Font.font("Verdana", FontWeight.BOLD, 70));
                tiles[i][j].getText().setFill(Color.WHITE);

            }
        }
    }

    public String makeMoveText(char move) {
        String text = null;
        if (move == 'X') {
            text = "X";
        } else if (move == 'O') {
            text = "O";
        }
        return text;
    }

    public char makeMoveTileStatus(char move) {
        char tileStatus = ' ';
        if (move == 'X') {
            tileStatus = 'X';
        } else if (move == 'O') {
            tileStatus = 'O';
        }
        return tileStatus;
    }

    public class PlayersPointsTile extends GridPane {
        Label labelPoints = new Label();
        Rectangle pointsCount = new Rectangle(603,65);
        public PlayersPointsTile() {
            pointsCount.setFill(Color.GRAY);
            setAlignment(Pos.CENTER);
            labelPoints.setText("  Player 1 points: " + player1Points + " || Player 2 points: " + player2Points);
            labelPoints.setTextAlignment(TextAlignment.CENTER);
            labelPoints.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
            getChildren().addAll(pointsCount, labelPoints);
        }
        public void changePoints() {
            labelPoints.setText("  Player 1 points: " + player1Points + " || Player 2 points: " + player2Points);
        }
    }

    public class Tile extends GridPane {
        Text text = new Text();
        char tileStatus = ' ';
        Rectangle rectangleTile = new Rectangle(200, 200);

        public Tile() {
            TileClassShortcuts tileClassShortcuts = new TileClassShortcuts();

            tileClassShortcuts.tileAndTextSettings(rectangleTile,text);

            getChildren().addAll(rectangleTile, text);

            setOnMouseClicked(event -> {
                if (gameVsHuman) {
                    playerVsPlayerSettings();
                }
                else {
                    OdpalaczPVC();
                }
            });
        }

        public Rectangle getRectangle() {
            return rectangleTile;
        }

        public char getTileStatus() {
            return tileStatus;
        }

        public Text getText() {
            return text;
        }

        PvPShortcuts pvPShortcuts = new PvPShortcuts();

        private void playerVsPlayerSettings() {
            if (isBoardEmpty()) {
                whoMoveNow = pvPShortcuts.pvpWhoMoveNowSetter(X_MoveFirst);
            }
            if (tileStatus == ' ') {
                text.setText(makeMoveText(whoMoveNow));
                tileStatus = makeMoveTileStatus(whoMoveNow);
            }
            if (winCondition(whoMoveNow)) {
                addingColorToWinningTiles(whoMoveNow);
                if (whoMoveNow == player1_X_O) {
                    player1Points += 1;
                    System.out.println("Player 1 won!");
                } else {
                    player2Points += 1;
                    System.out.println("Player 2 won!");
                }
                playersPointsTile.changePoints();
                whoMoveNow = pvPShortcuts.pvpWhoMoveNowChanger(X_MoveFirst);
                X_MoveFirst = !X_MoveFirst;
                pvPShortcuts.pvpWinStyle(gridPane, nextRoundButton, player1Points, player2Points);
            } else if (isBoardFull()) {
                whoMoveNow = pvPShortcuts.pvpWhoMoveNowChanger(X_MoveFirst);
                X_MoveFirst = !X_MoveFirst;
                pvPShortcuts.pvpDrawStyle(gridPane, nextRoundButton);
            } else if (!winCondition(whoMoveNow) || !isBoardFull()) {
                whoMoveNow = pvPShortcuts.pvpMoveChanger(whoMoveNow);
            }
        }

        PvCShortcuts pvCShortcuts = new PvCShortcuts();
        private void OdpalaczPVC() {
            if (isBoardEmpty()) {
                if (X_MoveFirst) {
                    whoMoveNow = 'X';
                } else {
                    whoMoveNow = 'O';
                }
            }
            if ((player2_X_O == whoMoveNow) && isBoardEmpty()) {
                computerMoveNormalIfPlayerStart();
            } else {
                pvcNormalIfPlayerStart();
            }
        }

        private void pvcNormalIfPlayerStart() {
            boolean playerMadeHisMove = false;
            if (tileStatus == ' ') {
                text.setText(makeMoveText(player1_X_O));
                tileStatus = makeMoveTileStatus(player1_X_O);
                playerMadeHisMove = true;
            }
            if (playerMadeHisMove) {
                computerMoveNormalIfPlayerStart();
            }
        }

        public void computerMoveNormalIfPlayerStart() {

            if(!isBoardFull() && !winCondition(player1_X_O)) {
                Random random = new Random();
                boolean findMove = true;
                while (findMove) {
                    int i = random.nextInt(3);
                    int j = random.nextInt(3);
                    if (tiles[i][j].getTileStatus() == ' ') {
                        tiles[i][j].text.setText(makeMoveText(player2_X_O));
                        tiles[i][j].tileStatus = makeMoveTileStatus(player2_X_O);
                        findMove = false;
                    }
                }
            }

            if (winCondition(player1_X_O) || winCondition(player2_X_O)) {
                if(winCondition(player1_X_O)) {

                    addingColorToWinningTiles(player1_X_O);
                    System.out.println("Player Win");
                    player1Points += 1;
                } else {
                    addingColorToWinningTiles(player2_X_O);
                    System.out.println("Computer win");
                    player2Points += 1;
                }
                playersPointsTile.changePoints();
                X_MoveFirst = !X_MoveFirst;
                pvCShortcuts.pvcWinStyle(gridPane,nextRoundButton, player1Points,player2Points);
            } else if (isBoardFull()) {
                X_MoveFirst = !X_MoveFirst;
                pvCShortcuts.pvcDrawStyle(gridPane,nextRoundButton);
            }
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}