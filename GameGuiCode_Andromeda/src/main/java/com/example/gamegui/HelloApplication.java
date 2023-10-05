//Use Hello Controller -displays 2 planets to pick from and return button
package com.example.gamegui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class HelloApplication extends Application {
    Stage stage;
    HashMap<String, Scene> sceneMap;

    @Override
    public void start(Stage pStage) throws IOException {
        stage = pStage;
        stage.setTitle("Space Exploration");
        sceneMap = new HashMap<>();
        loadUI();
    }

    public void loadUI() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        sceneMap.put("main", scene);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}