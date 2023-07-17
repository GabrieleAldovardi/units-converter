package com.example.generalconverter;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ConverterController {
    @FXML private Label startUnitLabel, endUnitLabel, infoLabel, searchLabel;
    @FXML private TextField startUnitField, endUnitField, searchUnitField;
    @FXML private Button convertButton;
    @FXML private ChoiceBox<String> conversionBox;
    @FXML public void initialize() {
        conversionBox.getItems().addAll("C -> F", "F -> C");
        conversionBox.getSelectionModel().select("C -> F");
    }
    /*@FXML void handleConvert(ActionEvent event) {
        if(conversionBox.getSelectionModel().getSelectedItem().equals("C -> F")) {
            Double f = Double.parseDouble(celsiusField.getText()) * 1.8 + 32;
            fahrenheitField.setText(f.toString());
        } else {
            Double c = (Double.parseDouble(fahrenheitField.getText()) - 32) / 1.8;
            celsiusField.setText(c.toString());
        }
    }*/
}
