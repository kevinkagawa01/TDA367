package com.cbm.tda367;

import javafx.event.Event;

public class ControllerManager {

    /* model - view */
    ApplicationModel model;
    ViewManager viewManager;

    /* controllers */
    LoginPageController loginPageController;
    ShopPageController shopPageController;

    public ControllerManager(ApplicationModel model, ViewManager viewManager) {
        this.model = model;
        this.viewManager = viewManager;
        loginPageController = new LoginPageController(this);
        shopPageController = new ShopPageController(this);
    }

    public LoginPageController getLoginPageController() {
        return loginPageController;
    }

    public ShopPageController getShopPageController() {
        return shopPageController;
    }

    void goToAccountPage(){

    }

    void goToSellPage(){

    }
}
