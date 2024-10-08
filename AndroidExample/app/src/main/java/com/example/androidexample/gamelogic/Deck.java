package com.example.androidexample.gamelogic;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> deck = new ArrayList<Card>();

    public Deck (){
        Card temp = null;

        //Initialize deck with the 13 cards of each suit
        for (int i = 1; i < 14; i++){
            temp = new Card(Value.NONE, Suit.NONE, Mod.NONE, Item.NONE);
            temp.setNumberValue(i);
            temp.setSuit(Suit.HEART);
            deck.add(temp);
        }

        for (int i = 1; i < 14; i++){
            temp = new Card(Value.NONE, Suit.NONE, Mod.NONE, Item.NONE);
            temp.setNumberValue(i);
            temp.setSuit(Suit.DIAMOND);
            deck.add(temp);
        }

        for (int i = 1; i < 14; i++){
            temp = new Card(Value.NONE, Suit.NONE, Mod.NONE, Item.NONE);
            temp.setNumberValue(i);
            temp.setSuit(Suit.CLUB);
            deck.add(temp);
        }

        for (int i = 1; i < 14; i++){
            temp = new Card(Value.NONE, Suit.NONE, Mod.NONE, Item.NONE);
            temp.setNumberValue(i);
            temp.setSuit(Suit.SPADE);
            deck.add(temp);
        }

        //Shuffle the deck
        Collections.shuffle(deck);
    }

    protected void shuffle(){
        Collections.shuffle(this.deck);
    }

    protected Card getCard (int index){
        return deck.get(index);
    }

    protected int getSize(){
        return deck.size();
    }

}
