module com.example.generalconverter {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.example.generalconverter to javafx.fxml;
    exports com.example.generalconverter;
}