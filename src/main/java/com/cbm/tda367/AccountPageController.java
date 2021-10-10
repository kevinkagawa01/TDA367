package com.cbm.tda367;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Accordion;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;
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
    @FXML private ScrollPane published;
    @FXML private Text emailText;
    @FXML private ImageView starRating;


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

        try { fxmlLoader.load(); }
        catch (IOException exception) { throw new RuntimeException(exception); }
    }

    /**
     * move to ShopPage by clicking on this button
     *
     * @param event ActionEvent occurring when method is triggered.
     */
    @FXML
    public void shopButton(Event event) {
        manager.goToShopPage();
    }

    /**
     * move to SellPage by clicking on this button
     *
     * @param event ActionEvent occurring when method is triggered.
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

    private String getRatingPicture() {

        double rating = model.getCurrentlyLoggedInUser().getRating();
        String sourcePathStar;
        if ((int) rating == 0) {
            sourcePathStar = "/Library/0-stars.png";
        } else if (rating > 0 || rating < 1) {
            sourcePathStar = "/Library/0-5stars.png";
        } else if ((int) rating == 1) {
            sourcePathStar = "/Library/1-stars.png";
        } else if (rating > 1 || rating < 2) {
            sourcePathStar = "/Library/1-5stars.png";
        } else if ((int) rating == 2) {
            sourcePathStar = "/Library/2-stars.png";
        } else if (rating > 2 || rating < 3) {
            sourcePathStar = "/Library/2-5stars.png";
        } else if ((int) rating == 3) {
            sourcePathStar = "/Library/3-stars.png";
        } else if (rating > 3.5 || rating < 4) {
            sourcePathStar = "/Library/3-5stars.png";
        } else if ((int) rating == 4) {
            sourcePathStar = "/Library/4-stars.png";
        } else if (rating > 4 || rating < 5) {
            sourcePathStar = "/Library/4-5stars.png";
        } else {
            sourcePathStar = "/Library/5-stars.png";
        }
        return sourcePathStar;
    }

    private void updateStarRating() {
        starRating.setImage(new Image(getClass().getResourceAsStream(getRatingPicture())));
    }

    @Override
    public void update() {
        updateLoggedInEmail();
        updateStarRating();
    }
}
