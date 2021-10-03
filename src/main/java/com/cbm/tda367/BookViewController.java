package com.cbm.tda367;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class BookViewController {

    private ControllerManager manager;
    private Book book;

    // FXML elements
    @FXML
    ImageView bookViewCategory;

    public BookViewController(Book book, ControllerManager manager) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("shop-page-book.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        this.book=book;
        this.manager=manager;

        bookViewCategory.setImage(book.getImage());
    }

    public void onClickBook(){
        //gå till subscriptionsidan
    }
}
