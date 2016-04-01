package com.twair;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlightSearch {

    private List<Flight> flightList;

    public FlightSearch(List<Flight> flightList) {
        this.flightList = flightList;
    }

    public List<Flight> getFlightList() {
        return flightList;
    }

    public FlightSearch byLocation(String source, String destination) {
        if(source == null || source.isEmpty() || destination == null || destination.isEmpty()) {
            throw new IllegalArgumentException("source cannot be null");
        }
        List<Flight> matchingFlights = new ArrayList<Flight>();
        for (Flight flight : flightList) {
            if (flight.getSource().equals(source) && flight.getDestination().equals(destination)) {
                matchingFlights.add(flight);
            }
        }
        return new FlightSearch(matchingFlights);
    }

    public FlightSearch byLocationAndAvailableSeats(String source, String destination, int passengerCount) {
        if(source == null || source.isEmpty() || destination == null || destination.isEmpty() || passengerCount < 0) {
            throw new IllegalArgumentException("source cannot be null");
        }
        if(passengerCount ==0 )
        {
            passengerCount = 1;
        }
        List<Flight> matchingFlights = new ArrayList<Flight>();
        for (Flight flight : flightList) {
            if (flight.getSource().equals(source) && flight.getDestination().equals(destination) && flight.getAvailableSeats()>=passengerCount) {
                matchingFlights.add(flight);
            }
        }
        return new FlightSearch(matchingFlights);
    }

    public FlightSearch searchByDate(Date date)
    {
        List<Flight> matchingFlights = new ArrayList<Flight>();
        if(date != null) {
            for (Flight flight : flightList) {
                Date flightStartDate = flight.getStartDate();
                if (date.getYear()==flightStartDate.getYear() && date.getMonth()==flightStartDate.getMonth()
                        && date.getDay()==flightStartDate.getDay()) {
                    matchingFlights.add(flight);
                }
            }
        }
        return new FlightSearch(matchingFlights);
    }
}
