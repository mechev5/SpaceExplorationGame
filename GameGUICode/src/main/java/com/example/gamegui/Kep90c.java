//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.gamegui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;

public class Kep90c implements Initializable {
    @FXML
    BorderPane root;
    @FXML
    ImageView kepX;
    @FXML
    TextArea planetText;
    @FXML
    Button toPlanet;
    @FXML
    Button backButton;

    public Kep90c() {
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image k = new Image(this.getClass().getResource("planetImages/Kepler-90c.png").toExternalForm());
        this.kepX.setImage(k);
        this.planetText.setMinSize(600.0, 300.0);
        this.planetText.setText("Name: Kepler-90c\nPlanet Type: Super Earth\nDiscovery Date: 2013\nMass: 1.81 Earths\nPlanet Radius: 1.19 x Earth\nOrbital Radius: 0.089 AU\nOrbital Period: 8.7 days");
        this.planetText.setEditable(false);
        this.toPlanet.setText("Explore Planet");
        this.toPlanet.setMinSize(200,50);
        this.toPlanet.setOnAction((e) -> {
            homeController.k90Planet = "c";
            homeController.playerScore = homeController.playerScore + 10;
            FileSwitcher.switchTo(FileStorage.PLANETDEST);
        });
        this.backButton.setText("Return to List");
        this.backButton.setMinSize(200,50);
        this.backButton.setOnAction((e) -> {
            FileSwitcher.switchTo(FileStorage.PLANETLIST);
        });
        Image KP90 = new Image(this.getClass().getResource("images/Kepler_02_Edited.png").toExternalForm());
        BackgroundImage andBg = new BackgroundImage(KP90, (BackgroundRepeat)null, (BackgroundRepeat)null, (BackgroundPosition)null, (BackgroundSize)null);
        Background andromedaBackground = new Background(new BackgroundImage[]{andBg});
        this.root.setBackground(andromedaBackground);
    }
}
