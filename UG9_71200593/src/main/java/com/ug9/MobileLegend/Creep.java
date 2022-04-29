package com.ug9.MobileLegend;

public class Creep extends NPC{
    public Creep(String name, int damage, int health) {
        super(name, damage, health);
    }

    @Override
    public void attack(Character enemy){
        if(enemy instanceof Creep || enemy instanceof Minion){
            System.out.println("Terjadi kesalahan ! Creep tidak dapat " +
                    "menyerang minion maupun creep lainnya.");
        }else {
            super.attack(enemy);
        }
    }
}
