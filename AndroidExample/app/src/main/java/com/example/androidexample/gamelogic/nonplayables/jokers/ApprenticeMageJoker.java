package com.example.androidexample.gamelogic.nonplayables.jokers;

import com.example.androidexample.gamelogic.Game;

public class ApprenticeMageJoker extends Joker{

    private int cost;
    private int sellValue;
    private Rarity rarity;

    public ApprenticeMageJoker(){
        this.cost = 4;
        this.sellValue = 2;
        this.rarity = Rarity.COMMON;
    }

    @Override
    public void triggerAbility(Game game) {
        game.addMagicBonus(20);
    }

    @Override
    public int sell (Game game){
        game.subtractMagicBonus(20);
        return this.sellValue;
    }
}
