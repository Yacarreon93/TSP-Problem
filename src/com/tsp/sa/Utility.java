package com.tsp.sa;

import com.tsp.City;
import java.util.Random;

public class Utility {
    
    /**
     * Computes and returns the Euclidean distance between two cities
     * @param city1
     * @param city2
     * @return distance the distance between the two cities
     */
    public static double distance(City city1, City city2) {
        int xDistance = Math.abs(city1.getX() - city2.getX());
        int yDistance = Math.abs(city1.getY() - city1.getY());
        double distance = Math.sqrt((xDistance * xDistance) + (yDistance * yDistance));
        return distance;
    }
    
    /**
     * Calculates the acceptance probability
     * @param currentDistance the total distance of the current tour
     * @param newDistance the total distance of the new tour
     * @param temperature the current temperature
     * @return value the probability of wheter to accept the new tour 
     */
    public static double acceptanceProbability(int currentDistance, int newDistance, double temperature) {
        // if the new solution is better, accepts it
        if(newDistance < currentDistance){
            return 1.0;
        }
        return Math.exp((currentDistance - newDistance) / temperature);
    }
    
    /**
     * Returns a random double value between 0 and 1 inclusive 
     * @return 
     */
    public static double randomDouble() {
        Random r = new Random();
        return r.nextInt(1000) / 1000.0;
    }
    
    /**
     * Returns a random int value within a given range
     * min inclusive ... max exclusive
     * @param min the min value of the range
     * @param max the max value of the range
     * @return random a random value between range
     */
    public static int randomInt(int min, int max) {
        Random r = new Random();
        double d = min + r.nextDouble() * (max - min);
        return (int) d;
    }
    
}
