package com.cbm.tda367;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Accordion;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccountPageController extends AnchorPane {

    private ControllerManager manager;
    private ApplicationModel model;
    private FXMLLoader fxmlLoader;

    @FXML
    Accordion publishedBooksAccordion;
    ScrollPane published;


    public AccountPageController(ControllerManager manager, ApplicationModel model) {
        this.model = model;
        this.manager = manager;

        fxmlLoader = new FXMLLoader(getClass().getResource("account-page.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try
        {
            fxmlLoader.load();
        } catch (IOException exception)
        {
            throw new RuntimeException(exception);
        }
    }
    //private static List<publishedBookItem>publishedBook=new ArrayList<>(); // lägger published bok i en lista


    public void setFxmlLoaderController(AccountPageController controller) {
        fxmlLoader.setController(controller);
    }




    /* onclick listeners*/
    @FXML
    public void shopButton(Event event) {
        manager.goToShopPage();
    }

    @FXML
    public void addButton(Event event) {
        manager.goToSellPage();
    }
}
