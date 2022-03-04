package com.ug4.soal1;

import java.time.LocalDate;
import java.util.Locale;

public class Pohon
{
    private static final int MASAHIDUP = 10;
    private int daun;
    private int akar;
    private int dahan;
    private int umur;
    private Buah buah;
    private Musim musim;
    private LocalDate tanggalMusim;

    public Pohon(int daun, int akar, int dahan, int umur) {
        this.setDaun(daun);
        this.setAkar(akar);
        this.setDahan(dahan);
        this.setUmur(umur);
    }

    public int getDaun() {
        return this.daun;
    }

    private void setDaun(int daun) {
        this.daun = daun;
    }

    public int getAkar() {
        return this.akar;
    }

    private void setAkar(int akar) {
        this.akar = akar;
    }

    public int getDahan() {
        return this.dahan;
    }

    private void setDahan(int dahan) {
        this.dahan = dahan;
    }

    public static int getMasahidup() {
        return MASAHIDUP;
    }

    public int getUmur() {
        return this.umur;
    }

    private void setUmur(int umur) {
        this.umur = umur;
    }

    public Buah getBuah() {
        return this.buah;
    }

    private void setBuah(Buah buah) {
        this.buah = buah;
    }

    public Musim getMusim() {
        return this.musim;
    }

    public void setMusim(Musim musim) {
        this.musim = musim;
        String Jmusim = this.musim.getName().toLowerCase(Locale.ROOT);
        switch (Jmusim) {
            case "kemarau": {
                final String nama = "Apel";
                final int masaPanen = 1;
                final int lamaBertahan = 7;
                final int rentangBerbuah = 5;
                final int jumlahBuah = musim.getHari() / masaPanen * rentangBerbuah;
                this.setBuah(new Buah(nama, jumlahBuah, masaPanen, lamaBertahan));
                this.setTanggalMusim(LocalDate.now());
            }
            case "penghujan": {
                final String nama = "Pisang";
                final int masaPanen = 10;
                final int lamaBertahan = 5;
                final int rentangBerbuah = 10;
                final int jumlahBuah = musim.getHari() / masaPanen * rentangBerbuah;
                this.setBuah(new Buah(nama, jumlahBuah, masaPanen, lamaBertahan));
                this.setTanggalMusim(LocalDate.now());
            }
            case "dingin": {
                final String nama = "Jeruk";
                final int masaPanen = 20;
                final int lamaBertahan = 13;
                final int rentangBerbuah = 20;
                final int jumlahBuah = this.musim.getHari() / masaPanen * rentangBerbuah;
                this.setBuah(new Buah(nama, jumlahBuah, masaPanen, lamaBertahan));
                this.setTanggalMusim(LocalDate.now());
            }
            default:
                System.out.println("Musim yang kamu masukan tidak benar");
        }
    }

    public LocalDate getTanggalMusim() {
        return this.tanggalMusim;
    }

    public void setTanggalMusim(final LocalDate tanggalMusim) {
        this.tanggalMusim = tanggalMusim;
    }
}
