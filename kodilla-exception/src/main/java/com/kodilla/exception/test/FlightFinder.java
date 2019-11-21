package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightFinder {
    List<Flight> flights;

    public FlightFinder(List<Flight> flights) {
        this.flights = flights;
    }

    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> destinations = getAirports();

        if (destinations.size() == 0 || !destinations.containsKey(flight.getArrivalAirport())) {
            throw new RouteNotFoundException("There is no airport '" + flight.getArrivalAirport() + "' in database.");
        } else {
            return destinations.get(flight.getArrivalAirport());
        }
    }

    private Map<String, Boolean> getAirports() {
        Map<String, Boolean> result = new HashMap<>();

        for (Flight flight : flights) {
            result.put(flight.getArrivalAirport(), true);
            if (!result.containsKey(flight.getDepartureAirport())) {
                result.put(flight.getDepartureAirport(), false);
            }
        }

        return result;
    }
}
