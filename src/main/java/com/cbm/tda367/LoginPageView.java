package com.cbm.tda367;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LoginPageView extends AnchorPane {

    public LoginPageView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login-page.fxml"));
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
}
