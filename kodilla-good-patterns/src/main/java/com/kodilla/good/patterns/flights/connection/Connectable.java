package com.kodilla.good.patterns.flights.connection;

import com.kodilla.good.patterns.flights.airport.Airport;
import com.kodilla.good.patterns.flights.flight.Flight;
import com.kodilla.good.patterns.flights.flight.FlightVia;

import java.util.Set;

public interface Connectable {
    Set<Flight> findFlightFrom(String departure);
    Set<Flight> findFlightTo(String destination);
    Set<FlightVia> findFlightVia(String departure, String destination);
    Set<Airport> createAirports();
}
