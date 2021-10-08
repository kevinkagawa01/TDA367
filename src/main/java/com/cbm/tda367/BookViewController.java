package com.cbm.tda367;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;

public class BookViewController extends AnchorPane {

    private Book book;
    @FXML private ImageView bookImageView;

    public BookViewController(Book book) {

        FXMLLoader shopPageBook = new FXMLLoader(getClass().getResource("shop-page-book.fxml"));
        shopPageBook.setRoot(this);
        shopPageBook.setController(this);


        try {
            shopPageBook.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        this.book = book;
        bookImageView.setImage(new Image(getClass().getResourceAsStream(book.getImagePath())));
    }
    @FXML
    public void onClicktoListingView(){

    }


}
