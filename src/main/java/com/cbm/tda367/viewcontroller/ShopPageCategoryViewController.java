package com.cbm.tda367.viewcontroller;

import com.cbm.tda367.model.Book;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.List;

/** Visual representation of a category in the shop page and defines its controllers
 *
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 1.0
 * @since 1.0
 * */
public class ShopPageCategoryViewController extends AnchorPane {

    private final ControllerManager manager;

    @FXML private Text shopPageCategoryTitle;
    @FXML private FlowPane shopPageCategoryFlowPane;

    public ShopPageCategoryViewController(ControllerManager manager,String shopPageCategoryTitle) {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/cbm/tda367/shop-page-category.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);

        try { fxmlLoader.load(); }
        catch (IOException exception) { throw new RuntimeException(exception); }

        this.manager = manager;
        this.shopPageCategoryTitle.setText(shopPageCategoryTitle);
    }

    protected void populateCategoryWithBooks(List<Book> books){
        shopPageCategoryFlowPane.getChildren().clear();
        for (Book book : books){
            BookViewController bookViewController = new BookViewController(manager,book);
            shopPageCategoryFlowPane.getChildren().add(bookViewController);
        }
    }
}
