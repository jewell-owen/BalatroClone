package com.example.androidexample.gamelogic;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> deck = new ArrayList<Card>();

    public Deck (){
        Card temp = new Card(Value.NONE, Suit.NONE, Mod.NONE, Item.NONE);

        //Initialize deck with the 13 cards of each suit
        for (int i = 1; i < 14; i++){
            temp.setNumberValue(i);
            temp.setSuit(Suit.HEART);
            deck.add(temp);
        }

        for (int i = 1; i < 14; i++){
            temp.setNumberValue(i);
            temp.setSuit(Suit.DIAMOND);
            deck.add(temp);
        }

        for (int i = 1; i < 14; i++){
            temp.setNumberValue(i);
            temp.setSuit(Suit.CLUB);
            deck.add(temp);
        }

        for (int i = 1; i < 14; i++){
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



}
