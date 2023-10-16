package com.example.gamegui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;


//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

        import java.io.IOException;
        import javafx.application.Application;
        import javafx.scene.Scene;
        import javafx.scene.layout.BorderPane;
        import javafx.stage.Stage;

public class ChristianHello extends Application {
    public ChristianHello() throws IOException {
        String save = "newSave4.json";
        JSONTest myTest = new JSONTest(save);
        // myTest.saving(myTest.getRoot(save), "newSave.json");
        // System.out.println(myTest.userO2Curr);
        myTest.editShipValues("O2", "Subtract", 50);
        myTest.editShipValues("Durability", "Set", 80.7);
        myTest.editShipValues("Fuel", "add", 10);
        myTest.editShipValues("Durability", "add", 0.1);
        myTest.editShipValues("O2", "add", 1.7);
        // myTest.saving(myTest.getRoot(), "newSave2.json");
        myTest.saving("newSave4.json");
    }

    public void start(Stage stage) throws IOException {
        BorderPane bP = new BorderPane();
        Scene scene = new Scene(bP, 1280.0, 720.0);
        FileSwitcher.setScene(scene);
        FileSwitcher.switchTo(FileStorage.KEPLERSOLARSYSTEM);
        stage.setScene(scene);
        stage.show();
    }

    public void saveTesting(JSONTest mySave) throws IOException {

    }

    public static void main(String[] args) {
        launch(new String[0]);
    }
}
