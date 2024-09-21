package com.example.androidexample.gamelogic;

public class Card {

    private Value value;
    private Suit suit;
    private Mod mod;
    private double meleeAtk;
    private double magicAtk;
    private double rangeAtk;
    private double defense;
    private double meleeAtkMult = 1;
    private double magicAtkMult = 1;
    private double rangeAtkMult = 1;
    private double defenseMult = 1;

    public Card(Value v, Suit s, Mod m){
        this.value = v;
        this.suit = s;
        this.mod = m;

        this.meleeAtk = 1;
        this.magicAtk = 1;
        this.rangeAtk = 1;
        this.defense = this.getNumberValue();

        switch (this.suit){
            case HEART:
                this.magicAtkMult = 1.5;
            case DIAMOND:
                this.rangeAtkMult = 1.5;
            case CLUB:
                this.meleeAtkMult = 1.5;
            case SPADE:
                this.defenseMult = 1.5;
        }


    }

    //returns an int for the card value
    //SPECIAL CASE: returns 0 for metal cards
    private int getNumberValue(){
        switch(this.value){
            case NONE:
                return 0;
            case ONE:
                return 1;
            case TWO:
                return 2;
            case THREE:
                return 3;
            case FOUR:
                return 4;
            case FIVE:
                return 5;
            case SIX:
                return 6;
            case SEVEN:
                return 7;
            case EIGHT:
                return 8;
            case NINE:
                return 9;
            case TEN:
                return 10;
            case ELEVEN:
                return 11;
            case TWELVE:
                return 12;
            case THIRTEEN:
                return 13;
        }
        return -1;
    }

    private Value getEnumValue(){
        return this.value;
    }

    private Suit getSuit(){
        return this.suit;
    }

    private Mod getMod(){
        return this.mod;
    }

    private double getDefense(){
        return Math.round(this.defense);
    }

    private double getDefenseMult(){
        return  Math.round(this.defenseMult);
    }

    private double getMeleeAtk(){
        return  Math.round(this.meleeAtk);
    }

    private double getMeleeAtkMult(){
        return  Math.round(this.meleeAtkMult);
    }

    private double getMagicAtk(){
        return  Math.round(this.magicAtk);
    }

    private double getMagicAtkMult(){
        return  Math.round(this.magicAtkMult);
    }

    private double getRangeAtk(){
        return  Math.round(this.rangeAtk);
    }

    private double getRangeAtkMult(){
        return  Math.round(this.rangeAtkMult);
    }
}
