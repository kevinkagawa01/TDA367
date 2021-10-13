package com.cbm.tda367;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

/**
 * Miniature representation of a bought book in our View/Controller in MVC.
 *
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 1.0
 * @since 1.0
 */
public class BoughtBooksMiniatureViewController {

    private final ApplicationModel model = ApplicationModel.getInstance();
    private final ControllerManager manager;
    private Listing listing;

    /**
     * class constructor
     *
     * @param listing Listing to be displayed as the miniature.
     */
    public BoughtBooksMiniatureViewController(ControllerManager manager, Listing listing) {
        this.listing = listing;
        this.manager = manager;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BoughtBooks.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

    }

    /**
     * On-click method to remove this from the user's bought books.
     *
     * @param event listing to be removed from the user's bought books.
     */
    @FXML
    protected void removeBoughtBooksMiniature(Event event) {
        model.getCurrentlyLoggedInUser().removePreviousPurchase(this.listing);
    }
}
