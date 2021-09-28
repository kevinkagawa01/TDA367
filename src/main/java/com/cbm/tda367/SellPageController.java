package com.cbm.tda367;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class SellPageController extends AnchorPane {

    private ControllerManager manager;
    private FXMLLoader fxmlLoader;

    public SellPageController(ControllerManager manager) {

        this.manager = manager;

        fxmlLoader = new FXMLLoader(getClass().getResource("sell-page.fxml"));
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

    public void setFxmlLoaderController(SellPageController controller) {
        fxmlLoader.setController(controller);
    }
}
