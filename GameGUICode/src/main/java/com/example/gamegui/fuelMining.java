package com.example.gamegui;

import javafx.animation.PauseTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class fuelMining implements Initializable {

    double fuelProgress = 0;

    @FXML
    AnchorPane root;
    @FXML
    Button button1;

    @FXML
    ProgressBar fuelGauge;

    @FXML
    ImageView flameImage;

    @FXML
    TextArea endGame;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image galaxyPic = new Image(getClass().getResource("Mining/miningSpace.jpg").toExternalForm());
        Background backg = new Background(new BackgroundImage(galaxyPic, null, null, null, new BackgroundSize(1280, 720,false,false,false,false)));
        root.setBackground(backg);
        fuelGauge.setVisible(false);
        flameImage.setVisible(false);


    }
    long start = 0;

    public void setPress(){
        Scene currScene = root.getScene();
        start = System.currentTimeMillis();


        currScene.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.SPACE)){
                    fuelProgress += 0.01;
                    fuelGauge.setProgress(fuelProgress);
                }
                if ((System.currentTimeMillis() - start) > 7500){
                    PauseTransition pause = new PauseTransition(Duration.seconds(10));
                    double fuelGain = AsteroidBelt.round((fuelProgress * 10), 1);
                    endGame.setVisible(true);
                    endGame.setText("TIME'S UP!\nFuel Gained: " + fuelGain);
                    homeController.currFuel += fuelGain;
                    if (homeController.currFuel > 100){
                        homeController.currFuel = 100;
                    }
                    pause.play();
                    pause.setOnFinished(e->{
                        homeController.playerScore += (int)(fuelProgress * 1000);
                        Stage currStage = HelloApplication.getStage();
                        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("galaxy.fxml"));
                        try {
                            Scene asteroidScene = new Scene(fxmlLoader.load(), 1280, 720);
                            asteroidScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
                            currStage.setScene(asteroidScene);
                        }
                        catch (IOException y){
                            System.out.println("Failure in scene asteroid scene transition");
                            System.out.println(y);
                        }
                    });


                }

            }
        });

        button1.setDisable(true);
        button1.setText("PRESS SPACEBAR!");
        flameImage.setVisible(true);
        fuelGauge.setVisible(true);
    }
}
