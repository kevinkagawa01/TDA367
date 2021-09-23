package com.cbm.tda367;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class ShopPageController implements GolbalMenu{

    /* controller manager */
    private ApplicationControllerManager manager;


    public ShopPageController(ApplicationControllerManager manager) {
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
