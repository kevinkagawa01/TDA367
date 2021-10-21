package com.cbm.tda367.viewcontroller;

import com.cbm.tda367.model.Observer;
import com.cbm.tda367.model.EmptyBook;
import com.cbm.tda367.model.EmptyListing;
import com.cbm.tda367.model.Book;
import com.cbm.tda367.model.Listing;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Represents the database of Books
 *
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 1.0
 * @since 1.0
 */

public class ControllerManager implements Initializable, Observer {


    private final static ControllerManager controllerManager = new ControllerManager();

    public static ControllerManager getInstance() {
        return controllerManager;
    }

    @FXML
    private AnchorPane mainAnchorPane;

    /* application pages */
    private final LoginPageViewController loginPage = new LoginPageViewController(this);
    private final ShopPageViewController shopPage = new ShopPageViewController(this);
    private final SellPageViewController sellPage = new SellPageViewController(this);
    private final AccountPageViewController accountPage = new AccountPageViewController(this);

    //TODO: First book should not be null!
    private final BookDetailViewController bookDetailViewController = new BookDetailViewController(this, EmptyBook.getInstance());
    private final ListingDetailViewController listingDetailViewController = new ListingDetailViewController(this, EmptyListing.getInstance());
    private final List<Observer> mainPages = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /* Adding observers locally */
        mainPages.add(sellPage);
        mainPages.add(accountPage);
        mainPages.add(shopPage);
        mainPages.add(loginPage);

        mainAnchorPane.getChildren().add(bookDetailViewController);
        mainAnchorPane.getChildren().add(listingDetailViewController);
        mainAnchorPane.getChildren().add(sellPage);
        mainAnchorPane.getChildren().add(accountPage);
        mainAnchorPane.getChildren().add(shopPage);
        mainAnchorPane.getChildren().add(loginPage);
    }

    /**
     * this method will update the model
     */

    @Override
    public void update() {
        for (Observer mainPageObserver : mainPages) {
            mainPageObserver.update();
        }
    }

    /**
     * Opens published listings accordion-section when called.
     */

    protected void openPublishedListingsAccordionInAccountPage() {
        accountPage.openPublishedListingsAccordion();
    }

    protected void openSubscribedBooksInAccordionPage() {
        accountPage.openSubscribedBooksAccordion();
    }

    protected void openReservedBooksInAccordionPage() {
        accountPage.openReservedBooksAccordion();
    }

    protected void openPurchasedBooksInAccordionInPage() {
        accountPage.openPurchasedBooksAccordion();
    }


    /**
     * Navigate to ShopPage
     */
    void goToShopPage() {
        shopPage.toFront();
    }

    /**
     * Navigate to SellPage
     */
    void goToSellPage() {
        sellPage.toFront();
    }


    /**
     * Navigate to AccountPage
     */
    void goToAccountPage() {
        accountPage.toFront();
    }

    /**
     * Navigate to BookDetailView
     */
    void goToBookDetailView() {
        bookDetailViewController.toFront();
    }

    /**
     * Opens detailed view of book.
     *
     * @param book book to be previewed in detailed view.
     */
    public void openBookDetailView(Book book) {
        /* Changes currently selected book in DetailView */
        bookDetailViewController.setBook(book);
        /* Update View */
        bookDetailViewController.updateBookView();
        /* Send it to front */
        bookDetailViewController.toFront();
    }

    /**
     * Opens detailed view of listing.
     *
     * @param listing listing to be previewed in detailed view.
     */
    public void openListingDetailView(Listing listing) {
        /* Changes currently selected book in DetailView */
        listingDetailViewController.setListing(listing);
        /* Update view */
        listingDetailViewController.updateListingView();
        /* Send it to front */
        listingDetailViewController.toFront();
    }

    public void openSellPageView(Listing listing) {
        sellPage.setAllFieldsFromListing(listing);

        sellPage.update();
        sellPage.toFront();
    }
}
