package com.ug13.sakitrumah;
import java.util.Scanner;

public class Pendaftaran {

    private String nama;

    public Pendaftaran(String nama) {
        this.nama = nama;
    }

    public void mengaturJadwal(Pengunjung pengunjung, Pemeriksa pemeriksa, Jadwal jadwal){
        if(!pengunjung.getStatus()){
            jadwal.setPengunjung(pengunjung);
            jadwal.setPemeriksa(pemeriksa);
            jadwal.setPendaftaran(this);
            jadwal.setStatusDaftar(true);
            System.out.println("Proses Pengaturan Jadwal Berhasil");
        }else {
            System.out.println("Pasien tidak sakit");
        }
    }

    public Pengunjung registrasi(){
        Scanner inp = new Scanner(System.in);
        System.out.print("Masukkan nama anda : ");
        String namaPengunjung = inp.nextLine();

        Scanner usia = new Scanner(System.in);
        System.out.print("Masukkan usia anda : ");
        int usiaPengunjung= inp.nextInt();

        Scanner inp2 = new Scanner(System.in);

        System.out.print("Masukkan alamat anda : ");
        String alamatPengunjung= inp2.nextLine();

        Scanner inp3 = new Scanner(System.in);
        System.out.print("Masukkan penyakit anda : ");
        String penyakitPengunjung = inp3.nextLine();

        Pengunjung pengunjung = new Pengunjung(namaPengunjung,usiaPengunjung,alamatPengunjung,penyakitPengunjung);
        System.out.println("Proses Registrasi Anda Berhasil!");
        return pengunjung;

    }

}
