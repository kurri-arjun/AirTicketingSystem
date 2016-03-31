package com.twair;

import java.util.*;

public class DataSource {
    final private static DataSource dataSource = new DataSource();
    public static DataSource instance() {
        return dataSource;
    }

    public List<String> fetchLocations() {
        List<String> locations = new ArrayList<String>();
        locations.add("Hyderabad");
        locations.add("Bangalore");
        return locations;
    }

    public List<Plane> fetchPlanes() {
        List<Plane> planes = new ArrayList<>();
        planes.add(new Plane("Boeing777-200LR(77L)", 195));
        planes.add(new Plane("Airbus A321", 152));
        return planes;
    }

    public FlightSearch fetchFlights() throws Exception {
        List<Flight> flightList = new ArrayList<>();
        List<Plane> planes = fetchPlanes();
        List<String> locations = fetchLocations();
        Flight flight1 = new Flight("F001", locations.get(0), locations.get(1), planes.get(0), 12);
        Flight flight2 = new Flight("F002", locations.get(0), locations.get(1), planes.get(1), 112);
        Flight flight3 = new Flight("F003", locations.get(0), locations.get(1), planes.get(1), 0);
        Flight flight4 = new Flight("F004", locations.get(0), locations.get(1), planes.get(0), 25);
        Flight flight5 = new Flight("F005", locations.get(0), locations.get(1), planes.get(0), 8);
        Flight flight6 = new Flight("F006", locations.get(0), locations.get(1), planes.get(0), 0);
        Flight flight7 = new Flight("F007", locations.get(0), locations.get(1), planes.get(0), 54);

        flightList.add(flight1);
        flightList.add(flight2);
        flightList.add(flight3);
        flightList.add(flight4);
        flightList.add(flight5);
        flightList.add(flight6);
        flightList.add(flight7);
        FlightSearch allFlights = new FlightSearch(flightList);
        return allFlights;
    }
}
