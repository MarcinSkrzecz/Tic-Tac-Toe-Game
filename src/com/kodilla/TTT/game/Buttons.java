package com.kodilla.TTT.game;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Buttons {

    public void generateNewGameButton(Button b0, Button b1, Button b2) {
        b0.setPrefSize(175, 50);
        b0.setOnAction(click -> {
            b1.setDisable(false);
            b1.setVisible(true);
            b2.setDisable(false);
            b2.setVisible(true);
        });
    }
    public void generateChooseYesButton(Button button) {
        button.setPrefSize(75, 25);
        button.setTranslateX(10);
        button.setDisable(true);
        button.setVisible(false);
        button.setStyle("-fx-background-color: RED; -fx-text-fill: WHITE");
    }
    public void simplifyYesInside(GridPane gridPane, Button newGameYes, Button newGameNo, Button nextRoundButton, Button choseXOrO, Button playerChooseX,
                                  Button playerChooseO, Button chooseWhoStart, Button xStartGame, Button oStartGame, Button chooseRival, Button vsPlayer,
                                  Button vsComputer, Button startGame) {

        gridPane.setDisable(true);
        newGameYes.setDisable(true);
        newGameYes.setVisible(false);
        newGameNo.setDisable(true);
        newGameNo.setVisible(false);
        nextRoundButton.setDisable(true);
        nextRoundButton.setStyle("-fx-stroke: 1");
        choseXOrO.setDisable(false);
        choseXOrO.setStyle("-fx-background-color: yellow");
        playerChooseX.setDisable(false);
        playerChooseO.setDisable(false);
        chooseWhoStart.setDisable(true);
        xStartGame.setDisable(true);
        oStartGame.setDisable(true);
        chooseRival.setDisable(true);
        vsPlayer.setDisable(true);
        vsComputer.setDisable(true);
        startGame.setDisable(true);

        playerChooseX.setStyle("-fx-stroke: 1");
        playerChooseO.setStyle("-fx-stroke: 1");
        chooseWhoStart.setStyle("-fx-stroke: 1");
        xStartGame.setStyle("-fx-stroke: 1");
        oStartGame.setStyle("-fx-stroke: 1");
        chooseRival.setStyle("-fx-stroke: 1");
        vsPlayer.setStyle("-fx-stroke: 1");
        vsComputer.setStyle("-fx-stroke: 1");
        startGame.setStyle("-fx-stroke: 1");
    }

    public void generateChooseNoButton(Button no, Button yes) {
        no.setPrefSize(75, 25);
        no.setTranslateX(15);
        no.setDisable(true);
        no.setVisible(false);
        no.setStyle("-fx-background-color: GREEN; -fx-text-fill: WHITE");
        no.setOnAction(click -> {
            yes.setDisable(true);
            yes.setVisible(false);
            no.setDisable(true);
            no.setVisible(false);
        });
    }

    public void generateUpperChooseButton(Button button, int setTranslateY, boolean setDisable) {
        button.setPrefSize(175, 50);
        button.setTranslateY(setTranslateY);
        button.setDisable(setDisable);
    }

    public void generateChooseButton(Button button, int setWidth, int setHeight, int translateX, int translateY, boolean setDisable) {
        button.setPrefSize(setWidth, setHeight);
        button.setStyle("-fx-font-size: 20");
        button.setTranslateX(translateX);
        button.setTranslateY(translateY);
        button.setDisable(setDisable);
    }

    public void shortActionXOrOButtons(Button b0, Button b1, Button b2, Button b3, Button b4, Button b5) {
        b0.setStyle("-fx-stroke: 1");
        b1.setPrefSize(50, 50);
        b2.setPrefSize(50, 50);
        b1.setStyle("-fx-background-color: GREEN; -fx-font-size: 20; -fx-text-fill: WHITE");
        b2.setStyle("-fx-background-color: RED; -fx-font-size: 20; -fx-text-fill: WHITE");
        b3.setDisable(false);
        b3.setStyle("-fx-background-color: yellow");
        b4.setDisable(false);
        b5.setDisable(false);
    }
    public void shortActionWhoStartButtons(Button b0, Button b1, Button b2, Button b3, Button b4, Button b5,Button b6, Button b7, Button b8) {
        b0.setDisable(true);
        b1.setDisable(true);
        b2.setDisable(true);
        b3.setStyle("-fx-stroke: 1");
        b4.setPrefSize(50,50);
        b5.setPrefSize(50,50);
        b4.setStyle("-fx-background-color: GREEN; -fx-font-size: 20; -fx-text-fill: WHITE");
        b5.setStyle("-fx-background-color: RED; -fx-font-size: 20; -fx-text-fill: WHITE");
        b6.setDisable(false);
        b6.setStyle("-fx-background-color: yellow");
        b7.setDisable(false);
        b8.setDisable(false);
    }
    public void shortActionEnemyButtons(Button b0, Button b1, Button b2, Button b3, Button b4, Button b5,Button b6) {
        b0.setDisable(true);
        b1.setDisable(true);
        b2.setDisable(true);
        b3.setStyle("-fx-stroke: 1");
        b4.setPrefSize(75,50);
        b5.setPrefSize(75,50);
        b4.setStyle("-fx-background-color: GREEN; -fx-font-size: 20; -fx-text-fill: WHITE");
        b5.setStyle("-fx-background-color: RED; -fx-font-size: 20; -fx-text-fill: WHITE");
        b6.setDisable(false);
        b6.setStyle("-fx-background-color: yellow");
    }

    public void generateStartGameButton(Button b0, Button b1, Button b2, Button b3, GridPane g0) {
        b0.setPrefSize(175, 50);
        b0.setStyle("-fx-font-size: 20");
        b0.setTranslateX(0);
        b0.setTranslateY(100);
        b0.setDisable(true);
        b0.setOnAction(click -> {
            b1.setDisable(true);
            b2.setDisable(true);
            b3.setDisable(true);
            b0.setDisable(true);
            b0.setStyle("-fx-stroke: 1");
            g0.setDisable(false);
        });
    }


    public void makeHbox(HBox hBox, int translateY) {
        hBox.setPrefSize(175, 50);
        hBox.setTranslateY(translateY);
    }
    public void makeVBox(VBox vbox, int prefWidth, int prefHeight, int translateX, int translateY) {
        vbox.setPrefSize(prefWidth,prefHeight);
        vbox.setTranslateX(translateX);
        vbox.setTranslateY(translateY);
    }
}

