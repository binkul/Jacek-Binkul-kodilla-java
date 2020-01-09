package com.kodilla.good.patterns.flights;

import com.kodilla.good.patterns.flights.connection.Connectable;
import com.kodilla.good.patterns.flights.connection.Connection;

public class Application {

    public static void main(String[] args) {

        Connectable connection = new Connection();
        DomesticConnection domesticConnection = new DomesticConnection(connection);

        domesticConnection.printAllConnection();

        domesticConnection.printFlightFrom("Warszawa");
        domesticConnection.printFlightTo("Berlin");
        domesticConnection.printFlightVia("Bydgoszcz", "Berlin");
    }
}
