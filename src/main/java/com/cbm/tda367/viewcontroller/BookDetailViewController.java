package com.cbm.tda367.viewcontroller;

import com.cbm.tda367.model.ApplicationModel;
import com.cbm.tda367.model.Book;
import com.cbm.tda367.model.Listing;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
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

    private final ApplicationModel model=ApplicationModel.getInstance();
    private final ControllerManager manager;
    private Book book;
    private boolean subscribedToBook;

    @FXML
    private ImageView bookImageView;
    @FXML
    private Text bookTitleText;
    @FXML
    private FlowPane listingsFlowPane;
    @FXML
    private Button subscribeButton,
            unsubscribeButton;

    /**
     * Creates a detail view of a book.
     *
     * @param manager This controller manager.

     */
    public BookDetailViewController(ControllerManager manager, Book book) {

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
        if(subscribedToBook){unsubscribe();}
        else{subscribe();}
    }

    private void unsubscribe() {
        for(Book book : model.getCurrentlyLoggedInUser().getSubscribedBooks()){
            if(book.getBookCode().equals(this.book.getBookCode())){
                model.removeBookFromSubscriptionList(book.getBookCode());
                updateSubscriptionStatus();
            }
        }
    }

    private void subscribe() {
        model.addBookToSubscriptionList(book.getBookCode());
        updateSubscriptionStatus();
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
            if (listing.getBook().getBookCode().equals(bookCode) && !listing.isReserved()) {
                ListingViewController listingViewController = new ListingViewController(manager, listing);
                listingsFlowPane.getChildren().add(listingViewController);
            }
        }
    }

    public void updateBookView() {
        updateBookPicture();
        updateBookTitleText();
        updateListingFlowPane();
        updateSubscriptionStatus();
    }

    private void updateSubscriptionStatus() {
        subscribedToBook = false;
        for(Book book : model.getCurrentlyLoggedInUser().getSubscribedBooks()){
            if(book.getBookCode().equals(this.book.getBookCode())) {
                subscribedToBook = true;
                break;
            }
        }
        if(subscribedToBook){
            subscribeButton.setVisible(false);
            unsubscribeButton.setVisible(true);
        } else {
            subscribeButton.setVisible(true);
            unsubscribeButton.setVisible(false);
        }
    }

    @FXML
    protected void onClickReturnToShopPage() {
        manager.goToShopPage();
    }

    public void setBook(Book book) {
        this.book = book;
    }


}
