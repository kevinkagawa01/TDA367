package com.cbm.tda367;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ShopPageController extends AnchorPane {

    private ControllerManager manager;
    private ApplicationModel model;
    private FXMLLoader fxmlLoader;

    public ShopPageController(ControllerManager manager, ApplicationModel model) {
        this.manager = manager;
        this.model = model;
        fxmlLoader = new FXMLLoader(getClass().getResource("shop-page.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try{
            fxmlLoader.load();
        } catch (IOException exception){
            throw new RuntimeException(exception);
        }
    }

    public void setFxmlLoaderController(Object controller){
        fxmlLoader.setController(controller);
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
