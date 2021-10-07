package com.cbm.tda367;

import javafx.fxml.FXMLLoader;

import java.io.IOException;


public class ReservedBooksMiniatureViewController {

    /**
     * Visual representation of the miniature view of a User's reserved books.
     *
     * @author Kevin Pham
     * @author Simon Holst
     * @author Carl-Magnus Wall
     * @author Pegah Amanzadeh
     * @version 1.0
     * @since 1.0
     */


    private ControllerManager manager;

    /**
     * Constructs the view and defines its controller.
     *
     * @param manager A ControllerManager. Handles all controllers.
     */
    public ReservedBooksMiniatureViewController(ControllerManager manager) {
        this.manager = manager;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ReservedBooks.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

    }
}