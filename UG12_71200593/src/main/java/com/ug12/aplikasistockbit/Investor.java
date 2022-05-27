package com.ug12.aplikasistockbit;

import java.util.*;

public class Investor {

    private String username;
    private String password;
    private HashMap<Saham,Integer> portfolio = new HashMap<Saham,Integer>();
    private String nama;

    public Investor(String nama, String username, String password){
        this.nama = nama;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public HashMap<Saham, Integer> getPortfolio() {
        return portfolio;
    }

    public String getPassword() {
        return password;
    }

    public String getNama() {
        return nama;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setPortfolio(HashMap<Saham, Integer> portfolio) {
        this.portfolio = portfolio;
    }

}
