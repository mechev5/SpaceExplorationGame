//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.gamegui;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
import javafx.scene.layout.VBox;

public class planetList implements Initializable {
    @FXML
    BorderPane root;
    @FXML
    ImageView k90b;
    @FXML
    ImageView k90c;
    @FXML
    ImageView k90d;
    @FXML
    ImageView k90e;
    @FXML
    ImageView k90f;
    @FXML
    ImageView k90g;
    @FXML
    ImageView k90h;
    @FXML
    ImageView k90i;
    @FXML
    Button leftButton;
    @FXML
    Button middleButton;
//    @FXML
//    Button rightButton;
    @FXML
    VBox topRow;
    @FXML
    VBox middleRow;
    @FXML
    VBox bottomRow;
    Image k90a = new Image(this.getClass().getResource("images/Kepler_02_Edited.png").toExternalForm());
    BackgroundImage k90aBG;
    Background k90aB;
    @FXML
    private Label welcomeText;

    public planetList() {
        this.k90aBG = new BackgroundImage(this.k90a, (BackgroundRepeat)null, (BackgroundRepeat)null, (BackgroundPosition)null, (BackgroundSize)null);
        this.k90aB = new Background(new BackgroundImage[]{this.k90aBG});
    }

    @FXML
    protected void onHelloButtonClick() {
        this.welcomeText.setText("Welcome to JavaFX Application!");
        FileSwitcher.switchTo(FileStorage.HELLO);
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image kb = new Image(this.getClass().getResource("planetImages/Kepler-90b.png").toExternalForm());
        Image kc = new Image(this.getClass().getResource("planetImages/Kepler-90c.png").toExternalForm());
        Image kd = new Image(this.getClass().getResource("planetImages/Kepler-90d.png").toExternalForm());
        Image ke = new Image(this.getClass().getResource("planetImages/Kepler-90e.png").toExternalForm());
        this.k90b.setImage(kb);
        this.k90c.setImage(kc);
        this.k90d.setImage(kd);
        this.k90e.setImage(ke);
        Image kf = new Image(this.getClass().getResource("planetImages/Kepler-90f.png").toExternalForm());
        Image kg = new Image(this.getClass().getResource("planetImages/Kepler-90g.png").toExternalForm());
        Image kh = new Image(this.getClass().getResource("planetImages/Kepler-90h.png").toExternalForm());
        Image ki = new Image(this.getClass().getResource("planetImages/Kepler-90i.png").toExternalForm());
        this.k90f.setImage(kf);
        this.k90g.setImage(kg);
        this.k90h.setImage(kh);
        this.k90i.setImage(ki);
        leftButton.setMinSize(100,50);
        //rightButton.setMinSize(100,50);
        middleButton.setMinSize(150,50);
        this.leftButton.setText("Exit");
        this.middleButton.setText("Kepler Galaxy Hub");
        //this.rightButton.setText("Exit");
        this.leftButton.setOnAction((e) -> {
            Platform.exit();
        });
        this.leftButton.setStyle("-fx-text-fill: white; -fx-background-color: red;");
        this.middleButton.setOnAction((e) -> {
            FileSwitcher.switchTo(FileStorage.KEPLERSOLARSYSTEM);
        });
//        this.rightButton.setOnAction((e) -> {
//            Platform.exit();
//        });
        this.k90b.setOnMouseClicked((e) -> {
            System.out.println("b clicked");
            FileSwitcher.switchTo(FileStorage.KEP_B);
        });
        this.k90c.setOnMouseClicked((e) -> {
            System.out.println("c clicked");
            FileSwitcher.switchTo(FileStorage.KEP_C);
        });
        this.k90d.setOnMouseClicked((e) -> {
            System.out.println("d clicked");
            FileSwitcher.switchTo(FileStorage.KEP_D);
        });
        this.k90e.setOnMouseClicked((e) -> {
            System.out.println("e clicked");
            FileSwitcher.switchTo(FileStorage.KEP_E);
        });
        this.k90f.setOnMouseClicked((e) -> {
            System.out.println("f clicked");
            FileSwitcher.switchTo(FileStorage.KEP_F);
        });
        this.k90g.setOnMouseClicked((e) -> {
            System.out.println("g clicked");
            FileSwitcher.switchTo(FileStorage.KEP_G);
        });
        this.k90h.setOnMouseClicked((e) -> {
            System.out.println("h clicked");
            FileSwitcher.switchTo(FileStorage.KEP_H);
        });
        this.k90i.setOnMouseClicked((e) -> {
            System.out.println("i clicked");
            FileSwitcher.switchTo(FileStorage.KEP_I);
        });
        Image andromeda = new Image(this.getClass().getResource("images/Kepler_02_Edited.png").toExternalForm());
        BackgroundImage andBg = new BackgroundImage(andromeda, (BackgroundRepeat)null, (BackgroundRepeat)null, (BackgroundPosition)null, (BackgroundSize)null);
        Background andromedaBackground = new Background(new BackgroundImage[]{andBg});
        this.root.setBackground(andromedaBackground);
    }
}
