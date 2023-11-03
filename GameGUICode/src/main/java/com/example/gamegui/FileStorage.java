//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
package com.example.gamegui;
import java.util.List;
import java.util.ArrayList;

public enum FileStorage {

    HELLO("christian-hello-view.fxml"),
    PLANETLIST("planet-list.fxml"),
    KEPLER90B("kepler-90b.fxml"),
    KEPLERSOLARSYSTEM("kepler-system.fxml"),
    KEP_B("kep-90b.fxml"),
    KEP_C("kep-90c.fxml"),
    KEP_D("kep-90d.fxml"),
    KEP_E("kep-90e.fxml"),
    KEP_F("kep-90f.fxml"),
    KEP_G("kep-90g.fxml"),
    KEP_H("kep-90h.fxml"),
    KEP_I("kep-90i.fxml"),
    MANUAL("Manual.fxml"),

    AndroSystem("Andromeda.fxml");


    private String fileName;

    private FileStorage(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return this.fileName;
    }
}
