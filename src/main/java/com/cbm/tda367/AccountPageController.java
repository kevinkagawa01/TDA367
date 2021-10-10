package com.cbm.tda367;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Accordion;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.FlowPane;
import javafx.scene.layout.TilePane;

import javafx.scene.text.Text;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Visual representation of the account page in the application, as well as controller.
 *
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 1.0
 * @since 0.5
 */
public class AccountPageController extends AnchorPane implements Observer {

    private ControllerManager manager;
    private ApplicationModel model;
    private FXMLLoader fxmlLoader;


    @FXML private Accordion accountPageAccordion;
    @FXML private FlowPane publishedBooksFlowPane;
    @FXML private ScrollPane published;
    @FXML  private Text publishedBookText;





    @FXML
    private Text emailText;
    @FXML
    private ImageView starRating;



    /**
     * Initializes account page view/controller.
     *
     * @param manager This controller manager, which handles all controllers.
     * @param model   Model viewed.
     */

    public AccountPageController(ControllerManager manager, ApplicationModel model) {
        this.model = model;
        this.manager = manager;

        fxmlLoader = new FXMLLoader(getClass().getResource("account-page.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }


    /* onclick listeners*/

    /**
     * move to ShopPage by clicking on this button
     *
     * @param event
     */
    @FXML
    public void shopButton(Event event) {
        manager.goToShopPage();
    }

    /**
     * move to SellPage by clicking on this button
     *
     * @param event
     */
    @FXML
    public void addButton(Event event) {
        manager.goToSellPage();
    }

    protected void openPublishedListingsAccordion() {
        accountPageAccordion.setExpandedPane(accountPageAccordion.getPanes().get(1));
        //TODO: Make the scrollPane inside the expanded pane roll to the top.
    }


    private void updateLoggedInEmail() {
        System.out.println(model.getCurrentlyLoggedInUser().getCid());
        emailText.setText(model.getCurrentlyLoggedInUser().getCid());


    }

    private void updateStarRating() {
        starRating.setImage(new Image(getClass().getResourceAsStream(model.getRatingPicture())));
    }


    @Override
    public void update() {
        updateLoggedInEmail();
        updateStarRating();
        updatePublishedBooks();
    }

    private void updatePublishedBooks() {
        ArrayList<Listing> publishedListings = model.getCurrentlyLoggedInUser().getBooksForSale();
        for(Listing listing:publishedListings){
            publishedBooksFlowPane.getChildren().add(new PublishedListingsMiniatureViewController(listing));

        }





    }
}
