package com.ug8.dota;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Creep creep1 = new Creep("Creep1",20,200);
        Creep creep2 = new Creep("Creep2",20,200);
        Creep creep3 = new Creep("Creep3",20,200);

        LoneDruid loneDruid = new LoneDruid();
        Warlock warlock = new Warlock();
        SpiritBear spiritBear = loneDruid.summon();
        Golem golem = warlock.summon();

//      //Sebelum SpiritBear dan Warlock Di Serang Creep 1
        System.out.println("Sebelum SpiritBear dan Warlock Di Serang Creep 1");
        spiritBear.showCharacterInfo();
        System.out.println("\n");
        warlock.showCharacterInfo();
        System.out.println("\n");

        creep1.attack(spiritBear);
        creep1.attack(warlock);

//        Setelah SpiritBear dan Warlock Di Serang Creep 1
        System.out.println("Setelah SpiritBear dan Warlock Di Serang Creep 1");
        spiritBear.showCharacterInfo();
        System.out.println("\n");
        warlock.showCharacterInfo();
        System.out.println("\n");


//        Sebelum Creep1, Creep2, dan Creep3 di Serang oleh LoneDruid,SpiritBear,dan Warlock
        System.out.println("Sebelum Creep1, Creep2, dan Creep3 di Serang oleh LoneDruid,SpiritBear,dan Warloc");
        creep1.showCharacterInfo();
        System.out.println("\n");
        creep2.showCharacterInfo();
        System.out.println("\n");
        creep3.showCharacterInfo();
        System.out.println("\n");

        loneDruid.attack(creep1);
        spiritBear.attack(creep2);
        warlock.attack(creep3);

//        Setelah Creep1, Creep2, dan Creep3 Di Serang oleh LoneDruid,SpiritBear,dan Warlock
        System.out.println("Setelah Creep1, Creep2, dan Creep3 Di Serang oleh LoneDruid,SpiritBear,dan Warlock");
        creep1.showCharacterInfo();
        System.out.println("\n");
        creep2.showCharacterInfo();
        System.out.println("\n");
        creep3.showCharacterInfo();
        System.out.println("\n");

//        Sebelum Creep1 dan Creep2 Di Serang oleh Golem
        System.out.println("Sebelum Creep1 dan Creep2 Di Serang oleh Golem");
        creep1.showCharacterInfo();
        System.out.println("\n");
        creep2.showCharacterInfo();
        System.out.println("\n");

//        Setelah Creep1 dan Creep2 Di Serang oleh Golem
        System.out.println("Setelah Creep1 dan Creep2 Di Serang oleh Golem");
        golem.attack(creep1);
        golem.attack(creep2);
        System.out.println("\n");
        creep1.showCharacterInfo();
        System.out.println("\n");
        creep2.showCharacterInfo();
        System.out.println("\n");

//        summon minigolem
        Golem minigolem = golem.summon();

        loneDruid.showCharacterInfo();
        System.out.println("\n");
        spiritBear.showCharacterInfo();
        System.out.println("\n");
        minigolem.showCharacterInfo();

    }
}
