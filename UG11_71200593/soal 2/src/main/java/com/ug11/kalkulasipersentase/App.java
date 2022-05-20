package com.ug11.kalkulasipersentase;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Scanner inp = new Scanner(System.in);
        System.out.print("Masukkan teks: ");
        String persen = inp.nextLine();
        String[] kata = persen.split("\\s+");
        String rincian = "";
        float total = 0;

        for (String i : kata){
            String checkpersen = String.valueOf(i.charAt(i.length()-1));
            if(checkpersen.equals("%")){
                String angka = i.split("%")[0];
                try {
                    rincian += i + " + ";
                    total += Float.parseFloat(angka);
                }catch (NumberFormatException e){
                    continue;
                }

            }
        }

        if(rincian != ""){
            rincian = rincian.substring(0,rincian.length()-3);
        }else {
            rincian = "-";
        }

        System.out.println("Rincian perhitungan: "+rincian);
        System.out.println("Total kenaikan (Dalam Persen): "+ total + "%");


    }
}
