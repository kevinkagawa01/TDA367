package com.cbm.tda367.viewcontroller;

import com.cbm.tda367.model.ApplicationModel;
import com.cbm.tda367.model.Observer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * Visual representation of the loginPage/firstPage of the application.
 *
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 1.0
 * @since 1.0
 */
public class LoginPageViewController extends AnchorPane implements Observer {

    private final ControllerManager manager;
    private final ApplicationModel model = ApplicationModel.getInstance();

    /* fxml elements */
    @FXML
    private TextField cidTextField;
    @FXML
    private PasswordField passwordTextField;

    /**
     * Creates the login view
     *
     * @param manager This controller manager
     */
    public LoginPageViewController(ControllerManager manager) {
        this.manager = manager;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/cbm/tda367/login-page.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * On-click method that compares the input from the textfields to the userDataBase
     * and sees whether there is a matching user.
     */
    @FXML
    public void onClickAttemptToLogin() {
        if (model.isLoginSuccessful(cidTextField.getText(), passwordTextField.getText())) {
            manager.goToShopPage();
        } else {
            //TODO: Create visual pliancy informing the user that there was an issue logging in.
            System.out.println("Unauthorized login! (mock-login: id=1,pw=1)");
        }
    }

    /**
     * Updates this status.
     */
    @Override
    public void update() {
        // Is implemented for future functionality.
    }
}
