package com.example.gamegui;

import java.util.HashMap;

import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

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
import javafx.scene.layout.*;
import javafx.scene.image.Image;
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



    public static HashMap<String, Scene> sceneMap;
    FileSwitcher christianFiles;

    public static MediaPlayer mediaPlayer;

    private static Stage stage;

    public static String lastScene;

    private static Scene holderScene = null;

    public static Scene getHolderScene(){ return holderScene; }

    public static void setHolderScene(Scene scene){ holderScene = scene; }

    public static Stage getStage() {
        return stage;
    }

    @Override
    public void start(Stage pStage) throws IOException {
        stage = pStage;
        stage.setTitle("Space Exploration");
        sceneMap = new HashMap<String,Scene>();
        loadUI();
        Media launchMedia = new Media(getClass().getResource("Sounds/242550__foolboymedia__chode-to-dub-step.wav").toExternalForm());
        mediaPlayer = new MediaPlayer(launchMedia);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();



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
        Button creativeButton = new Button("Creative Mode");
        Button exitButton = new Button("Exit");
        Button manualButton = new Button("Manual");

        // set Font
        explorationButton.setFont(Font.font("Papyrus", FontWeight.BOLD, 14));
        creativeButton.setFont(Font.font("Papyrus", FontWeight.BOLD, 14));
        manualButton.setFont(Font.font("Papyrus", FontWeight.BOLD, 14));

        exitButton.setStyle("-fx-text-fill: white; -fx-background-color: red;");

        // set button Size
        creativeButton.setMinSize(50, 50);
        explorationButton.setMinSize(50,50);
        manualButton.setMinSize(50,50);

        //template exit commands
        explorationButton.setOnAction(e->{
            Media mediaStart = new Media(getClass().getResource("Sounds/71150__timbre__simulation-of-nasa-rocket-launch.wav").toExternalForm());
            Media mediaOngoing = new Media(getClass().getResource("Sounds/396627__matrixxx__space-atmosphere-01.wav").toExternalForm());
            mediaPlayer.stop();
            mediaPlayer = new MediaPlayer(mediaStart);
            mediaPlayer.setCycleCount(1);
            mediaPlayer.play();
            PauseTransition pause = new PauseTransition(Duration.seconds(15));
            pause.setOnFinished(x->{
                // add parent transition here I think, try it out tomorrow
                mediaPlayer.stop();
                mediaPlayer = new MediaPlayer(mediaOngoing);
                mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
                mediaPlayer.play();
                pStage.setScene(sceneMap.get("main"));
            });
            pause.play();
        });
        exitButton.setOnAction(e->Platform.exit());
        creativeButton.setOnAction(e->pStage.setScene(sceneMap.get("creative")));
        manualButton.setOnAction(e->pStage.setScene(sceneMap.get("manual")));

        // holders that will hold the buttons
        HBox gameModeHolder = new HBox(30, explorationButton, creativeButton, manualButton);
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
        sceneMap.put("start", start);
        pStage.setTitle("Space Exploration Game");
        pStage.setScene(start);
        pStage.show();
    }

    public void loadUI() throws IOException {
        try{
            mediaPlayer.stop();
        }
        catch (Exception e){
            System.out.println("No media loaded");
        }
        // NOTE: NO LONGER USING com.example.gamegui.HelloController
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("homeView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        sceneMap.put("main", scene);

        FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("creative.fxml"));
        Scene sceneSB = new Scene(fxmlLoader2.load(), 1280, 720);
        sceneSB.getStylesheets().add(getClass().getResource("style_creative.css").toExternalForm());
        sceneMap.put("creative", sceneSB);

        FXMLLoader fxmlLoader3 = new FXMLLoader(HelloApplication.class.getResource("Manual.fxml"));
        Scene sceneManual = new Scene(fxmlLoader3.load(), 1280, 720);
        sceneManual.getStylesheets().add(getClass().getResource("style_manual.css").toExternalForm());
        sceneMap.put("manual", sceneManual);

        FXMLLoader fxmlLoader4 = new FXMLLoader(HelloApplication.class.getResource("GameOver.fxml"));
        Scene sceneDeath = new Scene(fxmlLoader4.load(), 1280, 720);
        sceneDeath.getStylesheets().add(getClass().getResource("GameOver.css").toExternalForm());
        sceneMap.put("death", sceneDeath);

        FXMLLoader fxmlLoader5 = new FXMLLoader(HelloApplication.class.getResource("kepler-system.fxml"));
        Scene sceneKepler = new Scene(fxmlLoader5.load(), 1280, 720);
        sceneKepler.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        sceneMap.put("kepler", sceneKepler);
    }





    public static void main(String[] args) {
        launch();
    }
}