package com.kodilla.TTT.game;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class PvCShortcuts {

    public void pvcWinStyle(GridPane gridPane, Button nextRoundButton, int player1Points, int player2Points) {
        gridPane.setDisable(true);
        nextRoundButton.setDisable(false);
        nextRoundButton.setStyle("-fx-background-color: yellow");
        System.out.println("Player points: " + player1Points + " || Computer Points: " + player2Points);
    }

    public void pvcDrawStyle(GridPane gridPane, Button nextRoundButton) {
        gridPane.setDisable(true);
        nextRoundButton.setDisable(false);
        nextRoundButton.setStyle("-fx-background-color: yellow");
        System.out.println("Draw");
    }
}
