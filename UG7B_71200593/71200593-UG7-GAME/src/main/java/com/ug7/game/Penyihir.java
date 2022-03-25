package com.ug7.game;

public class Penyihir extends Karakter{
    private boolean isAbilityReady;

    public Penyihir(Player player) {
        super(player);
    }

    public void buyWeapon(int weapon) {
        System.out.println("Daftar senjata:\n1. Pisau\n2. Tongkat\n3. Tongkat Sihir\n4. Katana");
        System.out.println("Pilihan senjata: " + weapon);
        if (weapon != 2 && weapon != 3) {
            System.out.println("Sebagai penyihir kamu hanya boleh membeli tongkat/tongkat sihir!");
        } else {
            super.buyWeapon(weapon);
        }
    }

    public void abilityAttack(Karakter karakter) {
        if (this.isAbilityReady) {
            int heal;
            if (this.isWalk()) {
                heal = 100;
            } else {
                heal = karakter.getHP() / 2;
            }

            System.out.println("Tidak semudah itu, " + karakter.getPlayer().getUsername() + "!");
            super.receiveHP(heal);
        } else {
            System.out.println("Ability belum aktif!");
        }

    }

    public void normalAttack(Karakter karakter) {
        if (!this.isWalk()) {
            int Weapondamage;
            switch(this.getWeapon()) {
                default:
                    Weapondamage = 0;
                    break;
                case 2:
                    Weapondamage = 60;
                    break;
                case 3:
                    Weapondamage = 25;
                    break;
            }

            int damage = (int)((double)Weapondamage * 1.5D);
            karakter.receiveDamage(damage);
            if (karakter.getHP() < 50) {
                this.isAbilityReady = true;
            }

            if (karakter.getHP() == 0) {
                this.getPlayer().levelUp();
            }
        } else {
            super.normalAttack(karakter);
            if (karakter.getHP() < 50) {
                this.isAbilityReady = true;
            }
        }
    }

    public void walk(boolean type) {
        if (!type) {
            System.out.println(this.getPlayer().getUsername() + " terbang! (Lari)");
        }

        super.walk(type);
    }

    public void getInfo() {
        System.out.println("[Karakter Penyihir]");
        super.getInfo();
    }
}
