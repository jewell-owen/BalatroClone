package com.example.androidexample.gamelogic.nonplayables.jokers;

import com.example.androidexample.gamelogic.Game;

public class ApprenticeArcherJoker extends Joker{

    private int cost;
    private int sellValue;
    private Rarity rarity;

    public ApprenticeArcherJoker(){
        this.cost = 4;
        this.sellValue = 2;
        this.rarity = Rarity.COMMON;
    }

    @Override
    public void triggerAbility(Game game) {
        game.addRangeBonus(20);
    }

    @Override
    public int sell (Game game){
        game.subtractRangeBonus(20);
        return this.sellValue;
    }

}
