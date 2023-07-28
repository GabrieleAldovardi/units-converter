package com.example.generalconverter;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Map.entry;

public class ConverterController {
    @FXML private TextField startUnitField, finalUnitField, searchStartUnitField;
    @FXML private Button convertButton, aboutButton;
    @FXML private ComboBox<String> startUnitBox, finalUnitBox;
    private final List<String> temperatures = Arrays.asList("Celsius", "Fahrenheit", "Kelvin");
    private final List<String> angles = Arrays.asList("Degrees", "Radiant");
    private final List<String> distances = Arrays.asList("Kilometer", "Meter", "Decimeter", "Centimeter", "Millimeter", "Micrometer", "Nanometer", "Feet", "Yard", "Inch", "Mile", "Light year");
    private final List<String> weights = Arrays.asList("Kilogram", "Hectogram", "Gram", "Centigram", "Milligram",
            "Ounce", "Pound", "Ton");
    private final List<String> volumes = Arrays.asList("Kilolitre", "Litre", "Decilitre", "Centilitre", "Millilitre",
            "Gallon", "Pint", "Fluid Ounce", "Cubic decimeter", "Cubic centimeter", "Cubic milliliter");
    private final List<String> times = Arrays.asList("Nanosecond", "Microsecond", "Millisecond", "Second", "Minute",
            "Hour", "Day", "Month", "Week", "Year");
    private final List<String> velocity = Arrays.asList("Kilometer per second", "Kilometer per hour", "Meter per " +
            "second", "Meter per hour", "Miles per second", "Miles per hour", "Light speed", "Sound speed");
    private final List<String> currency = Arrays.asList("Argentinian-Pesos", "Dirham", "Euro", "Indian-Rupee", "Naira",
            "Pound", "US-dollar",  "Won",  "Yen", "Yuan");
    private final List<String> data = Arrays.asList("Bit", "Byte", "Kilobit", "Kilobyte","Megabit","Megabyte",
            "Gigabit", "Gigabyte", "Terabit", "Terabyte", "Petabit", "Petabyte", "Exabit", "Exabyte");
    private final List<List<String>> allUnits = List.of(temperatures, angles, distances, weights, volumes, times,
            velocity, currency, data);
    @FXML public void initialize() {
        List<String> units =
                new ArrayList<String>(allUnits.stream().flatMap(Collection::stream).collect(Collectors.toList()));
        startUnitBox.getItems().addAll(units);
        startUnitBox.setVisibleRowCount(10);
    }

    @FXML public void handleStartBox() {
        int index;
        for(index = 0; index < allUnits.size(); index++)
            if (allUnits.get(index).contains(startUnitBox.getValue()))
                break;
        finalUnitBox.getItems().clear();
        finalUnitBox.getItems().addAll(allUnits.get(index));
        finalUnitBox.getItems().remove(startUnitBox.getValue());
        finalUnitBox.setVisibleRowCount(5);
    }

    @FXML public void handleStartSearch() {
        if(startUnitBox.getItems().contains(searchStartUnitField.getCharacters().toString())) {
            startUnitBox.setValue(searchStartUnitField.getCharacters().toString());
            searchStartUnitField.clear();
        } else {
            Alert wrongUnit = new Alert(Alert.AlertType.ERROR);
            wrongUnit.setTitle("Error");
            wrongUnit.setHeaderText("Wrong unit typed");
            wrongUnit.showAndWait();
        }
    }
    @FXML public void handleConvert() {
        String startUnit = startUnitBox.getValue();
        String endUnit = finalUnitBox.getValue();
        double startValue = Double.valueOf(startUnitField.getCharacters().toString());

        if(startUnit == null || endUnit == null) {
            Alert noUnitSelected = new Alert(Alert.AlertType.ERROR);
            noUnitSelected.setTitle("None unit selected");
            noUnitSelected.setHeaderText("You haven't selected the start or the final unit");
            noUnitSelected.setContentText("Please, select both and then try the conversion");
            noUnitSelected.showAndWait();
        }

        finalUnitField.setText("Result");
    }
}
