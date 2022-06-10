package com.ug14.rumahsakit;

import java.sql.*;

public class DAO {

    public void inputPasien(Pasien pasien) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/rumahsakit";
        Connection conn = DriverManager.getConnection(url,"root","");
        Statement statement = conn.createStatement();
        String sql = "INSERT INTO pasien values ('"+pasien.getRm()+"','"+pasien.getNama()+"','"+pasien.getUsia()+"','"+pasien.getAlamat()+"')";
        statement.executeUpdate(sql);
        System.out.println("Data Pasien Berhasil Disimpan");
    }

    public Dokter getDokterByID(int idDokter) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/rumahsakit";
        Connection conn = DriverManager.getConnection(url,"root","");
        Statement statement = conn.createStatement();
        String sql = "SELECT * FROM dokter where idDokter="+idDokter;
        ResultSet rs = statement.executeQuery(sql);
        String inpnama = "";
        String inpspes = "";
        String inpruang = "";
        while (rs.next())
        {
            int id = rs.getInt("idDokter");
            String nama = rs.getString("nama");
            inpnama = nama;
            String spesialis = rs.getString("spesialis");
            inpspes = spesialis;
            String ruangan = rs.getString("ruangan");
            inpruang = ruangan;

            // print the results
            System.out.format("%s, %s, %s, %s\n", id, nama, spesialis, ruangan);
        }
        statement.close();
        Dokter dokter = new Dokter(0,inpnama,inpspes,inpruang);
        return dokter;
    }

    public Suster getSusterByID(int idSuster) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/rumahsakit";
        Connection conn = DriverManager.getConnection(url,"root","");
        Statement statement = conn.createStatement();
        String sql = "SELECT * FROM pelayanan where idSuster="+idSuster;
        ResultSet rs = statement.executeQuery(sql);
        String inpNama = "";
        while (rs.next())
        {
            int id = rs.getInt("idPelayan");
            String nama = rs.getString("nama");

            // print the results
            System.out.format("%s, %s\n", id, nama);
        }
        statement.close();
        Suster suster = new Suster(0,inpNama);
        return suster;
    }

    public Pelayanan getPelayananByID(int idPelayan) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/rumahsakit";
        Connection conn = DriverManager.getConnection(url,"root","");
        Statement statement = conn.createStatement();
        String sql = "SELECT * FROM pelayanan where idSuster="+idPelayan;
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next())
        {
            int id = rs.getInt("idPelayan");
            String nama = rs.getString("nama");

            // print the results
            System.out.format("%s, %s\n", id, nama);
        }
        statement.close();
        Pelayanan pelayanan = new Pelayanan();
        return pelayanan;
    }

    public void inputJadwal(Jadwal jadwal){

        int idPemeriksa = jadwal.getIdPemeriksaan();
        int rm = jadwal.getPasien().getRm();
        int iddokter = 0;
        int idpelayan = 0;
        int status = jadwal.getPasien().getStatus() ? 1 : 0;
        String url = "jdbc:mysql://localhost:3306/rumahsakit";
        try {

            Connection conn = DriverManager.getConnection(url,"root","");
            Statement statement = conn.createStatement();
            int rs = statement.executeUpdate("INSERT INTO jadwal values ('"+idPemeriksa+"','"+rm+"','"+iddokter+"','"+idpelayan+"','"+status+"')");
            System.out.println("Data Jadwal Berhasil Disimpan !!");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void getPasienSembuh() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/rumahsakit";
        Connection conn = DriverManager.getConnection(url,"root","");
        Statement statement = conn.createStatement();
        String sql = "SELECT * FROM jadwal where status=1";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next())
        {
            int id = rs.getInt("rm");

            // print the results
            System.out.format("%s\n", id);
        }
    }

    public void updateStatusPasien(Pasien pasien) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/rumahsakit";
        Connection conn = DriverManager.getConnection(url,"root","");
        Statement statement = conn.createStatement();
        String sql = "UPDATE jadwal set status = 1 where rm="+pasien.getRm();
        statement.executeUpdate(sql);
        System.out.println("Statu Pasien Berhasil Di Ubah");
        System.out.println(pasien.getRm());
        System.out.println(pasien.getStatus());

    }

}
