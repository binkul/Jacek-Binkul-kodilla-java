package com.kodilla.good.patterns.food;

import java.time.LocalDate;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {
        LocalDate localDate = LocalDate.now();
        String product = "Eco radish";
        int amount = 60;

        return new OrderRequest(1, localDate, product, amount);
    }
}
