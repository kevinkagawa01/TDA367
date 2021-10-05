package com.cbm.tda367;

import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class PublishedBooks {

    private ControllerManager manager;

    public PublishedBooks(ControllerManager manager) {
        this.manager = manager;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PublishedBooks.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

    }
}
