package com.cbm.tda367;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Flow;

public class ShopPageController extends AnchorPane {

    private ControllerManager manager;
    private ApplicationModel model;
    private FXMLLoader fxmlLoader;

    @FXML
    private FlowPane popularBookscategory;
    @FXML
    private FlowPane mostSubscribedBooks;


    public ShopPageController(ControllerManager manager, ApplicationModel model) {
        this.manager = manager;
        this.model = model;


        fxmlLoader = new FXMLLoader(getClass().getResource("shop-page.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try{
            fxmlLoader.load();
        } catch (IOException exception){
            throw new RuntimeException(exception);
        }
    }

    public void updatePopularCategoryPane(){
        List<Book> items = BookDatabase.getInstance().getBookList();
        popularBookscategory.getChildren().clear();
        for (Book book:
                items) {
           // popularBooks.getChildren().add();
        }

    }
    public void updateSubscribedCategoryPane(){
        List<Book> items = BookDatabase.getInstance().getBookList();
        mostSubscribedBooks.getChildren().clear();
        for (Book book:
                items) {
            // mostSubscribedBooks.getChildren().add();
        }

    }

    @FXML
    public void accountButton(Event event) {
        manager.goToAccountPage();
    }

    @FXML
    public void addButton(Event event) {
        manager.goToSellPage();
    }
}
