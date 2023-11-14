package com.example.gamegui;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class scanController implements Initializable {
    @FXML
    Button b1, b2, b3, b4, b5, b6, b7, b8;

    Scene preScene;

    ArrayList<Button> correctOrder;
    MediaPlayer click;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        correctOrder = new ArrayList<Button>(Arrays.asList(b4, b5, b1, b3, b7, b2, b8, b6));
        click = new MediaPlayer(new Media(getClass().getResource("Sounds/jump_coin.wav").toExternalForm()));
        click.setCycleCount(1);
        click.setVolume(1);
        flashButtons();
        game();
    }

    // Save the previous scene when loading the scan mini-game, that way we can switch back from any planet
    public void setPreScene(Scene preScene) {
        this.preScene = preScene;
    }

    public void flashButtons() {
        for (Button b: correctOrder) {
            b.setVisible(false);
        }
        final IntegerProperty i = new SimpleIntegerProperty(0);
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(
                Duration.seconds(.5),
                event -> {
                    if (i.get() > 7) {
                        timeline.stop();
                    } else {
                        correctOrder.get(i.getValue()).setVisible(true);
                        i.set(i.get() + 1);
                    }
                });
        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void game() {
        ArrayList<Button> currList = new ArrayList<Button>();
        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                click.stop();
                click.play();
                currList.add(b1);
                b1.setVisible(false);
                if (checkWin(currList)) {exit();}
                if (!checkOrder(currList)) {
                    currList.clear();
                    reset();
                }
            }
        });
        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                click.stop();
                click.play();
                currList.add(b2);
                b2.setVisible(false);
                if (checkWin(currList)) {exit();}
                if (!checkOrder(currList)) {
                    currList.clear();
                    reset();
                }
            }
        });
        b3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                click.stop();
                click.play();
                currList.add(b3);
                b3.setVisible(false);
                if (checkWin(currList)) {exit();}
                if (!checkOrder(currList)) {
                    currList.clear();
                    reset();
                }
            }
        });
        b4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                click.stop();
                click.play();
                currList.add(b4);
                b4.setVisible(false);
                if (checkWin(currList)) {exit();}
                if (!checkOrder(currList)) {
                    currList.clear();
                    reset();
                }
            }
        });
        b5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                click.stop();
                click.play();
                currList.add(b5);
                b5.setVisible(false);
                if (checkWin(currList)) {exit();}
                if (!checkOrder(currList)) {
                    currList.clear();
                    reset();
                }
            }
        });
        b6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                click.stop();
                click.play();
                currList.add(b6);
                b6.setVisible(false);
                if (checkWin(currList)) {exit();}
                if (!checkOrder(currList)) {
                    currList.clear();
                    reset();
                }
            }
        });
        b7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                click.stop();
                click.play();
                currList.add(b7);
                b7.setVisible(false);
                if (checkWin(currList)) {exit();}
                if (!checkOrder(currList)) {
                    currList.clear();
                    reset();
                }
            }
        });
        b8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                click.stop();
                click.play();
                currList.add(b8);
                b8.setVisible(false);
                if (checkWin(currList)) {exit();}
                if (!checkOrder(currList)) {
                    currList.clear();
                    reset();
                }
            }
        });
    }

    public boolean checkWin(ArrayList<Button> list) {
        return correctOrder.equals(list);
    }
    public boolean checkOrder(ArrayList<Button> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != correctOrder.get(i)) {
                return false;
            }
        }
        return true;
    }

    // Reset the buttons
    public void reset() {
        System.out.println("Reset");
        for (Button b: correctOrder) {
            b.setVisible(true);
        }
    }

    public void exit() {
        Stage stage = HelloApplication.getStage();
        stage.setScene(preScene);
    }
}
