package com.ug9.MobileLegend;

public class Ranged extends Hero implements Skill{
    public Ranged(String name, int damage, int health) {
        super(name, damage, health);
    }

    @Override
    public void ultimate() {
        System.out.println(this.getName()+" " +
                "mengaktifkan ulti. Damage saat ini bertambah 150");
        this.addDamage(150);
    }

    @Override
    public void attack(Character enemy){
        if(enemy instanceof Minion){
            this.setHealthBonus(150);
        }else {
            this.setHealthBonus(0);
        }
        super.attack(enemy);
    }
}
