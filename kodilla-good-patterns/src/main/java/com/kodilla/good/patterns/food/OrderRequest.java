package com.kodilla.good.patterns.food;

import java.time.LocalDate;
import java.util.Objects;

public class OrderRequest {
    private final long id;
    private final LocalDate orderDate;
    private final String product;
    private final int amount;

    public OrderRequest(long id, LocalDate orderDate, String product, int amount) {
        this.id = id;
        this.orderDate = orderDate;
        this.product = product;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public String getProduct() {
        return product;
    }

    int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", product='" + product + '\'' +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof OrderRequest)) return false;
        OrderRequest that = (OrderRequest) o;
        return id == that.id &&
                amount == that.amount &&
                Objects.equals(orderDate, that.orderDate) &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderDate, product, amount);
    }
}
