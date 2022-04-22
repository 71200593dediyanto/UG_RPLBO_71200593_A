package com.ug8.dota;

public abstract class SummonCharacter extends Hero{
    private Summoner owner;

    public SummonCharacter(String name,int damage, int health,Summoner owner){
        super(name,damage,health);
        this.owner = owner;
    }
}
