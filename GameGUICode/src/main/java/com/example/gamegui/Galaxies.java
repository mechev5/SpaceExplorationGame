package com.example.gamegui;

    import javafx.animation.PauseTransition;
    import javafx.animation.PathTransition;
    import javafx.animation.TranslateTransition;
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
    import javafx.scene.control.TextField;
    import javafx.scene.image.Image;
    import javafx.scene.image.ImageView;
    import javafx.scene.input.MouseEvent;
    import javafx.scene.layout.*;
    import javafx.scene.media.Media;
    import javafx.scene.media.MediaPlayer;
    import javafx.stage.Stage;
    import javafx.util.Duration;
    import org.controlsfx.control.tableview2.filter.filtereditor.SouthFilter;

    import java.io.IOException;
    import java.net.URL;
    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.Map;
    import java.util.ResourceBundle;
    import java.util.Random;
    import java.lang.Math;

public class Galaxies implements Initializable {

    static public double xPos = 229.0, yPos = 400.0;

    @FXML
    AnchorPane root;

    @FXML
    TextField AsteroidAlert;


    @FXML
    ImageView playerShip;


    @FXML
    Button milkyway;
    @FXML
    Button kepler;
    @FXML
    Button Andro;
    @FXML
    Button testMining;

    TranslateTransition transition = new TranslateTransition();
    MediaPlayer media;

    Random rand = new Random();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Keep track of all stats using variables, until classes are made
        root.setMinSize(1280, 720);
        playerShip.setX(xPos);
        playerShip.setY(yPos);
        playerShip.setTranslateX(0);
        playerShip.setTranslateY(0);
        System.out.println("Player X and Y: " + playerShip.getX() + " - " + playerShip.getY());
        Image galaxyPic = new Image(getClass().getResource("images/GalaxyBackground.jpg").toExternalForm());
        Background backg = new Background(new BackgroundImage(galaxyPic, null, null, null, new BackgroundSize(1300, 1260,false,false,false,false)));
        root.setBackground(backg);
        transition.setNode(playerShip);
        MediaPlayer alarmMedia = new MediaPlayer(new Media(getClass().getResource("Sounds/asteroidAlarm.wav").toExternalForm()));
        media = new MediaPlayer(new Media(getClass().getResource("Sounds/340956__projectsu012__rocket-short.wav").toExternalForm()));
        media.setCycleCount(1);
        media.setVolume(0.1);

        // Animation transition of rocket ship upon clicking on anchorpane
        root.setOnMouseClicked(e-> {
            // update value because jose is worried about being stranded in space with no fuel
            int randomCheck = rand.nextInt(10);
            System.out.println(randomCheck);
            if (randomCheck < 2){
                PauseTransition pause = new PauseTransition(Duration.seconds(4));
                AsteroidAlert.setVisible(true);

                pause.setOnFinished(x->{
                    AsteroidAlert.setVisible(false);
                    alarmMedia.stop();
                    Stage currStage = HelloApplication.getStage();
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AsteroidBelt.fxml"));
                    try {
                        Scene asteroidScene = new Scene(fxmlLoader.load(), 1280, 720);
                        asteroidScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
                        currStage.setScene(asteroidScene);
                    }
                    catch (IOException y){
                        System.out.println("Failure in scene asteroid scene transition");
                        System.out.println(y);
                    }
                });
                alarmMedia.play();
                pause.play();


            }
            else{
                homeController.currFuel -= AsteroidBelt.round(Math.sqrt(Math.pow(Math.max(e.getX(), xPos) - Math.min(xPos,e.getX()), 2) + Math.pow(Math.max(e.getY(), yPos) - Math.min(yPos,e.getY()), 2)) / 50, 0);
                System.out.println(AsteroidBelt.round(Math.sqrt(Math.pow(Math.max(e.getX(), xPos) - Math.min(xPos,e.getX()), 2) + Math.pow(Math.max(e.getY(), yPos) - Math.min(yPos,e.getY()), 2)) / 50, 0));
                PauseTransition pause = new PauseTransition(Duration.seconds(1));
                pause.setOnFinished(x->{
                    media.stop();
                });
                transition.stop();

//

                transition.setToX(e.getX() - playerShip.getX());
                transition.setToY(e.getY() - playerShip.getY());
                transition.toXProperty();
                transition.toYProperty();
                xPos = e.getX();
                yPos = e.getY();

                transition.playFromStart();
                media.play();
                pause.play();
            }

        });

