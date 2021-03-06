package com.cbm.tda367.viewcontroller;

import com.cbm.tda367.model.ApplicationModel;
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
public class PublishedListingsMiniatureViewController extends AnchorPane {

    private final ApplicationModel model = ApplicationModel.getInstance();
    private final ControllerManager manager;
    private final Listing listing;

    @FXML
    FlowPane publishedList;
    @FXML
    private ImageView BookImage;
    @FXML
    private Text BookName;
    @FXML
    private Text Price;
    @FXML
    private Text date;
    @FXML
    private Button ChangeButton;
    @FXML
    private Button DeleteButton;

    /**
     * Constructs the miniature view and defines its controller.
     *
     * @param listing A ControllerManager. Handles all controllers.
     */


    public PublishedListingsMiniatureViewController(ControllerManager manager, Listing listing) {
        this.manager = manager;
        this.listing = listing.cloneObject();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/cbm/tda367/PublishedBooks.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        BookName.setText(listing.getBook().getBookName());
        Price.setText(String.format("Price: %s kr", listing.getPrice()));
        date.setText(String.valueOf(listing.getDate()));
        updateBookPicture();
    }

    public void updateBookPicture() {
        BookImage.setImage(new Image(getClass().getResourceAsStream(this.listing.getBook().getImagePath())));
    }

    /**
     * Removes published book from the user in the application.
     *
     * @param event Click Event.
     */
    @FXML
    protected void onClickRemovePublishedBook(Event event) {
        model.removedListingFromCurrentlyLoggedInUser(listing);
        System.out.println("Deleted from list");
    }
    /**
     * Edit published book.
     *
     * @param event Click Event.
     */


    /**
     * Changes published book from the user in the application.
     *
     * @param event Click Event.
     */
    @FXML
    protected void onClickEditButton(Event event) {
        manager.openSellPageView(this.listing);
    }


}
