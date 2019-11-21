package com.kodilla.exception.test;

import java.util.ArrayList;
import java.util.List;

public class FlightTest {
    private static List<Flight> generateFlights() {
        List<Flight> result = new ArrayList<>();

        result.add(new Flight("Warszawa", "Berlin"));
        result.add(new Flight("Warszawa", "Paryż"));
        result.add(new Flight("Warszawa", "Londyn"));
        result.add(new Flight("Warszawa", "Madryd"));
        result.add(new Flight("Warszawa", "Dublin"));
        result.add(new Flight("Warszawa", "Nowy Jork"));
        result.add(new Flight("Berlin", "Warszawa"));
        result.add(new Flight("Londyn", "Paryż"));
        result.add(new Flight("Bukareszt", "Londyn"));
        result.add(new Flight("Tokyo", "Madryd"));
        result.add(new Flight("Dublin", "Londyn"));
        result.add(new Flight("Katowice", "Rzym"));

        return result;
    }

    public static void main(String[] args) {
        List<Flight> flights = generateFlights();
        boolean foundFlight = false;

        FlightFinder flightFinder = new FlightFinder(flights);

        try {
            foundFlight = flightFinder.findFlight(new Flight("Warszawa", "Lizbona"));
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