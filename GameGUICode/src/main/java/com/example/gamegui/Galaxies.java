package com.example.gamegui;

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
    import javafx.scene.image.Image;
    import javafx.scene.image.ImageView;
    import javafx.scene.layout.BorderPane;
    import javafx.scene.layout.FlowPane;
    import javafx.scene.layout.HBox;
    import javafx.scene.layout.Background;
    import javafx.scene.layout.BackgroundImage;
    import javafx.stage.Stage;

    import java.io.IOException;
    import java.net.URL;
    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.Map;
    import java.util.ResourceBundle;

public class Galaxies implements Initializable {
    @FXML
    BorderPane root;

    @FXML
    HBox galaxyMenu;

    @FXML
    protected void onHelloButtonClick() {
    }

    @FXML
    Button milkyway, kepler;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Keep track of all stats using variables, until classes are made
        root.setMinSize(1280, 720);
        milkyway.setMinSize(640,720);
        kepler.setMinSize(640, 720);
        galaxyMenu.setMinSize(1280,720);
        Image milkyWayImage = new Image(getClass().getResource("images/milkyWayBack2.jpg").toExternalForm());
        ImageView milkyWayView = new ImageView(milkyWayImage);
        Image keplerGalaxy = new Image(getClass().getResource("images/Kepler_02.jpg").toExternalForm());
        ImageView keplerView = new ImageView(keplerGalaxy);

        milkyWayView.fitHeightProperty().bind(milkyway.heightProperty());
        milkyWayView.fitWidthProperty().bind(milkyway.widthProperty());

        keplerView.fitHeightProperty().bind(kepler.heightProperty());
        keplerView.fitWidthProperty().bind(kepler.widthProperty());

        kepler.setGraphic(keplerView);
        milkyway.setGraphic(milkyWayView);

        milkyway.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Entering MilkyWay");
                try {
                    enterMilkyWay(actionEvent);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        kepler.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Entering MilkyWay");
                try {
                    enterKepler(actionEvent);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });


    }

    public void enterMilkyWay(ActionEvent event) throws IOException {
        Stage currStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("homeView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        currStage.setScene(scene);
    }
    public void enterKepler(ActionEvent event) throws IOException {
        Stage currStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        BorderPane bP = new BorderPane();
        Scene scene = new Scene(bP, 1280.0, 720.0);
        FileSwitcher.setScene(scene);
        FileSwitcher.switchTo(FileStorage.KEPLERSOLARSYSTEM);
        currStage.setScene(scene);
    }
}
