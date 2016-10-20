package com.tsp.sa;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import com.tsp.City;
import com.tsp.Tour;
import com.tsp.TourManager;

public class SimulatedAnnealingTest {

    public static void main(String[] args) {
        
        // create cities
        City city = new City(60, 200, "Mexico");
        TourManager.addCity(city);
        City city2 = new City(100, 30, "Aguascalientes");
        TourManager.addCity(city2);
        City city3 = new City(60, 90, "Jalisco");
        TourManager.addCity(city3);
        City city4 = new City(160, 40, "Zacatecas");
        TourManager.addCity(city4);
        City city5 = new City(60, 100, "Guanajuato");
        TourManager.addCity(city5);
        City city6 = new City(100, 180, "Jesus Maria");
        TourManager.addCity(city6);
        City city7 = new City(160, 120, "San Juan");
        TourManager.addCity(city7);
        City city8 = new City(30, 50, "Verazcruz");
        TourManager.addCity(city8);
        
        // set initial temperature
        double temperature = 100000;
        
        // set cooling rate
        double coolingRate = 0.003;
        
        // create a random initial solution
        Tour currenSolution = new Tour();
        currenSolution.generateIndividual();
        
        System.out.println("Tour: " + currenSolution);
        System.out.println("Total distance of initial solution " + currenSolution.getTotalDistance());
        
        // assume best solution is the current solution
        Tour bestSolution = new Tour(currenSolution.getTour());
        
        // loop until system has cooled
        while(temperature > 1) {
            
            // create a neighbor solution
            Tour newSolution = new Tour(currenSolution.getTour());
            
            // get random position in the tour
            int tourPos1 = Utility.randomInt(0, newSolution.tourSize());
            int tourPos2 = Utility.randomInt(0, newSolution.tourSize());
            
            // get the cities at selected positions in tour
            City citySwap1 = newSolution.getCity(tourPos1);
            City citySwap2 = newSolution.getCity(tourPos2);
            
            // swap cities
            newSolution.setCity(tourPos2, citySwap1);
            newSolution.setCity(tourPos1, citySwap2);
            
            // get energy of solutions
            int currentDistance = currenSolution.getTotalDistance();
            int neighborDistance = newSolution.getTotalDistance();
            
            // decide if accept the negihbor 
            double rand = Utility.randomDouble();
            if(Utility.acceptanceProbability(currentDistance, neighborDistance, temperature) > rand) {
                currenSolution = new Tour(newSolution.getTour());
            }
            
            // keep track of the best solution found
            if(currenSolution.getTotalDistance() < bestSolution.getTotalDistance()) {
                bestSolution = new Tour(currenSolution.getTour());
            }
            
            // cool system
            temperature *= 1 - coolingRate;
            
        }                        
        System.out.println("The best solution is: " + bestSolution);
        System.out.println("Total distance of best solution " + bestSolution.getTotalDistance());
    }
    
}
