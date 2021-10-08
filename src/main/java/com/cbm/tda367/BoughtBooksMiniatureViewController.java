package com.cbm.tda367;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class BoughtBooksMiniatureViewController {
    private ControllerManager manager;
    AccountPageController accountPageController;

    public BoughtBooksMiniatureViewController(ControllerManager manager, Listing listing) {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BoughtBooks.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

    }

    @FXML
    public void removeBoughtBooksMiniature(Listing listing) {
        accountPageController.removeBoughtBook(listing);
    }
}
