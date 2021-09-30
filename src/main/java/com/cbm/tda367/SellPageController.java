package com.cbm.tda367;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class SellPageController extends AnchorPane {

    private ControllerManager manager;
    private ApplicationModel model;

    /* FXML elements */
    @FXML private TextField bookCodeTextField;
    @FXML private TextField bookPriceTextField;
    @FXML private ComboBox<String> bookCategoryComboBox;
    @FXML private ComboBox<String> bookConditionComboBox;
    @FXML private ImageView bookImageView;
    @FXML private TextArea listingDescriptionTextArea;

    public SellPageController(ControllerManager manager, ApplicationModel model) {
        this.model = model;
        this.manager = manager;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sell-page.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try
        {
            fxmlLoader.load();
        } catch (IOException exception)
        {
            throw new RuntimeException(exception);
        }

        initSceneBuilderElements();
    }

    private void initSceneBuilderElements() {
        /* add categories to all combo-boxes in the sell page */
        bookCategoryComboBox.getItems().addAll(
                "Mathematics","Physics","Biology","Chemistry","Programming","Fiction" );
        bookConditionComboBox.getItems().addAll("New","Mint","Used","Damaged");
    }

    @FXML
    protected void onClickGoToShopPage(Event event){
        manager.goToShopPage();
    }

    @FXML
    protected void onClickGoToAccountPage(Event event){
        manager.goToAccountPage();
    }
}
