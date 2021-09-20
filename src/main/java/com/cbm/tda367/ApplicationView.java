package com.cbm.tda367;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ApplicationView implements Initializable {

    @FXML
    private AnchorPane mainAnchorPane;

    /* login page */
    private LoginPage loginPage = new LoginPage();

    /* shop page */
    private ShopPage shopPage = new ShopPage();

    /* sell page */
    private SellPage sellPage = new SellPage();

    /* account page */
    private AccountPage accountPage = new AccountPage();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mainAnchorPane.getChildren().add(loginPage);
        mainAnchorPane.getChildren().add(shopPage);
        mainAnchorPane.getChildren().add(sellPage);
        mainAnchorPane.getChildren().add(accountPage);
    }
}
