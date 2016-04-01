package com.twair;

import java.util.Date;

public class Flight {
    private String source;
    private String destination;
    private Plane plane;
    private String number;
    private int availableSeats;
    private Date startDate;

    public Flight(String number, String source, String destination, Plane plane, int seats, Date date) throws Exception {
        this.source = source;
        this.destination = destination;
        this.plane = plane;
        this.number = number;
        if(seats >=1) {
            this.availableSeats = seats;
        }
        else
        {
            this.availableSeats = 0;
        }
        this.startDate = date;
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

    public Date getStartDate() {
        return startDate;
    }
}
