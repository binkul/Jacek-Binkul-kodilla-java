package com.kodilla.good.patterns.orders.information;

import com.kodilla.good.patterns.orders.User;

public class SmsService implements InformationService {

    @Override
    public void inform(User user) {
        System.out.println("SMS about the order was sent to " + user.toString());
    }
}
