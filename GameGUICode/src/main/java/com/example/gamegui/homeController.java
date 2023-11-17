package com.example.gamegui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class homeController implements Initializable {
    HelloApplication accessScenes;

    @FXML
    AnchorPane root;
    @FXML
    FlowPane fpInv;
    @FXML
    Label locationLabel, fuelLabel, durabilityLabel, scoreLabel;
    @FXML
    private HBox botMenu;

    String location;
    static public double currFuel = 100.0, maxFuel = 100.0, currDurability = 100.0, maxDurability = 100.0;
    static public int playerScore = 0;

    static public String k90Planet = "None";

    @FXML
    protected void onHelloButtonClick() {
    }

    @FXML
    private Button milkyWay_POI, changeDestination, exit;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Keep track of all stats using variables, until classes are made
        location = "Milky Way";
        //changeDestination.setText("Travel to another Galaxy");
        //changeDestination.setMinSize(100,100);
        changeDestination.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Entering MilkyWay");
                try {
                    changeGalaxies(actionEvent);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // Show the variables on screen
        //locationLabel.setMinSize(400, 17);
        locationLabel.setText("Destination: " + location);
        //fuelLabel.setMinSize(400, 17);
        fuelLabel.setText(String.valueOf(AsteroidBelt.round(currFuel, 1)));
        //durabilityLabel.setMinSize(400, 17);
        durabilityLabel.setText(String.valueOf(currDurability));
        //scoreLabel.setMinSize(400, 17);
        scoreLabel.setText(String.valueOf(playerScore));

        // This will all get cleaned up [hopefully]
        Image square = new Image(getClass().getResource("images/square.png").toExternalForm());
        int imageH = 512;
        int imageW = 512;

        Image menuImage = new Image(getClass().getResource("images/pause.png").toExternalForm());
        ImageView menuIV = new ImageView(menuImage);
        menuIV.setPreserveRatio(true);
        menuIV.setFitWidth(imageW / 8);
        menuIV.setFitHeight(imageH / 8);

        // Milky Way Point of Interest
        // Set the background color to transparent in styles.css
        // Make sure no text is in the fxml file
        Image mlk_poi_img = new Image(getClass().getResource("images/mlkPOI.png").toExternalForm());
        ImageView mlk_poi_imgv = new ImageView(mlk_poi_img);
        mlk_poi_imgv.setFitHeight(150);  // Resize the image
        mlk_poi_imgv.setFitWidth(150);
        milkyWay_POI.setGraphic(mlk_poi_imgv); // Set the graphic of the button
        milkyWay_POI.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //System.out.println("Entering MilkyWay");
                try {
                    enterMilkyWay(actionEvent);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        Image milkyWay = new Image(getClass().getResource("images/milkyWayBack.jpg").toExternalForm());
        BackgroundImage mlkBg = new BackgroundImage(
                milkyWay,
                null,
                null,
                null,
                null
        );
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage currStage = HelloApplication.getStage();
                currStage.setScene(HelloApplication.sceneMap.get("start"));
            }
        });
        Background milkyWayBackground = new Background(mlkBg);
        root.setBackground(milkyWayBackground);
    }

    public void enterMilkyWay(ActionEvent event) throws IOException {
        Stage currStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("milkyWaySceneView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        currStage.setScene(scene);
    }

    public void changeGalaxies(ActionEvent event) throws IOException {
        Stage currStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("galaxy.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        currStage.setScene(scene);
    }



}