        // Animation transition of rocket ship upon clicking on button
        milkyway.setOnMouseClicked(e-> {
            int randomCheck = rand.nextInt(10);
            System.out.println(randomCheck);
            if (randomCheck < 2){
                PauseTransition pause = new PauseTransition(Duration.seconds(4));
                AsteroidAlert.setVisible(true);

                pause.setOnFinished(x->{
                    AsteroidAlert.setVisible(false);
                    alarmMedia.stop();
                    Stage currStage = HelloApplication.getStage();
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AsteroidBelt.fxml"));
                    try {
                        Scene asteroidScene = new Scene(fxmlLoader.load(), 1280, 720);
                        asteroidScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
                        currStage.setScene(asteroidScene);
                    }
                    catch (IOException y){
                        System.out.println("Failure in scene asteroid scene transition");
                        System.out.println(y);
                    }
                });
                alarmMedia.play();
                pause.play();

            }
            else {
                homeController.currFuel -= AsteroidBelt.round(Math.sqrt(Math.pow(Math.max(e.getSceneX(), xPos) - Math.min(xPos,e.getSceneX()), 2) + Math.pow(Math.max(e.getSceneY(), yPos) - Math.min(yPos,e.getSceneY()), 2)) / 50, 0);
                System.out.println(AsteroidBelt.round(Math.sqrt(Math.pow(Math.max(e.getSceneX(), xPos) - Math.min(xPos,e.getSceneX()), 2) + Math.pow(Math.max(e.getSceneY(), yPos) - Math.min(yPos,e.getSceneY()), 2)) / 50, 0));
                PauseTransition pause = new PauseTransition(Duration.seconds(1));
                pause.setOnFinished(x -> {
                    media.stop();
                    try {
                        enterMilkyWay(e);
                    }
                    catch (IOException l){
                        System.out.println(l);
                    }
                });
                transition.stop();

                transition.setToX(e.getSceneX() - playerShip.getX());
                transition.setToY(e.getSceneY() - playerShip.getY());
                transition.toXProperty();
                transition.toYProperty();
                xPos = e.getSceneX();
                yPos = e.getSceneY();

                transition.play();
                media.play();
                pause.play();
            }
        });

        // Same as above but for kepler button
        kepler.setOnMouseClicked(e-> {
            int randomCheck = rand.nextInt(10);
            System.out.println(randomCheck);
            if (randomCheck < 2){
                PauseTransition pause = new PauseTransition(Duration.seconds(4));
                AsteroidAlert.setVisible(true);

                pause.setOnFinished(x->{
                    AsteroidAlert.setVisible(false);
                    alarmMedia.stop();
                    Stage currStage = HelloApplication.getStage();
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AsteroidBelt.fxml"));
                    try {
                        Scene asteroidScene = new Scene(fxmlLoader.load(), 1280, 720);
                        asteroidScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
                        currStage.setScene(asteroidScene);
                    }
                    catch (IOException y){
                        System.out.println("Failure in scene asteroid scene transition");
                        System.out.println(y);
                    }
                });
                alarmMedia.play();
                pause.play();

            }
            else {
                homeController.currFuel -= AsteroidBelt.round(Math.sqrt(Math.pow(Math.max(e.getSceneX(), xPos) - Math.min(xPos,e.getSceneX()), 2) + Math.pow(Math.max(e.getSceneY(), yPos) - Math.min(yPos,e.getSceneY()), 2)) / 50, 0);
                System.out.println(AsteroidBelt.round(Math.sqrt(Math.pow(Math.max(e.getSceneX(), xPos) - Math.min(xPos,e.getSceneX()), 2) + Math.pow(Math.max(e.getSceneY(), yPos) - Math.min(yPos,e.getSceneY()), 2)) / 50, 0));
                PauseTransition pause = new PauseTransition(Duration.seconds(1));
                pause.setOnFinished(x -> {
                    media.stop();
                    try {
                        enterKepler(e);
                    }
                    catch (IOException l){
                        System.out.println(l);
                    }

                });
                transition.stop();

                transition.setToX(e.getSceneX() - playerShip.getX());
                transition.setToY(e.getSceneY() - playerShip.getY());
                transition.toXProperty();
                transition.toYProperty();
                xPos = e.getSceneX();
                yPos = e.getSceneY();


                transition.play();
                media.play();
                pause.play();
            }
        });

