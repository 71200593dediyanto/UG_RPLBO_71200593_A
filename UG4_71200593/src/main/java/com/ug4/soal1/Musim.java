package com.ug4.soal1;

public class Musim {
    private String name;
    private int hari;

    public Musim(String name, int hari) {
        this.setName(name);
        this.setHari(hari);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHari() {
        return this.hari;
    }

    public void setHari(int hari) {
        this.hari = hari;
    }
}
