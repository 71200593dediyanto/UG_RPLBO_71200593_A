package com.ug3.soa2;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class UG3soal2 {
    public static void main(String[] args) {
        int banyakMenyala = 1;
        while (banyakMenyala>=0){
            System.out.println("Lampu merah menyala selama");
            for (int i = 20; i >= 1; i--){
                System.out.println(i);
            }
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println();
            System.out.println("Akan Berganti kelampu kuning");
            System.out.println("Lampu kuning menyala selama");
            for (int i = 2; i > 0; i--){
                System.out.println(i);
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println();
            System.out.println("Akan Berganti kelampu hijau");
            System.out.println("Lampu hijau menyala selama");
            for (int i = 15; i>=1; i--){
                System.out.println(i);
            }
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Akan Berganti kelampu kuning");
            System.out.println("Lampu kuning menyala selama");
            for (int i = 2; i > 0; i--){
                System.out.println(i);
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
            banyakMenyala -=1;
        }
    }
}
