module com.example.gamegui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;

    opens com.example.gamegui to javafx.fxml;
    exports com.example.gamegui;
}