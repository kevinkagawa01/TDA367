package com.cbm.tda367.viewcontroller;

import com.cbm.tda367.model.ApplicationModel;
import com.cbm.tda367.model.Book;
import com.cbm.tda367.model.Listing;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Accordion;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;

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
public class AccountPageViewController extends AnchorPane implements Observer {

    private ControllerManager manager;
    private ApplicationModel model;
    private FXMLLoader fxmlLoader;


    @FXML
    private Accordion accountPageAccordion;
    @FXML
    private ScrollPane published;
    @FXML
    private Text publishedBookText;
    @FXML FlowPane publishedBooksFlowPane;
    @FXML FlowPane subscribedBooksFlowPane;
    @FXML FlowPane reservedBookAccordion;
    @FXML FlowPane purchasedBook;

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

    public AccountPageViewController(ControllerManager manager, ApplicationModel model) {
        this.model = model;
        this.manager = manager;

        fxmlLoader = new FXMLLoader(getClass().getResource("/com/cbm/tda367/account-page.fxml"));
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
     * @param event ActionEvent occurring when method is triggered.
     */
    @FXML
    public void shopButton(Event event) {
        manager.goToShopPage();
    }

    /**
     * move to SellPage by clicking on this button.
     *
     * @param event ActionEvent occurring when method is triggered.
     */
    @FXML
    public void addButton(Event event) {
        manager.goToSellPage();
    }

    /**
     * opens the accordion-section where published listings are displayed.
     */
    protected void openReservedBooksAccordion(){
        accountPageAccordion.setExpandedPane(accountPageAccordion.getPanes().get(0));
    }
    protected void openPublishedListingsAccordion() {
        accountPageAccordion.setExpandedPane(accountPageAccordion.getPanes().get(1));
        //TODO: Make the scrollPane inside the expanded pane roll to the top.
    }
    protected void openSubscribedBooksAccordion() {
        accountPageAccordion.setExpandedPane(accountPageAccordion.getPanes().get(2));

        //TODO: Make the scrollPane inside the expanded pane roll to the top.
    }

    protected void openPurchasedBooksAccordion(){
        accountPageAccordion.setExpandedPane(accountPageAccordion.getPanes().get(3));
    }

    /**
     * Updates the visual representation of which user i logged in to the application.
     */
    private void updateLoggedInEmail() {
        emailText.setText(model.getCurrentlyLoggedInUser().getCid());

    }

    /**
     * Returns a rating image-path, represented in the form of 0-5 stars, corresponding to the user's rating.
     *
     * @return rating image-path.
     */
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

    /**
     * Updates the user's star rating image.
     */
    private void updateStarRating() {
        starRating.setImage(new Image(getClass().getResourceAsStream(getRatingPicture())));
    }

    /**
     * Implemented from the observer interface; updates the status of the object.
     */
    @Override
    public void update() {
        updateLoggedInEmail();
        updateStarRating();

        updatePublishedBooks();
        updateSubscribedBooks();
        updateReservedBooks();
        updatePurchasedBooks();


    }
    private void updatePublishedBooks() {
        publishedBooksFlowPane.getChildren().clear();

        ArrayList<Listing> publishedListings = model.getCurrentlyLoggedInUser().getBooksForSale();
        for (Listing listing : publishedListings) {
            publishedBooksFlowPane.getChildren().add(new PublishedListingsMiniatureViewController(manager,listing));

        }
    }
    private void updateSubscribedBooks(){
        subscribedBooksFlowPane.getChildren().clear();

        ArrayList<Book> subscribedBooks= model.getCurrentlyLoggedInUser().getSubscribedBooks();
        for(Book book:subscribedBooks){
            subscribedBooksFlowPane.getChildren().add(new SubscribedBooksMiniatureViewController(book,manager));
        }

    }
    private void updateReservedBooks() {
        reservedBookAccordion.getChildren().clear();

        ArrayList<Listing> reservedBooks = model.getCurrentlyLoggedInUser().getReservedBooks();
        for (Listing listing : reservedBooks) {
            reservedBookAccordion.getChildren().add(new ReservedBooksMiniatureViewController(manager,listing));

        }
    }
    private void updatePurchasedBooks() {
        purchasedBook.getChildren().clear();

        ArrayList<Listing> purchasedBooks = model.getCurrentlyLoggedInUser().getPreviousPurchases();
        for (Listing listing : purchasedBooks) {
            purchasedBook.getChildren().add(new BoughtBooksMiniatureViewController(manager,listing));

        }
    }


}
