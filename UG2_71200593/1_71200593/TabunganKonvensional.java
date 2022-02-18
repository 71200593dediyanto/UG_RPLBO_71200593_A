package RplBo;

public class TabunganKonvensional {
    private String pemilik;
    private double saldo = 100000;
    private TabunganBerjangka s ;

    String getPemilik() { return pemilik; }

    void getSaldo() {
        System.out.println(saldo);
    }

    void penarikan(double jumlah){
        if(jumlah > 0 && saldo >= jumlah){
        saldo = saldo - jumlah;
        System.out.println("-----Tabungan Konvensional-----");
        System.out.println("Penarikan Rp."+ jumlah);
        }
    }

    void penyetoran(double jumlah){
        if(jumlah > 0){
            saldo = saldo + jumlah;
            System.out.println("-----Tabungan Konvensional-----");
            System.out.println("Penyetoran Rp." + jumlah);
        }
    }
}
