module com.example.generalconverter {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.generalconverter to javafx.fxml;
    exports com.example.generalconverter;
}