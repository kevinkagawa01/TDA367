package com.cbm.tda367;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.List;

public class ShopPageCategoryViewController extends AnchorPane {

    private ControllerManager manager;

    @FXML private Text shopPageCategoryTitle;
    @FXML private FlowPane shopPageCategoryFlowPane;

    public ShopPageCategoryViewController(ControllerManager manager,String shopPageCategoryTitle) {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("shop-page-category.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        this.manager = manager;

        this.shopPageCategoryTitle.setText(shopPageCategoryTitle);
    }

    public void populateCategoryWithBooks(List<Book> books){
        for (Book book : books){
            BookViewController bookViewController = new BookViewController(manager,book);
            shopPageCategoryFlowPane.getChildren().add(bookViewController);
        }
    }
}
