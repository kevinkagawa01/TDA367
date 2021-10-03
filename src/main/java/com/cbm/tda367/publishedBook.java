package com.cbm.tda367;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class publishedBook extends AnchorPane {

    private ControllerManager manager;
    private ApplicationModel model;
    private FXMLLoader fxmlLoader;

    public publishedBook(ControllerManager manager, ApplicationModel model) {
        this.model = model;
        this.manager = manager;

        fxmlLoader = new FXMLLoader(getClass().getResource("account-page-publishedBooks.fxml"));
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

}
