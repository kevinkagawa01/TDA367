package com.cbm.tda367;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {

    private ApplicationModel model;
    private ViewManager view;

    @Override
    public void start(Stage stage) throws IOException {

        model = new ApplicationModel();
        view = new ViewManager();



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