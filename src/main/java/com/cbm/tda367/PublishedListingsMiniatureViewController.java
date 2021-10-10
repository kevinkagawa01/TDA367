package com.cbm.tda367;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.text.Text;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

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

    private ApplicationModel model = ApplicationModel.getInstance();
    private AccountPageController accountPageController;
    private ControllerManager manager;
    private Listing listing;
    private String blankSpace = "\t\t";
    private @FXML Text publishedBookTitle;
    private @FXML Text publishedBookDate;
    private @FXML Text publishedBookPrice;

    /**
     * Constructs the miniature view and defines its controller.
     *
     * @param manager A ControllerManager. Handles all controllers.
     */
    public PublishedListingsMiniatureViewController(ControllerManager manager, Listing listing) {
        this.manager = manager;
        this.listing = listing;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PublishedBooks.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try { fxmlLoader.load(); }
        catch (IOException exception) { throw new RuntimeException(exception); }

        LocalDate localDate = LocalDate.now();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd  hh:mm");
        String date = (sdf.format(listing.getDate()));
        publishedBookTitle.setText(listing.getBook().getBookName());
        publishedBookDate.setText(date);
        publishedBookPrice.setText(Double.toString(listing.getPrice()));

    }

    /**
     * Removes published book from the user in the application.
     * @param event Click Event.
     */
    @FXML
    protected void onClickRemovePublishedBook(Event event) {
        model.getCurrentlyLoggedInUser().removeListingForSale(listing.getListingNumber());
    }

    /**
     * Changes published book from the user in the application.
     * @param event Click Event.
     */
    @FXML
    protected void onClickChangePublishedBook(Event event) {

    }
}