        Andro.setOnMouseClicked(e-> {
            int randomCheck = rand.nextInt(10);
            System.out.println(randomCheck);
            if (randomCheck < 2){
                PauseTransition pause = new PauseTransition(Duration.seconds(4));
                AsteroidAlert.setVisible(true);

                pause.setOnFinished(x->{
                    AsteroidAlert.setVisible(false);
                    alarmMedia.stop();
                    Stage currStage = HelloApplication.getStage();
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AsteroidBelt.fxml"));
                    try {
                        Scene asteroidScene = new Scene(fxmlLoader.load(), 1280, 720);
                        asteroidScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
                        currStage.setScene(asteroidScene);
                    }
                    catch (IOException y){
                        System.out.println("Failure in scene asteroid scene transition");
                        System.out.println(y);
                    }
                });
                alarmMedia.play();
                pause.play();

            }
            else {
                homeController.currFuel -= AsteroidBelt.round(Math.sqrt(Math.pow(Math.max(e.getSceneX(), xPos) - Math.min(xPos,e.getSceneX()), 2) + Math.pow(Math.max(e.getSceneY(), yPos) - Math.min(yPos,e.getSceneY()), 2)) / 50, 0);
                System.out.println(AsteroidBelt.round(Math.sqrt(Math.pow(Math.max(e.getSceneX(), xPos) - Math.min(xPos,e.getSceneX()), 2) + Math.pow(Math.max(e.getSceneY(), yPos) - Math.min(yPos,e.getSceneY()), 2)) / 50, 0));
                PauseTransition pause = new PauseTransition(Duration.seconds(1));
                pause.setOnFinished(x -> {
                    media.stop();
                    try {
                        enterAndro(e);
                    }
                    catch (IOException l){
                        System.out.println(l);
                    }

                });
                transition.stop();



                transition.setToX(e.getSceneX() - playerShip.getX());
                transition.setToY(e.getSceneY() - playerShip.getY());
                transition.toXProperty();
                transition.toYProperty();
                xPos = e.getSceneX();
                yPos = e.getSceneY();

                transition.play();
                media.play();
                pause.play();
            }
        });

        testMining.setOnMouseClicked(e->{
            Stage currStage = HelloApplication.getStage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fuelMine.fxml"));
            try {
                Scene asteroidScene = new Scene(fxmlLoader.load(), 1280, 720);
                asteroidScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
                currStage.setScene(asteroidScene);
            }
            catch (IOException y){
                System.out.println("Failure in scene asteroid scene transition");
                System.out.println(y);
            }
        });

    }

    public void enterMilkyWay(MouseEvent event) throws IOException {
        Stage currStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("homeView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(x->{
            scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
            currStage.setScene(scene);
        });
        pause.play();
    }
    public void enterKepler(MouseEvent event) throws IOException {
        Stage currStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        BorderPane bP = new BorderPane();
        Scene scene = new Scene(bP, 1280.0, 720.0);
        FileSwitcher.setScene(scene);
        FileSwitcher.switchTo(FileStorage.KEPLERSOLARSYSTEM);
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(x->{
            currStage.setScene(scene);
        });
        pause.play();
    }

    public void enterAndro(MouseEvent event) throws IOException {
        Stage currStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        //maybe crea
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AScene1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(x->{
            currStage.setScene(scene);
        });
        pause.play();
    }


}
