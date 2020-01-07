package com.kodilla.good.patterns.flights;

import com.kodilla.good.patterns.flights.airport.Airport;
import com.kodilla.good.patterns.flights.connection.Connectable;
import com.kodilla.good.patterns.flights.flight.Flight;
import com.kodilla.good.patterns.flights.flight.FlightVia;
import com.kodilla.good.patterns.flights.flight.Town;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DomesticConnection {
    private final Connectable connection;
    private final Set<Airport> airports;

    public DomesticConnection(Connectable connection) {
        this.connection = connection;
        this.airports = connection.createAirports();
    }

    public Set<Airport> getAirports() {
        return airports;
    }

    void printFlightVia(String departure, String destination) {
        Set<FlightVia> flightsVia = connection.findFlightVia(departure, destination);
        if (flightsVia.size() > 0) {
            flightsVia.forEach(FlightVia::printConnection);
        } else {
            System.out.println("\nThere is no connection from '" + departure + "' to '" + destination + "'");
        }
    }

    void printFlightFrom(String departure) {
        Set<Flight> flightsFrom = connection.findFlightFrom(departure);
        if (flightsFrom.size() > 0) {
            System.out.println("\nFounded connection from '" + departure + "'");
            flightsFrom.forEach(System.out::println);
        } else {
            System.out.println("\nThere is no connection from '" + departure + "'");
        }
    }

    void printFlightTo(String destination) {
        Set<Flight> flightsTo = connection.findFlightTo(destination);
        if (flightsTo.size() > 0) {
            System.out.println("\nFounded connection to '" + destination + "'");
            flightsTo.forEach(System.out::println);
        } else {
            System.out.println("\nThere is no connection to '" + destination + "'");
        }
    }

    void printAllConnection() {
        airports.forEach(System.out::println);
    }
}
