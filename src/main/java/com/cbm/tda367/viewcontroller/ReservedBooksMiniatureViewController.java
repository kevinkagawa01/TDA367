package com.cbm.tda367.viewcontroller;

import com.cbm.tda367.model.ApplicationModel;
import com.cbm.tda367.model.Listing;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

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
    private @FXML
    Text reservedListingTitle;
    private @FXML
    Text reservedDate;
    private @FXML
    Text reservedListingPrice;
    private @FXML
    Rectangle unReserve;


    /**
     * Constructs the view and defines its controller.
     *
     * @param manager A ControllerManager. Handles all controllers.
     */
    public ReservedBooksMiniatureViewController(ControllerManager manager, Listing listing) {
        this.manager = manager;
        this.listing = listing;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/cbm/tda367/ReservedBooks.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        LocalDate localDate = LocalDate.now();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd  hh:mm");
        String date = (sdf.format(listing.getDate()));

        reservedListingTitle.setText(listing.getBook().getBookName());
        reservedDate.setText(date);
        reservedListingPrice.setText(Double.toString(listing.getPrice()));



    }

    @FXML
    public void onClickUnreserveBook(Listing listing) {
        model.getListingDatabase().remove(listing);

    }


}
