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
    ApplicationModel model;
    /* application pages */
    private final LoginPageController loginPage;
    private final ShopPageController shopPage;
    private final SellPageController sellPage;
    private final AccountPageController accountPage;
    /* list of pages */
    private final List<Node> controllerList = new ArrayList<>();

    public ControllerManager(ApplicationModel model) {
        this.model = model;
        this.loginPage = new LoginPageController(this, model);
        this.shopPage = new ShopPageController(this, model);
        this.sellPage = new SellPageController(this, model);
        this.accountPage = new AccountPageController(this, model);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        controllerList.add(accountPage);
        controllerList.add(sellPage);
        controllerList.add(shopPage);
        controllerList.add(loginPage);

        for (Node view : controllerList){
            mainAnchorPane.getChildren().add(view);
        }
    }

    @Override
    public void update() {
        //TODO: what should views update when model is updated?
    }

    void goToShopPage(){
        mainAnchorPane.getChildren().get(controllerList.indexOf(shopPage)).toFront();
    }

    void goToSellPage(){
        mainAnchorPane.getChildren().get(controllerList.indexOf(sellPage)).toFront();
    }

    void goToAccountPage(){
        mainAnchorPane.getChildren().get(controllerList.indexOf(accountPage)).toFront();
    }
}
