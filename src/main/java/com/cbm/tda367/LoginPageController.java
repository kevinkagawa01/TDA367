package com.cbm.tda367;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LoginPageController extends AnchorPane {

    ControllerManager manager;
    ApplicationModel model;
    FXMLLoader fxmlLoader;

    /* fxml elements */
    @FXML private TextField cidTextField;
    @FXML private TextField passwordTextField;

    public LoginPageController(ControllerManager manager, ApplicationModel model) {
        this.manager = manager;
        this.model = model;
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

    @FXML
    public void onClickAttemptToLogin(){
        if (model.isLoginSuccessful(cidTextField.getText(),passwordTextField.getText())){
            manager.goToShopPage();
        } else {
            //TODO: something went wrong with login!
            System.out.println("Nej");
        }
    }
}
