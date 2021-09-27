package com.cbm.tda367;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ShopPageView extends AnchorPane {

    private ApplicationViewManager manager;

    public ShopPageView(ApplicationViewManager manager) {
        this.manager = manager;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("shop-page.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(new ShopPageController(manager));

        try{
            fxmlLoader.load();
        } catch (IOException exception){
            throw new RuntimeException(exception);
        }
    }

    @FXML
    public void accountButton(Event event) {
        manager.goToAccountPage();
    }

    @FXML
    public void addButton(Event event) {
        manager.goToSellPage();
    }
}
