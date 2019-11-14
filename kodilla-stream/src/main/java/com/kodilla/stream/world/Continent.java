package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public final class Continent {
    private final List<Country> countries = new ArrayList<>();
    private final String name;

    public Continent(final String name) {
        this.name = name;
    }

    public void addCountry(Country country) {
        countries.add(country);
    }

    public List<Country> getCountries() {
        return new ArrayList<>(this.countries);
    }

    public String getName() {
        return name;
    }

    public int getCountriesCount() {
        return countries.size();
    }
}
