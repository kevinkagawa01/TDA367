package com.cbm.tda367;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Control;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class SellPageController implements GolbalMenu{

    /* view manager */
    private ControllerManager manager;

    /* listing elements */
    @FXML private TextField bookNumber;
    @FXML private TextField bookPrice;
    @FXML private TextArea bookDescription;
    @FXML private ImageView bookImage;

    public SellPageController(ControllerManager manager) {

        this.manager = manager;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sell-page.fxml"));
        fxmlLoader.setController(this);
    }

    @Override
    public void shopButton(Event event) {
        
    }

    @Override
    public void accountButton(Event event) {

    }

    @Override
    public void addButton(Event event) {

    }
}
