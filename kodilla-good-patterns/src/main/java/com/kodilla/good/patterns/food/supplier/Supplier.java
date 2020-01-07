package com.kodilla.good.patterns.food.supplier;

import java.util.Objects;

public class Supplier {
    private final String firsName;
    private final String secondName;
    private final String address;

    public Supplier(String firsName, String secondName, String address) {
        this.firsName = firsName;
        this.secondName = secondName;
        this.address = address;
    }

    public String getFullData() {
        return String.format("Supplier name: %s %s, address: %s", firsName, secondName, address);
    }

    @Override
    public String toString() {
        return String.format("%s %s", firsName, secondName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Supplier)) return false;
        Supplier supplier = (Supplier) o;
        return  Objects.equals(firsName, supplier.firsName) &&
                Objects.equals(secondName, supplier.secondName) &&
                Objects.equals(address, supplier.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firsName, secondName, address);
    }
}
