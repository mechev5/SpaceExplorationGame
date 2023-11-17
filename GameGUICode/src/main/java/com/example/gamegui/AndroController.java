package com.example.gamegui;

import java.io.IOException;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextArea;
import javafx.util.Duration;

import java.util.Arrays;
import java.util.Random;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;


public class AndroController implements Initializable {
    @FXML
    ImageView inv1, inv2, inv3, inv4, inv5, inv6, inv7, inv8;
    private Stage stage;
    private Scene scene;
    private Parent root;
    Random rand = new Random();

    double fuel = homeController.currFuel;
    double durability = homeController.currDurability;
    double maxfuel = homeController.maxFuel;
    double maxdur = homeController.maxDurability;

    @FXML
    Label locationLabel, fuelLabel, durabilityLabel, scoreLabel;

    int max_added_fuel = 20;
    int added_fuel = 0;
    Boolean test = true;

    public void switchToScene1(ActionEvent event) throws IOException {
        double isdead = homeController.currFuel;
        double health = homeController.currDurability;
        if (isdead >=0 || health >= 0){
            Parent root = FXMLLoader.load(getClass().getResource("AScene1.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else{
            Stage currStage = HelloApplication.getStage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("GameOver.fxml"));
            try {
                Scene asteroidScene = new Scene(fxmlLoader.load(), 1280, 720);
                asteroidScene.getStylesheets().add(getClass().getResource("GameOver.css").toExternalForm());
                currStage.setScene(asteroidScene);
            }
            catch (IOException y){
                System.out.println("GameOver");
                System.out.println(y);
            }
        }

//        root = FXMLLoader.load(getClass().getResource("AScene1.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
    }


    public void switchToScene2(ActionEvent event) throws IOException {
        int randomCheck = rand.nextInt(10);
        System.out.println(randomCheck);
        if(randomCheck > 7){// 70% fail, 30% succeed
            if(homeController.currFuel < 100){
                double fuel = homeController.currFuel;
                if(fuel + 5 > 100){
                    homeController.currFuel = 100;
                }else{
                    homeController.currFuel = homeController.currFuel+3;
                }
            }
            homeController.playerScore = homeController.playerScore+30;
            Parent root = FXMLLoader.load(getClass().getResource("AScene2.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else{
            //switch to damaged hull and lost of fuel due to pirates or nah

            Parent root = FXMLLoader.load(getClass().getResource("And_Game.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }



    public void switchToScene3(ActionEvent event) throws IOException {
        int randomCheck = rand.nextInt(10);
        System.out.println(randomCheck);
        if(randomCheck > 4){
            if(homeController.currFuel < 100){
                double fuel = homeController.currFuel;
                if(fuel + 5 > 100){
                    homeController.currFuel = 100;
                }else{
                    homeController.currFuel = homeController.currFuel+5;
                }
            }
            homeController.playerScore = homeController.playerScore+10;
//            homeController.currFuel = homeController.currFuel+5;
            Parent root = FXMLLoader.load(getClass().getResource("AScene3.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else{
            //switch to damaged hull and lost of fuel due to pirates or nah

            Parent root = FXMLLoader.load(getClass().getResource("And_Game.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void switchToScene4(ActionEvent event) throws IOException {
        int randomCheck = rand.nextInt(10);
        System.out.println(randomCheck);
        if(randomCheck > 4){
            if(homeController.currFuel < 100){
                double fuel = homeController.currFuel;
                if(fuel + 5 > 100){
                    homeController.currFuel = 100;
                }else{
                    homeController.currFuel = homeController.currFuel+5;
                }
            }
            homeController.playerScore = homeController.playerScore+10;
            Parent root = FXMLLoader.load(getClass().getResource("AScene4.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else{
            //switch to damaged hull and lost of fuel due to pirates or nah

            Parent root = FXMLLoader.load(getClass().getResource("And_Game.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void switchToScene5(ActionEvent event) throws IOException {
        int randomCheck = rand.nextInt(10);
        System.out.println(randomCheck);
        if(randomCheck > 4){
            if(homeController.currFuel < 100){
                double fuel = homeController.currFuel;
                if(fuel + 5 > 100){
                    homeController.currFuel = 100;
                }else{
                    homeController.currFuel = homeController.currFuel+5;
                }
            }
            homeController.playerScore = homeController.playerScore+10;
            Parent root = FXMLLoader.load(getClass().getResource("AScene5.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else{
            //switch to damaged hull and lost of fuel due to pirates or nah

            Parent root = FXMLLoader.load(getClass().getResource("And_Game.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void switchToScene6(ActionEvent event) throws IOException {
        int randomCheck = rand.nextInt(10);
        System.out.println(randomCheck);
        if(randomCheck > 4){
            if(homeController.currFuel < 100){
                double fuel = homeController.currFuel;
                if(fuel + 5 > 100){
                    homeController.currFuel = 100;
                }else{
                    homeController.currFuel = homeController.currFuel+5;
                }
            }
            homeController.playerScore = homeController.playerScore+10;
            Parent root = FXMLLoader.load(getClass().getResource("AScene6.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else{
            //switch to damaged hull and lost of fuel due to pirates or nah

            Parent root = FXMLLoader.load(getClass().getResource("And_Game.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void switchToScene7(ActionEvent event) throws IOException {
        int randomCheck = rand.nextInt(10);
        System.out.println(randomCheck);
        if(randomCheck > 4){
            if(homeController.currFuel < 100){
                double fuel = homeController.currFuel;
                if(fuel + 5 > 100){
                    homeController.currFuel = 100;
                }else{
                    homeController.currFuel = homeController.currFuel+5;
                }
            }
            homeController.playerScore = homeController.playerScore+10;
            Parent root = FXMLLoader.load(getClass().getResource("AScene7.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else{
            //switch to damaged hull and lost of fuel due to pirates or nah

            Parent root = FXMLLoader.load(getClass().getResource("And_Game.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void switchToScene8(ActionEvent event) throws IOException {
        int randomCheck = rand.nextInt(10);
        System.out.println(randomCheck);
        if(randomCheck > 4){
            if(homeController.currFuel < 100){
                double fuel = homeController.currFuel;
                if(fuel + 5 > 100){
                    homeController.currFuel = 100;
                }else{
                    homeController.currFuel = homeController.currFuel+5;
                }
            }
            homeController.playerScore = homeController.playerScore+10;
            Parent root = FXMLLoader.load(getClass().getResource("AScene8.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else{
            //switch to damaged hull and lost of fuel due to pirates or nah

            Parent root = FXMLLoader.load(getClass().getResource("And_Game.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void switchToScene9(ActionEvent event) throws IOException {
        int randomCheck = rand.nextInt(10);
        System.out.println(randomCheck);
        if(randomCheck > 4){
            if(homeController.currFuel < 100){
                double fuel = homeController.currFuel;
                if(fuel + 5 > 100){
                    homeController.currFuel = 100;
                }else{
                    homeController.currFuel = homeController.currFuel+5;
                }
            }
            homeController.playerScore = homeController.playerScore+10;
            Parent root = FXMLLoader.load(getClass().getResource("AScene9.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else{
            //switch to damaged hull and lost of fuel due to pirates or nah

            Parent root = FXMLLoader.load(getClass().getResource("And_Game.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void switchToScene10(ActionEvent event) throws IOException {
        int randomCheck = rand.nextInt(10);
        System.out.println(randomCheck);
        if(randomCheck > 4){
            if(homeController.currFuel < 100){
                double fuel = homeController.currFuel;
                if(fuel + 5 > 100){
                    homeController.currFuel = 100;
                }else{
                    homeController.currFuel = homeController.currFuel+5;
                }
            }
            homeController.playerScore = homeController.playerScore+10;
            Parent root = FXMLLoader.load(getClass().getResource("AScene10.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else{
            //switch to damaged hull and lost of fuel due to pirates or nah

            Parent root = FXMLLoader.load(getClass().getResource("And_Game.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void switchToScene11(ActionEvent event) throws IOException {
        int randomCheck = rand.nextInt(10);
        System.out.println(randomCheck);
        if(randomCheck > 4){
            if(homeController.currFuel < 100){
                double fuel = homeController.currFuel;
                if(fuel + 5 > 100){
                    homeController.currFuel = 100;
                }else{
                    homeController.currFuel = homeController.currFuel+5;
                }
            }
            homeController.playerScore = homeController.playerScore+10;
            Parent root = FXMLLoader.load(getClass().getResource("AScene11.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else{
            //switch to damaged hull and lost of fuel due to pirates or nah
            Parent root = FXMLLoader.load(getClass().getResource("And_Game.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void enterGalaxy(ActionEvent event) throws IOException {
        Stage currStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("galaxy.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        currStage.setScene(scene);
    }

    public void Evade(ActionEvent event) throws IOException {
        int randomCheck = rand.nextInt(10);
        System.out.println(randomCheck);
        if(randomCheck > 3){ //70% to evade
            Parent root = FXMLLoader.load(getClass().getResource("A_Evade_Suc.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else{
            //switch to damaged hull and lost of fuel due to pirates or nah
            homeController.currFuel -= 15;
            if (homeController.currFuel >=0){
                Parent root = FXMLLoader.load(getClass().getResource("A_Evade_Fail.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }else{
                Stage currStage = HelloApplication.getStage();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("GameOver.fxml"));
                try {
                    Scene asteroidScene = new Scene(fxmlLoader.load(), 1280, 720);
                    asteroidScene.getStylesheets().add(getClass().getResource("GameOver.css").toExternalForm());
                    currStage.setScene(asteroidScene);
                }
                catch (IOException y){
                    System.out.println("GameOver");
                    System.out.println(y);
                }
            }

        }
    }

    public void Fight(ActionEvent event) throws IOException {
        int randomCheck = rand.nextInt(10);
        System.out.println(randomCheck);
        if(randomCheck > 3){ //60% you fail, 40% you suc
            homeController.currFuel = homeController.currFuel-10;
            homeController.currDurability = homeController.currDurability-10;
            double isdead = homeController.currFuel;
            double health = homeController.currDurability;
            if (isdead > 0 && health > 0){

                Parent root = FXMLLoader.load(getClass().getResource("A_Fight_Fail.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }else{
                Stage currStage = HelloApplication.getStage();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("GameOver.fxml"));
                try {
                    Scene asteroidScene = new Scene(fxmlLoader.load(), 1280, 720);
                    asteroidScene.getStylesheets().add(getClass().getResource("GameOver.css").toExternalForm());
                    currStage.setScene(asteroidScene);
                }
                catch (IOException y){
                    System.out.println("GameOver");
                    System.out.println(y);
                }
            }


        }else{
            //switch to damaged hull and lost of fuel due to pirates or nah
            if(homeController.currFuel < 100){
                double fuel = homeController.currFuel;
                if(fuel + 5 > 100){
                    homeController.currFuel = 100;
                }else{
                    homeController.currFuel = homeController.currFuel+10;
                }
            }
            if(homeController.currDurability < 100){
                double dur = homeController.currDurability;
                if(dur + 15 > 100){
                    homeController.currDurability = 100;
                }else{
                    homeController.currDurability = homeController.currDurability+15;
                }
            }
            Parent root = FXMLLoader.load(getClass().getResource("A_Fight_Suc.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void Negotiate(ActionEvent event) throws IOException {
        homeController.currFuel = homeController.currFuel-5;
        double isdead = homeController.currFuel;
        if (isdead >=0){
            Stage currStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("A_Negotiate.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
            scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
            currStage.setScene(scene);
        }else{
            Stage currStage = HelloApplication.getStage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("GameOver.fxml"));
            try {
                Scene asteroidScene = new Scene(fxmlLoader.load(), 1280, 720);
                asteroidScene.getStylesheets().add(getClass().getResource("GameOver.css").toExternalForm());
                currStage.setScene(asteroidScene);
            }
            catch (IOException y){
                System.out.println("GameOver");
                System.out.println(y);
            }
        }


    }
    //    public void initialize(URL url, ResourceBundle resourceBundle) {
////        this.locationLabel.setText(this.location);
//        this.fuelLabel.setText("Fuel: " + homeController.currFuel + " / " + homeController.maxFuel);
//        this.durabilityLabel.setText("Durability: " + homeController.currDurability + " / " + homeController.maxDurability);
//        Image square = new Image(this.getClass().getResource("images/square.png").toExternalForm());
//        int imageH = 512;
//        int imageW = 512;
//    }
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        this.locationLabel.setText(this.location);
        this.fuelLabel.setText("Fuel: " + AsteroidBelt.round(homeController.currFuel, 1) + " / " + homeController.maxFuel);
        this.durabilityLabel.setText("Durability: " + homeController.currDurability + " / " + homeController.maxDurability);
        this.scoreLabel.setText("Score: " + homeController.playerScore);
    }
}

//ideas:
//if random number < 2 then switch to mini game, else AScene2.fxml
//call random function -oxygen, use oxygen game
//        if (test){
//            homeController.currFuel = 50;
//            test=false;
//        }

//            }else{
//                //switch, Galaxy empty -> next to switch back to planet (Ascne2.fxml
//            }

//            if(max_added_fuel != added_fuel && homeController.currFuel != homeController.maxFuel){

//            System.out.println(added_fuel);
//            System.out.println(max_added_fuel);
//            if(max_added_fuel != 0){
//                max_added_fuel = max_added_fuel-1;