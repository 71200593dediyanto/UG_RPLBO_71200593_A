package com.ug4.soal1;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

import static java.lang.System.*;

public class App
{
    private static final Scanner scanner;
    public static void main(final String[] args) {
        inisialisasiPohon();
    }

    static {
        scanner = new Scanner(in);
    }

    private static void inisialisasiPohon() {
        System.out.println("=====================================================================================================================");
        System.out.println("Pohon kehidupan");
        System.out.println("Mari menyiapkan pohon kehidupanmu");
        System.out.println("=====================================================================================================================");
        System.out.print("Berapa banyak daun yang akan dimiliki: ");
        final int daun = App.scanner.nextInt();
        App.scanner.nextLine();
        System.out.print("Berapa banyak akar yang akan tumbuh: ");
        final int akar = App.scanner.nextInt();
        App.scanner.nextLine();
        System.out.print("Berapa banyak dahan yang akan dimiliki: ");
        final int dahan = App.scanner.nextInt();
        App.scanner.nextLine();
        System.out.println("Masa Hidup Pohon mu hanya sampai "+Pohon.getMasahidup() + "Tahun");
        System.out.print("Berapa umur mulai pohon kamu (tahun): ");
        final int umur = App.scanner.nextInt();
        App.scanner.nextLine();
        if (umur > Pohon.getMasahidup()) {
            out.println("Maaf umur melebihi masa hidup pohon kamu"+"\n\n");
        }
        else {
            final Pohon pohon = new Pohon(daun, akar, dahan, umur);
            out.println("Pohon kehidupan kamu sudah tumbuh");
            out.println("=====================================================================================================================");
            out.println("\n\n");
            out.flush();
            menuPohon(pohon);
        }
    }

    private static void menuPohon(final Pohon pohon) {
        out.println("=====================================================================================================================");
        out.println("Pohon kehidupan");
        out.println("Atur pohon kamu agar menjadi pohon yang bermanfaat");
        out.println("=====================================================================================================================");
        out.println();
        out.println("1. Tampilkan informasi pohon");
        out.println("2. Masukan musim sekarang");
        out.println("3. Panen buah");
        out.println("4. Keluar");
        out.print("Pilihan kamu: ");
        final int pilihan = App.scanner.nextInt();
        App.scanner.nextLine();
        switch (pilihan) {
            case 1: {
                tampilkanInformasi(pohon);
                break;
            }
            case 2: {
                inputMusim(pohon);
                break;
            }
            case 3: {
                panenBuah(pohon);
                break;
            }
            case 4: {
                out.println("Makasih sudah membuat pohon kehidupan");
                out.println("Sampai jumpa dilain waktu");
            }
            default: {
                out.println("Input kamu salah");
                out.println("\n\n");
                out.flush();
                menuPohon(pohon);
                break;
            }
        }
    }

    private static void tampilkanInformasi(final Pohon pohon) {
        out.println("\n\n");
        out.println("Intip Pohonmu Yuk");
        out.println("1. Tampilkan jumlah daun");
        out.println("2. Tampilkan jumlah akar");
        out.println("3. Tampilkan jumlah dahan");
        out.println("4. Tampilkan umur pohon kamu sekarang");
        out.println("5. Tampilkan rentang hidup pohon kamu");
        out.println("6. Tampilkan musim apa sekarang");
        out.println("7. Tampilkan berapa banyak buah yang sudah dipanen");
        out.println("8. Kembali");
        out.print("Pilihan kamu: ");
        final int pilihan = App.scanner.nextInt();
        App.scanner.nextLine();
        switch (pilihan) {
            case 1: {
                out.println(pohon.getDaun());
                out.println("\n\n");
                tampilkanInformasi(pohon);
                break;
            }
            case 2: {
                out.println(pohon.getAkar());
                out.println("\n\n");
                tampilkanInformasi(pohon);
                break;
            }
            case 3: {
                out.println(pohon.getDahan());
                out.println("\n\n");
                tampilkanInformasi(pohon);
                break;
            }
            case 4: {
                out.println(pohon.getUmur());
                out.println("\n\n");
                tampilkanInformasi(pohon);
                break;
            }
            case 5: {
                out.println(Pohon.getMasahidup());
                out.println("\n\n");
                tampilkanInformasi(pohon);
                break;
            }
            case 6: {
                if (pohon.getMusim() == null) {
                    out.println("Maaf kamu belum mengatur musim apa yang akan berlangsung untuk pohon kehidupanmu");
                    out.println("Atur musim dulu gih");
                }
                else {
                    Musim musim = pohon.getMusim();
                    String NMusim = musim.getName();
                    Buah buah = pohon.getBuah();
                    String Nbuah = buah.getName();
                    System.out.println(NMusim + " " + Nbuah);
                }
                out.println("\n\n");
                tampilkanInformasi(pohon);
                break;
            }
            case 7: {
                try {
                    Buah buah = pohon.getBuah();
                    int Jbuah = buah.getJumlah();
                    String Nbuah = buah.getName();
                    out.println(Jbuah + " " + Nbuah);
                    break;
                }
                catch(Exception e) {
                    out.println("Pohon belum mempunyai buah");
                }
            }
            case 8: {
                menuPohon(pohon);
                break;
            }
            default: {
                out.println("Input yang kamu masukin salah");
                out.println("\n\n");
                out.flush();
                tampilkanInformasi(pohon);
                break;
            }
        }
    }

