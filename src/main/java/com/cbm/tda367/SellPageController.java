package com.cbm.tda367;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class SellPageController implements GolbalMenu{

    /* global navigation buttons */
    @FXML private ImageView shopButton;
    @FXML private ImageView accountButton;

    /* listing elements */
    @FXML private TextField bookNumber;
    @FXML private TextField bookPrice;
    @FXML private TextArea bookDescription;
    @FXML private ImageView bookImage;

    /* sell page elements */
    @FXML private Rectangle createListingButton;

    public SellPageController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sell-page.fxml"));
        fxmlLoader.setController(this);
    }

    @Override
    public void shopButton() {
        
    }

    @Override
    public void accountButton() {

    }

    @Override
    public void addButton() {

    }
}
