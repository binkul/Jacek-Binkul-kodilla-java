package com.kodilla.good.patterns.flights.connection;

import com.kodilla.good.patterns.flights.flight.Flight;
import com.kodilla.good.patterns.flights.flight.FlightVia;

import java.util.Set;

public interface Connectable {
    Set<Flight> findFlightFrom(Set<Flight> flights, String destination);
    Set<Flight> findFlightTo(Set<Flight> flights, String arrival);
    Set<FlightVia> findFlightVia(Set<Flight> flights, String destination, String arrival);
    Set<Flight> createFlights(String[] flights);
}
