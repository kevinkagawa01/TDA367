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

/** Visual representation of the Sell page and defines it's controllers
 *
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 1.0
 * @since 1.0
 * */
public class SellPageViewController extends AnchorPane {

    private ControllerManager manager;
    private ApplicationModel model;

    /* FXML elements */
    @FXML private TextField bookCodeTextField;
    @FXML private TextField bookPriceTextField;
    @FXML private ComboBox<String> bookCategoryComboBox;
    @FXML private ComboBox<String> bookConditionComboBox;
    @FXML private ImageView bookImageView;
    @FXML private TextArea listingDescriptionTextArea;

    public SellPageViewController(ControllerManager manager, ApplicationModel model) {
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

    /** add categories to all combo-boxes in the sell page
     *
     */
    private void initSceneBuilderElements() {

        bookCategoryComboBox.getItems().addAll(
                "Mathematics","Physics","Biology","Chemistry","Programming","Fiction" );
        bookConditionComboBox.getItems().addAll("New","Mint","Used","Damaged");
    }

    /** On-click method that navigates the application to the ShopPage
     *
     * @param event
     */
    @FXML
    protected void onClickGoToShopPage(Event event){
        manager.goToShopPage();
    }

    /** On-click method that navigates the application to the AccountPage
     *
     * @param event
     */
    @FXML
    protected void onClickGoToAccountPage(Event event){
        manager.goToAccountPage();
    }

    /** A method that bakes all the inputs and creates a listing
     *
     * @param event
     */
    @FXML
    protected void onClickCreateListing(Event event){
        System.out.println("Vi har skapat en listing!");
        if (isListingCompleted()){
                //TODO: Hardcoded :)

                /* creating listing */
                model.addListing(bookCodeTextField.getText(),bookConditionComboBox.getPromptText(),
                        bookPriceTextField.getText());
                /* switch to account page */
                manager.goToAccountPage();
                /* open accordion menu for my listings */
                //TODO: add code to open correct tab in accordion
        }
    }

    /** Checks if all fields are filled in
     *
     * @return true when filled in, else false
     */
    private boolean isListingCompleted(){
        //TODO: is all fields filled in?
        return true;
    }
}
