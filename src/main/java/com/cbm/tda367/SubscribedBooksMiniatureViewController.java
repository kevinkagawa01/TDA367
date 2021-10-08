package com.cbm.tda367;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.Date;
import java.util.spi.LocaleServiceProvider;

/**
 * Visual representation of a miniature view
 * under the category SubscribedBooks on the account page
 *
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 1.0
 * @since 1.0
 */
public class SubscribedBooksMiniatureViewController  {

    private ControllerManager manager;
    private Application model;
    private AccountPageController accountPageController;
    private Book book;
    @FXML
    Text dateSubscribedMiniature;
    @FXML
    Text titleSubscriebdMiniature;
    @FXML
    Rectangle unsubscribedMiniature;


    public SubscribedBooksMiniatureViewController(ControllerManager manager,Book book) {
        this.book=book;
        this.manager = manager;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SubscribedBooks.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        Date date = new Date();

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        dateSubscribedMiniature.setText(Integer.toString(date.getDate()));
        titleSubscriebdMiniature.setText(book.getBookName());

    }
 /*   public void setUnsubscribedMiniature(){
       accountPageController.removeSubscribedBook();
    }
*/
}
