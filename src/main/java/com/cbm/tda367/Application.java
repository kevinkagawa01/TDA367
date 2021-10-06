package com.cbm.tda367;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {

    private ApplicationModel model;
    private ControllerManager controllerManager;

    @Override
    public void start(Stage stage) throws IOException {

        /* initiate MVC */
        model = ApplicationModel.getInstance();
        controllerManager = new ControllerManager();

        /* Add observers to model */
        model.addObserver(controllerManager);
        model.notifyObservers();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mainAnchorPane.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 411, 731);
        stage.setTitle("CBM!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}