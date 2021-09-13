package main.java;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

public class Application extends javafx.application.Application {

    public void start(Stage stage) throws Exception {

        ResourceBundle bundle = java.util.ResourceBundle.getBundle("cbm");

        Parent root = FXMLLoader.load(getClass().getResource("cbm_main_anchorpane"), bundle);

        Scene scene = new Scene(root, 1000, 1000);
        stage.setScene(scene);
        stage.show();
    }
}