    private static void inputMusim(final Pohon pohon) {
        int hari = 0;
        out.println("\n\n");
        out.print("Masukan musim apa sekarang (Kemarau, Penghujan, Dingin): ");
        final String namaMusim = App.scanner.nextLine().toLowerCase(Locale.ROOT);
        if (namaMusim.isEmpty()) {
            out.println("Kamu belum masukin musim apa sekarang");
            out.println("\n\n");
            inputMusim(pohon);

        }
        else if (namaMusim.equalsIgnoreCase("kemarau") || namaMusim.equalsIgnoreCase("penghujan") || namaMusim.equalsIgnoreCase("dingin")) {
            if (namaMusim.equalsIgnoreCase("kemarau")) {
                hari = 40;
            }
            else if (namaMusim.equalsIgnoreCase("penghujan")) {
                hari = 30;
            }
            else if (namaMusim.equalsIgnoreCase("dingin")) {
                hari = 60;
            }
            final Musim musim = new Musim(namaMusim, hari);
            pohon.setMusim(musim);
            out.println("Berhasil menambahkan musim untuk pohonmu");
            menuPohon(pohon);
        } else {
            out.println("Musim yang kamu masukan ga sesuai");
            out.println("\n\n");
            inputMusim(pohon);
        }
    }

    private static void panenBuah(final Pohon pohon) {
        if (pohon.getMusim() != null) {
            final LocalDate hariIni = LocalDate.now();
            LocalDate hariPanen = pohon.getTanggalMusim();
            hariPanen = hariPanen.plusDays(pohon.getBuah().getMasaPanen());
            final long selisihHari = ChronoUnit.DAYS.between(hariIni, hariPanen);
            final String today = hariIni.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
            final String harvestDay = hariPanen.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
            final String tanggalMusim = pohon.getTanggalMusim().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
            out.println("\n\n");
            out.println("=====================================================================================================================");
            out.println("Ayo panen buahnya");
            out.println(tanggalMusim);
            out.println(today);
            out.println(harvestDay);
            out.println(selisihHari);
            out.println();
            if (selisihHari <= 1L && selisihHari > -1L) {
                Buah Nambuah = pohon.getBuah();
                String Nbuah = Nambuah.getName();
                int LamBuah = Nambuah.getLamaBertahan();
                out.println(Nbuah + " " + LamBuah);
            }
            else if (selisihHari > 1L) {
                Buah buah = pohon.getBuah();
                String Nbuah = buah.getName();
                int Mpanen = buah.getMasaPanen();
                int LBbuah = buah.getLamaBertahan();
                out.println(Nbuah + " "+Mpanen+" "+LBbuah+" "+Nbuah);
            }
            out.println("=====================================================================================================================");
        }
        else {
            out.println();
            out.println("Maaf kamu belum mengatur musim apa yang akan berlangsung untuk pohon kehidupanmu");
            out.println("Atur musim dulu gih");
        }
        out.println("\n\n");
        menuPohon(pohon);
    }

}
