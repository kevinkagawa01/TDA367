package com.cbm.tda367;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerManager implements Initializable,Observer {

    @FXML
    private AnchorPane mainAnchorPane;

    /* model */
    ApplicationModel model = ApplicationModel.getInstance();
    /* application pages */
    private LoginPageController loginPage = new LoginPageController(this, model);
    private ShopPageController shopPage = new ShopPageController(this, model);
    private SellPageController sellPage = new SellPageController(this, model);
    private AccountPageController accountPage = new AccountPageController(this, model);
    /* list of pages */
    private final List<Node> controllerList = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        controllerList.add(shopPage);
        controllerList.add(sellPage);
        controllerList.add(accountPage);
        controllerList.add(loginPage);

        for (Node view : controllerList){
            mainAnchorPane.getChildren().add(view);
        }
    }

    @Override
    public void update() {
        //TODO: what should views update when model is updated?
    }

    void goToShopPage(){
        mainAnchorPane.getChildren().get(controllerList.indexOf(shopPage)).toFront();
    }

    void goToSellPage(){
        mainAnchorPane.getChildren().get(controllerList.indexOf(sellPage)).toFront();
    }

    void goToAccountPage(){
        mainAnchorPane.getChildren().get(controllerList.indexOf(accountPage)).toFront();
    }

}
