package com.example.gamegui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class milkyWayController implements Initializable {
    @FXML
    BorderPane root;
    @FXML
    FlowPane fpInv;

    @FXML
    private HBox botMenu;
    @FXML
    ImageView inv1, inv2, inv3, inv4, inv5, inv6, inv7, inv8;
    @FXML
    TextArea scanArea;
    @FXML
    StackPane sp;

    String location;

    // don't use these, access global variables from homeController
    // double currFuel, maxFuel, currDurability, maxDurability;
    @FXML
    protected void onHelloButtonClick() {
    }

    @FXML
    private Button neptune_button, uranus_button, saturn_button, jupiter_button
            , mars_button, earth_button, venus_button, mercury_button, sun_button, returnMilky;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Keep track of all stats using variables, until classes are made
        location = "Gary, ID";
//        currFuel = 77;
//        maxFuel = 100;
//        currDurability = 88.5;
//        maxDurability = 100;
        scanArea.setMinSize(100.0, 100.0);
        scanArea.setEditable(false);

        // Show the variables on screen
        //locationLabel.setText("Location: " + location);
        //fuelLabel.setText("Fuel: " + currFuel + " / " + maxFuel);
        //durabilityLabel.setText("Durability: " + currDurability + " / " + maxDurability);

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

        inv1.setVisible(false);
        inv2.setVisible(false);
        inv3.setVisible(false);
        inv4.setVisible(false);
        inv5.setVisible(false);
        inv6.setVisible(false);
        inv7.setVisible(false);
        inv8.setVisible(false);


        returnMilky.setText("Milky Way Hub");

//        Image menuImage = new Image(getClass().getResource("images/pause.png").toExternalForm());
//        ImageView menuIV = new ImageView(menuImage);
//        menuIV.setPreserveRatio(true);
//        menuIV.setFitWidth(imageW / 8);
//        menuIV.setFitHeight(imageH / 8);


        Image milkyWay = new Image(getClass().getResource("images/milkyWayBack2.jpg").toExternalForm());
        BackgroundImage mlkBg = new BackgroundImage(
                milkyWay,
                null,
                null,
                null,
                null
        );
        Background milkyWayBackground = new Background(mlkBg);
        sp.setBackground(milkyWayBackground);
        loadPlanets();
    }

    public void loadPlanets() {
        // Get each planet png as an imageview. Store each image in map for easy access
        String[] planets = {"earth", "jupiter", "mars", "mercury", "neptune", "saturn", "sun", "uranus", "venus"};
        Map<String, ImageView> images = new HashMap<String, ImageView>();
        for (String planet : planets){
            Image graphicImg = new Image(getClass().getResource("planetImages/" + planet + ".png").toExternalForm());
            ImageView graphicIV = new ImageView(graphicImg);
            graphicIV.setPreserveRatio(true);
            graphicIV.setFitWidth(250);
            graphicIV.setFitHeight(250);
            images.put(planet, graphicIV);
        }
        // Set the images for each planet
        images.get("sun").setFitWidth(300);
        images.get("sun").setFitHeight(300);
        earth_button.setGraphic(images.get("earth"));
        jupiter_button.setGraphic(images.get("jupiter"));
        mars_button.setGraphic(images.get("mars"));
        mercury_button.setGraphic(images.get("mercury"));
        neptune_button.setGraphic(images.get("neptune"));
        saturn_button.setGraphic(images.get("saturn"));
        sun_button.setGraphic(images.get("sun"));
        uranus_button.setGraphic(images.get("uranus"));
        venus_button.setGraphic(images.get("venus"));

        // Set event handlers (set buttons to open pop up window with info on planet)
        earth_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
//                Stage newStage =  new Stage();
//                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("earthView.fxml"));
//                Scene scene = null;
//                try {
//                    scene = new Scene(fxmlLoader.load(), 600, 600);
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//                scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
//                newStage.setTitle("Earth");
//                newStage.setScene(scene);
//                newStage.show();
                scanArea.setMinSize(200.0, 100.0);
                scanArea.setText("Name: Earth\nPlanet Type: Terrestrial\nMass: 5.972 × 10^24 kg\nPlanet Radius: 6378 km\nOrbital Radius: 1 AU\nOrbital Period: 365 days");
            }
        });
        jupiter_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
