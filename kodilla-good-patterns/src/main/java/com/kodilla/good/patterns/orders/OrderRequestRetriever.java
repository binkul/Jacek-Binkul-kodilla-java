package com.kodilla.good.patterns.orders;

import java.time.LocalDate;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {
        User user = new User("Jacek", "Binkul");
        LocalDate orderDate = LocalDate.now();
        String product = "Bicycle";

        return new OrderRequest(user, orderDate, product);
    }
}
