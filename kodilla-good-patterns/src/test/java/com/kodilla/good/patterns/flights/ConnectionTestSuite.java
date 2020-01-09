package com.kodilla.good.patterns.flights;

import com.kodilla.good.patterns.flights.connection.Connectable;
import com.kodilla.good.patterns.flights.connection.Connection;
import com.kodilla.good.patterns.flights.flight.Flight;
import com.kodilla.good.patterns.flights.flight.FlightVia;
import org.junit.*;

import java.util.Set;

public class ConnectionTestSuite {

    @Before
    public void before(){
        System.out.println("Test Case: begin");
    }

    @After
    public void after(){
        System.out.println("Test Case: end");
    }

    @Test
    public void simpleTestOnCollection() {

        //Given
        Connectable connection = new Connection();
        DomesticConnection domesticConnection = new DomesticConnection(connection);

        //When - Attention! amount can change during town and connection update
        System.out.println("Test for collection size ...");
        int airportsCount = domesticConnection.getAirports().size();
        int connectionCount = domesticConnection.getFlights().size();

        //Then
        Assert.assertEquals(6, airportsCount);
        Assert.assertEquals(23, connectionCount);
    }

    @Test
    public void fromFindConnectionList() {

        //Given
        String[] CONNECTION = {
                "WAW001|POZNAN|BYDGOSZCZ",
                "WAW002|KRAKOW|POZNAN",
                "WAW003|WARSZAWA|KRAKOW",
                "WAW004|GDANSK|LODZ",
                "WAW005|WARSZAWA|BERLIN",
                "WAW006|WARSZAWA|GDANSK"
        };
        Connectable connection = new Connection();
        Set<Flight> flights = connection.createFlights(CONNECTION);
        Flight flight = new Flight("WAW001", "Poznań", "Bydgoszcz");

        //When
        System.out.println("Test connection from ...");
        Set<Flight> fromPoznan = connection.findFlightFrom(flights, "Poznań");

        //Then
        Assert.assertEquals(flight, fromPoznan.iterator().next());
    }

    @Test
    public void toFindConnectionList() {

        //Given
        String[] CONNECTION = {
                "WAW001|POZNAN|BYDGOSZCZ",
                "WAW002|KRAKOW|POZNAN",
                "WAW003|WARSZAWA|KRAKOW",
                "WAW004|GDANSK|LODZ",
                "WAW005|WARSZAWA|BERLIN",
                "WAW006|WARSZAWA|GDANSK"
        };
        Connectable connection = new Connection();
        Set<Flight> flights = connection.createFlights(CONNECTION);
        Flight flight = new Flight("WAW002", "Kraków", "Poznań");

        //When
        System.out.println("Test connection to ...");
        Set<Flight> toPoznan = connection.findFlightTo(flights, "Poznań");

        //Then
        Assert.assertEquals(1, toPoznan.size());
        Assert.assertEquals(flight, toPoznan.iterator().next());
    }

    @Test
    public void viaFindConnectionList() {

        //Given
        String[] CONNECTION = {
                "WAW001|POZNAN|BYDGOSZCZ",
                "WAW002|BYDGOSZCZ|WARSZAWA",
                "WAW003|WARSZAWA|KRAKOW",
                "WAW004|GDANSK|LODZ",
                "WAW005|WARSZAWA|BERLIN",
                "WAW006|WARSZAWA|GDANSK"
        };
        Connectable connection = new Connection();
        Set<Flight> flights = connection.createFlights(CONNECTION);
        Flight destination = new Flight("WAW002", "Bydgoszcz", "Warszawa");
        Flight arrival = new Flight("WAW005", "Warszawa", "Berlin");

        //When
        System.out.println("Test connection via ...");
        Set<FlightVia> toPoznan = connection.findFlightVia(flights, "Bydgoszcz", "Berlin");

        //Then
        Assert.assertEquals(1, toPoznan.size());
        Assert.assertEquals(destination, toPoznan.iterator().next().getFlightFrom());
        Assert.assertEquals(arrival, toPoznan.iterator().next().getFlightTo());
    }
}
