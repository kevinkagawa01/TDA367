package com.cbm.tda367;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.List;

/** Visual representation of a listing in our View/Controller in MVC.
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 1.0
 * @since 1.0
 * */
public class ListingDetailViewController extends AnchorPane {
    private ApplicationModel model;
    private ControllerManager manager;
    private Listing listing;

    @FXML private ImageView starRatings;
    @FXML private ImageView frontProfilePic;
    @FXML private Text bookTitle;
    @FXML private Rectangle reserveButton;
    @FXML private Text email;
    @FXML private Text name;
    @FXML private FlowPane bookPictures;

    /**
     * Creates a detail view of a listing.
     *
     * @param manager This controller manager.
     * @param model   Singleton of application model.
     */
    public ListingDetailViewController(ControllerManager manager, ApplicationModel model) {
        this.model = model;
        this.manager = manager;

        FXMLLoader detailedView = new FXMLLoader(getClass().getResource("shop-page-detailedView.fxml"));
        detailedView.setRoot(this);
        detailedView.setController(this);

        try { detailedView.load(); }
        catch (IOException exception) { throw new RuntimeException(exception); }
    }

    /**
     * On click method, directing the user to the account page.
     * @param event Click event.
     */
    @FXML
    public void onClickGoToAccountPage(Event event) {
        manager.goToAccountPage();
    }

    /**
     * On click method, directing the user to the shop page.
     * @param event Click event.
     */
    @FXML
    public void onClickGoToShopPage(Event event) {
        manager.goToShopPage();
    }

    /**
     * On click method, directing the user to the sell page.
     * @param event Click event.
     */
    @FXML
    public void onClickGoToSellPage(Event event) {
        manager.goToSellPage();
    }
}
