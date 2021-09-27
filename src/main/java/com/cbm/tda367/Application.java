package com.cbm.tda367;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {

    private ApplicationModel model;
    private ViewManager viewManager;
    private ControllerManager controllerManager;

    @Override
    public void start(Stage stage) throws IOException {

        /* initiate MVC */
        model = new ApplicationModel();
        viewManager = new ViewManager();
        controllerManager = new ControllerManager(model, viewManager);

        /* assign controllers to corresponding view */
        viewManager.setShopPageController(controllerManager.getShopPageController());
        //TODO: connect other 3 controllers

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("mainAnchorPane.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 411, 731);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}