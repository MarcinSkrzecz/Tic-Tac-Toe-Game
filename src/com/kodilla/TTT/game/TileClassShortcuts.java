package com.kodilla.TTT.game;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class TileClassShortcuts extends GridPane {
    public void tileAndTextSettings(Rectangle rectangleTile, Text text) {
        rectangleTile.setFill(Color.GRAY);
        rectangleTile.setStroke(Color.BLACK);
        rectangleTile.setStrokeWidth(1);

        text.setFont(Font.font("Verdana", FontWeight.BOLD, 70));
        text.setFill(Color.WHITE);
        text.setTranslateX(rectangleTile.getWidth() / 3);

        setAlignment(Pos.CENTER);
    }
}
