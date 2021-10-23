package com.cbm.tda367.viewcontroller;

import com.cbm.tda367.model.ApplicationModel;
import com.cbm.tda367.model.Book;
import com.cbm.tda367.model.Observer;
import com.cbm.tda367.model.SubscribeNotification;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import javafx.scene.layout.AnchorPane;

import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.List;

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
public class SubscribedBooksMiniatureViewController extends AnchorPane implements Observer {

    private final ApplicationModel model = ApplicationModel.getInstance();
    private final ControllerManager manager;


    private final Book book;
    @FXML
    private Text titleSubscriebdMiniature;
    @FXML
    private Rectangle unsubscribedMiniature;
    @FXML
    private ImageView subscribedBookPicture;
    @FXML
    private Text date;
    @FXML
    private Button newListingsButton;
    @FXML
    private Button noNewListingsButton;



    public SubscribedBooksMiniatureViewController(Book book, ControllerManager manager) {

        this.book = book;
        this.manager = manager;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/cbm/tda367/SubscribedBooks.fxml"));
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
        update();
    }


    /**
     * Unsubscribes to this book.
     *
     * @param event Click Event.
     */
    @FXML
    protected void onClickUnsubscribeToBook(Event event) {
        model.removeBookFromSubscriptionList(book.getBookCode());

        System.out.println("Removed Subscribed");

    }

    @FXML
    protected void onClickGoToNewListingsOfThisBook(Event event){
        manager.openBookDetailView(book);
        model.removeNotification(book.getBookCode(),model.getCurrentlyLoggedInUser().getSubscribeNotifications().size());
        updateNewListingsNumber();
    }

    private void updateNewListingsNumber(){
        int notificationNumber = 0;
        List<SubscribeNotification> subscribeNotifications = model.getCurrentlyLoggedInUser().getSubscribeNotifications();
        for(SubscribeNotification notification : subscribeNotifications){
            if(notification.getBookCodeToRelatedBook().equals(this.book.getBookCode())){
                notificationNumber++;
            }
        }

        if(notificationNumber == 0){
            newListingsButton.setVisible(false);
            noNewListingsButton.setVisible(true);
        } else {
            newListingsButton.setText(String.format("%d New Listings",notificationNumber));
            newListingsButton.setVisible(true);
            noNewListingsButton.setVisible(false);
        }
    }

    /**
     * Updates this status.
     */
    @Override
    public void update() {
        updateNewListingsNumber();
    }
}
