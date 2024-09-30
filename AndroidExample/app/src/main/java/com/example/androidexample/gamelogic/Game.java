package com.example.androidexample.gamelogic;

import java.util.ArrayList;

public class Game {

    private Deck deck;
    private int money;
    private int hands;
    private int discards;
    private int handSize;
    private int round;
    private int ante;
    private int numCardsDealt;
    private double currentScore;
    private double requiredScoreOffense;
    private double requiredScoreDefense;
    private ArrayList<Card> hand = new ArrayList<Card>();
    private ArrayList<Double> baseAnteScoreOffense = new ArrayList<Double>();
    private ArrayList<Double> baseAnteScoreDefense = new ArrayList<Double>();

    public Game (){
        this.ante = 1;
        this.round = 1;
        this.money = 4;
        this.hands = 4;
        this.discards = 3;
        this.handSize = 8;
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

        numCardsDealt = 0;
        deal(handSize);

    }

    private void nextAnte(){
        this.ante ++;
        this.round = 1;
        this.requiredScoreOffense = baseAnteScoreOffense.get(ante);
        this.requiredScoreDefense = baseAnteScoreDefense.get(ante);

    }

    private void nextRound(){
        this.deck.shuffle();
        hand.clear();
        if (round == 1){
            requiredScoreOffense *= 1.5;
            round ++;
        }
        if (round == 2){
            requiredScoreOffense *= 2;
            requiredScoreDefense *= 1.75;
            round ++;
        }
        if (round == 3){
            this.nextAnte();
        }

    }

    private void deal(int numCards){
        for (int i = 0; i < numCards; i++){
            hand.add(deck.getCard(numCardsDealt));
            numCardsDealt++;
        }
    }

    private void discardCard(Card c){
        hand.remove(c);
    }

    private void discardIndex(int index){
        hand.remove(index);
    }


}
