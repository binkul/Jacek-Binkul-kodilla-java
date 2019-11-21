package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightTest {
    private static Map<String, Boolean> generateAirports() {
        Map<String, Boolean> result = new HashMap<>();

        result.put("Warsaw", true);
        result.put("Paris", false);
        result.put("London", true);
        result.put("Berlin", true);
        result.put("Katowice", true);
        result.put("Moscow", true);
        result.put("Hong Kong", false);
        result.put("New York", false);
        result.put("Tokyo", false);

        return result;
    }

    public static void main(String[] args) {
        Map<String, Boolean> airports = generateAirports();
        boolean foundFlight = false;

        FlightFinder flightFinder = new FlightFinder(airports);

        try {
            foundFlight = flightFinder.findFlight(new Flight("Warsaw", "Praha"));
        } catch (RouteNotFoundException ex) {
            System.out.println("Problem with flight: " + ex.getMessage());
        } finally {
            if (foundFlight) {
                System.out.println("Destination airport found.");
            } else {
                System.out.println("Destination airport not found.");
            }
        }
    }
}