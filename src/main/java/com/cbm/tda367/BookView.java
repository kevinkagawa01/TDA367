package com.cbm.tda367;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.List;

public class BookView {

    private Book book;
    @FXML private ImageView bookView;

    public BookView(Book book) {

        FXMLLoader shopPageBook = new FXMLLoader(getClass().getResource("shop-page-book.fxml"));
        shopPageBook.setRoot(this);
        shopPageBook.setController(this);

        try{
            shopPageBook.load();
        } catch (IOException exception){
            throw new RuntimeException(exception);
        }

        bookView.setImage(new Image(getClass().getClassLoader().getResourceAsStream(book.getImagePath())));
    }


}
