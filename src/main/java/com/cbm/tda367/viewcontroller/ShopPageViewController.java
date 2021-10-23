package com.cbm.tda367.viewcontroller;

import com.cbm.tda367.model.ApplicationModel;
import com.cbm.tda367.model.Book;
import com.cbm.tda367.model.Observer;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/*

 */


/**
 * A visual representation of the Shop page
 *
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 1.0
 * @since 1.0
 */
public class ShopPageViewController extends AnchorPane implements Observer {

    private final ControllerManager manager;
    private final ApplicationModel model = ApplicationModel.getInstance();

    private final ShopPageCategoryViewController allBooksCategory;
    private final ShopPageCategoryViewController mostSubscribedBooksCategory;
    private final List<ShopPageCategoryViewController> categories = new ArrayList<>();

    @FXML
    private TextField searchBarTextField;
    @FXML
    private Text noSearchResultsFoundText;
    @FXML
    private FlowPane categoriesFlowPane;

    /**
     * class constructor
     *
     * @param manager controller manager
     */
    public ShopPageViewController(ControllerManager manager) {
        this.manager = manager;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/cbm/tda367/shop-page.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        searchBarTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            updateSearchBarResults();
        });

        /* create shop page categories */
        allBooksCategory = new ShopPageCategoryViewController(manager, "All Books");
        mostSubscribedBooksCategory = new ShopPageCategoryViewController(manager, "Most Subscribed Books");
        /* add categories to list */
        categories.add(allBooksCategory);
        categories.add(mostSubscribedBooksCategory);
        /* add them to flow pane */
        populateWithCategories();
        /* add books to the categories */
        populateAllBooksCategoryFlowPane();
        populateMostSubscribedBooksCategoryFlowPane();
    }

    /**
     * Populates the categories flow pane.
     */
    private void populateWithCategories() {
        /* clear flow pane */
        categoriesFlowPane.getChildren().clear();
        /* add categories */
        for (ShopPageCategoryViewController category : categories) {
            categoriesFlowPane.getChildren().add(category);
        }
    }

    /**
     * Populates the 'All Books' category flow pane.
     */
    private void populateAllBooksCategoryFlowPane() {
        allBooksCategory.populateCategoryWithBooks(model.getAllBooks());
    }

    private void populateMostSubscribedBooksCategoryFlowPane() {
        mostSubscribedBooksCategory.populateCategoryWithBooks(model.getMostSubscribedBooks());
    }

    /**
     * On-click method that navigates the application to the accountPage.
     *
     * @param event Click Event.
     */
    @FXML
    public void accountButton(Event event) {
        manager.goToAccountPage();
    }


    /**
     * On-click method that navigates the application to the sellPage.
     *
     * @param event Click Event.
     */
    @FXML
    public void addButton(Event event) {
        manager.goToSellPage();
    }

    /**
     * Method implemented from Observer interface.
     */
    @Override
    public void update() {
        populateAllBooksCategoryFlowPane();
        populateMostSubscribedBooksCategoryFlowPane();
    }

    /**
     * Updates view of search results
     */
    public void updateSearchBarResults() {
        /* if search-bar is empty -> show categories */
        if (searchBarTextField.getText().isEmpty()) {
            noSearchResultsFoundText.toBack();
            populateWithCategories();
            return;
        }
        /* update pane with relevant search results */
        categoriesFlowPane.getChildren().clear();
        List<Book> relevantBooks = model.filterBooksByName(searchBarTextField.getText());
        if (relevantBooks.isEmpty()) {
            noSearchResultsFoundText.toFront();
        } else {
            noSearchResultsFoundText.toBack();
            for (Book book : relevantBooks) {
                BookViewController bookViewController = new BookViewController(manager, book);
                categoriesFlowPane.getChildren().add(bookViewController);
            }
        }
    }
}
