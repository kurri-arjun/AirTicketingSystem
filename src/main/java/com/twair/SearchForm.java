package com.twair;

public class SearchForm {
    private String from;
    private String to;
    private String number;
    private int passengersCount;

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

    public int getPassengersCount()
    {
        return this.passengersCount;
    }

    public void setPassengersCount(int count)
    {
        this.passengersCount = count;
    }
}
