package com.cbm.tda367;

import javafx.fxml.FXMLLoader;

public class LoginPageController{

    /* view manager */
    private ViewManager manager;

    public LoginPageController(ViewManager manager) {

        this.manager = manager;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login-page.fxml"));
        fxmlLoader.setController(this);
    }
}
