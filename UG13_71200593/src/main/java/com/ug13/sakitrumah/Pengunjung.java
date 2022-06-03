package com.ug13.sakitrumah;

public class Pengunjung {

    private String nama;
    private int usia;
    private String alamat;
    private String penyakit;
    private int levelPenyakit = 3;
    private Boolean status = false;

    public Pengunjung(String nama, int usia, String alamat, String penyakit) {
        this.nama = nama;
        this.usia = usia;
        this.alamat = alamat;
        this.penyakit = penyakit;
    }

    public Pengunjung(String nama, int usia, String alamat) {
        this.nama = nama;
        this.usia = usia;
        this.alamat = alamat;
    }




    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUsia() {
        return usia;
    }

    public void setUsia(int usia) {
        this.usia = usia;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getPenyakit() {
        return penyakit;
    }

    public void setPenyakit(String penyakit) {
        this.penyakit = penyakit;
    }

    public int getLevelPenyakit() {
        return levelPenyakit;
    }

    public void setLevelPenyakit(int levelPenyakit) {
        this.levelPenyakit = levelPenyakit;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
