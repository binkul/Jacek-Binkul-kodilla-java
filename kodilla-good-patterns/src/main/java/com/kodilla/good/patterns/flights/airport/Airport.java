package com.kodilla.good.patterns.flights.airport;

import com.kodilla.good.patterns.flights.flight.Flight;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Airport {
    private final Set<Flight> flights;
    private final String town;

    public Airport(Set<Flight> flights, String town) {
        this.flights = flights;
        this.town = town;
    }

    public Set<Flight> getFlights() {
        return flights;
    }

    public String getTown() {
        return town;
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    @Override
    public String toString() {
        return "Connection from '" + town + "'\n" +
                flights.stream()
                        .map(Flight::toString)
                        .collect(Collectors.joining("\n")) + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Airport)) return false;
        Airport airport = (Airport) o;
        return Objects.equals(flights, airport.flights) &&
                town.equals(airport.town);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flights, town);
    }
}
