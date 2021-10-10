package com.cbm.tda367;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.spi.LocaleServiceProvider;

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
public class SubscribedBooksMiniatureViewController {

    private final ApplicationModel model = ApplicationModel.getInstance();
    private final ControllerManager manager;
    private AccountPageController accountPageController;
    private final Book book;

    @FXML private Text titleSubscriebdMiniature;
    @FXML private Rectangle unsubscribedMiniature;


    public SubscribedBooksMiniatureViewController(ControllerManager manager, Book book) {
        this.book = book;
        this.manager = manager;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SubscribedBooks.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        Date date = new Date();

        try { fxmlLoader.load(); }
        catch (IOException exception) { throw new RuntimeException(exception); }

        titleSubscriebdMiniature.setText(book.getBookName());

    }

    /**
     * Unsubscribes to this book.
     * @param event Click Event.
     */
    @FXML
    protected void onClickUnsubscribeToBook(Event event) {
        model.getCurrentlyLoggedInUser().removeBookSubscription(book.getBookCode());
    }

}
