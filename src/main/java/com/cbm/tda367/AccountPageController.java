package com.cbm.tda367;

import javafx.fxml.FXMLLoader;

public class AccountPageController implements GolbalMenu {

    public AccountPageController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("account-page.fxml"));
        fxmlLoader.setController(this);
    }

    @Override
    public void shopButton() {

    }

    @Override
    public void accountButton() {

    }

    @Override
    public void addButton() {

    }
}
