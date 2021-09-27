package com.cbm.tda367;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ViewManager implements Initializable,Observer {

    @FXML
    private AnchorPane mainAnchorPane;

    /* views */
    private final LoginPageView loginPage = new LoginPageView();
    private final ShopPageView shopPage = new ShopPageView(this);
    private final SellPageView sellPage = new SellPageView();
    private final AccountPageView accountPage = new AccountPageView();
    /* list of views */
    private final List<Node> viewList = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        viewList.add(accountPage);
        viewList.add(sellPage);
        viewList.add(loginPage);
        viewList.add(shopPage);

        for (Node view : viewList){
            mainAnchorPane.getChildren().add(view);
        }
    }

    @Override
    public void update() {
        //TODO: what should views update when model is updated?
    }

    void setShopPageController(Object controller){
        shopPage.setFxmlLoaderController(controller);
    }

    void goToShopPage(){
        mainAnchorPane.getChildren().get(viewList.indexOf(shopPage)).toFront();
    }

    void goToSellPage(){
        mainAnchorPane.getChildren().get(viewList.indexOf(sellPage)).toFront();
    }

    void goToAccountPage(){
        mainAnchorPane.getChildren().get(viewList.indexOf(accountPage)).toFront();
    }
}
