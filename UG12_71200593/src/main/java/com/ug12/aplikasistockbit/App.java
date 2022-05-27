package com.ug12.aplikasistockbit;

public class App 
{
    public static void main( String[] args )
    {
        Stockbit stockbit = new Stockbit();
        Saham saham1 = new Saham("BBRI",4330);
        Saham saham2 = new Saham("ANTM",2530);
        Saham saham3 = new Saham("ADRO",3150);
        Saham saham4 = new Saham("BBCA",7375);
        System.out.println("----------Skenario 1: Registrasi Investor---- ------");
        Investor investor1 = new Investor("Albertus Adrian","albertusadrian","albertusadrian");
        Investor investor2 = new Investor("Antonius Felix","antoniusfelix","antoniusfelix");
        stockbit.register(investor1);
        stockbit.register(investor2);
        System.out.println("----------Skenario 2: Login Gagal---------- ");
        stockbit.login("albertus","albertus");
        System.out.println("----------Skenario 3: Login Berhasil (Username: albertusadrian)----------");
        stockbit.login("albertusadrian","albertusadrian");
        System.out.println("----------Skenario 4: Print Portfolio Client#1----------");
        stockbit.orderBeli(saham1,2);
        stockbit.orderBeli(saham2,3);
        stockbit.printPortfolio();
        System.out.println("----------Skenario 5: Print Portfolio Client#2----------");
        stockbit.orderJual(saham2,4);
        stockbit.orderJual(saham2,1);
        stockbit.printPortfolio();
        System.out.println("----------Skenario 6: Print Portfolio Client#3----------");
        stockbit.orderJual(saham1,2);
        stockbit.printPortfolio();
        System.out.println("----------Skenario 7: Login Berhasil (Username: antoniusfelix)----------");
        stockbit.login("antoniusfelix","antoniusfelix");
        System.out.println("----------Skenario 8: Print Portfolio Client#4----------");
        stockbit.orderBeli(saham3,2);
        stockbit.orderBeli(saham4,1);
        stockbit.printPortfolio();

    }
}
