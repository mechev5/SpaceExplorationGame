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

public class Kep90i implements Initializable {
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

    public Kep90i() {
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image k = new Image(this.getClass().getResource("planetImages/Kepler-90i.png").toExternalForm());
        this.kepX.setImage(k);
        this.planetText.setMinSize(600.0, 300.0);
        this.planetText.setText("Name: Kepler-90i\nPlanet Type: Super Earth\nDiscovery Date: 2017\nMass: 2.3 Earth\nPlanet Radius: 1.32 x Earth\nOrbital Radius: Unknown\nOrbital Period: 14.4 days");
        this.toPlanet.setText("Explore Planet");
        this.backButton.setText("Return to List");
        this.backButton.setOnAction((e) -> {
            FileSwitcher.switchTo(FileStorage.PLANETLIST);
        });
        Image KP90 = new Image(this.getClass().getResource("images/Kepler_02_Edited.png").toExternalForm());
        BackgroundImage andBg = new BackgroundImage(KP90, (BackgroundRepeat)null, (BackgroundRepeat)null, (BackgroundPosition)null, (BackgroundSize)null);
        Background andromedaBackground = new Background(new BackgroundImage[]{andBg});
        this.root.setBackground(andromedaBackground);
    }
}

