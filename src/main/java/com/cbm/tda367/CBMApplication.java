package com.cbm.tda367;

import com.cbm.tda367.model.ApplicationModel;
import com.cbm.tda367.viewcontroller.ControllerManager;
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
public class CBMApplication extends javafx.application.Application {

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
        stage.setResizable(false);


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