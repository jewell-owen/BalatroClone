package com.example.androidexample.gamelogic;

public class Card {

    private Value value;
    private Suit suit;
    private Mod mod;
    private Item item;

    private double meleeAtk = 1;
    private double magicAtk = 1;
    private double rangeAtk = 1;
    private double defense;

    private double meleeAtkMult = 1;
    private double magicAtkMult = 1;
    private double rangeAtkMult = 1;
    private double defenseMult = 1;

    public Card(Value v, Suit s, Mod m, Item i){
        this.value = v;
        this.suit = s;
        this.mod = m;
        this.item = i;

        this.defense = this.getNumericValue();

        switch (this.suit){
            case HEART:
                this.magicAtkMult = 1.5;
            case SPADE:
                this.rangeAtkMult = 1.5;
            case CLUB:
                this.meleeAtkMult = 1.5;
            case DIAMOND:
                this.defenseMult = 1.5;
        }
    }

    //returns an int for the card value
    public int getNumericValue(){
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

    public Value getEnumValue(){
        return this.value;
    }

    public Suit getSuit(){
        return this.suit;
    }

    protected Mod getMod(){
        return this.mod;
    }

    protected Item getItem(){return this.item;}

    protected void setNumberValue(int i){
        this.value = Value.values()[i];
        if (this.defense < i){
            this.defense = i;
        }
    }

    protected void setEnumValue(Value v){
        this.value = v;
        if (this.defense < this.getNumericValue()){
            this.defense = this.getNumericValue();
        }
    }

    //Sets the suit of the card
    //First checks if the suit is the same as the current suit
    //Then sets old suit mult back to 1
    protected void setSuit(Suit s){
        if (this.suit != s) {
            //set old suit mult to 1
            switch (this.suit){
                case HEART:
                    magicAtkMult = 1;
                case SPADE:
                    rangeAtkMult = 1;
                case CLUB:
                    meleeAtkMult = 1;
                case DIAMOND:
                    defenseMult = 1;
            }
            //set suit to new suit and then increase mult
            this.suit = s;
            switch (this.suit){
                case HEART:
                    if (this.magicAtkMult < 1.5){this.magicAtkMult = 1.5;}
                    else if (this.magicAtkMult >= 1.5){this.magicAtkMult += 1.5;}
                case SPADE:
                    if (this.rangeAtkMult < 1.5){this.rangeAtkMult = 1.5;}
                    else if (this.rangeAtkMult >= 1.5){this.rangeAtkMult += 1.5;}
                case CLUB:
                    if (this.meleeAtkMult < 1.5){this.meleeAtkMult = 1.5;}
                    else if (this.meleeAtkMult >= 1.5){this.meleeAtkMult += 1.5;}
                case DIAMOND:
                    if (this.defenseMult < 1.5){this.defenseMult = 1.5;}
                    else if (this.defenseMult >= 1.5){this.defenseMult += 1.5;}
            }
        }
    }

    protected void setMod(Mod m) {
        if (this.mod != m){
            switch (this.mod){
                case UNDEAD:
                    defense -= 10;
                case SWORDSMAN:
                    meleeAtk -= 3;
                case MARKSMAN:
                    rangeAtk -= 3;
                case MAGE:
                    magicAtk -= 3;
            }
            this.mod = m;
            switch (this.mod){
                case UNDEAD:
                    defense += 10;
                case SWORDSMAN:
                    meleeAtk += 3;
                case MARKSMAN:
                    rangeAtk += 3;
                case MAGE:
                    magicAtk += 3;
            }
        }
    }

    protected void setItem(Item i){
        if (this.item != i){
            switch(this.item){
                case STONE:
                    if (this.suit == Suit.CLUB){meleeAtkMult = 1.5;}
                    else meleeAtkMult = 1;
                case ARROW:
                    if (this.suit == Suit.SPADE){rangeAtkMult = 1.5;}
                    else rangeAtkMult = 1;
                case FEATHER:
                    if (this.suit == Suit.HEART){magicAtkMult = 1.5;}
                    else magicAtkMult = 1;
            }
            this.item = i;
            switch (this.item){
                case STONE:
                    if (this.suit == Suit.CLUB){meleeAtkMult = 3;}
                    else meleeAtkMult = 2;
                case ARROW:
                    if (this.suit == Suit.SPADE){rangeAtkMult = 3;}
                    else rangeAtkMult = 2;
                case FEATHER:
                    if (this.suit == Suit.HEART){magicAtkMult = 3;}
                    else magicAtkMult = 2;
            }
        }
    }


    protected double getMeleeAtkTotal(double bonusMeleeAtk, double bonusMeleeAtkMult){
        return Math.round((this.meleeAtk + bonusMeleeAtk) * (this.meleeAtkMult + bonusMeleeAtkMult));
    }

    protected double getMagicAtkTotal(double bonusMagicAtk, double bonusMagicAtkMult){
        return Math.round((this.magicAtk + bonusMagicAtk) * (this.magicAtkMult * bonusMagicAtkMult));
    }

    protected double getRangeAtkTotal(double bonusRangeAtk, double bonusRangeAtkMult){
        return Math.round((this.rangeAtk + bonusRangeAtk) * (this.rangeAtkMult + bonusRangeAtkMult));
    }

    protected double getDefenseTotalScore(double bonusDefense, double bonusDefenseMult){
         return  Math.round((this.defense + bonusDefense) + (this.defenseMult * bonusDefenseMult));
    }

    protected double getHighestAttackTotalScore(double bonusMeleeAtk, double bonusMeleeAtkMult, double bonusMagicAtk, double bonusMagicAtkMult, double bonusRangeAtk, double bonusRangeAtkMult){
        double meleeTotal = this.getMeleeAtkTotal(bonusMeleeAtk,bonusMeleeAtkMult);
        double magicTotal = this.getMagicAtkTotal(bonusMagicAtk,bonusMagicAtkMult);
        double rangeTotal = this.getRangeAtkTotal(bonusRangeAtk,bonusRangeAtkMult);

        if (meleeTotal >= magicTotal && meleeTotal >= rangeTotal){
            return meleeTotal;
        }
        else if (magicTotal >= meleeTotal && magicTotal >= rangeTotal){
            return magicTotal;
        }
        else{
            return rangeTotal;
        }

    }

    @Override
    public String toString() {
        return "Card{" +
                "value=" + value +
                ", suit=" + suit +
                ", mod=" + mod +
                ", item=" + item;
    }
}
