package com.example.gamegui;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
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

public class PlanetDestinationTest implements Initializable {
    @FXML
    BorderPane root;
    @FXML
    ImageView planet;
    @FXML
    Button returnToList;
    @FXML
    Button fuelMinigame;
    @FXML
    HBox test;
    @FXML
    private Button menuButton, changeDestination, galaxyButton;

    public JSONPlanetTest planetInitialization(String galaxy, String planet) throws IOException {
        JSONPlanetTest myTest2 = new JSONPlanetTest("PlanetTest.json", galaxy, planet);
        // System.out.println("Inside planetInitialization");
        myTest2.planetInformation();
        return myTest2;
    }

    public void loadingMap() throws IOException {

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Image myPlanet = new Image(this.getClass().getResource("planetImages/Kepler-90"+homeController.k90Planet+".png").toExternalForm());
        this.planet.setImage(myPlanet);
        // this.test = new HBox();
        // this.test.setAlignment(Pos.CENTER);

        JSONPlanetTest planetInfo = null;
        try {
            planetInfo = planetInitialization("Kepler90", homeController.k90Planet);
            // System.out.println(planetInfo.planetType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Image img;

        //

        if (Objects.equals(planetInfo.planetType, "Super Earth")) {
            img = new Image(this.getClass().getResource("images/Super Earth Landscape.gif").toExternalForm());
        } else if (Objects.equals(planetInfo.planetType, "Neptune-like")) {
            img = new Image(this.getClass().getResource("images/Neptune Like Landscape.gif").toExternalForm());
        } else if (Objects.equals(planetInfo.planetType, "Gas Giant")) {
            img = new Image(this.getClass().getResource("images/Gas Giant Landscape.png").toExternalForm());
        } else {
            System.out.println("MASSIVE ERROR ON TRYING TO READ PLANET TYPE, PLANET TYPE INVALID");
            throw new RuntimeException();
        }

        this.returnToList.setText("Return to List");
        this.returnToList.setMinSize(200,50);
        this.returnToList.setOnAction((e) -> {
            // Stage currStage = HelloApplication.getStage();
            // currStage.setScene(HelloApplication.sceneMap.get("death"));
            FileSwitcher.switchTo(FileStorage.PLANETLIST);
        });
        this.fuelMinigame.setText("Gather Fuel");
        this.fuelMinigame.setMinSize(200, 50);
        this.fuelMinigame.setOnAction(e->{
            Stage currStage = HelloApplication.getStage();
            HelloApplication.setHolderScene(currStage.getScene());
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fuelMine.fxml"));
            try {
                Scene fuelScene = new Scene(fxmlLoader.load(), 1280, 720);
                fuelScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
                currStage.setScene(fuelScene);
            }
            catch (IOException y){
                System.out.println("Failure in scene asteroid scene transition");
                System.out.println(y);
            }
        });
         //

        // img = new Image(this.getClass().getResource("images/Kepler_02.jpg").toExternalForm());
        BackgroundImage bgImg = new BackgroundImage(img,
                null,
                null,
                null,
                null);
        Background bg = new Background(bgImg);
        this.root.setBackground(bg);

    }
}
