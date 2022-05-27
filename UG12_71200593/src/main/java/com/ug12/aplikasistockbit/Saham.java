package com.ug12.aplikasistockbit;

public class Saham {
    private long harga;
    private String kode;

    public Saham(String kode, long harga){
        this.kode = kode;
        this.harga = harga;
    }

    public long getHarga() {
        return harga;
    }

    public String getKode() {
        return kode;
    }

}
