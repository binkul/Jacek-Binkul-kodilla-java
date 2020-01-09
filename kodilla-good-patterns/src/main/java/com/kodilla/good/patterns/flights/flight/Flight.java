package com.kodilla.good.patterns.flights.flight;

import java.util.Objects;

public class Flight {
    private final String number;
    private final String departure;
    private final String destination;

    public Flight(final String number, final String departure, final String destination) {
        this.departure = departure;
        this.destination = destination;
        this.number = number;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return  String.format("Flight number '%s' From %s To %s", number, departure, destination);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Flight)) return false;
        Flight flight = (Flight) o;
        return Objects.equals(number, flight.number) &&
                Objects.equals(departure, flight.departure) &&
                Objects.equals(destination, flight.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, departure, destination);
    }
}
