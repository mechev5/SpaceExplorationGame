//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.gamegui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class keplerSystem implements Initializable {
    @FXML
    BorderPane root;
    @FXML
    FlowPane fpInv;
    @FXML
    Label locationLabel;
    @FXML
    Label fuelLabel;
    @FXML
    Label durabilityLabel;
    @FXML
    private HBox botMenu;
    @FXML
    ImageView inv1;
    @FXML
    ImageView inv2;
    @FXML
    ImageView inv3;
    @FXML
    ImageView inv4;
    @FXML
    ImageView inv5;
    @FXML
    ImageView inv6;
    @FXML
    ImageView inv7;
    @FXML
    ImageView inv8;
    @FXML
    ImageView gl;
    String location;
    Image WP_Edited = new Image(getClass().getResource("images/WP_Edited.png").toExternalForm());
    BackgroundImage WP_E_BG;
    Background WP_E_B;
    @FXML
    private Button menuButton, changeDestination, galaxyButton;


    public keplerSystem() {
        this.WP_E_BG = new BackgroundImage(this.WP_Edited, (BackgroundRepeat)null, (BackgroundRepeat)null, (BackgroundPosition)null, (BackgroundSize)null);
        this.WP_E_B = new Background(new BackgroundImage[]{this.WP_E_BG});
    }

    @FXML
    protected void onGalaxyButtonClick() throws IOException {
        FileSwitcher.switchTo(FileStorage.PLANETLIST);
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.location = "Designation: Kepler";

        this.locationLabel.setText(this.location);
        this.fuelLabel.setText("Fuel: " + homeController.currFuel + " / " + homeController.maxFuel);
        this.durabilityLabel.setText("Durability: " + homeController.currDurability + " / " + homeController.maxDurability);
        Image square = new Image(this.getClass().getResource("images/square.png").toExternalForm());
        int imageH = 512;
        int imageW = 512;
        this.inv1.setImage(square);
        this.inv2.setImage(square);
        this.inv3.setImage(square);
        this.inv4.setImage(square);
        this.inv5.setImage(square);
        this.inv6.setImage(square);
        this.inv7.setImage(square);
        this.inv8.setImage(square);
        this.inv1.setPreserveRatio(true);
        this.inv2.setPreserveRatio(true);
        this.inv3.setPreserveRatio(true);
        this.inv4.setPreserveRatio(true);
        this.inv5.setPreserveRatio(true);
        this.inv6.setPreserveRatio(true);
        this.inv7.setPreserveRatio(true);
        this.inv8.setPreserveRatio(true);
        this.inv1.setFitHeight((double)(imageH / 5));
        this.inv2.setFitHeight((double)(imageH / 5));
        this.inv3.setFitHeight((double)(imageH / 5));
        this.inv4.setFitHeight((double)(imageH / 5));
        this.inv5.setFitHeight((double)(imageH / 5));
        this.inv6.setFitHeight((double)(imageH / 5));
        this.inv7.setFitHeight((double)(imageH / 5));
        this.inv8.setFitHeight((double)(imageH / 5));
        this.inv1.setFitWidth((double)(imageW / 5));
        this.inv2.setFitWidth((double)(imageW / 5));
        this.inv3.setFitWidth((double)(imageW / 5));
        this.inv4.setFitWidth((double)(imageW / 5));
        this.inv5.setFitWidth((double)(imageW / 5));
        this.inv6.setFitWidth((double)(imageW / 5));
        this.inv7.setFitWidth((double)(imageW / 5));
        this.inv8.setFitWidth((double)(imageW / 5));
        Image menuImage = new Image(this.getClass().getResource("images/pause.png").toExternalForm());
        ImageView menuIV = new ImageView(menuImage);
        menuIV.setPreserveRatio(true);
        menuIV.setFitWidth((double)(imageW / 8));
        menuIV.setFitHeight((double)(imageH / 8));
        this.menuButton.setGraphic(menuIV);
        Image galaxy = new Image(this.getClass().getResource("images/Spiral-02.png").toExternalForm());
        ImageView galaxyIV = new ImageView(galaxy);
        galaxyIV.setPreserveRatio(true);
        galaxyIV.setFitWidth((double)(imageW / 4));
        galaxyIV.setFitHeight((double)(imageH / 4));
        this.galaxyButton.setGraphic(galaxyIV);
        Image andromeda = new Image(this.getClass().getResource("images/Kepler_02.jpg").toExternalForm());
        BackgroundImage andBg = new BackgroundImage(andromeda, (BackgroundRepeat)null, (BackgroundRepeat)null, (BackgroundPosition)null, (BackgroundSize)null);
        Background andromedaBackground = new Background(new BackgroundImage[]{andBg});
        this.root.setBackground(andromedaBackground);

        // galaxyButotn.setOnAction(e-> FileSwitcher.switchTo(FileStorage.PLANETLIST));

        inv1.setVisible(false);
        inv2.setVisible(false);
        inv3.setVisible(false);
        inv4.setVisible(false);
        inv5.setVisible(false);
        inv6.setVisible(false);
        inv7.setVisible(false);
        inv8.setVisible(false);


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

    }

    public void changeGalaxies(ActionEvent event) throws IOException {
        Stage currStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("galaxy.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        currStage.setScene(scene);
    }
}

