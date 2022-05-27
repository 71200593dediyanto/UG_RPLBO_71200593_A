package com.ug12.aplikasistockbit;

import java.util.*;

public class Stockbit {

    private ArrayList<Investor> arrInvestor = new ArrayList<Investor>();
    private Investor investor;

    public Stockbit(){

    }

    public void login(String username, String password){
        Boolean test = true;
        for(Investor i : arrInvestor){
            if (i.getUsername().equals(username) && i.getPassword().equals(password)){
                this.investor = i;
                System.out.println("Login berhasil!");
                test = false;
                break;
            }
        }
        if (test){
            System.out.println("Username/password Anda salah!");
        }
    }

    public void register(Investor investor){
        arrInvestor.add(investor);
        System.out.println("Registrasi akun atas nama "+ investor.getNama()+" sukses! ");
    }

    public void orderBeli(Saham saham,int lot){
        HashMap<Saham,Integer> tmp_portofolio = this.investor.getPortfolio();

        if (tmp_portofolio.containsKey(saham)){
            Integer lotlama = tmp_portofolio.get(saham);
            tmp_portofolio.put(saham,lotlama+lot);

        }else {
            tmp_portofolio.put(saham,lot);
        }
        System.out.println("Order beli "+saham.getKode() + " sebanyak "+ lot + " lot sukses!");
        investor.setPortfolio(tmp_portofolio);

    }

    public void orderJual(Saham saham, int lot){
        HashMap<Saham,Integer> tmp_portofolio = this.investor.getPortfolio();

        if(tmp_portofolio.containsKey(saham)){
            if(tmp_portofolio.get(saham) == lot){
                tmp_portofolio.remove(saham);
                System.out.println("Order jual "+ saham.getKode()+ " sebanyak "+ lot + " lot sukses!");
            }else if(tmp_portofolio.get(saham) > lot){
                Integer lotlama = tmp_portofolio.get(saham);
                tmp_portofolio.put(saham,lotlama-lot);
                System.out.println("Order jual "+ saham.getKode()+ " sebanyak "+ lot + " lot sukses!");
            }else {
                System.out.println("Order jual gagal!");
            }
        }
    }

    public void printPortfolio(){
        HashMap<Saham,Integer> tmp_portofolio = this.investor.getPortfolio();
        long totalsemua = 0;
        int counter = 1;
        System.out.println("==========Portfolio Client==========");
        System.out.println("Client: "+ this.investor.getNama());
        System.out.println("No.  Kode Saham   Jumlah Lot      Harga       Sub Total");

        for(Saham i : tmp_portofolio.keySet()){
            long harga = i.getHarga()*(100* tmp_portofolio.get(i));
            System.out.println(counter+".   "+ i.getKode() +"         "+tmp_portofolio.get(i)+"x              "
            + i.getHarga() + "        " + harga);
            totalsemua += harga;
            counter ++;
        }
        System.out.println("Total Investasi: Rp"+totalsemua);

    }

}
