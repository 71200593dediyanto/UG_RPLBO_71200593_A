package com.ug14.rumahsakit;
import java.sql.*;

public class Suster {
    private static int idSuster = 0;
    private String nama;

    public Suster(String nama){
        this.nama = nama;
        String url = "jdbc:mysql://localhost:3306/rumahsakit";
        try {

            Connection conn = DriverManager.getConnection(url,"root","");
            Statement statement = conn.createStatement();
            int rs = statement.executeUpdate("INSERT INTO suster values ('"+idSuster+"','"+nama+"')");
            idSuster += 1;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Suster (int id , String nama){

    }

    public void screening(Pasien pasien,Jadwal jadwal){
        if (jadwal.getPasien().equals(pasien)){
            if(jadwal.getPasien().equals(pasien) && jadwal.getStatusDaftar()){
                jadwal.setStatusScreening(true);
                System.out.println("Screening berhasil");
            }else {
                System.out.println(
                        "=========ANDA HARUS MELAKUKAN PROSES PENDAFTARAN " +
                                "TERLEBIH DAHULU DI BAGIAN PELAYAN=========="
                );
            }
        }else {
            System.out.println(
                    "=========ANDA HARUS MELAKUKAN PROSES PENDAFTARAN " +
                            "TERLEBIH DAHULU DI BAGIAN PELAYAN=========="
            );
        }
    }

    public int getIdSuster() {
        return idSuster;
    }

    public void setIdSuster(int idSuster) {
        this.idSuster = idSuster;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
