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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
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

    @FXML
    TextArea instructionText;

    MediaPlayer actionSound;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image galaxyPic = new Image(getClass().getResource("Mining/miningSpace.jpg").toExternalForm());
        Background backg = new Background(new BackgroundImage(galaxyPic, null, null, null, new BackgroundSize(1280, 720,false,false,false,false)));
        root.setBackground(backg);
        fuelGauge.setVisible(false);
        flameImage.setVisible(false);
        actionSound = new MediaPlayer(new Media(getClass().getResource("Sounds/miningSound.wav").toExternalForm()));

    }
    long start = 0;
    boolean buttonPressed = false;

    public void setPress(){
        Scene currScene = root.getScene();
        start = System.currentTimeMillis();
        instructionText.setVisible(false);



        currScene.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.SPACE)){
                    actionSound.seek(Duration.ZERO);
                    actionSound.play();
                    fuelProgress += 0.01;
                    fuelGauge.setProgress(fuelProgress);
                }
                if ((System.currentTimeMillis() - start) > 7500){
                    PauseTransition pause = new PauseTransition(Duration.seconds(7));
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
                        if (HelloApplication.getHolderScene() == null){
                            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(HelloApplication.lastScene));
                            try {
                                Scene goBack = new Scene(fxmlLoader.load(), 1280, 720);
                                goBack.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
                                currStage.setScene(goBack);
                            }
                            catch (IOException y){
                                System.out.println("Failure in scene asteroid scene transition");
                                System.out.println(y);
                            }
                        }
                        else {
                            currStage.setScene(HelloApplication.getHolderScene());
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
