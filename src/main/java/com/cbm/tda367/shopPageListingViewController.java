package com.cbm.tda367;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class shopPageListingViewController extends AnchorPane {
    private final ApplicationModel model;
    private final ControllerManager manager;
    private Listing listing;

    @FXML private Text listingPrice;
    @FXML private ImageView listingImage;
    @FXML private Text listingBookCondition;


    public shopPageListingViewController(ControllerManager manager, ApplicationModel model) {
        this.model = model;
        this.manager = manager;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("shop-page-subscription(1).fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try { fxmlLoader.load(); }
        catch (IOException exception) { throw new RuntimeException(exception); }
        //listingPrice.setText(Double.toString(listing.getPrice()));
        //listingImage.setImage(new Image(getClass().getResourceAsStream(listing.getImage())));
        //listingBookCondition.setText(listing.getCondition());
    }

}
