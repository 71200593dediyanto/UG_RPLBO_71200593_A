package com.ug9.MobileLegend;

public class Melee extends Hero implements Skill{
    public Melee(String name, int damage, int health) {
        super(name, damage, health);
    }


    @Override
    public void ultimate() {
        System.out.println(this.getName()+" " +
                "mengaktifkan ulti. Damage saat ini bertambah 100");
        this.addDamage(100);
    }

    @Override
    public void attack(Character enemy){
        if(enemy instanceof Creep){
            this.setHealthBonus(200);
        }
        super.attack(enemy);
    }



}
