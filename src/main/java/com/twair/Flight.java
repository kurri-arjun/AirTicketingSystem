package com.twair;

public class Flight {
    private String source;
    private String destination;
    private Plane plane;
    private String number;
    private int availableSeats;

    public Flight(String number, String source, String destination, Plane plane, int seats) throws Exception {
        this.source = source;
        this.destination = destination;
        this.plane = plane;
        this.number = number;
        this.availableSeats = seats;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getNumber() {
        return number;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }
}
