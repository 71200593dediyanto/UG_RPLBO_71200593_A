package com.ug7.game;

public class Ninja extends Karakter{

    private boolean isAbilityReady;

    public Ninja(Player player) {
        super(player);
    }

    public void buyWeapon(int weapon) {
        System.out.println("Daftar senjata:\n1. Pisau\n2. Tongkat\n3. Tongkat Sihir\n4. Katana"); //mark 1
        System.out.println("Pilihan senjata: " + weapon);
        if (weapon != 1 && weapon != 4) {
            System.out.println("Sebagai ninja kamu hanya boleh membeli pisau/katana!");
        } else {
            super.buyWeapon(weapon);
        }
    }

    public void abilityAttack(Karakter karakter) {
        if (this.isAbilityReady) {
            int damage;
            if (this.isWalk()) {
                damage = karakter.getHP() / 2;
                karakter.receiveDamage(damage);
            }else{
                damage = karakter.getHP();
                karakter.receiveDamage(damage);
            }

            System.out.println("Rasakan ini, " + karakter.getPlayer().getUsername() + "!");
            if (karakter.isDie()) {
                this.getPlayer().levelUp();
            }
        } else {
            System.out.println("Ability belum aktif!");
        }
    }

    public void normalAttack(Karakter karakter) {
        if (this.getWeapon() == 0) {
            System.out.println("Maaf, " + this.getPlayer().getUsername() + "... Silakan beli senjata terlebih dahulu!");
        } else {
            if (!this.isWalk()) {
                int weaponDamage;
                switch(this.getWeapon()) {
                    default:
                        weaponDamage = 0;
                        break;
                    case 1:
                        weaponDamage = 20;
                        break;
                    case 4:
                        weaponDamage = 50;
                        break;
                }

                int damage = weaponDamage;
                damage = (int)((double)damage * 1.5D);
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
    }

    public void walk(boolean type) {
        if (!type) {
            System.out.println(this.getPlayer().getUsername() + " menghilang! (Lari)");
        }

        super.walk(type);
    }

    public void getInfo() {
        System.out.println("[Karakter Ninja]");
        super.getInfo();
    }
}
