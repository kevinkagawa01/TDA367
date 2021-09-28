package com.cbm.tda367;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LoginPageView extends AnchorPane {

    ViewManager manager;
    FXMLLoader fxmlLoader;

    public LoginPageView(ViewManager manager) {

        this.manager = manager;
        fxmlLoader = new FXMLLoader(getClass().getResource("login-page.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try
        {
            fxmlLoader.load();
        } catch (IOException exception)
        {
            throw new RuntimeException(exception);
        }
    }

    public void setFxmlLoaderController(Object controller) {
        fxmlLoader.setController(controller);
    }
}
