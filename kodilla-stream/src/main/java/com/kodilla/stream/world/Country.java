package com.kodilla.stream.world;

import java.math.BigDecimal;

public final class Country {
    private final BigDecimal peopleQuantity;
    private final String name;
    private final String capitalCity;

    public Country(final String name,  final String capitalCity, final long peopleQuantity) {
        this.peopleQuantity = new BigDecimal(peopleQuantity);
        this.name = name;
        this.capitalCity = capitalCity;
    }

    public BigDecimal getPeopleQuantity() {
        return peopleQuantity;
    }

    public String getName() {
        return name;
    }

    public String getCapitalCity() {
        return capitalCity;
    }
}
