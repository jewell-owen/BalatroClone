package com.example.androidexample.gamelogic;

import java.util.ArrayList;

public class AnteBaseOffenseScore {

    private ArrayList<Double> baseAnteScoreOffense = new ArrayList<Double>();

    public AnteBaseOffenseScore(){

        //Offense scores for antes 0-12
        this.baseAnteScoreOffense.add(100.0);
        this.baseAnteScoreOffense.add(300.0);
        this.baseAnteScoreOffense.add(800.0);
        this.baseAnteScoreOffense.add(2000.0);
        this.baseAnteScoreOffense.add(5000.0);
        this.baseAnteScoreOffense.add(11000.0);
        this.baseAnteScoreOffense.add(20000.0);
        this.baseAnteScoreOffense.add(35000.0);
        this.baseAnteScoreOffense.add(50000.0);
        this.baseAnteScoreOffense.add(110000.0);
        this.baseAnteScoreOffense.add(560000.0);
        this.baseAnteScoreOffense.add(7200000.0);
        this.baseAnteScoreOffense.add(300000000.0);
    }

    public double getBaseOffense (int ante){
        return baseAnteScoreOffense.get(ante);
    }

}
