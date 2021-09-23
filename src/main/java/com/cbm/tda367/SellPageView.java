package com.cbm.tda367;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class SellPageView extends AnchorPane {

    public SellPageView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sell-page.fxml"));
        fxmlLoader.setRoot(this);

        try
        {
            fxmlLoader.load();
        } catch (IOException exception)
        {
            throw new RuntimeException(exception);
        }
    }
}
