package com.cbm.tda367;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;

public class AccountPageController implements GolbalMenu {

    /* view manager */
    private ViewManager manager;

    public AccountPageController(ViewManager manager) {

        this.manager = manager;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("account-page.fxml"));
        fxmlLoader.setController(this);
    }

    @Override
    public void shopButton(Event event) {

    }

    @Override
    public void accountButton(Event event) {

    }

    @Override
    public void addButton(Event event) {

    }
}
