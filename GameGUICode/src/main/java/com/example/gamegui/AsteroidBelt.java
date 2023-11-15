package com.example.gamegui;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class AsteroidBelt implements Initializable {
    @FXML
    AnchorPane root;
    @FXML
    TextArea Instructions, GameReport;
    @FXML
    ImageView asteroid1, asteroid2, asteroid3, asteroid4, asteroid5, asteroid6, asteroid7;

    MediaPlayer explosions;
    MediaPlayer lasers;

    Boolean[] asteroidDead = new Boolean[7];

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public Boolean checkAllDead(Boolean[] array){
        for (int i = 0; i < 7; i++){
            if (!array[i]){
                return false;
            }
        }
        return true;
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        Arrays.fill(asteroidDead, Boolean.FALSE);
        long start = System.currentTimeMillis();

        Image asteroidPic = new Image(getClass().getResource("Asteroids/asteroidBack.jpg").toExternalForm());
        Background backg = new Background(new BackgroundImage(asteroidPic, null, null, null, new BackgroundSize(1300, 1260,false,false,false,false)));

        explosions = new MediaPlayer(new Media(getClass().getResource("Sounds/asteroidExplosion.wav").toExternalForm()));
        lasers = new MediaPlayer(new Media(getClass().getResource("Sounds/laserShot.wav").toExternalForm()));
        lasers.setCycleCount(1);
        explosions.setCycleCount(1);
        explosions.setVolume(1);

        root.setBackground(backg);

        Instructions.setText("Click on the Asteroids to detroy them! Hurry!!\nThe longer you take the more damage your ship takes!");

        // Asteroid actions

        asteroid1.setOnMouseClicked(e->{
            PauseTransition pauseLaser = new PauseTransition(Duration.seconds(1));
            pauseLaser.setOnFinished(x->{
                lasers.stop();
                asteroid1.setVisible(false);
                asteroid1.setDisable(true);
                explosions.play();
            });
            lasers.play();
            pauseLaser.play();

            PauseTransition pauseExplosion = new PauseTransition(Duration.seconds(2));
            PauseTransition gameFinish = new PauseTransition(Duration.seconds(5));

            gameFinish.setOnFinished(x->{
                homeController.playerScore += 100;
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

            pauseExplosion.setOnFinished(x->{
                explosions.stop();
                asteroidDead[0] = true;
                if (checkAllDead(asteroidDead)){
                    long finish = System.currentTimeMillis();
                    double timeLapsed = TimeUnit.MILLISECONDS.toSeconds(finish - start);
                    System.out.println("Previous Durability:");
                    System.out.println(homeController.currDurability);
                    double damageTaken = round((timeLapsed * 0.75), 2);
                    homeController.currDurability = round(homeController.currDurability - damageTaken,2);
                    System.out.println("New Durability:");
                    System.out.println(homeController.currDurability);
                    GameReport.setText("Time Taken: " + timeLapsed + "\nDamage Taken: " + damageTaken);
                    GameReport.setVisible(true);

                    gameFinish.play();

                }
            });

            pauseExplosion.play();
        });

        asteroid2.setOnMouseClicked(e->{
            PauseTransition pauseLaser = new PauseTransition(Duration.seconds(1));
            pauseLaser.setOnFinished(x->{
                lasers.stop();
                asteroid2.setVisible(false);
                asteroid2.setDisable(true);
                explosions.play();
            });
            lasers.play();
            pauseLaser.play();

            PauseTransition pauseExplosion = new PauseTransition(Duration.seconds(2));
            PauseTransition gameFinish = new PauseTransition(Duration.seconds(5));

            gameFinish.setOnFinished(x->{
                homeController.playerScore += 100;
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

            pauseExplosion.setOnFinished(x->{
                explosions.stop();
                asteroidDead[1] = true;
                if (checkAllDead(asteroidDead)){
                    long finish = System.currentTimeMillis();
                    double timeLapsed = TimeUnit.MILLISECONDS.toSeconds(finish - start);
                    System.out.println("Previous Durability:");
                    System.out.println(homeController.currDurability);
                    double damageTaken = round((timeLapsed *  0.75), 2);
                    homeController.currDurability = round(homeController.currDurability - damageTaken,2);
                    System.out.println("New Durability:");
                    System.out.println(homeController.currDurability);
                    GameReport.setText("Time Taken: " + timeLapsed + "\nDamage Taken: " + damageTaken);
                    GameReport.setVisible(true);

                    gameFinish.play();
                }
            });

            pauseExplosion.play();
        });

        asteroid3.setOnMouseClicked(e->{
            PauseTransition pauseLaser = new PauseTransition(Duration.seconds(1));
            pauseLaser.setOnFinished(x->{
                lasers.stop();
                asteroid3.setVisible(false);
                asteroid3.setDisable(true);
                explosions.play();
            });
            lasers.play();
            pauseLaser.play();

            PauseTransition pauseExplosion = new PauseTransition(Duration.seconds(2));
            PauseTransition gameFinish = new PauseTransition(Duration.seconds(5));

            gameFinish.setOnFinished(x->{
                homeController.playerScore += 100;
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
            pauseExplosion.setOnFinished(x->{
                explosions.stop();
                asteroidDead[2] = true;
                if (checkAllDead(asteroidDead)){
                    long finish = System.currentTimeMillis();
                    double timeLapsed = TimeUnit.MILLISECONDS.toSeconds(finish - start);
                    System.out.println("Previous Durability:");
                    System.out.println(homeController.currDurability);
                    double damageTaken = round((timeLapsed *  0.75), 2);
                    homeController.currDurability = round(homeController.currDurability - damageTaken, 2);
                    System.out.println("New Durability:");
                    System.out.println(homeController.currDurability);
                    GameReport.setText("Time Taken: " + timeLapsed + "\nDamage Taken: " + damageTaken);
                    GameReport.setVisible(true);

                    gameFinish.play();

                }
            });

            pauseExplosion.play();
        });

        asteroid4.setOnMouseClicked(e->{
            PauseTransition pauseLaser = new PauseTransition(Duration.seconds(1));
            pauseLaser.setOnFinished(x->{
                lasers.stop();
                asteroid4.setVisible(false);
                asteroid4.setDisable(true);
                explosions.play();
            });
            lasers.play();
            pauseLaser.play();

            PauseTransition pauseExplosion = new PauseTransition(Duration.seconds(2));
            PauseTransition gameFinish = new PauseTransition(Duration.seconds(5));

            gameFinish.setOnFinished(x->{
                homeController.playerScore += 100;
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

            pauseExplosion.setOnFinished(x->{
                explosions.stop();
                asteroidDead[3] = true;
                if (checkAllDead(asteroidDead)){
                    long finish = System.currentTimeMillis();
                    double timeLapsed = TimeUnit.MILLISECONDS.toSeconds(finish - start);
                    System.out.println("Previous Durability:");
                    System.out.println(homeController.currDurability);
                    double damageTaken = round((timeLapsed *  0.75), 2);
                    homeController.currDurability = round(homeController.currDurability - damageTaken,2);
                    System.out.println("New Durability:");
                    System.out.println(homeController.currDurability);
                    GameReport.setText("Time Taken: " + timeLapsed + "\nDamage Taken: " + damageTaken);
                    GameReport.setVisible(true);

                    gameFinish.play();
                }
            });

            pauseExplosion.play();
        });

        asteroid5.setOnMouseClicked(e->{
            PauseTransition pauseLaser = new PauseTransition(Duration.seconds(1));
            pauseLaser.setOnFinished(x->{
                homeController.playerScore += 100;
                lasers.stop();
                asteroid5.setVisible(false);
                asteroid5.setDisable(true);
                explosions.play();
            });
            lasers.play();
            pauseLaser.play();

            PauseTransition pauseExplosion = new PauseTransition(Duration.seconds(2));
            PauseTransition gameFinish = new PauseTransition(Duration.seconds(5));

            gameFinish.setOnFinished(x->{
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
            pauseExplosion.setOnFinished(x->{
                explosions.stop();
                asteroidDead[4] = true;
                if (checkAllDead(asteroidDead)){
                    long finish = System.currentTimeMillis();
                    double timeLapsed = TimeUnit.MILLISECONDS.toSeconds(finish - start);
                    System.out.println("Previous Durability:");
                    System.out.println(homeController.currDurability);
                    double damageTaken = round((timeLapsed *  0.75), 2);
                    homeController.currDurability = round(homeController.currDurability - damageTaken,2);
                    System.out.println("New Durability:");
                    System.out.println(homeController.currDurability);
                    GameReport.setText("Time Taken: " + timeLapsed + "\nDamage Taken: " + damageTaken);
                    GameReport.setVisible(true);

                    gameFinish.play();
                }
            });

            pauseExplosion.play();
        });

        asteroid6.setOnMouseClicked(e->{
            PauseTransition pauseLaser = new PauseTransition(Duration.seconds(1));
            pauseLaser.setOnFinished(x->{
                lasers.stop();
                asteroid6.setVisible(false);
                asteroid6.setDisable(true);
                explosions.play();
            });
            lasers.play();
            pauseLaser.play();

            PauseTransition pauseExplosion = new PauseTransition(Duration.seconds(2));
            PauseTransition gameFinish = new PauseTransition(Duration.seconds(5));

            gameFinish.setOnFinished(x->{
                homeController.playerScore += 100;
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
            pauseExplosion.setOnFinished(x->{
                explosions.stop();
                asteroidDead[5] = true;
                if (checkAllDead(asteroidDead)){
                    long finish = System.currentTimeMillis();
                    double timeLapsed = TimeUnit.MILLISECONDS.toSeconds(finish - start);
                    System.out.println("Previous Durability:");
                    System.out.println(homeController.currDurability);
                    double damageTaken = round((timeLapsed *  0.75), 2);
                    homeController.currDurability = round(homeController.currDurability - damageTaken,2);
                    System.out.println("New Durability:");
                    System.out.println(homeController.currDurability);
                    GameReport.setText("Time Taken: " + timeLapsed + "\nDamage Taken: " + damageTaken);
                    GameReport.setVisible(true);
                    gameFinish.play();
                }
            });

            pauseExplosion.play();
        });

        asteroid7.setOnMouseClicked(e->{
            PauseTransition pauseLaser = new PauseTransition(Duration.seconds(1));
            pauseLaser.setOnFinished(x->{
                lasers.stop();
                asteroid7.setVisible(false);
                asteroid7.setDisable(true);
                explosions.play();
            });
            lasers.play();
            pauseLaser.play();

            PauseTransition pauseExplosion = new PauseTransition(Duration.seconds(2));
            PauseTransition gameFinish = new PauseTransition(Duration.seconds(5));

            gameFinish.setOnFinished(x->{
                homeController.playerScore += 100;
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
            pauseExplosion.setOnFinished(x->{
                explosions.stop();
                asteroidDead[6] = true;
                if (checkAllDead(asteroidDead)){
                    long finish = System.currentTimeMillis();
                    double timeLapsed = TimeUnit.MILLISECONDS.toSeconds(finish - start);
                    System.out.println("Previous Durability:");
                    System.out.println(homeController.currDurability);
                    double damageTaken = round((timeLapsed *  0.75), 2);
                    homeController.currDurability = round(homeController.currDurability - damageTaken,2);
                    System.out.println("New Durability:");
                    System.out.println(homeController.currDurability);
                    GameReport.setText("Time Taken: " + timeLapsed + "\nDamage Taken: " + damageTaken);
                    GameReport.setVisible(true);
                    gameFinish.play();

                }
            });

            pauseExplosion.play();
        });

    }
}
