package com.cbm.tda367.viewcontroller;

import com.cbm.tda367.model.Listing;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

/**
 * Miniature representation of a bought book in our View/Controller in MVC.
 *
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 1.0
 * @since 1.0
 */
public class BoughtBooksMiniatureViewController extends AnchorPane {

    private final Listing listing;
    @FXML
    ImageView purchasedPicture;
    @FXML
    Text purchasedTitle;
    @FXML
    Text date;
    @FXML
    Text purchasedPrice;

    /**
     * class constructor
     *
     * @param listing Listing to be displayed as the miniature.
     */
    public BoughtBooksMiniatureViewController(Listing listing) {
        this.listing = listing.cloneObject();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/cbm/tda367/BoughtBooks.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        purchasedPicture.setImage(new Image(getClass().getResourceAsStream(this.listing.getBook().getImagePath())));
        purchasedTitle.setText(listing.getBook().getBookName());
        date.setText(String.valueOf(listing.getDate()));
        purchasedPrice.setText(listing.getPrice() + " kr");
    }
}
