module com.example.gamegui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires java.desktop;


    opens com.example.gamegui to javafx.fxml;
    exports com.example.gamegui;
}