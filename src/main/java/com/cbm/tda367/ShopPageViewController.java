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

    private final ShopPageCategoryViewController allBooksCategory;

    private final ShopPageCategoryViewController mostSubscribedBooksCategory;

    @FXML private FlowPane categoriesFlowPane;

    public ShopPageViewController(ControllerManager manager, ApplicationModel model) {
        this.manager = manager;
        this.model = model;

        /* Loads FXML */
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("shop-page.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try{
            fxmlLoader.load();
        } catch (IOException exception){
            throw new RuntimeException(exception);
        }

        /* create shop page categories */
        allBooksCategory = new ShopPageCategoryViewController("All Books");
        mostSubscribedBooksCategory = new ShopPageCategoryViewController("Most Subscribed Books");
        /* add them to flow pane */
        populateCategoriesFlowPane();
        /* add books to the categories */
        populateAllBooksCategoryFlowPane();
    }

    private void populateCategoriesFlowPane() {
        categoriesFlowPane.getChildren().add(allBooksCategory);
        categoriesFlowPane.getChildren().add(mostSubscribedBooksCategory);
    }

    private void populateAllBooksCategoryFlowPane() {
        allBooksCategory.populateCategoryWithBooks(BookDatabase.getInstance().getBookList());
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

    }
}
