package com.kodilla.good.patterns.flights.flight;

import java.util.Objects;

public class FlightVia {
    private final Flight flightFrom;
    private final Flight flightTo;

    public FlightVia(Flight flightFrom, Flight flightTo) {
        this.flightFrom = flightFrom;
        this.flightTo = flightTo;
    }

    public Flight getFlightFrom() {
        return flightFrom;
    }

    public Flight getFlightTo() {
        return flightTo;
    }

    public void printConnection() {
        System.out.println("\nConnection from: " + flightFrom.getDestination() + " to " + flightTo.getArrival() + ", via " + flightFrom.getArrival());
        System.out.println(flightFrom);
        System.out.println(flightTo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof FlightVia)) return false;
        FlightVia flightVia = (FlightVia) o;
        return Objects.equals(flightFrom, flightVia.flightFrom) &&
                Objects.equals(flightTo, flightVia.flightTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightFrom, flightTo);
    }
}
