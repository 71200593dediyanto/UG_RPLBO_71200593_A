package com.ug14.rumahsakit;
import java.sql.*;

public class Jadwal {
    private int idPemeriksaan = 0;
    private Pasien pasien;
    private Dokter dokter;
    private Suster suster;
    private Pelayanan pelayanan;
    private Boolean statusDaftar = false;
    private Boolean statusScreening = false;

    public Jadwal(){

    }

    public Jadwal(Pasien pasien){
        this.pasien = pasien;
    }


    public int getIdPemeriksaan() {
        return idPemeriksaan;
    }

    public void setIdPemeriksaan(int idPemeriksaan) {
        this.idPemeriksaan = idPemeriksaan;
    }

    public Pasien getPasien() {
        return pasien;
    }

    public void setPasien(Pasien pasien) {
        this.pasien = pasien;
    }

    public Dokter getDokter() {
        return dokter;
    }

    public void setDokter(Dokter dokter) {
        this.dokter = dokter;
    }

    public Suster getSuster() {
        return suster;
    }

    public void setSuster(Suster suster) {
        this.suster = suster;
    }

    public Pelayanan getPelayanan() {
        return pelayanan;
    }

    public void setPelayanan(Pelayanan pelayanan) {
        this.pelayanan = pelayanan;
    }

    public Boolean getStatusDaftar() {
        return statusDaftar;
    }

    public void setStatusDaftar(Boolean statusDaftar) {
        this.statusDaftar = statusDaftar;
    }

    public Boolean getStatusScreening() {
        return statusScreening;
    }

    public void setStatusScreening(Boolean statusScreening) {
        this.statusScreening = statusScreening;
    }
}
