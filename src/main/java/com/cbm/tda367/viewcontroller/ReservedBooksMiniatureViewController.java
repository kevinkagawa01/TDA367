package com.cbm.tda367.viewcontroller;

import com.cbm.tda367.model.ApplicationModel;
import com.cbm.tda367.model.Listing;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

/**
 * Visual representation of the miniature view of a User's reserved books.
 *
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 1.0
 * @since 1.0
 */
public class ReservedBooksMiniatureViewController extends AnchorPane {


    private final ControllerManager manager;
    private final Listing listing;
    private final ApplicationModel model = ApplicationModel.getInstance();
    //private @FXML
    //Text reservedListingTitle;
    private @FXML
    Text reservedDate;
    private @FXML
    Text reservedListingPrice;
    private @FXML
    Button unReserve;
    private @FXML
    ImageView reservePicture;
    private @FXML
    Text email;
    private @FXML
    Button doneButton;

    /**
     * Constructs the view and defines its controller.
     *
     * @param manager A ControllerManager. Handles all controllers.
     */
    public ReservedBooksMiniatureViewController(ControllerManager manager, Listing listing) {
        this.manager = manager;
        this.listing = listing.cloneObject();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/cbm/tda367/ReservedBooks.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        reservePicture.setImage(new Image(getClass().getResourceAsStream(this.listing.getBook().getImagePath())));
        //reservedListingTitle.setText(listing.getBook().getBookName());
        reservedDate.setText(String.valueOf(listing.getDate()));
        reservedListingPrice.setText(listing.getPrice() + " kr");
        email.setText(model.getCurrentlyLoggedInUser().getCid());
    }

    /**
     * Updates the visual representation of which user i logged in to the application.
     */
    @FXML
    protected void onClickRemoveReservedBook(Event event) {
        model.removeBookFromReservedList(listing);

    }

    @FXML
    protected void onClickPurchased(Event event) {
        model.purchaseDone(listing);
        System.out.println("Purchased Done");

        manager.goToAccountPage();
        manager.openPurchasedBooksInAccordionInPage();

    }


}
