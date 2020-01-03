package com.kodilla.good.patterns.food.information;

import com.kodilla.good.patterns.food.supplier.Supplier;

public class MailService implements InformationService {

    @Override
    public void inform(Supplier supplier) {
        System.out.println("Mail about the order was sent to " + supplier.toString() + " company");
    }
}
