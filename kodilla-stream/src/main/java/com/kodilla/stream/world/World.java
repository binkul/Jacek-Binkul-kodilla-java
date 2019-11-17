package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public final class World {
    private final List<Continent> continents = new LinkedList<>();
    private final String name;

    public World(final String name) {
        this.name = name;
    }

    public void addContinent(Continent continent) {
        continents.add(continent);
    }

    public List<Continent> getContinents() {
        return new LinkedList<>(continents);
    }

    public BigDecimal getPeopleQuantity() {
        return continents.stream()
                .flatMap(continent -> continent.getCountries().stream())
                .map(country -> country.getPeopleQuantity())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public int getCountryCount() {
        return continents.stream()
                .map(country -> country.getCountriesCount())
                .reduce(0, (sum, current) -> sum += current);
    }
}
