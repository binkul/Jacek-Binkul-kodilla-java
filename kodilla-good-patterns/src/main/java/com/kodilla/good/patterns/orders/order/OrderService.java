package com.kodilla.good.patterns.orders.order;

import com.kodilla.good.patterns.orders.User;

import java.time.LocalDate;

public interface OrderService {
    boolean order(final User user, final String article, final LocalDate localDate);
}
