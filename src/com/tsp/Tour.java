package com.tsp;

import com.tsp.sa.Utility;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Tour.java
 * Models a traveling salesman tour
 * Stores a candidate tour through all cities
 */
public class Tour {    
    
    // holds a tour of cities
    private ArrayList<City> tour = new ArrayList<>();
    // assumes initial value of distance = 0
    private int distance = 0;
    
    // starts a void tour
    public Tour() {        
        for (int i = 0; i < TourManager.numberOfCities(); i++) {
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
    
    /**
     * Creates a random tour (i.e. individual or candidate solution)
     */
    public void generateIndividual() {
        // loop through all destination cities and add them to tour
        for (int cityIndex = 0; cityIndex < TourManager.numberOfCities(); cityIndex++) {
            setCity(cityIndex, TourManager.getCity(cityIndex));
        }
        // randomly reorder the tour
        Collections.shuffle(tour);
    }
    
    /**
     * Returns a city from the tour given a city's index 
     * @param index
     * @return City at the index
     */
    public City getCity(int index) {
        return tour.get(index);
    }
    
    /**
     * Sets a city in a certain position within a tour
     * @param index
     * @param city
     */
    public void setCity(int index, City city) {
        tour.set(index, city);
        // because the tour has been altered we need to reset the fitness and distance
        distance = 0;
    }
    
    /**
     * Computes and returns the total distance of the tour
     * @return distance total distance of the tour
     */
    public int getTotalDistance() {
        if(distance == 0) {
            int tourDistance = 0;
            // loop through all cities of tour
            for (int cityIndex = 0; cityIndex < tourSize(); cityIndex++) {
                // get city we are traveling from
                City fromCity = getCity(cityIndex);
                // the city we are traveling to
                City destinationCity;
                // check if we are not in the tour's last city, if we are set 
                // the tour's final destination to the tour's starting city
                if(cityIndex + 1 == tourSize()) {
                    destinationCity = getCity(cityIndex + 1);
                } else {
                    destinationCity = getCity(0);
                }
                // get the distance between two cities
                tourDistance += Utility.distance(fromCity, destinationCity);
            }
            distance = tourDistance;
        }
        return distance;
    }
    
    /**
     * Gets the number of cities in tour
     * @return number how many cities there are in the tour
     */
    public int tourSize() {
        return tour.size();
    }
    
    @Override
    /**
     * Prints out all the cities in the tour
     */    
    public String toString() {
        String s = getCity(0).getName();
        for (int cityIndex = 1; cityIndex < TourManager.numberOfCities(); cityIndex++) {
            s += " -> " + getCity(cityIndex).getName();
        }
        return s;
    }
        
}
