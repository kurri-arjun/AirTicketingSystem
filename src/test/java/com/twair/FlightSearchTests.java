package com.twair;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class FlightSearchTests {
    private String source;
    private String destination;
    private FlightSearch allFlights;

    @Before
    public void setUp() throws Exception {
        source = "TestSource";
        destination = "TestDestination";
        Plane plane1 = new Plane("type1", 10);
        Flight flight1 = new Flight("F001", source, destination, plane1, 01);
        Flight flight2 = new Flight("F002", "TestSource1", destination, plane1, 100);
        Flight flight3 = new Flight("F003", source, destination, plane1, 125);
        List<Flight> flightList = new ArrayList<>();
        flightList.add(flight1);
        flightList.add(flight2);
        flightList.add(flight3);
        allFlights = new FlightSearch(flightList);
    }

    @Test
    public void shouldReturnListOfFlightsForMatchingSourceDestination() throws Exception {
        List<Flight> flights = allFlights.byLocation(source, destination).getFlightList();
        Assert.assertEquals(source, flights.get(0).getSource());
        Assert.assertEquals(destination, flights.get(0).getDestination());
        Assert.assertEquals(source, flights.get(1).getSource());
        Assert.assertEquals(destination, flights.get(1).getDestination());
        Assert.assertEquals(2, flights.size());
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldMandateSource() throws Exception {
        allFlights.byLocation(null, destination);
    }

    @Test(expected=IllegalArgumentException.class)
    public void sourceCannotBeEmpty() throws Exception {
        allFlights.byLocation("", destination);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldMandateDestination() throws Exception {
        allFlights.byLocation(source, null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void destinationCannotBeEmpty() throws Exception {
        allFlights.byLocation(source, "");
    }

    @Test
    public void testListofFlightsReturnedBySearch()
    {
        List<Flight> flights = allFlights.byLocationAndAvailableSeats(source, destination, 10).getFlightList();
        Assert.assertEquals(1, flights.size());
        Assert.assertEquals(source, flights.get(0).getSource());
        Assert.assertEquals(destination, flights.get(0).getDestination());
    }

    @Test
    public void testListofFlightsReturnedBySearch_1()
    {
        List<Flight> flights = allFlights.byLocationAndAvailableSeats(source, destination, 150).getFlightList();
        Assert.assertEquals(0, flights.size());
    }

    @Test
    public void testListofFlightsReturnedBySearch_2()
    {
        List<Flight> flights = allFlights.byLocationAndAvailableSeats(source, destination, 0).getFlightList();
        Assert.assertEquals(2, flights.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testListofFlightsReturnedBySearch_NegativeScenario()
    {
        List<Flight> flights = allFlights.byLocationAndAvailableSeats(source, destination, -150).getFlightList();
    }
}
