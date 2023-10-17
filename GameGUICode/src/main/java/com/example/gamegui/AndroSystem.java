//Scene with 2 planets and return button -this uses homeView.fxml
package com.example.gamegui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AndroSystem implements Initializable {
    @FXML
    BorderPane root;
    @FXML
    private Button menuButton, milkyWay_POI;
    @FXML
    ImageView inv1, inv2, inv3;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image square = new Image(getClass().getResource("images/Square1.jpg").toExternalForm());
        Image square2 = new Image(getClass().getResource("images/square2.png").toExternalForm());
        inv1.setImage(square);
        inv2.setImage(square2);
        inv1.setFitHeight(512);
        inv2.setFitHeight(512);
        inv1.setFitWidth(512);
        inv2.setFitWidth(512);
        BorderPane.setAlignment(inv1, Pos.CENTER);
        BorderPane.setAlignment(inv2, Pos.CENTER);

        // Create an HBox to hold the images and center it in the BorderPane
        HBox imageBox = new HBox();
        imageBox.setAlignment(Pos.CENTER);
        imageBox.getChildren().addAll(inv1, inv2);
        root.setCenter(imageBox);

        ImageView right = new ImageView(square2);
        menuButton.setGraphic(right); // Set the graphic of the button
        menuButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Entering Kepler");
                try {
                    enterPlanet2(actionEvent);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        ImageView mlk_poi_imgv = new ImageView(square);
        milkyWay_POI.setGraphic(mlk_poi_imgv); // Set the graphic of the button
        milkyWay_POI.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Entering Kepler");
                try {
                    enterPlanet1(actionEvent);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        //Return Button
        Button bottomButton = new Button("Return");
        HBox bottomBox = new HBox(bottomButton);
        bottomBox.setAlignment(Pos.CENTER);
        root.setBottom(bottomBox);

        bottomButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Leaving MilkyWay");
                try {
                    enterMilkyWay(actionEvent);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        Image Andro = new Image(getClass().getResource("images/Andromeda galaxy.jpg").toExternalForm());
        BackgroundImage mlkBg = new BackgroundImage(
                Andro,
                null,
                null,
                null,
                new BackgroundSize(1300, 1260,false,false,false,false)
        );
        Background milkyWayBackground = new Background(mlkBg);
        root.setBackground(milkyWayBackground);
    }

    public void enterMilkyWay(ActionEvent event) throws IOException { //throw back home
        Stage currStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("milkyWaySceneView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        currStage.setScene(scene);
    }

    public void enterPlanet1(ActionEvent event) throws IOException { //throw back home
        Stage currStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AndroPlanet1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        currStage.setScene(scene);
    }

    public void enterPlanet2(ActionEvent event) throws IOException { //throw back home
        Stage currStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AndroPlanet2.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        currStage.setScene(scene);
    }
}