package com.cbm.tda367;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerManager implements Initializable,Observer {

    @FXML
    private AnchorPane mainAnchorPane;

    /* model */
    ApplicationModel model = ApplicationModel.getInstance();
    /* application pages */
    private LoginPageController loginPage = new LoginPageController(this, model);
    private ShopPageController shopPage = new ShopPageController(this, model);
    private SellPageController sellPage = new SellPageController(this, model);
    private AccountPageController accountPage = new AccountPageController(this, model);
    private SubscribtionPageController subPage=new SubscribtionPageController(this,model);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mainAnchorPane.getChildren().add(sellPage);
        mainAnchorPane.getChildren().add(accountPage);
        mainAnchorPane.getChildren().add(shopPage);
        mainAnchorPane.getChildren().add(loginPage);
    }

    @Override
    public void update() {
        //TODO: what should views update when model is updated?
    }

    void goToShopPage(){
        shopPage.toFront();
    }

    void goToSellPage(){
        sellPage.toFront();
    }

    void goToAccountPage(){
        accountPage.toFront();
    }

}
