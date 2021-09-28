package com.cbm.tda367;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class AccountPageView extends AnchorPane {

    private ViewManager manager;
    private FXMLLoader fxmlLoader;

    public AccountPageView(ViewManager manager) {

        this.manager = manager;

        fxmlLoader = new FXMLLoader(getClass().getResource("account-page.fxml"));
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

    public void setFxmlLoaderController(AccountPageController controller) {
        fxmlLoader.setController(controller);
    }
}
