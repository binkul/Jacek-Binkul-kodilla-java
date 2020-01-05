package com.kodilla.good.patterns.flights.connection;

import com.kodilla.good.patterns.flights.flight.Flight;
import com.kodilla.good.patterns.flights.flight.FlightVia;
import com.kodilla.good.patterns.flights.flight.Town;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class Connection implements Connectable {

    @Override
    public Set<Flight> findFlightFrom(Set<Flight> flights, String destination) {
        return flights.stream()
                .filter(e -> e.getDestination().equals(destination))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Flight> findFlightTo(Set<Flight> flights, String arrival) {
        return flights.stream()
                .filter(e -> e.getArrival().equals(arrival))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<FlightVia> findFlightVia(Set<Flight> flights, String destination, String arrival) {
        Set<Flight> fromCity = findFlightFrom(flights, destination);
        Set<Flight> toCity = findFlightTo(flights, arrival);

        return fromCity.stream()
                .map(from -> {
                    return toCity.stream()
                            .filter(to -> to.getDestination().equals(from.getArrival()))
                            .map(to -> new FlightVia(from, to))
                            .collect(Collectors.toSet());
                })
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Flight> createFlights(String[] flights) {
        return Arrays.stream(flights)
                .map(this::createFlight)
                .collect(Collectors.toSet());
    }

    private Flight createFlight(String line) {
        String[] values = line.split("\\|");
        return new Flight(values[0], Town.getElement(values[1]).getName(), Town.getElement(values[2]).getName());
    }
}
