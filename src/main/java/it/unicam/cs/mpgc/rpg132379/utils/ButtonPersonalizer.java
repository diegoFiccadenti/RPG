package it.unicam.cs.mpgc.rpg132379.utils;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class ButtonPersonalizer {

    public static Button newButton(String label) {
        Button button = new Button(label);
        button.setPrefSize(200, 50);
        button.setAlignment(Pos.CENTER);
        button.setFont(Font.font("Copperplate Gothic Light", 24));
        return button;
    }

    public static Button newButton(String label, int width, int height, int fontSize) {
        Button button = new Button(label);
        button.setPrefSize(width, height);
        button.setAlignment(Pos.CENTER);
        button.setFont(Font.font("Copperplate Gothic Light", fontSize));
        return button;
    }
}
