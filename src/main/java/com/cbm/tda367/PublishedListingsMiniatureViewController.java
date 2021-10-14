package com.cbm.tda367;

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

    private ApplicationModel model = ApplicationModel.getInstance();

    //private AccountPageController accountPageController;
    private ControllerManager manager=ControllerManager.getInstance();

    private AccountPageViewController accountPageController;




    @FXML
    FlowPane publishedList;

    private Listing listing;

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
        this.listing = listing;





        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PublishedBooks.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }



        BookName.setText(listing.getBook().getBookName());
        Price.setText((int) listing.getPrice() + " kr");
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

        model.getCurrentlyLoggedInUser().removeListingForSale(this.listing);

        //model.deleteFromListing(BookName.getText(),date.getText(),Price.getText(), String.valueOf(BookImage.getImage()));
        System.out.println("Deleted from list");
    }

    /* move to sell page*/
    @FXML
    protected void onClickEditButton(Event event){
        manager.goToSellPage();
    }



    /**
     * Changes published book from the user in the application.
     *
     * @param event Click Event.
     */
    @FXML
    protected void onClickOpenDetailedView(Event event) {
        manager.openSellPageView(this.listing);
    }



}
