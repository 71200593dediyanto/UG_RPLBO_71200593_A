package com.ug9.MobileLegend;

public class NPC extends Character{
    public NPC(String name,int damage,int health){
        super(name,damage,health);
    }

    @Override
    public void attack(Character enemy) {
        if(enemy instanceof Melee || enemy instanceof Ranged){
            enemy.setHealth(enemy.getHealth()-(this.getDamage()+100));
            if (enemy.getHealth() <=0 ){
                enemy.setHealth(0);
                enemy.setDie(true);
            }

            this.attackInformation(enemy,this.getDamage()+100);
        }else {
            enemy.setHealth(enemy.getHealth()-this.getDamage());
            if (enemy.getHealth() <=0 ){
                enemy.setHealth(0);
                enemy.setDie(true);
            }
            this.attackInformation(enemy,this.getDamage());

        }
    }

}
