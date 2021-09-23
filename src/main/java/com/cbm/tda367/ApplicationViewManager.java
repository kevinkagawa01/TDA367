package com.cbm.tda367;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ApplicationViewManager implements Initializable,Observer {

    @FXML
    private AnchorPane mainAnchorPane;

    private LoginPageView loginPage = new LoginPageView();
    private ShopPageView shopPage = new ShopPageView();
    private SellPageView sellPage = new SellPageView();
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
