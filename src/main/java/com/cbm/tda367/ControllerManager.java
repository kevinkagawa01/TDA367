package com.cbm.tda367;

import javafx.event.Event;

public class ControllerManager {

    /* model - view */
    ApplicationModel model;
    ViewManager viewManager;

    /* controllers */
    LoginPageController loginPageController;
    ShopPageController shopPageController;
    SellPageController sellPageController;
    AccountPageController accountPageController;

    public ControllerManager(ApplicationModel model, ViewManager viewManager) {
        this.model = model;
        this.viewManager = viewManager;
        loginPageController = new LoginPageController(this);
        shopPageController = new ShopPageController(this);
        sellPageController = new SellPageController(this);
        accountPageController = new AccountPageController(this);
    }

    public LoginPageController getLoginPageController() {
        return loginPageController;
    }

    public ShopPageController getShopPageController() {
        return shopPageController;
    }

    public SellPageController getSellPageController() {
        return sellPageController;
    }

    public AccountPageController getAccountPageController() {
        return accountPageController;
    }

    void goToAccountPage(){

    }

    void goToSellPage(){

    }

}
