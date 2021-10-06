package com.cbm.tda367;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Represents the database of Books
 *
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 1.0
 * @since 1.0
 */

public class ControllerManager implements Initializable,Observer {

    @FXML
    private AnchorPane mainAnchorPane;

    /* model */
    ApplicationModel model = ApplicationModel.getInstance();
    /* application pages */
    private LoginPageViewController loginPage = new LoginPageViewController(this, model);
    private ShopPageViewController shopPage = new ShopPageViewController(this, model);
    private SellPageViewController sellPage = new SellPageViewController(this, model);
    private AccountPageController accountPage = new AccountPageController(this, model);
    private BookDetailViewController subPage=new BookDetailViewController(this,model);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mainAnchorPane.getChildren().add(sellPage);
        mainAnchorPane.getChildren().add(accountPage);
        mainAnchorPane.getChildren().add(shopPage);
        mainAnchorPane.getChildren().add(loginPage);
    }

    /**
     * this method will update modelen
     */

    @Override
    public void update() {
        //TODO: what should views update when model is updated?
    }


    /**
     * Navigate to ShopPage
     */
    void goToShopPage(){
        shopPage.toFront();
    }

    /**
     * Navigate to SellPage
     */
    void goToSellPage(){
        sellPage.toFront();
    }


    /**
     * Navigate to AccountPage
     */
    void goToAccountPage(){
        accountPage.toFront();
    }

}
