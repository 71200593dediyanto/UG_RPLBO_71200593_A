package com.ug8.dota;

public class SpiritBear extends SummonCharacter{
    public SpiritBear(LoneDruid loneDruid){
        super("Spirit Bear",130,1000,loneDruid);
    }


    @Override
    public void attack(Creep creep) {
        creep.attacked(this.getDamage());
    }
}
