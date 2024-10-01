package com.example.androidexample.gamelogic.nonplayables.jokers;

import com.example.androidexample.gamelogic.Game;

public abstract class Joker {

    private int cost;
    private int sellValue;
    private Rarity rarity;

    public abstract void triggerAbility(Game game);

    public int sell (Game game){
        return this.sellValue;
    }

    public int buy (){
        return this.cost;
    }


}
