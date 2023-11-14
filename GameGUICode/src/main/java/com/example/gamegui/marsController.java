package com.example.gamegui;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class marsController implements Initializable {
    @FXML
    Button back_button, scan_button;
    @FXML
    ImageView load_iv;
    @FXML
    TextArea textarea;
    @FXML
    Label fuel_label, durability_label;

    final String info = "Name: Mars\n\n\nPlanet Type: Terrestrial\n\n\nMass: 6.41693 × 10^23 kg\n\n\nPlanet Radius: 3,390 km\n\n\nOrbital Radius: 1.5 AU\n\n\nOrbital Period: 687 days";
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        load_iv.setVisible(false);
        fuel_label.setText(String.valueOf(homeController.currFuel));
        durability_label.setText(String.valueOf(homeController.currDurability));
        back_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage newStage =  HelloApplication.getStage();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("milkyWaySceneView.fxml"));
                Scene scene = null;
                try {
                    scene = new Scene(fxmlLoader.load(), 1280, 720);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
                newStage.setTitle("Space Exploration Game");
                newStage.setScene(scene);
                newStage.show();
            }
        });
        scan_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                final IntegerProperty i = new SimpleIntegerProperty(0);
                Timeline timeline = new Timeline();
                KeyFrame keyFrame = new KeyFrame(
                        Duration.seconds(.05),
                        event -> {
                            if (i.get() > info.length()) {
                                timeline.stop();
                            } else {
                                textarea.setText(info.substring(0, i.get()));
                                i.set(i.get() + 1);
                            }
                        });
                timeline.getKeyFrames().add(keyFrame);
                timeline.setCycleCount(Animation.INDEFINITE);
                load_iv.setVisible(true);
                PauseTransition visiblePause = new PauseTransition(
                        Duration.seconds(2)
                );
                Random random = new Random();
                int r = random.nextInt(101);
                visiblePause.setOnFinished(
                        new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                load_iv.setVisible(false);
                                // 20/100 chance of playing mini-game
                                System.out.println(r);
                                if (r < 20) {
                                    loadGame();
                                }
                                timeline.play();
                            }
                        }
                );
                visiblePause.play();
                //textarea.appendText(info);

            }
        });
    }

    public void loadGame() {
        Stage newStage =  HelloApplication.getStage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("scan_game.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1280, 720);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        scanController controller = fxmlLoader.getController();
        controller.setPreScene(load_iv.getScene());
        newStage.setTitle("Space Exploration Game");
        newStage.setScene(scene);
        newStage.show();
    }
}
