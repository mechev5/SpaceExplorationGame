package com.example.gamegui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
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
    double currFuel, maxFuel, currDurability, maxDurability;
    @FXML
    protected void onHelloButtonClick() {
    }

    @FXML
    private Button menuButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Keep track of all stats using variables, until classes are made
        location = "Gary, ID";
        currFuel = 77;
        maxFuel = 100;
        currDurability = 88.5;
        maxDurability = 100;

        // Show the variables on screen
        locationLabel.setText("Location: " + location);
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
        menuButton.setGraphic(menuIV);

// First, load the Andromeda image
        Image andromeda = new Image("Andromeda galaxy.jpg");
        BackgroundImage andBg = new BackgroundImage(
                andromeda,
                null,
                null,
                null,
                null
        );
        Background andromedaBackground = new Background(andBg);
        root.setBackground(andromedaBackground);

    }
}