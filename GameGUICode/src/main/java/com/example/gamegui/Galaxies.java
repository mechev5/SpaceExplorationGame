package com.example.gamegui;

    import javafx.animation.PauseTransition;
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
    import javafx.scene.layout.*;
    import javafx.scene.media.Media;
    import javafx.scene.media.MediaPlayer;
    import javafx.stage.Stage;
    import javafx.util.Duration;

    import java.io.IOException;
    import java.net.URL;
    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.Map;
    import java.util.ResourceBundle;
    import java.util.Random;

public class Galaxies implements Initializable {

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

    TranslateTransition transition = new TranslateTransition();
    MediaPlayer media;

    Random rand = new Random();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Keep track of all stats using variables, until classes are made
        root.setMinSize(1280, 720);
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
                homeController.currFuel = homeController.currFuel - 5;
                PauseTransition pause = new PauseTransition(Duration.seconds(1));
                pause.setOnFinished(x->{
                    media.stop();
                });
                transition.stop();
//            System.out.println(e.getX());
//            System.out.println(e.getY());
                transition.setToX(e.getX());
                transition.setToY(e.getY());
                transition.toXProperty();
                transition.toYProperty();
                transition.play();
                media.play();
                pause.play();
            }

        });

        // Animation transition of rocket ship upon clicking on button
        milkyway.setOnMouseClicked(e-> {
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(x->{
                media.stop();
            });
            transition.stop();
//            System.out.println(e.getSceneX());
//            System.out.println(e.getSceneY());
            transition.setToX(e.getSceneX());
            transition.setToY(e.getSceneY());
            transition.toXProperty();
            transition.toYProperty();
            transition.play();
            media.play();
            pause.play();
        });

        // Same as above but for kepler button
        kepler.setOnMouseClicked(e-> {
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(x->{
                media.stop();
            });
            transition.stop();
//            System.out.println(e.getSceneX());
//            System.out.println(e.getSceneY());
            transition.setToX(e.getSceneX());
            transition.setToY(e.getSceneY());
            transition.toXProperty();
            transition.toYProperty();
            transition.play();
            media.play();
            pause.play();
        });


    }

    public void enterMilkyWay(ActionEvent event) throws IOException {
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
    public void enterKepler(ActionEvent event) throws IOException {
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

    public void enterAndro(ActionEvent event) throws IOException {
        Stage currStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AScene1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(x->{
            currStage.setScene(scene);
        });
        pause.play();
    }
}
