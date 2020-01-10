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

        //Then
        Assert.assertEquals(6, airportsCount);
    }

    @Test
    public void fromFindConnectionList() {

        //Given
        Connectable connection = new Connection();
        Flight flight = new Flight("WAW001", "Warszawa", "Bydgoszcz");

        //When
        System.out.println("Test connection from ...");
        Set<Flight> fromWarszawa = connection.findFlightFrom("Warszawa");

        //Then
        Assert.assertTrue(fromWarszawa.contains(flight));
    }

    @Test
    public void toFindConnectionList() {

        //Given
        Connectable connection = new Connection();
        Flight flight = new Flight("KRK003", "Kraków", "Poznań");

        //When
        System.out.println("Test connection to ...");
        Set<Flight> toPoznan = connection.findFlightTo("Poznań");

        //Then
        Assert.assertEquals(3, toPoznan.size());
        Assert.assertTrue(toPoznan.contains(flight));
    }

    @Test
    public void viaFindConnectionList() {

        //Given
        Connectable connection = new Connection();

        //When
        System.out.println("Test connection via ...");
        Set<FlightVia> toPoznan = connection.findFlightVia("Bydgoszcz", "Berlin");

        //Then
        Assert.assertEquals(2, toPoznan.size());
    }
}
