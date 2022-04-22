package com.ug8.dota;

public class LoneDruid extends Hero implements Upgradable,Summoner{
    private int killCreep;
    private int level;

    public LoneDruid(){
        super("Lone Druid",140,1800);
    }
    public SpiritBear summon(){
        return new SpiritBear(this);
    }

    public void upgrade(){
        if(getKillCreep()>=3){
            this.setLevel(this.getLevel()+1);
            this.setKillCreep(this.getKillCreep()-3);
            this.setName("Lone Druid "+ "Level : "+this.getLevel());
            this.setDamage(this.getDamage()+20);
        }
    }

    public void showCharacterInfo(){
        super.showCharacterInfo();
        System.out.println("Kill Creep \t: "+getKillCreep());
    }

    @Override
    public void attack(Creep creep) {
        creep.attacked(this.getDamage());
        if (creep.isDie()){
            this.setKillCreep(this.getKillCreep() + 1);
        }

    }

    public void setKillCreep(int killCreep) {
        this.killCreep = killCreep;
    }

    public int getKillCreep() {
        return killCreep;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
