package com.example.gamegui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class creativeController implements Initializable {
    @FXML
    FlowPane fp;
    @FXML
    ImageView prev, p1, p2, p3, p4, p5, p6, next, currImage;
    @FXML
    ToggleButton gray_on, gray_off, mirror_on, mirror_off;
    ToggleGroup gray_tg, mirror_tg;

    @FXML
    VBox sidebar_vbox;
    @FXML
    HBox currImage_hbox;
    @FXML
    Button r_left, r_right;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String bgLink = getClass().getResource("images/Whirlpool.jpg").toExternalForm();
        currImage_hbox.setStyle("-fx-background-image: url('" + bgLink + "');");
        load_images();
        load_right();
        setImage(p2);
    }

    public void load_images() {
        // Load the bottom planet images
        prev = new ImageView(new Image(getClass().getResource("images/back.png").toExternalForm()));
        p1 = new ImageView(new Image(getClass().getResource("planetImages/earth.png").toExternalForm()));
        p2 = new ImageView(new Image(getClass().getResource("planetImages/jupiter.png").toExternalForm()));
        p3 = new ImageView(new Image(getClass().getResource("planetImages/Kepler-90b.png").toExternalForm()));
        p4 = new ImageView(new Image(getClass().getResource("planetImages/Kepler-90c.png").toExternalForm()));
        p5 = new ImageView(new Image(getClass().getResource("planetImages/mars.png").toExternalForm()));
        p6 = new ImageView(new Image(getClass().getResource("planetImages/neptune.png").toExternalForm()));
        next = new ImageView(new Image(getClass().getResource("images/forward.png").toExternalForm()));
        ImageView[] images = {prev, p1, p2, p3, p4, p5, p6, next};
        // Attach each image to a button, fix the size, and add to the flowPlane
        for (ImageView img: images) {
            Button tempButton = new Button();
            tempButton.setStyle("-fx-background-color: transparent;");
            img.setPreserveRatio(true);
            img.setFitWidth(100);
            img.setFitHeight(100);
            tempButton.setGraphic(img);
            fp.getChildren().add(tempButton);
            if (img != prev && img != next) {
                tempButton.setOnAction(actionEvent -> setImage(img));
            }
        }
        fp.setMaxWidth(1200);
    }

    // Load the right side menu
    public void load_right() {
        mirror_tg = new ToggleGroup();
        gray_tg = new ToggleGroup();
        gray_on.setToggleGroup(gray_tg);
        gray_off.setToggleGroup(gray_tg);
        mirror_on.setToggleGroup(mirror_tg);
        mirror_off.setToggleGroup(mirror_tg);

        ImageView rightRotate_iv = new ImageView(new Image(getClass().getResource("images/right_rotate.png").toExternalForm()));
        ImageView leftRotate_iv = new ImageView(new Image(getClass().getResource("images/left_rotate.png").toExternalForm()));
        rightRotate_iv.setPreserveRatio(true);
        leftRotate_iv.setPreserveRatio(true);
        rightRotate_iv.setFitWidth(25);
        leftRotate_iv.setFitWidth(25);
        r_left.setGraphic(leftRotate_iv);
        r_right.setGraphic(rightRotate_iv);
    }

    //Set the current image
    public void setImage(ImageView newImage) {
        currImage.setImage(newImage.getImage());
        currImage.setPreserveRatio(true);
        currImage.setFitWidth(400);
    }
}
