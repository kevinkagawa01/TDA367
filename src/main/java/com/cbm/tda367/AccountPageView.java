package com.cbm.tda367;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class AccountPageView extends AnchorPane {

    public AccountPageView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("account-page.fxml"));
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
