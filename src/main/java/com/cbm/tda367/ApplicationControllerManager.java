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

    public ApplicationControllerManager(ApplicationModel model, ApplicationViewManager view) {
        this.model = model;
        this.view = view;
    }

    void goToShopPage(){

    }

    void goToSellPage(){

    }

    void goToAccountPage(){

    }
}