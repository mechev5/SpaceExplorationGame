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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class homeController implements Initializable {
    HelloApplication accessScenes;

    @FXML
    BorderPane root;
    @FXML
    FlowPane fpInv;
    @FXML
    Label locationLabel, fuelLabel, durabilityLabel;
    @FXML
    private HBox botMenu;
    @FXML
    ImageView inv1, inv2, inv3, inv4, inv5, inv6, inv7, inv8;

    String location;
    static public double currFuel = 100.0, maxFuel = 100.0, currDurability = 100.0, maxDurability = 100.0;


    @FXML
    protected void onHelloButtonClick() {
    }

    @FXML
    private Button menuButton, milkyWay_POI, changeDestination;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Keep track of all stats using variables, until classes are made
        location = "Milky Way";
        changeDestination.setText("Travel to another Galaxy");
        changeDestination.setMinSize(100,100);
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
        locationLabel.setText("Designation: " + location);
        fuelLabel.setText("Fuel: " + currFuel + " / " + maxFuel);
        durabilityLabel.setText("Durability: " + currDurability + " / " + maxDurability);

        // This will all get cleaned up [hopefully]
        Image square = new Image(getClass().getResource("images/square.png").toExternalForm());
        int imageH = 512;
        int imageW = 512;

        inv1.setImage(square);
        inv2.setImage(square);
        inv3.setImage(square);
        inv4.setImage(square);
        inv5.setImage(square);
        inv6.setImage(square);
        inv7.setImage(square);
        inv8.setImage(square);

        inv1.setPreserveRatio(true);
        inv2.setPreserveRatio(true);
        inv3.setPreserveRatio(true);
        inv4.setPreserveRatio(true);
        inv5.setPreserveRatio(true);
        inv6.setPreserveRatio(true);
        inv7.setPreserveRatio(true);
        inv8.setPreserveRatio(true);

        inv1.setFitHeight(imageH / 5);
        inv2.setFitHeight(imageH / 5);
        inv3.setFitHeight(imageH / 5);
        inv4.setFitHeight(imageH / 5);
        inv5.setFitHeight(imageH / 5);
        inv6.setFitHeight(imageH / 5);
        inv7.setFitHeight(imageH / 5);
        inv8.setFitHeight(imageH / 5);

        inv1.setFitWidth(imageW / 5);
        inv2.setFitWidth(imageW / 5);
        inv3.setFitWidth(imageW / 5);
        inv4.setFitWidth(imageW / 5);
        inv5.setFitWidth(imageW / 5);
        inv6.setFitWidth(imageW / 5);
        inv7.setFitWidth(imageW / 5);
        inv8.setFitWidth(imageW / 5);

        Image menuImage = new Image(getClass().getResource("images/pause.png").toExternalForm());
        ImageView menuIV = new ImageView(menuImage);
        menuIV.setPreserveRatio(true);
        menuIV.setFitWidth(imageW / 8);
        menuIV.setFitHeight(imageH / 8);
        //menuButton.setGraphic(menuIV);

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