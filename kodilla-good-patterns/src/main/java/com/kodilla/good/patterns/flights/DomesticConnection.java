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
    private final Set<Flight> flights;
    private final Set<Airport> airports;

    public DomesticConnection(Connectable connection) {
        this.connection = connection;
        this.flights = createAllFlights();
        this.airports = createAirports();
    }

    public Set<Flight> getFlights() {
        return flights;
    }

    public Set<Airport> getAirports() {
        return airports;
    }

    private Set<Airport> createAirports() {
        return Stream.of(Town.values())
                .map(e -> new Airport(connection.createFlights(e.getFlights()), e.getName()))
                .filter(e -> e.getFlights().size() > 0)
                .collect(Collectors.toSet());
    }

    private Set<Flight> createAllFlights() {
        return createAirports().stream()
                .map(Airport::getFlights)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

    void printFlightVia(String destination, String arrival) {
        Set<FlightVia> flightsVia = connection.findFlightVia(flights, destination, arrival);
        if (flightsVia.size() > 0) {
            flightsVia.forEach(FlightVia::printConnection);
        } else {
            System.out.println("\nThere is no connection from '" + destination + "' to '" + arrival + "'");
        }
    }

    void printFlightFrom(String destination) {
        Set<Flight> flightsFrom = connection.findFlightFrom(flights, destination);
        if (flightsFrom.size() > 0) {
            System.out.println("\nFounded connection from '" + destination + "'");
            flightsFrom.forEach(System.out::println);
        } else {
            System.out.println("\nThere is no connection from '" + destination + "'");
        }
    }

    void printFlightTo(String arrival) {
        Set<Flight> flightsTo = connection.findFlightTo(flights, arrival);
        if (flightsTo.size() > 0) {
            System.out.println("\nFounded connection to '" + arrival + "'");
            flightsTo.forEach(System.out::println);
        } else {
            System.out.println("\nThere is no connection to '" + arrival + "'");
        }
    }

    void printAllConnection() {
        airports.forEach(System.out::println);
    }
}
