//matched with Planet2.fxml
package com.example.gamegui;

        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.fxml.Initializable;
        import javafx.scene.Node;
        import javafx.scene.Scene;
        import javafx.scene.layout.*;
        import javafx.geometry.Pos;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.scene.image.Image;
        import javafx.scene.image.ImageView;
        import javafx.scene.layout.BorderPane;
        import javafx.stage.Stage;
        import javafx.scene.control.TextArea;

        import java.io.IOException;
        import java.net.URL;
        import java.util.ResourceBundle;

public class AndroPlanet2 implements Initializable {
    @FXML
    BorderPane root;
    //    @FXML
//    private TextArea infoTextArea;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Return Button
        Button bottomButton = new Button("Return");
        HBox bottomBox = new HBox(bottomButton);
        bottomBox.setAlignment(Pos.CENTER);
        root.setBottom(bottomBox);

        bottomButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Leaving MilkyWay");
                try {
                    enterUniverse(actionEvent);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        Image Andro = new Image(getClass().getResource("images/Square2.png").toExternalForm());
        BackgroundImage mlkBg = new BackgroundImage(
                Andro,
                null,
                null,
                null,
                new BackgroundSize(1300, 1260,false,false,false,false)
        );
        Background milkyWayBackground = new Background(mlkBg);
        root.setBackground(milkyWayBackground);
    }

    //return back to homecontroller
    public void enterUniverse(ActionEvent event) throws IOException { //throw back home
        Stage currStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("milkyWaySceneView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        currStage.setScene(scene);
    }
}