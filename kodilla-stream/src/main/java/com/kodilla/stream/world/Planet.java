package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public final class Planet {
    private final List<World> planets = new LinkedList<>();

    public void addWorld(World world) {
        planets.add(world);
    }

    public BigDecimal getAliensQuantity() {
        return planets.stream()
                .flatMap(world -> world.getContinents().stream())
                .flatMap(continent -> continent.getCountries().stream())
                .map(country -> country.getPeopleQuantity())
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
    }
}
