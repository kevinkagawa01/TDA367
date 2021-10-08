package com.cbm.tda367;

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

    private ControllerManager manager;
    Listing listing;
    private String blankSpace = "\t\t";
    @FXML
    Text publishedBookTitle;
    @FXML
    Text publishedBookDate;
    @FXML
    Text publishedBookPrice;

    /**
     * Constructs the miniature view and defines its controller.
     *
     * @param manager A ControllerManager. Handles all controllers.
     */
    public PublishedListingsMiniatureViewController(ControllerManager manager, Listing listing) {
        this.manager = manager;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PublishedBooks.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        LocalDate localDate = LocalDate.now();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd  hh:mm");
        String date = (sdf.format(listing.getDate()));
        publishedBookTitle.setText(listing.getBook().getBookName());
        publishedBookDate.setText(date);
        publishedBookPrice.setText(Double.toString(listing.getPrice()));

    }
    @FXML public void onClickRemovePublishedBook(){

    }
    @FXML public void onClickChangePublishedBook(){

    }
}
