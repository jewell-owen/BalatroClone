package com.example.androidexample.gamelogic;

import java.util.Comparator;

public class CardRankComparator implements Comparator<Card> {

    public int compare(Card c1, Card c2) {
        return c2.getNumericValue() - c1.getNumericValue();
    }
}
