package com.example.gamegui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.stage.Stage;

public class Andromeda extends Application {
    public Andromeda() {
    }

    public static void main(String[] args) {
        launch(new String[0]);
    }

//    @Override
@FXML
public void start(Stage stage) throws IOException {
        BorderPane bP = new BorderPane();
        Scene scene = new Scene(bP, 1280.0, 720.0);
        FileSwitcher.setScene(scene);
        FileSwitcher.switchTo(FileStorage.AndroSystem);
        stage.setScene(scene);
        stage.show();
        //        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
    //        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
    //        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
    //        sceneMap.put("main", scene);
    //        stage.setScene(scene);
    //        stage.show();
    }
}
