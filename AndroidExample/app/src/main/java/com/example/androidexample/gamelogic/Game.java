package com.example.androidexample.gamelogic;

import com.example.androidexample.PlayAreaFragment;
import com.example.androidexample.SidebarFragment;

import java.util.ArrayList;

public class Game {

    // Deck object for the game
    private Deck deck;

    //int for cards dealt each round
    private int numCardsDealt;

    // Ints for money and interest threshold
    private int money;
    private int interestThreshold;

    // Ints to store game logic variables
    private int currHands;
    private int totalHands;
    private int currDiscards;
    private int totalDiscards;
    private int currHandSize;
    private int totalHandSize;

    // Ints to store round and ante
    private int round;
    private int ante;

    // Fragments to be updated with game data
    private PlayAreaFragment playFragment;
    private SidebarFragment sidebarFragment;

    // Doubles to hold all variables dealing with score and scoring
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

    // Arraylists that hold the current hand, current selected cards, and the boolean that determines sort type
    private ArrayList<Card> hand = new ArrayList<Card>();
    private ArrayList<Card> selectedCards = new ArrayList<Card>();
    private boolean sortByRank = true;

    // Objects that handle the  required scores for each ante
    private AnteBaseOffenseScore baseAnteScoreOffense = new AnteBaseOffenseScore();
    private AnteBaseDefenseScore baseAnteScoreDefense = new AnteBaseDefenseScore();


    /**
     * Constructor for the game class
     * @param pFragment PlayAreaFragment to update views
     * @param sFragment SidebarFragment to update views
     * @param startHands Number of starting hands
     * @param startDiscards Number of starting discards
     * @param startMoney Amount of starting money
     */
    public Game (PlayAreaFragment pFragment, SidebarFragment sFragment, int startHands, int startDiscards, int startMoney){
        this.ante = 1;
        this.round = 1;
        this.money = startMoney;
        this.currHands = startHands;
        this.totalHands = startHands;
        this.currDiscards = startDiscards;
        this.totalDiscards = startDiscards;
        this.currHandSize = 8;
        this.interestThreshold = 25;
        this.playFragment = pFragment;
        this.sidebarFragment = sFragment;
        this.deck = new Deck();
        numCardsDealt = 0;
    }

    private void nextAnte(){
        this.ante ++;
        this.round = 1;
        this.requiredScoreOffense = baseAnteScoreOffense.getBaseOffense(ante);
        this.requiredScoreDefense = baseAnteScoreDefense.getBaseDefense(ante);

    }

    private void nextRound(){
        //Shuffle the deck, reset num cards dealt,earn interest, earn round money, reset hand, reset discards
        this.deck.shuffle();
        numCardsDealt = 0;
        hand.clear();
        earnInterest();
        earnEndRoundMoney();
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

    // Start of methods to deal cards =============================================================
    /**
     * Deal cards to the hand
     * @param numCards number of cards to deal
     */
    private void deal(int numCards){
        for (int i = 0; i < numCards; i++){
            hand.add(deck.getCard(numCardsDealt));
            numCardsDealt++;
            if (sortByRank){
                sortHandByRank();
            } else {
                sortHandBySuit();
            }
        }
    }

    /**
     * Method to deal cards at the start of round
     */
    public void startRoundDeal(){
        deal(currHandSize);
    }
    // End of methods to deal cards ===============================================================

    // Start of methods to add/subtract local bonuses for jokers ==================================
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
    // End of methods to add/subtract local bonuses for jokers ====================================

    /**
     * Getter for the hand
     * @return ArrayList of cards in hand
     */
    public ArrayList<Card> getHand(){
        return this.hand;
    }

    // Start of methods to convert objects to strings for debugging cards =========================
    /**
     * Convert the hand to a string for debugging
     * @return str of cards in hand
     */
    public String handToString(){
        String str = "";
        for (Card c : hand){
            str += c.toString() + " ||| ";
        }
        return str;
    }

    /**
     * Convert the deck to a string for debugging
     * @return str of cards in deck
     */
    public String deckToString(){
        String str = "";
        for (int i = 0; i < deck.getSize(); i++){
            deck.getCard(i);
            str += deck.getCard(i).toString() + " ||| ";
        }
        return str;
    }
    // End of methods to convert objects to strings for debugging cards ===========================

    // Start of methods to select cards ===========================================================

    /**
     * Select a card from the hand
     * @param c card to be selected
     */
    public void selectCard(Card c){
        selectedCards.add(c);
    }

    /**
     * Deselect a card from the hand
     * @param c card to be deselected
     */
    public void deselectCard(Card c){
        selectedCards.remove(c);
    }

    /**
     * Get the selected cards
     * @return ArrayList of selected cards
     */
    public ArrayList<Card> getSelectedCards(){
        return selectedCards;
    }

    /**
     * Clear the selected cards array list
     */
    public void clearSelectedCards(){
        selectedCards.clear();
    }
    // End of methods to select cards =============================================================

    // Start of methods to discard cards ==========================================================
    /**
     * Discard the selected cards if at least 1 is selected and there are discards left
     * Clear the selected cards array list
     * Update number of discards in game logic and sidebar fragment
     */
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

    /**
     * Discard a card from the hand
     * @param c Card that should be discarded
     */
    private void discardCard(Card c){
        hand.remove(c);
    }

    /**
     * Discard card by index in hand
     * Use this method to discard random cards from hand
     * @param index index in hand that card to be discarded is located
     */
    private void discardIndex(int index){
        hand.remove(index);
    }
    // End of methods to discard cards ============================================================

    // Start of methods to play cards =============================================================

    /**
     * Play the selected cards
     */
    public void playSelectedCards(){

    }
    // End of methods to play cards ===============================================================

    // Start of methods to sort hands =============================================================
    /**
     * Sort the hand by rank
     */
    public void sortHandByRank(){
        sortByRank = true;
        hand.sort(new CardRankComparator());
        playFragment.updateHand(hand);
    }

    /**
     * Sort the hand by suit
     */
    public void sortHandBySuit(){
        sortByRank = false;
        hand.sort(new CardSuitComparator());
        playFragment.updateHand(hand);
    }
    // End of methods to sort hands ===============================================================

    // Start of methods to handle earning money=====================================================
    /**
     * If player has more money than threshold add the threshold % 5 to their money
     * Else add the money % 5 to their money
     */
    private void earnInterest(){
        if (money >= interestThreshold) {
            money += interestThreshold % 5;
        }
        else {
            money += money % 5;
        }
    }

    /**
     * Small blind = $3 + remaining hands
     * Big blind = $4 + remaining hands
     * Boss blind = $5 + remaining hands
     */
    private void earnEndRoundMoney(){
        if (round == 1) {
            money += 3 + currHands;
        }
        else if (round == 2){
            money += 4 + currHands;
        }
        else if (round == 3){
            money += 5 + currHands;
        }
    }
    // End of methods to handle earning money =====================================================
}
