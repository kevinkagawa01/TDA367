package com.cbm.tda367;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * Application launcher
 *
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 1.0
 * @since 0.1
 */
public class Application extends javafx.application.Application {

    private ApplicationModel model;
    private ControllerManager controllerManager;

    /**
     * Start method for the application, initiating the application at launch.
     * @param stage window which the application appears in.
     * @throws IOException throws exception in case of I/O issues.
     */
    @Override
    public void start(Stage stage) throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mainAnchorPane.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 411, 731);
        stage.setTitle("CBM!");
        stage.setScene(scene);
        /* lock aspect ratio */
        stage.setMaxHeight(731);
        stage.setMinHeight(731);
        stage.setMaxWidth(411);
        stage.setMinWidth(411);
        /* don't allow fullscreen */
        stage.maximizedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) { stage.setMaximized(false); }
                });

        stage.show();
        model = ApplicationModel.getInstance();
        controllerManager = fxmlLoader.getController();

        /* Add observers to model */
        model.addObserver(controllerManager);
        model.notifyObservers();
    }

    public static void main(String[] args) {
        launch();
    }
}