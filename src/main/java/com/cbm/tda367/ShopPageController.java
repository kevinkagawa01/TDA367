package com.cbm.tda367;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class ShopPageController implements GolbalMenu{

    /* controller manager */
    private ApplicationControllerManager manager;

    public ShopPageController(ApplicationControllerManager manager) {

        this.manager = manager;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("shop-page.fxml"));
        fxmlLoader.setController(this);
    }

    @Override
    @FXML
    public void shopButton() {}

    @Override
    @FXML
    public void accountButton() {
        manager.goToAccountPage();
    }

    @Override
    @FXML
    public void addButton() {
        manager.goToSellPage();
    }
}
