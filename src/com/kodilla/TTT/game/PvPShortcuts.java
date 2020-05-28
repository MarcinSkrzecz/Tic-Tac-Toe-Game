package com.kodilla.TTT.game;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class PvPShortcuts {

    public char pvpWhoMoveNowSetter(boolean X_MoveFirst) {
        if (X_MoveFirst) {
            return 'X';
        } else {
            return 'O';
        }
    }

    public char pvpWhoMoveNowChanger(boolean X_MoveFirst) {
        if (X_MoveFirst) {
            return 'O';
        } else {
            return 'X';
        }
    }

    public void pvpWinStyle(GridPane gridPane, Button nextRoundButton, int player1Points, int player2Points) {
        gridPane.setDisable(true);
        nextRoundButton.setDisable(false);
        nextRoundButton.setStyle("-fx-background-color: yellow");
        System.out.println("Player 1 points: " + player1Points + " || Player 2 Points: " + player2Points);
    }

    public void pvpDrawStyle(GridPane gridPane, Button nextRoundButton) {
        gridPane.setDisable(true);
        nextRoundButton.setDisable(false);
        nextRoundButton.setStyle("-fx-background-color: yellow");
        System.out.println("Draw");
    }

    public char pvpMoveChanger(char whoMoveNow) {
        if (whoMoveNow == 'X') {
            return 'O';
        } else {
            return 'X';
        }
    }

}
