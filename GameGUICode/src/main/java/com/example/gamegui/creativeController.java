package com.example.gamegui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
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
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.function.Function;

public class creativeController implements Initializable {
    @FXML
    FlowPane fp;
    @FXML
    ImageView prev, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16,
            w1, w2, w3, w4, w5, w6, w7, w8, next, currImage, prev2, next2;
    @FXML
    ToggleButton gray_on, gray_off, mirror_on, mirror_off, planets_tb, backgrounds_tb;
    ToggleGroup gray_tg, mirror_tg, bottom_tg;

    @FXML
    VBox sidebar_vbox, tg_vbox;
    @FXML
    HBox currImage_hbox, bottom_hbox;
    @FXML
    Button r_left, r_right;
    @FXML
    Slider size_slider;
    @FXML
    Button export, exit, prev_b, next_b, prev2_b, next2_b;
    double width = 400;
    ArrayList<Button> w_buttons, p_buttons;

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
        size_slider.setValue(100);
        load_images();
        setImage(p2);
        load_right();
    }

    public void load_images() {
        // Load the bottom planet images
        prev = new ImageView(new Image(getClass().getResource("images/back.png").toExternalForm()));
        p1 = new ImageView(new Image(getClass().getResource("planetImages/earth.png").toExternalForm()));
        p2 = new ImageView(new Image(getClass().getResource("planetImages/jupiter.png").toExternalForm()));
        p3 = new ImageView(new Image(getClass().getResource("planetImages/mars.png").toExternalForm()));
        p4 = new ImageView(new Image(getClass().getResource("planetImages/mercury.png").toExternalForm()));
        p5 = new ImageView(new Image(getClass().getResource("planetImages/neptune.png").toExternalForm()));
        p6 = new ImageView(new Image(getClass().getResource("planetImages/saturn.png").toExternalForm()));
        p7 = new ImageView(new Image(getClass().getResource("planetImages/uranus.png").toExternalForm()));
        p8 = new ImageView(new Image(getClass().getResource("planetImages/venus.png").toExternalForm()));
        p9 = new ImageView(new Image(getClass().getResource("planetImages/Kepler-90b.png").toExternalForm()));
        p10 = new ImageView(new Image(getClass().getResource("planetImages/Kepler-90c.png").toExternalForm()));
        p11 = new ImageView(new Image(getClass().getResource("planetImages/Kepler-90d.png").toExternalForm()));
        p12 = new ImageView(new Image(getClass().getResource("planetImages/Kepler-90e.png").toExternalForm()));
        p13 = new ImageView(new Image(getClass().getResource("planetImages/Kepler-90f.png").toExternalForm()));
        p14 = new ImageView(new Image(getClass().getResource("planetImages/Kepler-90g.png").toExternalForm()));
        p15 = new ImageView(new Image(getClass().getResource("planetImages/Kepler-90h.png").toExternalForm()));
        p16 = new ImageView(new Image(getClass().getResource("planetImages/Kepler-90i.png").toExternalForm()));
        next = new ImageView(new Image(getClass().getResource("images/forward.png").toExternalForm()));
        ImageView[] p_images = {prev, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, next};
        p_buttons = new ArrayList<Button>();
        // Attach each image to a button, fix the size, and add to the flowPlane
        for (ImageView img: p_images) {
            Button tempButton = new Button();
            tempButton.setStyle("-fx-background-color: transparent;");
            img.setPreserveRatio(true);
            img.setFitWidth(100);
            img.setFitHeight(100);
            tempButton.setGraphic(img);
            if (img == prev) {
                prev_b = tempButton;
            } else if (img == next) {
                next_b = tempButton;
            }else {
                p_buttons.add(tempButton);
                tempButton.setOnAction(ActionEvent -> setImage(img));
            }
        }
        fp.getChildren().add(prev_b);
        for (int i = 0; i < 6; i++) {
            fp.getChildren().add(p_buttons.get(i));
        }
        fp.getChildren().add(next_b);
        prev_b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Collections.rotate(p_buttons, -1);
                flipHBox(1);
            }
        });
        next_b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Collections.rotate(p_buttons, -1);
                flipHBox(1);
            }
        });
        loadBgs();
        fp.setMaxWidth(1200);
    }

    // Load the right side menu
    public void load_right() {
        mirror_tg = new ToggleGroup();
        gray_tg = new ToggleGroup();
        bottom_tg = new ToggleGroup();

        gray_on.setToggleGroup(gray_tg);
        gray_off.setToggleGroup(gray_tg);
        mirror_on.setToggleGroup(mirror_tg);
        mirror_off.setToggleGroup(mirror_tg);
        backgrounds_tb.setToggleGroup(bottom_tg);
        planets_tb.setToggleGroup(bottom_tg);

        ImageView bgtb = new ImageView(new Image(getClass().getResource("images/night-sky_black.png").toExternalForm()));
        ImageView bgtb2 = new ImageView(new Image(getClass().getResource("images/night-sky_blue.png").toExternalForm()));
        ImageView ptb = new ImageView(new Image(getClass().getResource("images/orbit_black.png").toExternalForm()));
        ImageView ptb2 = new ImageView(new Image(getClass().getResource("images/orbit_blue.png").toExternalForm()));
        bgtb.setPreserveRatio(true);
        ptb.setPreserveRatio(true);
        bgtb.setFitWidth(50);
        ptb.setFitWidth(50);
        bgtb2.setPreserveRatio(true);
        ptb2.setPreserveRatio(true);
        bgtb2.setFitWidth(50);
        ptb2.setFitWidth(50);
        backgrounds_tb.setGraphic(bgtb);
        planets_tb.setGraphic(ptb);

        gray_on.selectedProperty().addListener((observable, newV, oldV) -> {
            //System.out.println(oldV + " -> " + newV);
            if (oldV) {
                setImage(new ImageView (filters.get(0).apply(currImage.getImage())));
            } else {
                setImage(new ImageView (filters.get(0).getPrev()));
            }
        });

        backgrounds_tb.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (t1) {
                    flipHBox(0);
                    backgrounds_tb.setGraphic(bgtb2);
                } else {
                    backgrounds_tb.setGraphic(bgtb);
                }
            }
        });
        planets_tb.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (t1) {
                    flipHBox(1);
                    planets_tb.setGraphic(ptb2);
                } else {
                    planets_tb.setGraphic(ptb);
                }
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
                WritableImage exp = new WritableImage((int) currImage_hbox.getWidth(), (int) currImage_hbox.getHeight());
                currImage_hbox.snapshot(null, exp);
                try {
                    File outputImgFile = new File("custom_wallpaper.png");
                    ImageIO.write(Objects.requireNonNull(SwingFXUtils.fromFXImage(exp, null)), "png", outputImgFile);
                    System.out.println("Image saved to " + outputImgFile.getAbsolutePath());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage currStage = HelloApplication.getStage();
                currStage.setScene(HelloApplication.sceneMap.get("start"));
                width = 400;
                size_slider.setValue(50);
            }
        });
        size_slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number newN) {
                double percent = newN.doubleValue() / 100;
                if (percent > 1.45) {
                    percent = 1.45;
                }
                if (percent == 0) {
                    width = 0.01;
                } else {
                    width = 400 * percent;
                }
                setImage(currImage);
            }
        });
    }

    public void loadBgs() {
        prev2 = new ImageView(new Image(getClass().getResource("images/back.png").toExternalForm()));
        w1 = new ImageView(new Image(getClass().getResource("backgrounds/Whirlpool.jpg").toExternalForm()));
        w2 = new ImageView(new Image(getClass().getResource("backgrounds/nebula.jpg").toExternalForm()));
        w3 = new ImageView(new Image(getClass().getResource("backgrounds/space_blue.jpg").toExternalForm()));
        w4 = new ImageView(new Image(getClass().getResource("backgrounds/space_colorful.jpg").toExternalForm()));
        w5 = new ImageView(new Image(getClass().getResource("backgrounds/space_blue2.jpg").toExternalForm()));
        w6 = new ImageView(new Image(getClass().getResource("backgrounds/space_darkpurple.jpg").toExternalForm()));
        w7 = new ImageView(new Image(getClass().getResource("backgrounds/space_spaceship.jpg").toExternalForm()));
        w8 = new ImageView(new Image(getClass().getResource("backgrounds/space_stars.jpg").toExternalForm()));
        next2 = new ImageView(new Image(getClass().getResource("images/forward.png").toExternalForm()));
        ImageView[] w_images = {prev2, w1, w2, w3, w4, w5, w6, w7, w8, next2};
        w_buttons = new ArrayList<Button>();
        // Attach each image to a button, fix the size, and add to the flowPlane
        for (ImageView img: w_images) {
            Button tempButton = new Button();
            tempButton.setStyle("-fx-background-color: transparent;");
            img.setPreserveRatio(true);
            img.setFitWidth(100);
            img.setFitHeight(100);
            tempButton.setGraphic(img);
            if (img == prev2) {
                prev2_b = tempButton;
            } else if (img == next2) {
                next2_b = tempButton;
            } else {
                w_buttons.add(tempButton);
                tempButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        BackgroundSize s = new BackgroundSize(1280, 720, false, false
                        , false, false);
                        BackgroundImage b = new BackgroundImage(img.getImage(), BackgroundRepeat.NO_REPEAT
                                , BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, s);
                        currImage_hbox.setBackground(new Background(b));
                    }
                });
            }
        }
        prev2_b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Collections.rotate(w_buttons, 1);
                flipHBox(0);
            }
        });
        next2_b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Collections.rotate(w_buttons, -1);
                flipHBox(0);
            }
        });
    }
    public void flipHBox(int i) {
        if (i == 0) {
            fp.getChildren().setAll(tg_vbox);
            fp.getChildren().add(prev2_b);
            fp.getChildren().addAll(w_buttons.subList(0, 6));
            fp.getChildren().add(next2_b);
        } else {
            fp.getChildren().setAll(tg_vbox);
            fp.getChildren().add(prev_b);
            fp.getChildren().addAll(p_buttons.subList(0, 6));
            fp.getChildren().add(next_b);
        }
    }

    //Set the current image
    public void setImage(ImageView newImage) {
        currImage.setImage(newImage.getImage());
        currImage.setPreserveRatio(true);
        currImage.setFitWidth(width);
    }
}


