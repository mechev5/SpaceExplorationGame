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
import java.util.Random;
import java.net.URL;
import java.util.ResourceBundle;




public class AndroController {
    @FXML
    ImageView inv1, inv2, inv3, inv4, inv5, inv6, inv7, inv8;
    private Stage stage;
    private Scene scene;
    private Parent root;
    Random rand = new Random();

    double fuel = homeController.currFuel;
    double dur = homeController.currDurability;
    double maxfuel = homeController.maxFuel;
    double maxdur = homeController.maxDurability;

    @FXML
    Label locationLabel, fuelLabel, durabilityLabel;


    public void switchToScene1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AScene1.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene2(ActionEvent event) throws IOException {
        //if random number < 2 then switch to mini game, else AScene2.fxml
        //call random function -oxygen, use oxygen game
        int randomCheck = rand.nextInt(10);
        System.out.println(randomCheck);
        if(randomCheck < 2){
            fuel = fuel+5;
        }else{
            fuel = fuel-5;
        }
        //

        Parent root = FXMLLoader.load(getClass().getResource("AScene2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene3(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AScene3.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene4(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AScene4.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene5(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AScene5.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene6(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AScene6.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene7(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AScene7.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene8(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AScene8.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene9(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AScene9.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene10(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AScene10.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene11(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AScene11.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void enterGalaxy(ActionEvent event) throws IOException {
        Stage currStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("galaxy.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        currStage.setScene(scene);
    }

//    public void initialize(URL url, ResourceBundle resourceBundle) {
////        this.locationLabel.setText(this.location);
//        this.fuelLabel.setText("Fuel: " + homeController.currFuel + " / " + homeController.maxFuel);
//        this.durabilityLabel.setText("Durability: " + homeController.currDurability + " / " + homeController.maxDurability);
//        Image square = new Image(this.getClass().getResource("images/square.png").toExternalForm());
//        int imageH = 512;
//        int imageW = 512;
//    }
}