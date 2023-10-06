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
    public ChristianHello() {
    }

    public void start(Stage stage) throws IOException {
        BorderPane bP = new BorderPane();
        Scene scene = new Scene(bP, 1280.0, 720.0);
        FileSwitcher.setScene(scene);
        FileSwitcher.switchTo(FileStorage.KEPLERSOLARSYSTEM);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(new String[0]);
    }
}
