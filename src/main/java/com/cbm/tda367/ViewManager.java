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
    private final LoginPageView loginPage = new LoginPageView(this);
    private final ShopPageView shopPage = new ShopPageView(this);
    private final SellPageView sellPage = new SellPageView(this);
    private final AccountPageView accountPage = new AccountPageView(this);
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

    void setLoginPageController(LoginPageController controller){
        loginPage.setFxmlLoaderController(controller);
    }

    void setShopPageController(ShopPageController controller){
        shopPage.setFxmlLoaderController(controller);
    }

    void setSellPageController(SellPageController controller) {
        sellPage.setFxmlLoaderController(controller);
    }

    void setAccountPageController(AccountPageController controller) {
        accountPage.setFxmlLoaderController(controller);
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
