package com.kodilla.good.patterns.orders.repository;

import com.kodilla.good.patterns.orders.User;

import java.time.LocalDate;

public interface OrderRepositoryService {
    long createOrder(User user, String product, LocalDate localDate);
}
