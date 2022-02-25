package com.ug3.soal1;

import java.text.SimpleDateFormat;
import java.util.*;

public class UG3Soal1 {
    public static void main(String[] args) {
        System.out.println("====================absensi karyawan====================");
        System.out.print("Nama Karyawan : ");
        Scanner input = new Scanner(System.in);
        String nama = input.nextLine();

        System.out.println("\n\nBerhasil Absensi");
        System.out.println("Atas Nama : "+nama);
        Date dNow = new Date( );
        SimpleDateFormat date = new SimpleDateFormat("dd-MMMM-yyyy");
        SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss a");
        System.out.println("Pada tanggal "+date.format(dNow));
        System.out.println("Pukul "+time.format(dNow));
    }
}
