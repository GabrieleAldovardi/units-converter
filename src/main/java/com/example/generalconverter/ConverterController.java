package com.example.generalconverter;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConverterController {
    @FXML private Label startUnitLabel, endUnitLabel, searchStartLabel, searchFianlLabel;
    @FXML private TextField startUnitField, finalUnitField, searchStartUnitField, searchFinalUnitField;
    @FXML private Button convertButton, aboutButton;
    @FXML private ComboBox<String> startUnitBox, finalUnitBox;
    private final static List<String> temperatures = Arrays.asList("Celsius", "Fahrenheit", "Kelvin");
    private final static List<String> distances = Arrays.asList("Meter", "Kilometer", "Centimeter", "Millimeter", "Feet", "Yard",
            "Inch", "Mile");
    private final static List<String> weights = Arrays.asList("Gram", "Milligram", "Kilogram", "Ounce", "Pound", "Ton");
    private final static List<String> volumes = Arrays.asList("Litre", "Millilitre",
            "Kilolitre", "Gallon", "Pint", "Fluid Ounce");
    private final static List<String> times = Arrays.asList("Second", "Minute", "Hour", "Day", "Month", "Week", "Year");
    private final static List<String> units = new ArrayList<>();
    @FXML public void initialize() {
        units.addAll(temperatures);
        units.addAll(distances);
        units.addAll(weights);
        units.addAll(volumes);
        units.addAll(times);

        startUnitBox.getItems().addAll(units);
        startUnitBox.setVisibleRowCount(10);
        finalUnitBox.getItems().addAll(units);
        finalUnitBox.setVisibleRowCount(10);
    }


}
