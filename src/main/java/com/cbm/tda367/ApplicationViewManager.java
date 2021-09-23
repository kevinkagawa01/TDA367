package com.cbm.tda367;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ApplicationViewManager implements Initializable,Observer {

    @FXML
    private AnchorPane mainAnchorPane;

    /* login page */
    private LoginPageView loginPage = new LoginPageView();

    /* shop page */
    private ShopPageView shopPage = new ShopPageView();

    /* sell page */
    private SellPageView sellPage = new SellPageView();

    /* account page */
    private AccountPageView accountPage = new AccountPageView();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mainAnchorPane.getChildren().add(loginPage);
        mainAnchorPane.getChildren().add(shopPage);
        mainAnchorPane.getChildren().add(sellPage);
        mainAnchorPane.getChildren().add(accountPage);
    }

    @Override
    public void update() {
        //TODO: what should views update when model is updated?
    }
}
