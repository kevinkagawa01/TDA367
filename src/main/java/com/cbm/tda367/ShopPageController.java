package com.cbm.tda367;

import javafx.fxml.FXMLLoader;

public class ShopPageController implements GolbalMenu{

    public ShopPageController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("shop-page.fxml"));
        fxmlLoader.setController(this);
    }

    @Override
    public void shopButton() {

    }

    @Override
    public void accountButton() {

    }

    @Override
    public void addButton() {

    }
}
