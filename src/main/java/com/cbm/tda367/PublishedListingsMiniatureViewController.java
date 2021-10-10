package com.cbm.tda367;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

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

    private ControllerManager manager;
    Listing listing;
    private ApplicationModel model;
    private  Book book;

    @FXML
    FlowPane publishedList;

    @FXML private ImageView BookImage;
    @FXML private Text BookCode;
   // @FXML private Button ChangeButton;
    //@FXML private Button DeleteButton;
    @FXML private Text Price;
    @FXML private Text date;


    /**
     * Constructs the miniature view and defines its controller.
     *
    // * @param manager A ControllerManager. Handles all controllers.
     */
    public PublishedListingsMiniatureViewController(Listing listing) {
        //this.manager = manager;
        this.listing=listing;
        this.book=book;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PublishedBooks.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        BookCode.setText(listing.getBook().getBookName());
        Price.setText(String.valueOf(listing.getPrice()));
        date.setText(String.valueOf(listing.getDate()));
        updateBookPicture();



    }
    public void updateBookPicture() {

        BookImage.setImage(new Image(getClass().getResourceAsStream(listing.getBook().getImagePath())));
    }



}
