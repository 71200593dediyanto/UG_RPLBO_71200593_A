package com.ug8.dota;

public class Warlock extends Hero implements Summoner{
    private int numOfSummon;

    public Warlock(){
        super("Warlock",80,700);
    }


    @Override
    public void attack(Creep creep) {
        creep.attacked(this.getDamage());
    }

    @Override
    public Golem summon() {
        this.setNumOfSummon(getNumOfSummon()+1);
        return new Golem(this);

    }

    public void setNumOfSummon(int numOfSummon) {
        this.numOfSummon = numOfSummon;
    }

    public int getNumOfSummon() {
        return numOfSummon;
    }
}
