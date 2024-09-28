package com.example.androidexample.gamelogic;

import java.util.ArrayList;

public class Game {

    private Deck deck;
    private int money;
    private int hands;
    private int discards;
    private int round;
    private int ante;
    private double currentScore;
    private double requiredScoreOffense;
    private double requiredScoreDefense;
    private ArrayList<Double> baseAnteScoreOffense = new ArrayList<Double>();
    private ArrayList<Double> baseAnteScoreDefense = new ArrayList<Double>();

    public Game (){
        this.ante = 1;
        this.round = 1;
        this.money = 4;
        this.hands = 4;
        this.discards = 3;
        this.deck = new Deck();

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

    private void nextAnte(){
        this.ante ++;
        this.requiredScoreOffense = baseAnteScoreOffense.get(ante);
        this.requiredScoreDefense = baseAnteScoreDefense.get(ante);

    }

    private void nextRound(){
        if (round == 1){
            requiredScoreOffense *= 1.5;
        }
        if (round == 2){
            requiredScoreOffense *= 2;
            requiredScoreDefense *= 1.75;
        }
        if (round == 3){
            this.nextAnte();
        }

    }

}
