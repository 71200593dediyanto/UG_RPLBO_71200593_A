package com.ug8.dota;

public class Golem extends SummonCharacter implements Summoner{
    private int kill;

    public Golem(Summoner summoner){
        super("Golem",120,1000,summoner);
    }


    @Override
    public void attack(Creep creep) {
        creep.attacked(this.getDamage());
        if (creep.isDie()){
            this.setKill(this.getKill()+1);
        }
    }

    @Override
    public Golem summon() {
        if(this.getKill()>0){
            this.setKill(this.getKill()-1);
            return new Golem(this);
        }else {
            return null;
        }
    }

    public int getKill() {
        return kill;
    }

    public void setKill(int kill) {
        this.kill = kill;
    }
}

