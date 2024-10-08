package com.example.androidexample.gamelogic;

import com.example.androidexample.PlayAreaFragment;
import com.example.androidexample.SidebarFragment;

import java.util.ArrayList;

public class Game {

    private Deck deck;
    private int money;
    private int currHands;
    private int totalHands;
    private int currDiscards;
    private int totalDiscards;
    private int currHandSize;
    private int totalHandSize;
    private int round;
    private int ante;
    private int numCardsDealt;
    private PlayAreaFragment playFragment;
    private SidebarFragment sidebarFragment;
    private double currentScore;
    private double requiredScoreOffense;
    private double requiredScoreDefense;
    private double bonusMeleeAtk;
    private double bonusMagicAtk;
    private double bonusRangeAtk;
    private double bonusDef;
    private double bonusMeleeAtkMult;
    private double bonusMagicAtkMult;
    private double bonusRangeAtkMult;
    private double bonusDefMult;
    private ArrayList<Card> hand = new ArrayList<Card>();
    private ArrayList<Card> selectedCards = new ArrayList<Card>();
    private ArrayList<Double> baseAnteScoreOffense = new ArrayList<Double>();
    private ArrayList<Double> baseAnteScoreDefense = new ArrayList<Double>();

    public Game (PlayAreaFragment pFragment, SidebarFragment sFragment){
        this.ante = 1;
        this.round = 1;
        this.money = 4;
        this.currHands = 4;
        this.currDiscards = 3;
        this.currHandSize = 8;
        this.playFragment = pFragment;
        this.sidebarFragment = sFragment;
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

    }

    private void nextAnte(){
        this.ante ++;
        this.round = 1;
        this.requiredScoreOffense = baseAnteScoreOffense.get(ante);
        this.requiredScoreDefense = baseAnteScoreDefense.get(ante);

    }

    private void nextRound(){
        this.deck.shuffle();
        numCardsDealt = 0;
        hand.clear();
        currDiscards = totalDiscards;
        currHands = totalHands;
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
            playFragment.updateHand(hand);
        }
    }

    private void discardCard(Card c){
        hand.remove(c);
    }

    private void discardIndex(int index){
        hand.remove(index);
    }

    public void addMeleeBonus(double amount){
        this.bonusMeleeAtk += amount;
    }

    public void addMagicBonus(double amount){
        this.bonusMagicAtk += amount;
    }

    public void addRangeBonus(double amount){
        this.bonusRangeAtk += amount;
    }

    public void addDefenseBonus(double amount){
        this.bonusDef += amount;
    }

    public void subtractMeleeBonus(double amount){
        this.bonusMeleeAtk -= amount;
    }

    public void subtractMagicBonus(double amount){
        this.bonusMagicAtk -= amount;
    }

    public void subtractRangeBonus(double amount){
        this.bonusRangeAtk -= amount;
    }

    public void subtractDefenseBonus(double amount){
        this.bonusDef -= amount;
    }

    public void addMeleeMultBonus(double amount){
        this.bonusMeleeAtkMult += amount;
    }

    public void addMagicMultBonus(double amount){
        this.bonusMagicAtkMult += amount;
    }

    public void addRangeMultBonus(double amount){
        this.bonusRangeAtkMult += amount;
    }

    public void addDefenseMultBonus(double amount){
        this.bonusRangeAtkMult += amount;
    }

    public void subtractMeleeMultBonus(double amount){
        this.bonusMeleeAtkMult -= amount;
    }

    public void subtractMagicMultBonus(double amount){
        this.bonusMagicAtkMult -= amount;
    }

    public void subtractRangeMultBonus(double amount){
        this.bonusRangeAtkMult -= amount;
    }

    public void subtractDefenseMultBonus(double amount){
        this.bonusDefMult -= amount;
    }

    public ArrayList<Card> getHand(){
        return this.hand;
    }

    public String handToString(){
        String str = "";
        for (Card c : hand){
            str += c.toString() + " ||| ";
        }
        return str;
    }

    public String deckToString(){
        String str = "";
        for (int i = 0; i < deck.getSize(); i++){
            deck.getCard(i);
            str += deck.getCard(i).toString() + " ||| ";
        }
        return str;
    }

    public void selectCard(Card c){
        selectedCards.add(c);
    }

    public void deselectCard(Card c){
        selectedCards.remove(c);
    }

    public ArrayList<Card> getSelectedCards(){
        return selectedCards;
    }

    public void clearSelectedCards(){
        selectedCards.clear();
    }

    public void discardSelectedCards(){
        if (!selectedCards.isEmpty() && currDiscards >= 1){
            int numDiscard = selectedCards.size();
            for (Card c : selectedCards){
                hand.remove(c);
                discardCard(c);
            }
            clearSelectedCards();
            currDiscards -= 1;
            sidebarFragment.updateDiscards(currDiscards);
            deal(numDiscard);
        }

    }

    public void playSelectedCards(){

    }

    public void sortHandByRank(){
        hand.sort(new CardRankComparator());
        playFragment.updateHand(hand);
    }

    public void sortHandBySuit(){
        hand.sort(new CardSuitComparator());
        playFragment.updateHand(hand);
    }

    public void startRoundDeal(){
        deal(currHandSize);
    }

}
