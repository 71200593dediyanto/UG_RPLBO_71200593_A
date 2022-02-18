package RplBo;

public class TabunganBerjangka {
    String pemilik;
    double saldo = 200000;

    String getPemilik() { return pemilik; }

    void getSaldo() {
        System.out.println(saldo);
    }

    void penarikan(double jumlah){
        System.out.println("-----Tabungan Berjangka-----");
        System.out.println("Belum jatuh tempo");
    }

    void penyetoran(double jumlah) {
        if (jumlah > 0)  saldo = saldo + jumlah;
        System.out.println("-----Tabungan Berjangka-----");
        System.out.println("Penyetoran Rp." + jumlah);
    }
}