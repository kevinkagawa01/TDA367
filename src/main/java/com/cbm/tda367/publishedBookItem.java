package com.cbm.tda367;

import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.text.SimpleDateFormat;

public class publishedBookItem extends TitledPane {

    private ControllerManager manager;
    private ApplicationModel model;
    private FXMLLoader fxmlLoader;
    Listing listing;
    private String blankSpace = "\t\t";


    public publishedBookItem(Listing listing) {
        //this.model = model;
        //this.manager = manager;
        this.listing=listing;

        fxmlLoader = new FXMLLoader(getClass().getResource("account-page-publishedBookItem.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try
        {
            fxmlLoader.load();
        } catch (IOException exception)
        {
            throw new RuntimeException(exception);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd  hh:mm");
        String date = (sdf.format(listing.getDate()));
            setText(listing.getBook()+blankSpace+listing.getPrice()+date);

        }
    }









