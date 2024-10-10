package com.example.androidexample.gamelogic;

import java.util.ArrayList;

public class AnteBaseDefenseScore {

    private ArrayList<Double> baseAnteScoreDefense = new ArrayList<Double>();

    public AnteBaseDefenseScore(){

        //Defense scores for antes 0-12
        this.baseAnteScoreDefense.add(5.0);
        this.baseAnteScoreDefense.add(10.0);
        this.baseAnteScoreDefense.add(15.0);
        this.baseAnteScoreDefense.add(20.0);
        this.baseAnteScoreDefense.add(25.0);
        this.baseAnteScoreDefense.add(30.0);
        this.baseAnteScoreDefense.add(35.0);
        this.baseAnteScoreDefense.add(40.0);
        this.baseAnteScoreDefense.add(45.0);
        this.baseAnteScoreDefense.add(50.0);
        this.baseAnteScoreDefense.add(55.0);
        this.baseAnteScoreDefense.add(60.0);
        this.baseAnteScoreDefense.add(65.0);
    }

    public double getBaseDefense (int ante){
        return baseAnteScoreDefense.get(ante);
    }
}
