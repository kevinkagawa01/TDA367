package com.cbm.tda367;

import javafx.fxml.FXMLLoader;

import java.io.IOException;

/** Visual representation of a miniature view
 *  under the category SubscribedBooks on the account page
 *
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 1.0
 * @since 1.0
 * */
public class SubscribedBooksMiniatureViewController {

    private ControllerManager manager;

    public SubscribedBooksMiniatureViewController(ControllerManager manager) {

        this.manager = manager;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SubscribedBooks.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

    }
}
