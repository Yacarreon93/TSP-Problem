package com.tsp;

import java.util.ArrayList;

/**
 * TourManager.java
 * Holds and keeps track of the cities in a tour
 */
public class TourManager {
    
    // holds the cities
    private static ArrayList<City> destinationCities = new ArrayList<>();
    
    /**
     * Adds a destination city
     * @param city
     */
    public static void addCity(City city) {
        destinationCities.add(city);
    }
    
    /**
     * Returns a city given its index
     * @param index
     * @return city the city at the index
     */
    public static City getCity(int index) {
        return destinationCities.get(index);
    }
    
    /**
     * Returns the number of destination cities     
     * @return size the number of destination cities
     */
    public static int numberOfCities() {
        return destinationCities.size();
    }
    
}
