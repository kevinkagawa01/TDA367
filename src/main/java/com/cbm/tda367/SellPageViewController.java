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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/** Visual representation of the Sell page and defines it's controllers
 *
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 1.0
 * @since 1.0
 * */
public class SellPageViewController extends AnchorPane implements Observer{

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
                "Book Category","Mathematics","Physics","Biology","Chemistry","Programming","Fiction" );
        bookCategoryComboBox.getSelectionModel().selectFirst();
        bookConditionComboBox.getItems().addAll("Book Condition","New","Mint","Used","Damaged");
        bookConditionComboBox.getSelectionModel().selectFirst();

        bookCodeTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("bookCodeTextField changed from " + oldValue + " to " + newValue);
            informationEdited("bookCode",newValue, oldValue);
        });

        bookPriceTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("bookPriceTextField changed from " + oldValue + " to " + newValue);
            informationEdited("bookPrice",newValue, oldValue);
        });
    }

    private void informationEdited(String textField, String newValue, String oldValue){
        switch(textField){
            case "bookCode"     -> updateBookCode(newValue,oldValue);
            case "bookPrice"    -> updateBookPrice(newValue, oldValue);
        }
    }

    private void updateBookCode(String newValue, String oldValue) {
        if (isOnlyLettersAndHyphensAndDigits(newValue)) { bookCodeTextField.setText(newValue); }
        else {bookCodeTextField.setText(oldValue);}
    }

    private void updateBookPrice(String newValue, String oldValue) {
        if (isOnlyDigits(newValue)) { bookPriceTextField.setText(newValue); }
        else { bookPriceTextField.setText(oldValue); }
    }

    /** Determines if parameter String is only containing: letters, hyphens and digits.
     * @param string String to be determined whether it only contains: letters, hyphens and digits or not.
     * @return boolean if the parameter String only contains letters, hyphens and digits.
     * */
    private boolean isOnlyLettersAndHyphensAndDigits(String string)
    {
        if (string == null) { return true;}

        for (int i = 0; i < string.length(); i ++)
        {
            if (!Character.isLetter(string.charAt(i)) && (string.charAt(i) != '-')
                    && (!Character.isDigit(string.charAt(i))))
            {
                return false;
            }
        }
        return true;
    }


    /** Determines if parameter String is only containing digits.
     * @param string String to be determined whether it only contains digits or not.
     * @return boolean if the parameter String only contains digits.
     * */
    private boolean isOnlyDigits(String string)
    {
        if (string == null) { return  true;}

        for (int i = 0; i < string.length(); i++)
        {
            if(!Character.isDigit(string.charAt(i)))
            {
                return false;
            }
        }
        return true;
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

        if (isListingCompleted()){
            /* creating listing */
              model.addListing(bookCodeTextField.getText(),bookConditionComboBox.getSelectionModel().getSelectedItem(),
                    bookPriceTextField.getText());

            /* switch to account page */
            manager.goToAccountPage();

            /* open accordion menu for my listings */
            manager.openPublishedListingsAccordionInAccountPage();

            /* add created listing to the publishedBook listing*/


        }

    }

    /** Checks if all fields are filled in
     *
     * @return true when filled in, else false
     */
    private boolean isListingCompleted(){
        if( bookCodeTextField.getText().isEmpty()           ||
            bookPriceTextField.getText().isEmpty()          ||
            listingDescriptionTextArea.getText().isEmpty()  ||
            bookCategoryComboBox.getSelectionModel().getSelectedItem().equals("Book Category") ||
            bookConditionComboBox.getSelectionModel().getSelectedItem().equals("Book Condition")
            ){
            System.out.println("Not all fields are filled in!");
            return false;
        }

        /* all fields are filled in, return true */
        System.out.println("Listing was created successfully");
        return true;
    }

    @Override
    public void update() {

    }
}
