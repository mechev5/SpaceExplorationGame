package com.example.gamegui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.imageio.ImageIO;

import java.net.URL;
import java.nio.file.DirectoryStream;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.Function;

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
    @FXML
    Slider r_slider, g_slider, b_slider;
    @FXML
    Button export, exit;

    ArrayList<FilterImage> filters;

    private static class FilterImage implements Function<Image, Image> {

        private final String name;
        private final Function<Color, Color> colorMap;
        private Image prev;

        FilterImage(String name, Function<Color, Color> colorMap) {
            this.name = name;
            this.colorMap = colorMap;
        }
        @Override
        public Image apply(Image src) {
            int width = (int) src.getWidth();
            int height = (int) src.getHeight();
            WritableImage img = new WritableImage(width, height);
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    Color color1 = src.getPixelReader().getColor(x, y);
                    Color color2 = colorMap.apply(color1);
                    img.getPixelWriter().setColor(x, y, color2);
                }
            }
            if (src != img) {
                this.prev = src;
            }
            return img;
        }

        public Image getPrev() {
            return prev;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        filters = new ArrayList<FilterImage>();
        filters.add(new FilterImage("gray", Color::grayscale));
        filters.add(new FilterImage("red", color -> Color.color(color.getRed(), color.getBlue(), color.getGreen())));
        filters.add(new FilterImage("green", color -> Color.color(color.getRed(), color.getBlue(), color.getGreen())));
        filters.add(new FilterImage("blue", color -> Color.color(color.getRed(), color.getBlue(), color.getGreen())));
        //filters.add(new FilterImage("mirror", Color::);
        String bgLink = getClass().getResource("images/Whirlpool.jpg").toExternalForm();
        currImage_hbox.setStyle("-fx-background-image: url('" + bgLink + "');");
        load_images();
        setImage(p2);
        load_right();

        r_slider.setVisible(false);
        g_slider.setVisible(false);
        b_slider.setVisible(false);
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

        gray_on.selectedProperty().addListener((observable, newV, oldV) -> {
            //System.out.println(oldV + " -> " + newV);
            if (oldV) {
                setImage(new ImageView (filters.get(0).apply(currImage.getImage())));
            } else {
                setImage(new ImageView (filters.get(0).getPrev()));
            }
        });

        ImageView rightRotate_iv = new ImageView(new Image(getClass().getResource("images/right_rotate.png").toExternalForm()));
        ImageView leftRotate_iv = new ImageView(new Image(getClass().getResource("images/left_rotate.png").toExternalForm()));
        rightRotate_iv.setPreserveRatio(true);
        leftRotate_iv.setPreserveRatio(true);
        rightRotate_iv.setFitWidth(25);
        leftRotate_iv.setFitWidth(25);
        r_left.setGraphic(leftRotate_iv);
        r_right.setGraphic(rightRotate_iv);
        r_left.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                currImage.setRotate(currImage.getRotate() - 90);
                setImage(currImage);
            }
        });
        r_right.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                currImage.setRotate(currImage.getRotate() + 90);
                setImage(currImage);
            }
        });
        mirror_on.selectedProperty().addListener((observable, newV, oldV) -> {
            if (oldV) {
                currImage.setScaleY(-1);
            } else {
                currImage.setScaleY(1);
            }
            setImage(currImage);
        });
        export.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //System.out.println("Exporting");
                WritableImage exp = currImage.snapshot(null, null);

            }
        });
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage currStage = HelloApplication.getStage();
                currStage.setScene(HelloApplication.sceneMap.get("start"));
            }
        });
    }

    //Set the current image
    public void setImage(ImageView newImage) {
        currImage.setImage(newImage.getImage());
        currImage.setPreserveRatio(true);
        currImage.setFitWidth(400);
    }
}


