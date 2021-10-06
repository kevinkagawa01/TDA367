package com.cbm.tda367;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class BookViewController extends AnchorPane {

    private Book book;
    @FXML private ImageView bookImageView;

    public BookViewController(Book book) {

        FXMLLoader shopPageBook = new FXMLLoader(getClass().getResource("shop-page-book.fxml"));
        shopPageBook.setRoot(this);
        shopPageBook.setController(this);

        bookImageView.setImage(new Image(getClass().getClassLoader().getResourceAsStream(book.getImagePath())));

        try {
            shopPageBook.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

    }


}
