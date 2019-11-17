package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        return new ArrayList<>(countries);
    }

    public String getName() {
        return name;
    }

    public int getCountriesCount() {
        return countries.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Continent)) return false;
        Continent continent = (Continent) o;
        return Objects.equals(countries, continent.countries) &&
                Objects.equals(name, continent.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countries, name);
    }
}
