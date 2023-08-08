package com.example.generalconverter;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Contain the method that controls the UI of the application
 */
public class ConverterController {
    @FXML
    private TextField startUnitField, finalUnitField, searchStartUnitField;
    @FXML
    private ComboBox<String> startUnitBox, finalUnitBox;

    private Convert convert;

    /**
     * Creates the initial view of the application and creates the data
     * structures that will contain the information for the app
     */
    @FXML
    public void initialize() {
        List<String> units =
                new ArrayList<>(Unit.allUnits.stream().flatMap(Collection::stream).collect(Collectors.toList()));
        startUnitBox.getItems().addAll(units);
        startUnitBox.setVisibleRowCount(10);
        convert = new Convert();
    }

    /**
     * Modify the final unit box with only the units that are from the
     * same group as the initial selected, without the item itself
     */
    @FXML
    public void handleStartBox() {
        int index;
        for (index = 0; index < Unit.allUnits.size(); index++)
            if (Unit.allUnits.get(index).contains(startUnitBox.getValue()))
                break;

        if(!Unit.allUnits.get(index).contains(finalUnitBox.getValue())) {
            finalUnitBox.getItems().clear();
            finalUnitBox.getItems().addAll(Unit.allUnits.get(index));
            finalUnitBox.setVisibleRowCount(5);
        }
    }

    /**
     * Allow the user to search through the list of all the
     * units with a search bar
     */
    @FXML
    public void handleStartSearch() {
        if (startUnitBox.getItems().contains(searchStartUnitField.getCharacters().toString())) {
            startUnitBox.setValue(searchStartUnitField.getCharacters().toString());
            searchStartUnitField.clear();
        } else {
            Alert wrongUnit = new Alert(Alert.AlertType.ERROR);
            wrongUnit.setTitle("Error");
            wrongUnit.setHeaderText("Wrong unit typed");
            wrongUnit.show();
        }
    }

    /**
     * Convert the initial unit value to a new one
     */
    @FXML
    public void handleConvert() {
        try {
            Optional<String> startUnit = startUnitBox.getValue().describeConstable();
            Optional<String> endUnit = finalUnitBox.getValue().describeConstable();
            Optional<Double> startValue = Double.valueOf(startUnitField.getCharacters().toString()).describeConstable();

            if (startUnit.isEmpty() || endUnit.isEmpty()) {
                throw new NullPointerException();
            }

            Optional<Double> endValue = convert.convertUnit(startUnit, endUnit, startValue);
            finalUnitField.setText(Double.toString(endValue.get()));
        } catch (NullPointerException np) {
            Alert noUnitSelected = new Alert(Alert.AlertType.ERROR);
            noUnitSelected.setTitle("None unit selected");
            noUnitSelected.setHeaderText("You haven't selected the start or the final unit");
            noUnitSelected.setContentText("Please, select both and then try the conversion");
            noUnitSelected.showAndWait();
        } catch (NumberFormatException nf) {
            Alert noValueInserted = new Alert(Alert.AlertType.ERROR);
            noValueInserted.setTitle("None value inserted");
            noValueInserted.setHeaderText("You haven't selected a value for the start unit");
            noValueInserted.setContentText("Please, insert one and then try again");
            noValueInserted.showAndWait();
        }
    }
}
