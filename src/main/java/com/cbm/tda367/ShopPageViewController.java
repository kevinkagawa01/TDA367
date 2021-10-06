package com.cbm.tda367;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

import java.io.IOException;
import java.util.List;
/*

 */


/** A visual representation of the Shop page
 *
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 1.0
 * @since 1.0
 * */
public class ShopPageViewController extends AnchorPane implements Observer{

    private final ControllerManager manager;
    private final ApplicationModel model;

    @FXML private FlowPane allBooksFlowPane;
    @FXML private FlowPane mostSubscribedBooksFlowPane;

    public ShopPageViewController(ControllerManager manager, ApplicationModel model) {
        this.manager = manager;
        this.model = model;


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("shop-page.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try{
            fxmlLoader.load();
        } catch (IOException exception){
            throw new RuntimeException(exception);
        }
    }

    /** Updates the list of all books
     */
    public void updateAllBooksFlowPane(){
        List<Book> bookList = BookDatabase.getInstance().getBookList();

        /* Clear all children */
        allBooksFlowPane.getChildren().clear();

        for (Book book : bookList) {
            BookViewController bookViewController = new BookViewController(book);
            allBooksFlowPane.getChildren().add(bookViewController);
        }

    }

    /** Updates the list of books under mostSubscribed category
     *
     */
    public void updateMostSubscribedBooksFlowPane(){
        List<Book> items = BookDatabase.getInstance().getBookList();
        mostSubscribedBooksFlowPane.getChildren().clear();
        for (Book book:
                items) {
            // mostSubscribedBooks.getChildren().add();
        }

    }

    /** On-click method that navigates the application to the accountPage
     *
     * @param event
     */
    @FXML
    public void accountButton(Event event) {
        manager.goToAccountPage();
    }


    /** On-click method that navigates the application to the sellPage
     *
     * @param event
     */
    @FXML
    public void addButton(Event event) {
        manager.goToSellPage();
    }

    /** Method implemented from Observer interface.
     *
     */
    @Override
    public void update() {
        updateAllBooksFlowPane();
    }
}
