package com.kodilla.exception.test;

import java.util.Map;

public class FlightFinder {
    Map<String, Boolean> airports;

    public FlightFinder(Map<String, Boolean> airports) {
        this.airports = airports;
    }

    public boolean findFlight(Flight flight) throws RouteNotFoundException {

        if (airports.size() == 0 || !airports.containsKey(flight.getArrivalAirport())) {
            throw new RouteNotFoundException("There is no airport '" + flight.getArrivalAirport() + "' in database.");
        } else {
            return airports.get(flight.getArrivalAirport());
        }
    }
}
