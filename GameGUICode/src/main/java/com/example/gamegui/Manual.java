package com.example.gamegui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Manual implements Initializable {

    @FXML
    BorderPane root;

    @FXML
    VBox master;

    @FXML
    ImageView Inventory;
    @FXML
    ImageView Pause;
    @FXML
    ImageView Planets;


    Image WP_Edited = new Image(getClass().getResource("images/WP_Edited.png").toExternalForm());
    BackgroundImage WP_E_BG;
    Background WP_E_B;
    @FXML
    private Button menuButton;

    @FXML
    TextArea manualPart1;
    @FXML
    TextArea manualPart2, manualPart3, manualPart4;

    public Manual() {
        this.WP_E_BG = new BackgroundImage(this.WP_Edited, (BackgroundRepeat)null, (BackgroundRepeat)null, (BackgroundPosition)null, (BackgroundSize)null);
        this.WP_E_B = new Background(new BackgroundImage[]{this.WP_E_BG});
    }

    public void onExitButtonClick() {
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {

        String manualBeginning = "Hello, and welcome to the manual for our Space Exploration game! Here, we" + " \n" +
                "will teach you about some of the elements implemented in the game.\n";
        String manualDesignation = "Designation: Informs the player of their current location, be it the" + " \n" +
                "galaxy or the planet they're on.\n";
        String manualFuel = "Fuel: Informs the player of the current amount of fuel their ship possesses" + " \n" +
                "as well as the total fuel capacity. Fuel is used up as the player traverses from galaxy" + " \n" +
                "to galaxy, as well as galaxy to planet. Once fuel reaches 0, their ship will be stranded" + " \n" +
                "and will most likely result in a game over (future implementation)\n";
        String manualDurability = "Durability: Informs the player of the current amount of durability their" + " \n" +
                "ship possesses at any given time, as well as the total amount of durability it can have at" + " \n" +
                "one time. Durability only goes down during specific events, such as an asteroid colliding" + " \n" +
                "with the ship, or travelling to a planet that the ship isn't able to safely deal with yet." + " \n" +
                "Once durability reaches 0, their ship will no longer be operational, and will most likely" + " \n" +
                "result in a game over (future implementation)\n";
        String manualInv = "Squares like these will be used to represent the player's inventory, where" + " \n" +
                "items that they possess can be seen in them.\n";
        String manualPause = "This is the pause icon, where (once it is implemented) will allow the player" + " \n" +
                "the ability to pause the game, as well as accessing other menus.\n";
        String manualPlanets = "This button will bring you to a list of planets that are located in the" + " \n" +
                "current galaxy (only implemented for Kepler90 thus far)\n";

        master = new VBox();

        Image inv = new Image(this.getClass().getResource("images/square.png").toExternalForm());
        Inventory.setImage(inv);
        Inventory.setFitWidth(100);
        Inventory.setFitHeight(100);

        Image pau = new Image(this.getClass().getResource("images/pause.png").toExternalForm());
        Pause.setImage(pau);
        Pause.setFitWidth(100);
        Pause.setFitHeight(100);

        Image pla = new Image(this.getClass().getResource("images/Spiral-02.png").toExternalForm());
        Planets.setImage(pla);
        Planets.setFitWidth(100);
        Planets.setFitHeight(100);

        manualPart1.setMinSize(700, 600);
        manualPart2.setMinSize(700, 50);
        manualPart2.setMaxSize(700, 50);
        manualPart3.setMinSize(700, 50);
        manualPart3.setMaxSize(700, 50);
        manualPart4.setMinSize(700, 50);
        manualPart4.setMaxSize(700, 50);

        manualPart1.setText(manualBeginning+"\n"+manualDesignation+"\n"+manualFuel+"\n"+manualDurability);
        manualPart2.setText(manualInv);
        manualPart3.setText(manualPause);
        manualPart4.setText(manualPlanets);

        manualPart1.setEditable(false);
        manualPart2.setEditable(false);
        manualPart3.setEditable(false);
        manualPart4.setEditable(false);

        manualPart3.setVisible(false);
        Pause.setVisible(false);

        menuButton.setMinSize(100, 50);
        menuButton.setText("Main Menu");
        menuButton.setOnAction((e) -> {
            Stage currStage = HelloApplication.getStage();
            currStage.setScene(HelloApplication.sceneMap.get("start"));
        });

        Image manual = new Image(this.getClass().getResource("images/Galaxies.png").toExternalForm());
        BackgroundImage manualBg = new BackgroundImage(manual,
                null,
                null,
                null,
                null);
        Background manualBackground = new Background(manualBg);
        this.root.setBackground(manualBackground);
    }
}
