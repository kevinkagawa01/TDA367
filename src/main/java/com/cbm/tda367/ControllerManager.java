package com.cbm.tda367;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
    private final LoginPageViewController loginPage = new LoginPageViewController(this, model);
    private final ShopPageViewController shopPage = new ShopPageViewController(this, model);
    private final SellPageViewController sellPage = new SellPageViewController(this, model);
    private final AccountPageController accountPage = new AccountPageController(this, model);

    private final List<Observer> mainPages = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /* Adding observers locally */
        mainPages.add(sellPage);
        mainPages.add(accountPage);
        mainPages.add(shopPage);
        mainPages.add(loginPage);

        mainAnchorPane.getChildren().add(sellPage);
        mainAnchorPane.getChildren().add(accountPage);
        mainAnchorPane.getChildren().add(shopPage);
        mainAnchorPane.getChildren().add(loginPage);
    }

    /**
     * this method will update the model
     */

    @Override
    public void update() {
        for (Observer mainPageObserver : mainPages){
            mainPageObserver.update();
        }
    }

    protected void openPublishedListingsAccordionInAccountPage(){
        accountPage.openPublishedListingsAccordion();
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
