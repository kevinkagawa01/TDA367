package com.cbm.tda367;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.List;

/**
 * Visual representation of a listing in our View/Controller in MVC.
 *
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 1.0
 * @since 1.0
 */
public class ListingDetailViewController extends AnchorPane implements Observer {
    private final ApplicationModel model = ApplicationModel.getInstance();
    private final ControllerManager manager;
    private Listing listing;

    @FXML
    private ImageView listingDetailStarRatings;
    @FXML
    private ImageView frontProfilePic;
    @FXML
    private Text listingBookTitle;
    @FXML
    private Rectangle reserveButton;
    @FXML
    private Text listingDetailEmail;
    @FXML
    private Text listingDetailName;


    /**
     * Creates a detail view of a listing.
     *
     * @param manager This controller manager.
     * @param listing a Listing Object
     */
    public ListingDetailViewController(ControllerManager manager, Listing listing) {
        this.manager = manager;
        this.listing = listing;
        FXMLLoader detailedView = new FXMLLoader(getClass().getResource("shop-page-detailedView.fxml"));
        detailedView.setRoot(this);
        detailedView.setController(this);

        try {
            detailedView.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private String getRatingPicture(double userRating) {


        String sourcePathStar;
        if ((int) userRating == 0) {
            sourcePathStar = "/Library/0-stars.png";
        } else if (userRating > 0 || userRating < 1) {
            sourcePathStar = "/Library/0-5stars.png";
        } else if ((int) userRating == 1) {
            sourcePathStar = "/Library/1-stars.png";
        } else if (userRating > 1 || userRating < 2) {
            sourcePathStar = "/Library/1-5stars.png";
        } else if ((int) userRating == 2) {
            sourcePathStar = "/Library/2-stars.png";
        } else if (userRating > 2 || userRating < 3) {
            sourcePathStar = "/Library/2-5stars.png";
        } else if ((int) userRating == 3) {
            sourcePathStar = "/Library/3-stars.png";
        } else if (userRating > 3.5 || userRating < 4) {
            sourcePathStar = "/Library/3-5stars.png";
        } else if ((int) userRating == 4) {
            sourcePathStar = "/Library/4-stars.png";
        } else if (userRating > 4 || userRating < 5) {
            sourcePathStar = "/Library/4-5stars.png";
        } else {
            sourcePathStar = "/Library/5-stars.png";
        }
        return sourcePathStar;
    }


    public void updateListingDetailViewRating() {

        listingDetailStarRatings.setImage(new Image(getClass().getResourceAsStream(getRatingPicture(model.getListingSellerRating(this.listing)))));

    }

    public void updateListingEmail() {
        listingDetailEmail.setText(model.getListingSellerEmail(this.listing));
    }

    /**
     * On click method, directing the user to the account page.
     *
     * @param event Click event.
     */
    @FXML
    public void onClickGoToAccountPage(Event event) {
        manager.goToAccountPage();
    }

    /**
     * On click method, directing the user to the shop page.
     *
     * @param event Click event.
     */
    @FXML
    public void onClickGoToShopPage(Event event) {
        manager.goToShopPage();
    }

    /**
     * On click method, directing the user to the sell page.
     *
     * @param event Click event.
     */
    @FXML
    public void onClickGoToSellPage(Event event) {
        manager.goToSellPage();
    }

    @Override
    public void update() {
        updateListingDetailViewRating();
        updateListingEmail();
    }
    protected void onclickReservedBook(){
        

    }
}