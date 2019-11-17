package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.Objects;

public final class Country {
    private final BigDecimal peopleQuantity;
    private final String name;
    private final String capitalCity;

    public Country(final String name,  final String capitalCity, final BigDecimal peopleQuantity) {
        this.peopleQuantity = peopleQuantity;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Country)) return false;
        Country country = (Country) o;
        return Objects.equals(peopleQuantity, country.peopleQuantity) &&
                Objects.equals(name, country.name) &&
                Objects.equals(capitalCity, country.capitalCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(peopleQuantity, name, capitalCity);
    }
}
