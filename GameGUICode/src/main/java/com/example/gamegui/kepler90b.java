//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.gamegui;


import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class kepler90b {
    @FXML
    private Label welcomeText;

    public kepler90b() {
    }

    @FXML
    protected void onHelloButtonClick() {
        this.welcomeText.setText("Welcome to JavaFX Application!");
        FileSwitcher.switchTo(FileStorage.HELLO);
    }
}

