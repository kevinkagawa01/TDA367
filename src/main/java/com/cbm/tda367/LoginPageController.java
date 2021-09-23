package com.cbm.tda367;

import javafx.fxml.FXMLLoader;

public class LoginPageController{

    public LoginPageController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login-page.fxml"));
        fxmlLoader.setController(this);
    }
}
