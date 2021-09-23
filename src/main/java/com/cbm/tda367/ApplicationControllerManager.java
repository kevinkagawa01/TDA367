package com.cbm.tda367;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ApplicationControllerManager {

    private final LoginPageController loginPageController = new LoginPageController(this);
    private final ShopPageController shopPageController = new ShopPageController(this);
    private final SellPageController sellPageController = new SellPageController(this);
    private final AccountPageController accountPageController = new AccountPageController(this);
}