package com.cbm.tda367;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
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
    private boolean subscribePressed = true;

    @FXML
    private ImageView bookImageView;
    @FXML
    private Text bookTitleText;
    @FXML
    private Rectangle reserveButton;
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

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("shop-page-subscription.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }






    }
    //Todo: add shopPageListingviews in flowpane
   /* private void addListingFlowPane() {
        bookPane.getChildren().add(shopPageListing);
    }*/

    /**
     * On click method, subscribing/unsubscribing this to a book.
     *
     * @param event Click event.
     */
    @FXML
    public void onClickSubscribeToBook(Event event) {
        //Om false,greenButton.setFill() till röd
        //annars till grön
        model.addBooks(book.getBookName(),book.getImagePath());

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


    /**
     * Updates current user's list of subscribed books in shop page.
     */
    /*public void updateSubscribedCategoryPane() {
        List<Book> items = BookDatabase.getInstance().getBookList();
        //getBookCode osv
        listingsFlowPane.getChildren().clear();
        for (Book book :
                items) {
            // bookPane.getChildren().add();
        }

    }

     */


    public void fillFlowPane(){

    }

    public void updateBookView() {
        updateBookPicture();
        updateBookTitleText();
        //updateListingFlowPane();
    }

    @FXML
    protected void onClickReturnToShopPage() {
        manager.goToShopPage();
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
