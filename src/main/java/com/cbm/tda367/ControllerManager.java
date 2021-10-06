package com.cbm.tda367;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

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
    private final BookDetailViewController bookDetailPage = new BookDetailViewController(this,model);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mainAnchorPane.getChildren().add(sellPage);
        mainAnchorPane.getChildren().add(accountPage);
        mainAnchorPane.getChildren().add(shopPage);
        mainAnchorPane.getChildren().add(loginPage);
    }

    @Override
    public void update() {
        //TODO: what should views update when model is updated?

    }

    protected void openPublishedListingsAccordionInAccountPage(){
        accountPage.openPublishedListingsAccordion();
    }

    void goToShopPage(){
        shopPage.toFront();
    }

    void goToSellPage(){
        sellPage.toFront();
    }

    void goToAccountPage(){
        accountPage.toFront();
    }

}
