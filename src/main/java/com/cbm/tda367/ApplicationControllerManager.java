package com.cbm.tda367;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ApplicationControllerManager {

    /* model & view */
    private ApplicationModel model;
    private ApplicationViewManager view;

    /* controllers */
    private final LoginPageController loginPageController = new LoginPageController(this);
    private final ShopPageController shopPageController = new ShopPageController(this);
    private final SellPageController sellPageController = new SellPageController(this);
    private final AccountPageController accountPageController = new AccountPageController(this);

    //TODO: no view reference
    public ApplicationControllerManager(ApplicationModel model) {
        this.model = model;
        this.view = view;
    }

    void goToShopPage(){
        view.goToShopPage();
    }

    void goToSellPage(){
        view.goToSellPage();
    }

    void goToAccountPage(){
        view.goToAccountPage();
    }
}