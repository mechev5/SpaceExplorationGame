package com.example.gamegui;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class GameOver implements Initializable {

    @FXML
    BorderPane root;
    @FXML
    ImageView deathScene;
    @FXML
    TextArea deathCause;
    @FXML
    TextArea deathText;
    @FXML
    TextArea score;
    @FXML
    Button continueGame;
    @FXML
    Button exitGame;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Image deathMethod = new Image(this.getClass().getResource("images/rocketship_no_fuel_02.png").toExternalForm());
        Image deathMethod2 = new Image(this.getClass().getResource("images/rocketship_destroyed.png").toExternalForm());
        Image deathMethod3 = new Image(this.getClass().getResource("images/question-mark-03.jpg").toExternalForm());
        // this.deathScene.setImage(deathMethod);

        String deathByFuel =
                "Remember to keep an eye on your fuel at all times. " + "\n" +
                "If you're running low on fuel, consider refueling "  + "\n" +
                "before you visit any more planets!";
        String deathByDurability =
                "Your ship isn't invincible, those asteroids hurt! " + "\n" +
                "If you don't dispatch those asteroids in a timely " + "\n" +
                "manner, your ship will inevitably fall.";

        score.setText("Score: " + homeController.playerScore);

        double randomChance = Math.random();

        //

        deathCause.setMinSize(250, 70);
        deathCause.setMaxSize(250, 70);
        deathText.setMinSize(350, 100);
        deathText.setMaxSize(400,100);
        score.setMinSize(300, 100);
        score.setMaxSize(300, 100);

        deathCause.setEditable(false);
        deathText.setEditable(false);
        score.setEditable(false);

         //

        continueGame.setMinSize(100,50);
        exitGame.setMinSize(100, 50);
        continueGame.setText("Menu");
        exitGame.setText("Exit");
        continueGame.setOnAction((e)-> {
            HelloApplication.mediaPlayer.stop();
            Media launchMedia = new Media(getClass().getResource("Sounds/242550__foolboymedia__chode-to-dub-step.wav").toExternalForm());
            HelloApplication.mediaPlayer= new MediaPlayer(launchMedia);
            HelloApplication.mediaPlayer.seek(Duration.ZERO);
            HelloApplication.mediaPlayer.play();
            Galaxies.xPos = 229.0;
            Galaxies.yPos = 400.0;
            homeController.currFuel = 100;
            homeController.currDurability = 100;
            homeController.playerScore = 0;
            Stage currStage = HelloApplication.getStage();
            currStage.setScene(HelloApplication.sceneMap.get("start"));
        });
        exitGame.setOnAction(e-> Platform.exit());

        //

        if (homeController.currFuel <= 0) {
            this.deathScene.setImage(deathMethod);
            try {
                HelloApplication.mediaPlayer.stop();
                Media lost = new Media(getClass().getResource("Sounds/fuelGameover.wav").toExternalForm());
                HelloApplication.mediaPlayer = new MediaPlayer(lost);
                HelloApplication.mediaPlayer.seek(Duration.ZERO);
                HelloApplication.mediaPlayer.play();
            }
            catch (Exception e){
                System.out.println("Failure loading media");
            }
            deathCause.setText("Stranded");
            deathText.setText(deathByFuel);
        } else if (homeController.currDurability <= 0){
            this.deathScene.setImage(deathMethod2);

            try {
                HelloApplication.mediaPlayer.stop();
                Media shipWrecked = new Media(getClass().getResource("Sounds/durabilityWreck.wav").toExternalForm());
                HelloApplication.mediaPlayer = new MediaPlayer(shipWrecked);
                PauseTransition pause = new PauseTransition(Duration.seconds(3));
                HelloApplication.mediaPlayer.seek(Duration.ZERO);
                HelloApplication.mediaPlayer.play();


            }
            catch (Exception e){
                System.out.println("Failure loading in explosion media");
            }

            deathCause.setText("Destroyed");
            deathText.setText(deathByDurability);
        } else {
            this.deathScene.setImage(deathMethod3);
            deathCause.setText("What");
            deathText.setText("You're not supposed to be dead?");
        }

         //



        Image img = new Image(this.getClass().getResource("images/Death Scene 02.png").toExternalForm());
        BackgroundImage bgImg = new BackgroundImage(img,
                null,
                null,
                null,
                null);
        Background bg = new Background(bgImg);
        this.root.setBackground(bg);
    }
}
