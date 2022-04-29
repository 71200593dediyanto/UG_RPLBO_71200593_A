package com.ug9.MobileLegend;

public abstract class Character {
    private String name;
    private int damage;
    private int health;
    private boolean isDie = false;

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isDie() {
        return isDie;
    }

    public void setDie(boolean die) {
        isDie = die;
    }

    public Character(String name, int damage, int health) {
        this.name = name;
        this.damage = damage;
        this.health = health;
    }

    public abstract void attack(Character enemy);

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void attackInformation(Character enemy, int damage){
        System.out.print(this.name+" memberikan serangan ke ");
        if (enemy instanceof Ranged || enemy instanceof Melee){
            System.out.print("hero "+enemy.getName());
        } else if (enemy instanceof Creep){
            System.out.print("creep "+enemy.getName());
        } else if (enemy instanceof Minion){
            System.out.print("minion "+enemy.getName());
        }
        System.out.println(" sebesar "+damage);
    }
}
