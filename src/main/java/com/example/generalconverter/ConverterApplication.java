package com.example.generalconverter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ConverterApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ConverterApplication.class.getResource("convert-view.fxml"));
            Scene root = new Scene(fxmlLoader.load());
            stage.setTitle("Unit Converter");
            stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("icons/converter.png"))));
            stage.setScene(root);
            stage.resizableProperty().setValue(false);
            stage.show();
        } catch (NullPointerException np) {
            System.out.println("The resource passed for the fxml/icon is null");
            np.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}

