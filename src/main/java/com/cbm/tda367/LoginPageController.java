package com.cbm.tda367;

import javafx.fxml.FXMLLoader;

public class LoginPageController{

    /* controller manager */
    private ApplicationControllerManager manager;

    public LoginPageController(ApplicationControllerManager manager) {

        this.manager = manager;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login-page.fxml"));
        fxmlLoader.setController(this);
    }
}
