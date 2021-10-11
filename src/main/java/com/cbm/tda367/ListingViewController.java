package com.cbm.tda367;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

/**
 * A visual representation of the Shop page
 *
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 1.0
 * @since 1.0
 */

public class ListingViewController extends AnchorPane {
    private final ApplicationModel model = ApplicationModel.getInstance();
    private final ControllerManager manager;
    private Listing listing;

    @FXML
    private Text listingPrice;
    @FXML
    private ImageView listingImage;
    @FXML
    private Text listingBookCondition;


    public ListingViewController(ControllerManager manager, Listing listing) {
        this.listing = listing;
        this.manager = manager;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("shop-page-subscription(1).fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        listingPrice.setText(Double.toString(listing.getPrice()));
        listingImage.setImage(new Image(getClass().getResourceAsStream(listing.getImage())));
        listingBookCondition.setText(listing.getCondition());
    }

}
