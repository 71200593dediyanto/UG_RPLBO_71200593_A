package RplBo;
import java.util.*;

public class UG1B_Tabungan {

	public static void main(String[] args) {
        TabunganKonvensional K_71200593 = new TabunganKonvensional();
        TabunganBerjangka I_71200593 = new TabunganBerjangka();
        
        System.out.println("Pilihan:\n"+"1.Penyetoran \n2.Penarikan \n3.Lihat Saldo"
        		+"\nMasukan Pilihan: ");
        
        Scanner inp = new Scanner(System.in);
        int pilihan = inp.nextInt();
        
        if (pilihan == 1) {
        	K_71200593.penyetoran(200000);
        	I_71200593.penyetoran(1000000);
        }else if (pilihan == 2) {
        	K_71200593.penarikan(50000);
        	I_71200593.penarikan(0);
        }else if (pilihan == 3) {
            System.out.print("Saldo K_71200593: ");
            K_71200593.getSaldo();
            System.out.print("Saldo I_71200593: ");
            I_71200593.getSaldo();
        }else {
            System.out.println("Inputan tidak valid");
        }
        inp.close();
	}

}
