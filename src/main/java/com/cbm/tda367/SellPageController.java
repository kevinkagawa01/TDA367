package com.cbm.tda367;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class SellPageController implements GolbalMenu{

    /* controller manager */
    private ApplicationControllerManager manager;

    /* listing elements */
    @FXML private TextField bookNumber;
    @FXML private TextField bookPrice;
    @FXML private TextArea bookDescription;
    @FXML private ImageView bookImage;

    public SellPageController(ApplicationControllerManager manager) {

        this.manager = manager;

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
