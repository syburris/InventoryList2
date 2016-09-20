package com.company;

/**
 * Created by stevenburris on 9/20/16.
 */
public class SBT extends Tank {
    public SBT(String tankNames, int numberOfTanks, boolean hasBeenCleaned){
        this.tankNames = tankNames;
        this.numberOfTanks = numberOfTanks;
        this.hasBeenCleaned = hasBeenCleaned;
        this.category = "SBT";
    }
}
