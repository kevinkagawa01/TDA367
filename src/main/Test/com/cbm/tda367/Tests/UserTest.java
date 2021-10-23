package com.cbm.tda367.Tests;

import com.cbm.tda367.model.ApplicationModel;
import com.cbm.tda367.model.SubscribeNotification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    ApplicationModel model;


    @BeforeEach
    public void testSetUp() {
        model = ApplicationModel.getInstance();
    }

    @Test
    void getCorrectNrOfSubscribeNotificationsWithNoSubscriptions(){
        model.isLoginSuccessful("1","1");
        List<SubscribeNotification> subscribeNotifications = model.getCurrentlyLoggedInUser().getSubscribeNotifications();
        assertEquals(subscribeNotifications.size(),0);
    }

    @Test
    void getCorrectNrOfSubscribeNotificationsWithOneSubscription(){
        model.isLoginSuccessful("1","1");
        model.addBookToSubscriptionList("TMA660");
        List<SubscribeNotification> subscribeNotificationsBefore = model.getCurrentlyLoggedInUser().getSubscribeNotifications();
        model.addListing("TMA660","Mint","100","Hello");
        List<SubscribeNotification> subscribeNotificationsAfter = model.getCurrentlyLoggedInUser().getSubscribeNotifications();
        assertEquals(subscribeNotificationsBefore.size(), subscribeNotificationsAfter.size() - 1);
    }
}
