package com.cbm.tda367;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;

public class shopPageListingViewController {
    private ApplicationModel model;
    private ControllerManager manager;
    private FXMLLoader fxmlLoader;
    private Listing listing;

    @FXML
    Text listingPrice;
    @FXML
    ImageView listingImage;
    @FXML
    Text listingBookCondition;


    public shopPageListingViewController(ControllerManager manager, ApplicationModel model) {
        this.model = model;
        this.manager = manager;

        fxmlLoader = new FXMLLoader(getClass().getResource("shop-page-subscription(1).fxml"));
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