//                Stage newStage =  new Stage();
//                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("jupiterView.fxml"));
//                Scene scene = null;
//                try {
//                    scene = new Scene(fxmlLoader.load(), 600, 600);
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//                scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
//                newStage.setTitle("Earth");
//                newStage.setScene(scene);
//                newStage.show();
                scanArea.setMinSize(200.0, 100.0);
                scanArea.setText("Name: Jupiter\nPlanet Type: Gas\nMass: 1.8981 × 10^27 kg\nPlanet Radius: 69,911 km\nOrbital Radius: 5 AU\nOrbital Period: 4,330 days");
            }
        });
        mars_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
//                Stage newStage =  new Stage();
//                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("marsView.fxml"));
//                Scene scene = null;
//                try {
//                    scene = new Scene(fxmlLoader.load(), 600, 600);
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//                scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
//                newStage.setTitle("Mars");
//                newStage.setScene(scene);
//                newStage.show();
                scanArea.setMinSize(200.0, 100.0);
                scanArea.setText("Name: Mars\nPlanet Type: Terrestrial\nMass: 6.41693 × 10^23 kg\nPlanet Radius: 3,390 km\nOrbital Radius: 1.5 AU\nOrbital Period: 687 days");
            }
        });

        mercury_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
//                Stage newStage =  new Stage();
//                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mercuryView.fxml"));
//                Scene scene = null;
//                try {
//                    scene = new Scene(fxmlLoader.load(), 600, 600);
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//                scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
//                newStage.setTitle("Mercury");
//                newStage.setScene(scene);
//                newStage.show();
                scanArea.setMinSize(200.0, 100.0);
                scanArea.setText("Name: Mercury\nPlanet Type: Terrestrial\nMass: 3.285 × 10^23 kg\nPlanet Radius: 2,440 km\nOrbital Radius: 0.4 AU\nOrbital Period: 88 days");
            }
        });

        neptune_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
//                Stage newStage =  new Stage();
//                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("neptuneView.fxml"));
//                Scene scene = null;
//                try {
//                    scene = new Scene(fxmlLoader.load(), 600, 600);
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//                scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
//                newStage.setTitle("Neptune");
//                newStage.setScene(scene);
//                newStage.show();
                scanArea.setText("Name: Neptune\nPlanet Type: Gas\nMass: 1.024 × 10^26 kg\nPlanet Radius: 24,622 km\nOrbital Radius: 30 AU\nOrbital Period: 60,190 days");
                scanArea.setMinSize(200.0, 100.0);
            }
        });

        saturn_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
//                Stage newStage =  new Stage();
//                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("saturnView.fxml"));
//                Scene scene = null;
//                try {
//                    scene = new Scene(fxmlLoader.load(), 600, 600);
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//                scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
//                newStage.setTitle("Saturn");
//                newStage.setScene(scene);
//                newStage.show();
                scanArea.setText("Name: Saturn\nPlanet Type: Gas\nMass: 5.6832 × 1026 kg\nPlanet Radius: 58,232 km\nOrbital Radius: 9 AU\nOrbital Period: 10,756 days");
                scanArea.setMinSize(200.0, 100.0);
            }
        });

        uranus_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
//                Stage newStage =  new Stage();
//                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("uranusView.fxml"));
//                Scene scene = null;
//                try {
//                    scene = new Scene(fxmlLoader.load(), 600, 600);
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//                scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
//                newStage.setTitle("uranus");
//                newStage.setScene(scene);
//                newStage.show();
                scanArea.setText("Name: Uranus\nPlanet Type: Gas\nMass: 8.681 × 10^25 kg\nPlanet Radius: 25,362 km\nOrbital Radius: 19.8 AU\nOrbital Period: 30,687 days");
                scanArea.setMinSize(200.0, 100.0);
            }
        });

        venus_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
//                Stage newStage =  new Stage();
//                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("venusView.fxml"));
//                Scene scene = null;
//                try {
//                    scene = new Scene(fxmlLoader.load(), 600, 600);
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//                scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
//                newStage.setTitle("Venus");
//                newStage.setScene(scene);
//                newStage.show();
                scanArea.setText("Name: Venus\nPlanet Type: Terrestrial\nMass: 4.867 × 10^24 kg\nPlanet Radius: 6,051 km\nOrbital Radius: 0.7 AU\nOrbital Period: 225 days");
                scanArea.setMinSize(200.0, 100.0);
            }
        });
        sun_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                scanArea.setText("");
            }
        });
        returnMilky.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    backToMilyWay(actionEvent);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public void backToMilyWay(ActionEvent event) throws IOException {
        Stage currStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("homeView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        currStage.setScene(scene);
    }

}