package com.company;

import java.util.ArrayList;

/**
 * Created by stevenburris on 9/19/16.
 */
public class Engineer {
    String name;
    String password;
    ArrayList<Tank> tanks;

    public void setTanks(ArrayList<Tank> tanks) {
        this.tanks = tanks;
    }

    public ArrayList<Tank> getTanks() {
        return tanks;
    }
}
