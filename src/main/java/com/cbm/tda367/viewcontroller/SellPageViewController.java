package com.cbm.tda367.viewcontroller;

import com.cbm.tda367.model.ApplicationModel;
import com.cbm.tda367.model.Listing;
import com.cbm.tda367.model.Observer;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.io.IOException;

/**
 * Visual representation of the Sell page and defines its controllers
 *
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 1.0
 * @since 1.0
 */
public class SellPageViewController extends AnchorPane implements Observer {

    private final ControllerManager manager;
    private final ApplicationModel model = ApplicationModel.getInstance();
    private int editingListingNumber = -1;

    /* FXML elements */
    @FXML
    private TextField bookCodeTextField;
    @FXML
    private TextField bookPriceTextField;
    @FXML
    private ComboBox<String> bookConditionComboBox;
    @FXML
    private ImageView bookImageView;
    @FXML
    private TextArea listingDescriptionTextArea;

    /* prominent done buttons */
    @FXML
    private Text publishText,
            saveText;
    @FXML
    private Rectangle publishRectangle,
            saveRectangle;

    /**
     * Creates the sell page view
     *
     * @param manager This controller manager
     */
    public SellPageViewController(ControllerManager manager) {
        this.manager = manager;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/cbm/tda367/sell-page.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        initSceneBuilderElements();
    }

    /**
     * add categories to all combo-boxes in the sell page
     */
    private void initSceneBuilderElements() {
        bookConditionComboBox.getItems().addAll("Book Condition", "New", "Mint", "Used", "Damaged");
        bookConditionComboBox.getSelectionModel().selectFirst();

        bookCodeTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            updateBookCode(newValue, oldValue);
        });

        bookPriceTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            updateBookPrice(newValue, oldValue);
        });
    }

    /**
     * Attempts to update the bookCodeTextField if the new value meets all requirements.
     *
     * @param newValue new textField value.
     * @param oldValue old textField value.
     */
    private void updateBookCode(String newValue, String oldValue) {
        if (isOnlyLettersAndHyphensAndDigits(newValue)) {
            bookCodeTextField.setText(newValue);
        } else {
            bookCodeTextField.setText(oldValue);
            System.out.println("Invalid Character!");
        }
    }

    /**
     * Attempts to update the bookPriceTextField if the new value meets all requirements.
     *
     * @param newValue new textField value.
     * @param oldValue old textField value.
     */
    private void updateBookPrice(String newValue, String oldValue) {
        if (isOnlyDigits(newValue)) {
            bookPriceTextField.setText(newValue);
        } else {
            bookPriceTextField.setText(oldValue);
            System.out.println("Invalid Character!");
        }
    }

    /**
     * Determines if parameter String is only containing: letters, hyphens and digits.
     *
     * @param string String to be determined whether it only contains: letters, hyphens and digits or not.
     * @return boolean if the parameter String only contains letters, hyphens and digits.
     */
    private boolean isOnlyLettersAndHyphensAndDigits(String string) {
        if (string == null) {
            return true;
        }

        for (int i = 0; i < string.length(); i++) {
            if (!Character.isLetter(string.charAt(i)) && string.charAt(i) != '-'
                    && !Character.isDigit(string.charAt(i))) {
                return false;
            }
        }
        return true;
    }


    /**
     * Determines if parameter String is only containing digits.
     *
     * @param string String to be determined whether it only contains digits or not.
     * @return boolean if the parameter String only contains digits.
     */
    private boolean isOnlyDigits(String string) {
        if (string == null) {
            return true;
        }

        for (int i = 0; i < string.length(); i++) {
            if (!Character.isDigit(string.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * On-click method that navigates the application to the ShopPage
     *
     * @param event
     */
    @FXML
    protected void onClickGoToShopPage(Event event) {
        resetTextFields();
        publishButtonToFront();
        manager.goToShopPage();
    }

    /**
     * On-click method that navigates the application to the AccountPage
     *
     * @param event
     */
    @FXML
    protected void onClickGoToAccountPage(Event event) {
        resetTextFields();
        publishButtonToFront();
        manager.goToAccountPage();
    }

    /**
     * A method that bakes all the inputs and creates a listing
     *
     * @param event
     */
    @FXML
    protected void onClickCreateListing(Event event) {

        //TODO: Should require a valid book code to switch page
        if (isListingCompleted()) {
            /* creating listing */
            model.addListing(bookCodeTextField.getText(), bookConditionComboBox.getSelectionModel().getSelectedItem(),
                    bookPriceTextField.getText(), listingDescriptionTextArea.getText());
            /* switch to account page */
            manager.goToAccountPage();
            /* clear all fields and reset sell page */
            resetTextFields();
            /* open accordion menu for my listings */
            manager.openPublishedListingsAccordionInAccountPage();
        }
    }

    @FXML
    protected void onClickSaveListing(Event event) {

        if (isListingCompleted()) {
            /* creating listing */
            model.editListing(bookCodeTextField.getText(), bookConditionComboBox.getSelectionModel().getSelectedItem(),
                    bookPriceTextField.getText(), listingDescriptionTextArea.getText(), editingListingNumber);
            /* switch to account page */
            manager.goToAccountPage();
            /* clear all fields and reset sell page */
            resetTextFields();
            /* hide edit button */
            publishButtonToFront();
            /* open accordion menu for my listings */
            manager.openPublishedListingsAccordionInAccountPage();
        }

    }

    private void publishButtonToFront() {
        publishRectangle.toFront();
        publishText.toFront();
    }

    private void resetTextFields() {
        bookCodeTextField.clear();
        bookPriceTextField.clear();
        listingDescriptionTextArea.clear();
        bookConditionComboBox.getSelectionModel().selectFirst();
    }

    /**
     * Checks if all fields are filled in
     *
     * @return true when filled in, else false
     */
    private boolean isListingCompleted() {
        if (bookCodeTextField.getText().isEmpty() ||
                bookPriceTextField.getText().isEmpty() ||
                listingDescriptionTextArea.getText().isEmpty() ||
                "Book Condition".equals(bookConditionComboBox.getSelectionModel().getSelectedItem())
        ) {
            System.out.println("Not all fields are filled in!");
            return false;
        }

        /* all fields are filled in, return true */
        System.out.println("Listing was created successfully");
        return true;
    }

    /**
     * Sets all fields for a specific listing, for listing editing purposes
     *
     * @param listing a specific listing
     */
    @FXML
    public void setAllFieldsFromListing(Listing listing) {
        bookCodeTextField.setText(listing.getBook().getBookCode());
        bookPriceTextField.setText(listing.getPrice());
        bookConditionComboBox.getSelectionModel().select(listing.getCondition());
        listingDescriptionTextArea.setText(listing.getListingDescription());
        editingListingNumber = listing.getListingNumber();

        saveButtonToFront();
    }

    private void saveButtonToFront() {
        saveRectangle.toFront();
        saveText.toFront();
    }


    /**
     * Updates this status.
     */
    @Override
    public void update() {
        // Is implemented for future functionality.
    }
}
