package com.kodilla.good.patterns.flights.flight;

import java.util.Objects;

public class Flight {
    private final String number;
    private final String destination;
    private final String arrival;

    public Flight(final String number, final String destination, final String arrival) {
        this.destination = destination;
        this.arrival = arrival;
        this.number = number;
    }

    public String getDestination() {
        return destination;
    }

    public String getArrival() {
        return arrival;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return  String.format("Flight number '%s' From %s To %s", number, destination, arrival);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Flight)) return false;
        Flight flight = (Flight) o;
        return Objects.equals(number, flight.number) &&
                Objects.equals(destination, flight.destination) &&
                Objects.equals(arrival, flight.arrival);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, destination, arrival);
    }
}
