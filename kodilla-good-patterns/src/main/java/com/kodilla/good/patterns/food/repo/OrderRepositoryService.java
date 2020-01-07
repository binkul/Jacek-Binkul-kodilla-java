package com.kodilla.good.patterns.food.repo;

import com.kodilla.good.patterns.food.supplier.Supplier;

import java.time.LocalDate;

public interface OrderRepositoryService {
    long createOrder(Supplier supplier, String product, LocalDate localDate);
}
