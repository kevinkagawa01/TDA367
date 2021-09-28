package com.cbm.tda367;

import javafx.event.Event;
import javafx.fxml.FXML;

public class ShopPageController implements GolbalMenu{

    /* view manager */
    private ControllerManager manager;


    public ShopPageController(ControllerManager manager) {
        this.manager = manager;
    }

    @Override
    @FXML
    public void shopButton(Event event) {}

    @Override
    @FXML
    public void accountButton(Event event) {
        manager.goToAccountPage();
    }



    @Override
    @FXML
    public void addButton(Event event) {
        manager.goToSellPage();
    }
}
