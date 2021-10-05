package com.cbm.tda367;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.List;

/**
 * Visual representation of a book in our View/Controller in MVC.
 *
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 1.0
 * @since 1.0
 */
public class BookDetailViewController extends AnchorPane {
    private ApplicationModel model;
    private ControllerManager manager;
    private Book book;
    private boolean subscribePressed = true;

    @FXML
    private ImageView bookFront;
    @FXML
    private Text textFront;
    @FXML
    private Rectangle greenButton;
    @FXML
    private FlowPane bookPane;

    /**
     * Creates a detail view of a book.
     *
     * @param manager This controller manager.
     * @param model   Singleton of application model.
     */
    public BookDetailViewController(ControllerManager manager, ApplicationModel model) {
        this.model = model;
        this.manager = manager;
        this.book = book;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("shop-page-subscription.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        //bookFront.setImage(book.getImage());
        //textFront.setText(book.getBookName());


    }

    /**
     * On click method, subscribing/unsubscribing this to a book.
     *
     * @param event Click event.
     */
    @FXML
    public void onClickSubscribeToBook(Event event) {
        //Om false,greenButton.setFill() till röd
        //annars till grön

    }

    /**
     * Updates current user's list of subscribed books in shop page.
     */
    public void updateSubscribedCategoryPane() {
        List<Book> items = BookDatabase.getInstance().getBookList();
        //getBookCode osv
        bookPane.getChildren().clear();
        for (Book book :
                items) {
            // bookPane.getChildren().add();
        }

    }

    /**
     * On click method, directing the user to the account page.
     *
     * @param event Click event.
     */
    @FXML
    public void onClickGoToAccountPage(Event event) {
        manager.goToAccountPage();
    }

    /**
     * On click method, directing the user to the shop page.
     *
     * @param event Click event.
     */
    @FXML
    public void onClickGoToShopPage(Event event) {
        manager.goToShopPage();
    }

    /**
     * On click method, directing the user to the sell page.
     *
     * @param event Click event.
     */
    @FXML
    public void onClickGoToSellPage(Event event) {
        manager.goToSellPage();
    }


}
