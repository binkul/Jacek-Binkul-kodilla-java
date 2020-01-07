package com.kodilla.good.patterns.food.repo;

import com.kodilla.good.patterns.food.supplier.Supplier;

import java.time.LocalDate;

public class MsSqlService implements OrderRepositoryService{

    @Override
    public long createOrder(Supplier supplier, String product, LocalDate localDate) {
        System.out.format("The order for %s company was successfully added to database. \n", supplier.toString());
        return 1;
    }
}
