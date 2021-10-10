package com.cbm.tda367;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class BoughtBooksMiniatureViewController {

    private ApplicationModel model = ApplicationModel.getInstance();
    private ControllerManager manager;
    private AccountPageController accountPageController;

    public BoughtBooksMiniatureViewController(ControllerManager manager, Listing listing) {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BoughtBooks.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try { fxmlLoader.load(); }
        catch (IOException exception) { throw new RuntimeException(exception); }
    }

    @FXML
    protected void removeBoughtBooksMiniature(Listing listing) {
        model.getCurrentlyLoggedInUser().removePreviousPurchase(listing.getListingNumber());
    }
}
