package com.kodilla.good.patterns.food;

import com.kodilla.good.patterns.food.supplier.Supplier;

import java.util.Objects;

public class OrderDto {
    private final long id;
    private final String name;
    private final boolean isOrdered;
    private final Supplier supplier;

    public OrderDto(long id, String name, boolean isOrdered, Supplier supplier) {
        this.id = id;
        this.name = name;
        this.isOrdered = isOrdered;
        this.supplier = supplier;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isOrdered() {
        return isOrdered;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isOrdered=" + isOrdered +
                ", supplier=" + supplier.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof OrderDto)) return false;
        OrderDto orderDto = (OrderDto) o;
        return id == orderDto.id &&
                isOrdered == orderDto.isOrdered &&
                Objects.equals(name, orderDto.name) &&
                Objects.equals(supplier, orderDto.supplier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, isOrdered, supplier);
    }
}
