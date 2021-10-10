package com.cbm.tda367;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;
/**
 * Visual representation of a book in our View/Controller in MVC.
 *
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 1.0
 * @since 1.0
 */
public class BookViewController extends AnchorPane {

    private Book book;
    private ControllerManager manager;

    @FXML private ImageView bookImageView;

    public BookViewController(ControllerManager manager, Book book) {

        FXMLLoader shopPageBook = new FXMLLoader(getClass().getResource("shop-page-book.fxml"));
        shopPageBook.setRoot(this);
        shopPageBook.setController(this);


        try {
            shopPageBook.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        this.manager = manager;
        this.book = book;
        bookImageView.setImage(new Image(getClass().getResourceAsStream(book.getImagePath())));
    }

    /**
     * Opens the detailed view of this book, unveiling more information and the book's listings.
     * @param event Click Event.
     */
    @FXML
    protected void onClickOpenDetailedView(Event event){
        manager.openBookDetailView(book);
    }
}
