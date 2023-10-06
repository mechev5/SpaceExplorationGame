//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
package com.example.gamegui;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class FileSwitcher {
    public static Map<FileStorage, Parent> sceneMap = new HashMap();
    private static Scene scene;

    public FileSwitcher() {
    }

    public static void setScene(Scene scene) {
        FileSwitcher.scene = scene;
    }

    public static void switchTo(FileStorage file) {
        try {
            Parent root;
            if (sceneMap.containsKey(file)) {
                System.out.println("Test01(Load)");
                root = (Parent)sceneMap.get(file);
                scene.setRoot(root);
            } else {
                System.out.println(file);
                System.out.println("Test02(New)");
                System.out.println(file.getFileName());
                root = (Parent)FXMLLoader.load(FileStorage.class.getResource(file.getFileName()));
                scene.setRoot(root);
                sceneMap.put(file, root);
            }
        } catch (IOException var3) {
            var3.printStackTrace();
        }

    }
}
