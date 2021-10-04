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


public class DetailedBookView extends AnchorPane {
    ApplicationModel model;
    ControllerManager manager;
    Listing ads;

    @FXML
    private ImageView starRatings;
    @FXML
    private ImageView frontProfilePic;
    @FXML
    private Text bookTitle;
    @FXML
    private Rectangle reserveButton;
    @FXML
    private Text email;
    @FXML
    private Text name;
    @FXML
    private FlowPane bookPictures;


    public DetailedBookView(ControllerManager manager, ApplicationModel model) {
        this.model = model;
        this.manager = manager;

        FXMLLoader detailedView = new FXMLLoader(getClass().getResource("shop-page-detailedView.fxml"));
        detailedView.setRoot(this);
        detailedView.setController(this);

        try {
            detailedView.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }


    }


    @FXML
    public void accountButton(Event event) {
        manager.goToAccountPage();
    }

    @FXML
    public void shopButton(Event event) {
        manager.goToShopPage();
    }

    @FXML
    public void addButton(Event event) {
        manager.goToSellPage();
    }
}
