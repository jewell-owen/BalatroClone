package com.example.androidexample.gamelogic.nonplayables.jokers;

import com.example.androidexample.gamelogic.Game;

public class ApprenticeArmorsmithJoker extends Joker {

    private int cost;
    private int sellValue;
    private Rarity rarity;

    public ApprenticeArmorsmithJoker(){
        this.cost = 4;
        this.sellValue = 2;
        this.rarity = Rarity.COMMON;
    }

    @Override
    public void triggerAbility(Game game) {
        game.addDefenseBonus(50);
    }

    @Override
    public int sell (Game game){
        game.subtractDefenseBonus(50);
        return this.sellValue;
    }
}
