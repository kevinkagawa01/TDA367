package com.cbm.tda367;

import javafx.fxml.FXMLLoader;

public class LoginPageController{

    /* view manager */
    private ApplicationViewManager manager;

    public LoginPageController(ApplicationViewManager manager) {

        this.manager = manager;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login-page.fxml"));
        fxmlLoader.setController(this);
    }
}
