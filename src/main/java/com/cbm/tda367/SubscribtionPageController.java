package com.cbm.tda367;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.List;


public class SubscribtionPageController extends AnchorPane {

    private final FXMLLoader fxmlLoader;
    private ApplicationModel model;
    private ControllerManager manager;
    private Book book;
    boolean subscribePressed = true;


    @FXML
    private ImageView bookFront;
    private Text textFront;
    private Rectangle greenButton;
    private FlowPane bookPane;


    public SubscribtionPageController(ControllerManager manager, ApplicationModel model) {
        this.model = model;
        this.manager = manager;

        fxmlLoader = new FXMLLoader(getClass().getResource("shop-page-subscription.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        //bookFront.setImage(book.getImage());
        textFront.setText(book.getBookName());


    }

    public void subscribeButtonPressed() {
        //Om false,greenButton.setFill() till röd
        //annars till grön

    }

    public void updateSubscribedCategoryPane() {
        List<Book> items = BookDatabase.getInstance().getBookList();
        //getBookCode osv
        bookPane.getChildren().clear();
        for (Book book :
                items) {
            // bookPane.getChildren().add();
        }

    }


    @FXML
    public void accountButton(Event event) {
        manager.goToAccountPage();
    }

    @FXML
    public void shopButton(Event event) {
        manager.goToShopPage();
    }

    @FXML
    public void addButton(Event event) {
        manager.goToSellPage();
    }


}
