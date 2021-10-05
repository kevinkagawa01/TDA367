package com.cbm.tda367;

import javafx.fxml.FXMLLoader;

import java.io.IOException;

/**
 * A visual representation of the miniature view of a User's published Listings
 *
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 1.0
 * @since 1.0
 */
public class PublishedListingsMiniatureViewController {

    private ControllerManager manager;

    /**
     * Constructs the miniature view and defines its controller.
     *
     * @param manager A ControllerManager. Handles all controllers.
     */
    public PublishedListingsMiniatureViewController(ControllerManager manager) {
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
