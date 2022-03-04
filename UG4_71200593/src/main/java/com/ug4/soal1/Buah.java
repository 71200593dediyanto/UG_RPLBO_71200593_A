package com.ug4.soal1;

public class Buah
{
    private String name;
    private int jumlah;
    private int masaPanen;
    private int lamaBertahan;

    public Buah(final String name, final int jumlah, final int masaPanen, final int lamaBertahan) {
        this.setName(name);
        this.setJumlah(jumlah);
        this.setMasaPanen(masaPanen);
        this.setLamaBertahan(lamaBertahan);
    }

    public String getName() {
        return this.name;
    }

    private void setName(final String name) {
        this.name = name;
    }

    public int getJumlah() {
        return this.jumlah;
    }

    private void setJumlah(final int jumlah) {
        this.jumlah = jumlah;
    }

    public int getMasaPanen() {
        return this.masaPanen;
    }

    private void setMasaPanen(final int masaPanen) {
        this.masaPanen = masaPanen;
    }

    public int getLamaBertahan() {
        return this.lamaBertahan;
    }

    private void setLamaBertahan(final int lamaBertahan) {
        this.lamaBertahan = lamaBertahan;
    }
}
