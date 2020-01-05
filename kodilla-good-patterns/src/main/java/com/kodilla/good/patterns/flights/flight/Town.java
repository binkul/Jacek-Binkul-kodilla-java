package com.kodilla.good.patterns.flights.flight;

import java.util.stream.Stream;

public enum Town {
    BYDGOSZCZ("Bydgoszcz", FlightConstant.BYDGOSZCZ),
    BERLIN("Berlin", FlightConstant.NONE),
    WARSZAWA("Warszawa", FlightConstant.WARSZAWA),
    GDANSK("Gdańsk", FlightConstant.GDANSK),
    KRAKOW("Kraków", FlightConstant.KRAKOW),
    LODZ("Lódź", FlightConstant.LODZ),
    POZNAN("Poznań", FlightConstant.POZNAN),
    NONE("Error in Town name", FlightConstant.NONE);

    private String name;
    private String[] flights;

    Town(String name, String[] flights) {
        this.name = name;
        this.flights = flights;
    }

    public String getName() {
        return name;
    }

    public String[] getFlights() {
        return flights;
    }

    public static Town getElement(String element) {
        return Stream.of(Town.values())
                .filter(n -> n.name().equals(element))
                .findFirst()
                .orElse(NONE);
    }
}
