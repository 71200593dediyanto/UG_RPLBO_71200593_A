package com.ug8.dota;

public abstract class Character {
    protected int damagae;
    protected String name;
    protected int health;

    public Character(String name,int damage, int health) {
        this.name = name;
        this.damagae = damage;
        this.health = health;
    }

    public void showCharacterInfo(){
        System.out.println("Hero\t: "+this.getName());
        System.out.println("Health\t: "+this.getHealth());
        System.out.println("Damage\t: "+this.getDamage());
    }

    public boolean isDie(){
        if (this.getHealth() <= 0){
            setHealth(0);
        }
        return this.getHealth() <= 0;
    }

    public void attacked(int damage){
        this.setHealth(this.getHealth()-damage);
    };


    public int getDamage() {
        return damagae;
    }

    public void setDamage(int damagae) {
        this.damagae = damagae;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
