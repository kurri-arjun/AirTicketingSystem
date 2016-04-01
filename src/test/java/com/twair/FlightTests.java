package com.twair;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class FlightTests {
    private String source;
    private String dest;
    private Plane plane;
    private Flight flight;

    @Before
    public void setUp() throws Exception {
        source = "TestSource";
        dest = "TestDestination";
        plane = new Plane("type", 30);
        flight = new Flight("F001", source, dest, plane, 10, new Date(2016, 04, 02));
    }

    @Test
    public void testFlightHaveSource() throws Exception {
        Assert.assertEquals(source, flight.getSource());
    }

    @Test
    public void testFlightHaveDestination() throws Exception {
        Assert.assertEquals(dest, flight.getDestination());
    }

    @Test
    public void testFlightHaveNumber() throws Exception {
        Assert.assertEquals("F001", flight.getNumber());
    }

    @Test
    public void testFlightAvailableSeats() throws Exception {
        Assert.assertEquals(10, flight.getAvailableSeats());
    }
    @Test
    public void testFlightAvailableSeats_NegativeScenario() throws Exception {
        Assert.assertEquals(0, flight.getAvailableSeats());
    }
}
