package com.kodilla.good.patterns.orders;

import java.time.LocalDate;
import java.util.Objects;

public class OrderRequest {
    private User user;
    private LocalDate orderDate;
    private String product;

    public OrderRequest(User user, LocalDate orderDate, String product) {
        this.user = user;
        this.orderDate = orderDate;
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public String getProduct() {
        return product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof OrderRequest)) return false;
        OrderRequest that = (OrderRequest) o;
        return Objects.equals(user, that.user) &&
                Objects.equals(orderDate, that.orderDate) &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, orderDate, product);
    }
}
