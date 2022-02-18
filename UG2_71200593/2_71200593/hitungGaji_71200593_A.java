package RplBo;
import java.util.*;

public class hitungGaji_71200593_A {

	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		System.out.println("Berapa Karyawan: ");
		int jmlLoop = inp.nextInt();
		
		for (int i=1;i<=jmlLoop;i++) {
			System.out.println("Masukkan jumlah jam kerja: ");
			int totJamKerja = inp.nextInt();
			float gaji = 300000;
			
			if(totJamKerja == 8) {
				System.out.println("Total: Rp."+gaji);	
			}else if (totJamKerja < 8){
				int lesshour = 8 - totJamKerja;
				float potongan = 15000 * lesshour;
				gaji -= potongan;
				System.out.println("Less hours: "+lesshour + "\nPotongan: "+potongan);
				System.out.println("Total: Rp."+gaji);				
			}else if (totJamKerja > 8) {
				int extraJam = totJamKerja - 8;
				float extraPay = 15000 * extraJam;
				gaji += extraPay;
				System.out.println("Extra jam: "+extraJam+"\nExtra Payments: "+extraPay);
				System.out.println("Total: Rp."+gaji);
			}
			System.out.println("-----------------------------------------");
		}
		inp.close();
	}
}
