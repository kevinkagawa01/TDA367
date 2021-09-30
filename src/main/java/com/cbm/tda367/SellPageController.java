package com.cbm.tda367;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class SellPageController extends AnchorPane {

    private ControllerManager manager;
    private ApplicationModel model;

    public SellPageController(ControllerManager manager, ApplicationModel model) {
        this.model = model;
        this.manager = manager;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sell-page.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try
        {
            fxmlLoader.load();
        } catch (IOException exception)
        {
            throw new RuntimeException(exception);
        }
    }

    @FXML
    protected void onClickGoToShopPage(Event event){
        manager.goToShopPage();
    }

    @FXML
    protected void onClickGoToAccountPage(Event event){
        manager.goToAccountPage();
    }
}
