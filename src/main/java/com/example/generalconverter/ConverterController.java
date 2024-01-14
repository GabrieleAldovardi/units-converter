package com.example.generalconverter;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

/**
 * Contain the method that controls the UI of the application
 */
public class ConverterController {
    @FXML
    private AnchorPane pane;
    @FXML
    private TextField startUnitField, finalUnitField;
    @FXML
    private ComboBox<String> startUnitBox, finalUnitBox;
    @FXML
    private Button convertButton, aboutButton;
    //FXML
    //    private Button convertButton, aboutButton, button0, button1, button2, button3, button4, button5,
    //            button6, button7, button8, button9, buttonDot, buttonE;
    @FXML
    private ImageView swapGif, swapIcon, closeIcon;
    @FXML
    private TableView<Map.Entry<String, List<String>>> unitsTable;
    @FXML
    private Label unitsLabel;

    private Convert convert;

    /**
     * Creates the initial view of the application, the data
     * structures that will contain the information for the app
     * and the structure of the menu
     */
    @FXML
    public void initialize() {
        pane.setStyle("-fx-background-color: white");
        startUnitBox.getItems().addAll(Unit.distances);
        startUnitBox.setVisibleRowCount(10);
        finalUnitBox.getItems().addAll(Unit.distances);
        finalUnitBox.setVisibleRowCount(10);
        unitsLabel.setText("Distances");
        convert = new Convert();
        constructMenu();
    }

    /**
     * Build the inside structure of the menu button
     */
    private void constructMenu() {
        TableColumn<Map.Entry<String, List<String>>, String> column = new TableColumn<>("Groups of units");
        column.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getKey()));
        unitsTable.getColumns().add(column);

        ObservableList<Map.Entry<String, List<String>>> values = FXCollections.observableArrayList(Unit.unitGroups.entrySet());
        values.sort(Map.Entry.comparingByKey());
        unitsTable.setItems(values);
        unitsTable.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            String selectedGroup = values.get(newValue.intValue()).getKey();
            unitsLabel.setText(selectedGroup);
            startUnitBox.getItems().clear();
            startUnitBox.getItems().addAll(Unit.unitGroups.get(selectedGroup));
            finalUnitBox.getItems().clear();
            finalUnitBox.getItems().addAll(Unit.unitGroups.get(selectedGroup));
        });

        unitsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        //buttonList.forEach(b -> b.setOnMouseClicked(e -> {
        //            Button clickedButton = (Button) e.getSource();
        //            startUnitField.setText(startUnitField.getText() + clickedButton.getText());
        //        }));
    }

    /**
     * Swap the animation and the static image based on
     * the current position of the mouse
     */
    @FXML
    public void mouseOnIcon() {
        swapIcon.setVisible(!swapIcon.isVisible());
        swapGif.setVisible(!swapGif.isVisible());
    }

    /**
     * Swap the selected units
     */
    @FXML
    public void handleSwap() {
        String tmp = startUnitBox.getValue();
        startUnitBox.setValue(finalUnitBox.getValue());
        finalUnitBox.setValue(tmp);
    }

    /**
     * Open the menu represented by the table view
     */
    @FXML
    public void handleOpenMenu() {
        pane.setStyle("-fx-background-color: grey");
        setAll(true);
    }

    /**
     * Close the menu represented by the table view
     */
    @FXML
    public void handleCloseMenu() {
        pane.setStyle("-fx-background-color: white");
        setAll(false);
    }

    /**
     * Able/Disable all the nodes when the menu
     * is closed/opened
     */
    private void setAll(boolean value) {
        unitsTable.setVisible(value);
        closeIcon.setVisible(value);
        startUnitBox.setDisable(value);
        startUnitField.setDisable(value);
        finalUnitBox.setDisable(value);
        finalUnitField.setDisable(value);
        convertButton.setDisable(value);
        aboutButton.setDisable(value);
        swapIcon.setDisable(value);
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

            double endValue = convert.convertUnit(startUnit.orElseThrow(NullPointerException::new), endUnit.orElseThrow(NullPointerException::new), startValue.orElseThrow(NumberFormatException::new));
            finalUnitField.setText(Double.toString(endValue));
        } catch (NullPointerException np) {
            Alert noUnitSelected = new Alert(Alert.AlertType.ERROR);
            noUnitSelected.setTitle("None unit selected");
            noUnitSelected.setHeaderText("You haven't selected the start or the final unit");
            noUnitSelected.setContentText("Please, select both and then try the conversion");
            noUnitSelected.showAndWait();
        } catch (NumberFormatException nf) {
            Alert noValueInserted = new Alert(Alert.AlertType.ERROR);
            noValueInserted.setTitle("Wrong value inserted");
            noValueInserted.setHeaderText("You have selected a non valid value for the start unit");
            noValueInserted.setContentText("Please, insert only numbers and then try again");
            noValueInserted.showAndWait();
        }
    }

    /**
     * Shows some information about the author
     */
    @FXML
    public void handleAbout() {
        Hyperlink linkGA = new Hyperlink("https://github.com/GabrieleAldovardi");
        linkGA.setOnAction(e -> openWebPage());

        VBox vbox = new VBox();
        Label description = new Label("Here you can find more details:");
        vbox.getChildren().addAll(description, linkGA);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About me");
        alert.setHeaderText("Hi, i'm a Computer Engineering student at UNIMORE, University of Modena and Reggio Emilia");
        alert.getDialogPane().setContent(vbox);
        alert.showAndWait();
    }

    /**
     * Create a clickable link for a browser
     */
    private void openWebPage() {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI("https://github.com/GabrieleAldovardi"));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }
}
