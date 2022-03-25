package com.ug7.game;

public class Karakter {
    private Player player;
    private int HP = 100;
    private int money = 5000;
    private int weapon = 0;
    private boolean isWalk = false;

    public Karakter(Player player) {
        this.player = new Player(player.getUsername(), player.getPassword());
    }

    public void buyWeapon(int weapon) {
        if (weapon > 0 && weapon < 5) {
            this.weapon = weapon;
            int price;
            switch(weapon) {
                default:
                    price = 0;
                    break;
                case 1:
                    price = 500;
                    break;
                case 2:
                    price = 3000;
                    break;
                case 3:
                    price = 2000;
                    break;
                case 4:
                    price = 4000;
                    break;
            }
            boolean Test = this.money >= price ? true : false;

            if (Test) {
                this.money -= price;
                System.out.println("Berhasil membeli senjata! Uang sekarang: " + this.getMoney());
            } else {
                System.out.println("Maaf uang kamu tidak mencukupi!");
            }

        } else {
            System.out.println("Pilihan yang kamu masukkan salah!");
        }
    }

    public void abilityAttack(Karakter karakter) {
        karakter.HP -= 0;
        karakter.receiveDamage(0);
    }

    public void normalAttack(Karakter karakter) {
        int damage;
        switch(this.weapon) {
            default:
                damage = 0;
                break;
            case 1:
                damage = 20;
                break;
            case 2:
                damage = 60;
                break;
            case 3:
                damage = 25;
                break;
            case 4:
                damage = 50;
                break;
        }

        karakter.receiveDamage(damage);
    }

    public void receiveDamage(int damage) {
        this.HP -= damage;
        System.out.println(this.getPlayer().getUsername() + " terkena serangan! Sisa HP " + this.getPlayer().getUsername() + ": " + this.getHP());
        if (this.getHP() <= 0) {
            this.HP = 0;
            System.out.println(this.getPlayer().getUsername() + " mati!");
        }

    }

    public void receiveHP(int hp) {
        this.HP += hp;
        if (this.getHP() > 100) {
            this.HP = 100;
        }

        System.out.println("HP sekarang: " + this.getHP());
    }

    public void getInfo() {
        System.out.println("Username: " + this.getPlayer().getUsername());
        System.out.println("Level: " + this.getPlayer().getLevel());
        System.out.println("Money: " + this.getMoney());
        String keterangan = "";
        if (this.getHP() <= 0) {
            keterangan = "[Mati]";
        }

        System.out.println("HP: " + this.getHP() + " " + keterangan);
        String weapon;
        switch(this.weapon) {
            default:
                weapon = "Tamgam Kosong";
                break;
            case 1:
                weapon = "Pisau";
                break;
            case 2:
                weapon = "Tongkat Sihir";
                break;
            case 3:
                weapon = "Tongkat";
                break;
            case 4:
                weapon = "Katana";
                break;
        }

        System.out.println("Weapon: " + weapon);
        String movement;
        if (this.isWalk) {
            movement = "Berjalan";
        } else {
            movement = "Berlari";
        }

        System.out.println("Movement: " + movement);
        System.out.println();
    }

    public boolean isDie(){
        boolean test = this.getHP() <= 0 ? true : false;
        return test;
    }

    public void walk(boolean type) {
        this.isWalk = type;
    }

    public Player getPlayer() {
        return this.player;
    }

    public int getHP() {
        return this.HP;
    }

    public int getMoney() {
        return this.money;
    }

    public int getWeapon() {
        return this.weapon;
    }

    public boolean isWalk() {
        return this.isWalk;
    }


}
