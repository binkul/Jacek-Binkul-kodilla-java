package com.kodilla.good.patterns.orders.repository;

import com.kodilla.good.patterns.orders.User;

import java.time.LocalDate;
import java.util.Random;

public class MSSqlService implements OrderRepositoryService {

    @Override
    public long createOrder(User user, String product, LocalDate localDate) {
        Random random = new Random();

        System.out.format("The order for %s was successfully added ot DataBase.\n", user.toString());
        return random.nextInt(1000);
    }
}
