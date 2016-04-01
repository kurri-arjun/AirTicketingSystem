package com.twair;

import java.util.Date;

public class SearchForm {
    private String from;
    private String to;
    private String number;
    private int passengers;
    //private Date date;
    private String date;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getPassengers()
    {
        return this.passengers;
    }

    public void setPassengers(int count)
    {
        this.passengers = count;
    }

    /*public Date getDate() {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }*/

    public String getDate() {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }
}
