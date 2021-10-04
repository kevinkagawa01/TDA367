package com.cbm.tda367;

import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class SubscribedBooks {
    ApplicationModel model;
    ControllerManager manager;

    public SubscribedBooks(ControllerManager manager, ApplicationModel model) {
        this.model = model;
        this.manager = manager;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SubscribedBooks.fxml"));
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
