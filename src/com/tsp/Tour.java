package com.tsp;

import java.util.ArrayList;

/**
 * Tour.java
 * Models a traveling salesman tour
 * Stores a candidate tour through all cities
 **/

public class Tour {    
    
    // holds a tour of cities
    private ArrayList<City> tour = new ArrayList<>();
    // assumes initial value of distance = 0
    private int distance = 0;
    private final int NUMBER_OF_CITIES = 10;
    
    // starts a void tour
    public Tour() {        
        for (int i = 0; i < NUMBER_OF_CITIES; i++) {
            tour.add(null);
        }
    }
    
    // starts a tour from another tour
    public Tour(ArrayList<City> tour) {
        this.tour = (ArrayList<City>) tour.clone();
    }
    
    public ArrayList<City> getTour() {
        return tour;
    }

    public void setTour(ArrayList<City> tour) {
        this.tour = tour;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
    
}
