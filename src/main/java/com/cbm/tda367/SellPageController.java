package com.cbm.tda367;

import javafx.fxml.FXMLLoader;

public class SellPageController implements GolbalMenu{

    public SellPageController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sell-page.fxml"));
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
