package com.example.gamegui;

import java.util.HashMap;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import java.io.IOException;


public class HelloApplication extends Application {
    Stage stage;
    HashMap<String, Scene> sceneMap;

    @Override
    public void start(Stage pStage) throws IOException {
        stage = pStage;
        stage.setTitle("Space Exploration");
        sceneMap = new HashMap<String,Scene>();
        loadUI();

        // set up the background of the start up menu
        Image backgroundPic = new Image(getClass().getResource("images/RocketLaunch.jpg").toExternalForm());
        BackgroundImage backgroundStartUp = new BackgroundImage(backgroundPic, null, null, null, new BackgroundSize(1300, 1260,false,false,false,false));
        Background startBackground = new Background(backgroundStartUp);

        //TextField gameTitle = new TextField("Space Exploration Game");
        // gameTitle.setEditable(false);
        // gameTitle.setMaxWidth(310);
        // gameTitle.setStyle("-fx-background-color: white;" + "-fx-border-color: black;" + "-fx-text-color: white");
        // gameTitle.setFont(Font.font("Copperplate", FontWeight.BOLD, 24));

        // Adding game logo
        Image logo = new Image(getClass().getResource("Logo/logo_transparent.png").toExternalForm());
        ImageView logoIV = new ImageView(logo);
        logoIV.setPreserveRatio(true);
        logoIV.setFitHeight(400);
        logoIV.setFitWidth(400);

        Button explorationButton = new Button("Exploration Mode");
        Button sandboxButton = new Button("Sandbox Mode");
        Button exitButton = new Button("Exit");

        // set Font
        explorationButton.setFont(Font.font("Papyrus", FontWeight.BOLD, 14));
        sandboxButton.setFont(Font.font("Papyrus", FontWeight.BOLD, 14));

        // set button Size
        sandboxButton.setMinSize(50, 50);
        explorationButton.setMinSize(50,50);

        //template exit commands
        explorationButton.setOnAction(e->pStage.setScene(sceneMap.get("main")));
        exitButton.setOnAction(e->Platform.exit());
        sandboxButton.setOnAction(e->Platform.exit());

        // holders that will hold the buttons
        HBox gameModeHolder = new HBox(30, explorationButton, sandboxButton);
        gameModeHolder.setAlignment(Pos.CENTER);
        VBox buttonHolder = new VBox(30, gameModeHolder, exitButton);
        buttonHolder.setAlignment(Pos.CENTER);
        VBox centerPiece = new VBox(200, logoIV, buttonHolder);
        centerPiece.setAlignment(Pos.CENTER);
        centerPiece.setSpacing(10);

        // initialize and present Borderpane/scenes
        BorderPane borderPane = new BorderPane();
        borderPane.setBackground(startBackground);
        borderPane.setCenter(centerPiece);
        Scene start = new Scene(borderPane, 1280, 720);

        pStage.setTitle("Space Exploration Game");
        pStage.setScene(start);
        pStage.show();
    }

    public void loadUI() throws IOException {
        // NOTE: NO LONGER USING HelloController
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("homeView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        sceneMap.put("main", scene);
    }

    public static void main(String[] args) {
        launch();
    }
}