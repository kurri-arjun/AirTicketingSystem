package com.twair;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FlightTests {
    private String source;
    private String dest;
    private Plane plane;

    @Before
    public void setUp() throws Exception {
        source = "TestSource";
        dest = "TestDestination";
        plane = new Plane("type", 30);
    }

    @Test
    public void testFlightHaveSource() throws Exception {
        Flight flight = new Flight("F001", source, dest, plane, 10);
        Assert.assertEquals(source, flight.getSource());
    }

    @Test
    public void testFlightHaveDestination() throws Exception {
        Flight flight = new Flight("F001", source, dest, plane, 10);
        Assert.assertEquals(dest, flight.getDestination());
    }

    @Test
    public void testFlightHaveNumber() throws Exception {
        Flight flight = new Flight("F001", source, dest, plane, 10);
        Assert.assertEquals("F001", flight.getNumber());
    }

    @Test
    public void testFlightAvailableSeats() throws Exception {
        Flight flight = new Flight("F001", source, dest, plane, 10);
        Assert.assertEquals(10, flight.getAvailableSeats());
    }
    @Test
    public void testFlightAvailableSeats_NegativeScenario() throws Exception {
        Flight flight = new Flight("F001", source, dest, plane, -5);
        Assert.assertEquals(0, flight.getAvailableSeats());
    }
}
