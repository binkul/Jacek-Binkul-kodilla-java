package com.kodilla.good.patterns.flights.connection;

import com.kodilla.good.patterns.flights.airport.Airport;
import com.kodilla.good.patterns.flights.flight.Flight;
import com.kodilla.good.patterns.flights.flight.FlightVia;
import com.kodilla.good.patterns.flights.flight.Town;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Connection implements Connectable {

    private final Set<Flight> flights;

    public Connection() {
        flights = createAllFlights();
    }

    @Override
    public Set<Flight> findFlightFrom(String departure) {
        return flights.stream()
                .filter(e -> e.getDeparture().equals(departure))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Flight> findFlightTo(String destination) {
        return flights.stream()
                .filter(e -> e.getDestination().equals(destination))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<FlightVia> findFlightVia(String departure, String destination) {
        Set<Flight> fromCity = findFlightFrom(departure);

        return fromCity.stream()
                .map(from -> getIntermediate(from, destination))
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

    private Set<FlightVia> getIntermediate(Flight intermediate, String destination) {
        Set<Flight> flightTo = findFlightTo(destination);

        return flightTo.stream()
                .filter(e -> e.getDeparture().equals(intermediate.getDestination()))
                .map(e -> new FlightVia(intermediate, e))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Airport> createAirports() {
        return Stream.of(Town.values())
                .map(e -> new Airport(createAirportFlights(e.getFlights()), e.getName()))
                .filter(e -> e.getFlights().size() > 0)
                .collect(Collectors.toSet());
    }

    private Set<Flight> createAllFlights() {
        return Stream.of(Town.values())
                .map(e -> createAirportFlights(e.getFlights()))
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

    private Set<Flight> createAirportFlights(String[] flights) {
        return Arrays.stream(flights)
                .map(this::createFlight)
                .collect(Collectors.toSet());
    }

    private Flight createFlight(String line) {
        String[] values = line.split("\\|");
        return new Flight(values[0], Town.getTown(values[1]).getName(), Town.getTown(values[2]).getName());
    }
}
