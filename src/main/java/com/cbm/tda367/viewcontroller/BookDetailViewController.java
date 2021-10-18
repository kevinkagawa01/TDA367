package com.cbm.tda367.viewcontroller;

import com.cbm.tda367.model.ApplicationModel;
import com.cbm.tda367.model.Book;
import com.cbm.tda367.model.Listing;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.List;

/**
 * Visual representation of a book in our View/Controller in MVC.
 *
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 1.0
 * @since 1.0
 */
public class BookDetailViewController extends AnchorPane {
    private final ApplicationModel model;
    private final ControllerManager manager;
    private Book book;
    private Listing listing;
    private ListingViewController shopPageListing;
    private boolean subscribePressed = false;

    @FXML
    private ImageView bookImageView;
    @FXML
    private Text bookTitleText;
    @FXML
    private Rectangle greenButton;
    @FXML
    private FlowPane listingsFlowPane;

    /**
     * Creates a detail view of a book.
     *
     * @param manager This controller manager.
     * @param model   Singleton of application model.
     */
    public BookDetailViewController(ControllerManager manager, ApplicationModel model, Book book) {
        this.model = model;
        this.manager = manager;
        this.book = book;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/cbm/tda367/shop-page-subscription.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }


    }
    /**
     * On click method, subscribing/unsubscribing this to a book.
     *
     * @param event Click event.
     */
    @FXML
    public void onClickSubscribeToBook(Event event) {

        if (!subscribePressed) {
            greenButton.setFill(Color.RED);
            subscribePressed = true;
        } else {
            greenButton.setFill(Color.GREEN);
            subscribePressed = false;
        }

        model.addBookToSubscriptionList(book.getBookName(), book.getImagePath());

        /*Switch to account page*/

        manager.goToAccountPage();
        manager.openSubscribedBooksInAccordionPage();
    }

    public void updateBookPicture() {

        bookImageView.setImage(new Image(getClass().getResourceAsStream(book.getImagePath())));
    }

    public void updateBookTitleText() {
        bookTitleText.setText(book.getBookName());
    }

    public void updateListingFlowPane() {
        /* clear flow pane */
        listingsFlowPane.getChildren().clear();
        /* Retrieves this book code */
        String bookCode = book.getBookCode();
        /* Looks for listings with corresponding book */
        List<Listing> listings = model.getListingDatabase();
        for (Listing listing : listings) {
            if (listing.getBook().getBookCode().equals(bookCode) && !listing.getReserved()) {
                ListingViewController listingViewController = new ListingViewController(manager, listing);
                listingsFlowPane.getChildren().add(listingViewController);
            }
        }
    }

    public void updateBookView() {
        updateBookPicture();
        updateBookTitleText();
        updateListingFlowPane();
    }

    @FXML
    protected void onClickReturnToShopPage() {
        manager.goToShopPage();
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setSubscribePressed() {
        this.subscribePressed = false;
    }
}
