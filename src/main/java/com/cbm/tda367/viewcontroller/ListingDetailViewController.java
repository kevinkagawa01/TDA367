package com.cbm.tda367.viewcontroller;

import com.cbm.tda367.model.ApplicationModel;
import com.cbm.tda367.model.Listing;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

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
public class ListingDetailViewController extends AnchorPane {
    private final ApplicationModel model = ApplicationModel.getInstance();
    private final ControllerManager manager;
    private Listing listing;

    @FXML private Text listingDetailEmail;
    @FXML private ImageView listingDetailStarRatings;
    @FXML private Text listingBookTitle;
    @FXML private Text listingBookCondition;
    @FXML private Text listingBookPrice;
    @FXML private TextArea listingDetailDescription;


    /**
     * Creates a detail view of a listing.
     *
     * @param manager This controller manager.
     * @param listing a Listing Object
     */
    public ListingDetailViewController(ControllerManager manager, Listing listing) {
        this.manager = manager;
        this.listing = listing;
        FXMLLoader detailedView = new FXMLLoader(getClass().getResource("/com/cbm/tda367/shop-page-detailedView.fxml"));
        detailedView.setRoot(this);
        detailedView.setController(this);

        try { detailedView.load(); }
        catch (IOException exception) { throw new RuntimeException(exception); }
    }

    private String getRatingImagePath(double userRating) {
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


    public void updateListingDetailViewRatingImage() {
        listingDetailStarRatings.setImage(new Image(getClass().getResourceAsStream(getRatingImagePath(model.getListingSellerRating(this.listing)))));
    }

    public void updateListingEmailText() {
        listingDetailEmail.setText(model.getListingCid(this.listing));
    }
    /**
     * On click method, directing the user to the account page and open the Reserved Books in Accordion
     *
     * @param event Click event
     */

    @FXML
    public void onClickReservePurchase(Event event) {
        model.reserveListing(this.listing);

        manager.goToAccountPage();
        manager.openReservedBooksInAccordionPage();
    }



    /**
     * On click method, directing the user to the page before
     *
     * @param event Click event
     */
    @FXML
    public void onCLickGoToBookDetailView(Event event) {
        manager.goToBookDetailView();
    }


    //@Override
    //public void update() {
        //updateListingDetailViewRating();
        //updateListingEmail();
      // updateListingDetailDescription();


    public void setListing(Listing listing) {
        this.listing = listing;
    }

    public void updateListingView() {
        updateListingEmailText();
        updateListingDetailViewRatingImage();
        updateListingBookTitleText();
        updateListingBookConditionText();
        updateListingBookPriceText();
        updateListingBookDescriptionText();
    }

    private void updateListingBookPriceText() {
        //listingBookPrice.setText(String.format("%f kr",listing.getPrice()));
        listingBookPrice.setText((int) listing.getPrice() + " kr");
    }

    private void updateListingBookConditionText() {
        listingBookCondition.setText(String.format("%s",listing.getCondition()));
    }

    private void updateListingBookDescriptionText() {
        listingDetailDescription.setText(listing.getListingDescription());
    }

    private void updateListingBookTitleText() {
        listingBookTitle.setText(listing.getBook().getBookName());
    }



    @FXML
    void onClickReturnToBookDetailView(Event event){
        this.toBack();

    }

}
