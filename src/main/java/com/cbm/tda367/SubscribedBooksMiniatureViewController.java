package com.cbm.tda367;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import javafx.scene.layout.AnchorPane;

import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.io.IOException;

/**
 * Visual representation of a miniature view
 * under the category SubscribedBooks on the account page
 *
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 1.0
 * @since 1.0
 */
public class SubscribedBooksMiniatureViewController extends AnchorPane {

    private final ApplicationModel model = ApplicationModel.getInstance();

    private AccountPageViewController accountPageController;

    private final ControllerManager manager;
    //private AccountPageController accountPageController;

    private final Book book;
    @FXML private Text titleSubscriebdMiniature;
    @FXML  private Rectangle unsubscribedMiniature;
    @FXML  private ImageView subscribedBookPicture;
    @FXML  private Text date;


    public SubscribedBooksMiniatureViewController( Book book,ControllerManager manager) {
        this.book = book;
        this.manager = manager;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SubscribedBooks.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        titleSubscriebdMiniature.setText(book.getBookName());
        subscribedBookPicture.setImage(new Image(getClass().getResourceAsStream(book.getImagePath())));
        date.setText(String.valueOf(book.getDate()));


    }

    /**
     * Unsubscribes to this book.
     *
     * @param event Click Event.
     */
    @FXML
    protected void onClickUnsubscribeToBook(Event event) {
        model.removedBooksFromCurrentlyLoggedInUser(book);
        System.out.println("Removed Subscribed");

    }

}