package com.company;

/**
 * Created by stevenburris on 9/20/16.
 */
public class UST extends Tank {
    public UST(String tankNames, int numberOfTanks, boolean hasBeenCleaned) {
        this.tankNames = tankNames;
        this.numberOfTanks = numberOfTanks;
        this.hasBeenCleaned = hasBeenCleaned;
        this.category = "UST";
    }

}
