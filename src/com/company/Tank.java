package com.company;

/**
 * Created by stevenburris on 9/20/16.
 */
public class Tank {
    String tankNames;
    int numberOfTanks;
    boolean hasBeenCleaned;
    String category;


    Tank(){

    }

    public Tank(String tankNames, int numberOfTanks, boolean hasBeenCleaned, String category) {
        this.tankNames = tankNames;
        this.numberOfTanks = numberOfTanks;
        this.hasBeenCleaned = hasBeenCleaned;
        this.category = category;
    }
}
