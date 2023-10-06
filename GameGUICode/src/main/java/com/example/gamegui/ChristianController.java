package com.example.gamegui;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ChristianController {
    @FXML
    private Label welcomeText;

    public ChristianController() {
    }

    @FXML
    protected void onHelloButtonClick() {
        this.welcomeText.setText("Welcome to JavaFX Application!");
        FileSwitcher.switchTo(FileStorage.PLANETLIST);
    }
}

