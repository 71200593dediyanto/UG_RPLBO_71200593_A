package com.ug6.soal1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;

public class Production {
    private int productionCapacity;
    private ArrayList<LocalDate> productionDate;
    private ArrayList<Long> productionDueDays;
    private double costCalculation = 0.0D;

    public Production(int productionCapacity, ArrayList<LocalDate> productionDate, ArrayList<Long> productionDueDays) {
        this.productionCapacity = productionCapacity;
        this.productionDate = productionDate;
        this.productionDueDays = productionDueDays;
    }

    public boolean checkPhonesSpecification(String androidCode) {
        int index = 0;
        boolean status = false;
        ArrayList<String> androidCodess = new ArrayList<>(Arrays.asList("Lollipop", "Marshmallow",
                "Nougat"));
        ArrayList<String> code = Codes.ANDROIDCODES;
//        return androidCodess.contains(androidCode);

        for (String i: code){
            status = !androidCode.equalsIgnoreCase(i) || index >= 3;
            index++;
        }
        return status;
    }


    public boolean checkPhonesSpecification(String androidCode, int ramCapacity, int romCapacity) {
        int index = 0;
        boolean status;

        ArrayList<String> androidCodes1 = new ArrayList<>(Arrays.asList("Pie", "10 Q", "Red Velvet Cake",
                "Snow Cone", "Tiramisu"));

        ArrayList<String> androidCodes2 = new ArrayList<>(Arrays.asList("Lollipop", "Marshmallow",
                "Nougat", "Oreo"));

        System.out.println("Starting with status false");



        if (androidCodes1.contains(androidCode)){
            status = ramCapacity <= 16 && ramCapacity >= 4 && romCapacity <= 256 && romCapacity >= 64;
        }else if (androidCodes2.contains(androidCode)){
            status = ramCapacity <= 8 && ramCapacity >= 1 && romCapacity <= 128 && romCapacity >= 32;
        }else {
            status = false;
        }
        System.out.println("Finish checking with status " + status);
        return status;

    }

    public void conductProduction(Phones phone) {
        long productionDuration = (long)this.productionCapacity * 3L;
        DateTimeFormatter formatDay = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate today = LocalDate.now();
        this.productionDate.add(today);
        LocalDate productionDueDate = today.plusDays(productionDuration);
        long daysBetweenProduction = ChronoUnit.DAYS.between(today, productionDueDate);
        String todayFormat = today.format(formatDay);
        String productionDueDateFormat = productionDueDate.format(formatDay);
        this.costCalculation = (double)(this.productionCapacity * 1000) * (double)daysBetweenProduction;
        System.out.println("Congratulation\nBegin To Produce Phone " + phone.getPhoneName());
        System.out.println("With code: " + phone.getPhoneCode());
        System.out.println("Production Date: " + todayFormat);
        System.out.println("Production Due date: " + productionDueDateFormat);
        System.out.println("Days Before Due Date = " + daysBetweenProduction + " Days");
        System.out.println("Calculation Production Cost: Rp " + this.costCalculation);
    }

    public void conductProduction(Phones phone, float productionRate) {
        if (productionRate >= 0.0F && productionRate <= 2.0F) {
            long productionDuration = (long)((float)((long)this.productionCapacity * 3L) * productionRate);
            DateTimeFormatter formatDay = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate today = LocalDate.now();
            this.productionDate.add(today);
            LocalDate productionDueDate = today.plusDays(productionDuration);
            long daysBetweenProduction = ChronoUnit.DAYS.between(today, productionDueDate);
            this.costCalculation = (double)(this.productionCapacity * 1000) * (double)daysBetweenProduction * 2.0D;
            String bonusProductionDate = today.format(formatDay);
            String bonusProductionDueDate = productionDueDate.format(formatDay);

            System.out.println("Congratulation\nBegin To Produce Phone " + phone.getPhoneName());
            System.out.println("With code: " + phone.getPhoneCode());
            System.out.println("Production Date: " + bonusProductionDate);
            System.out.println("Production Due date: " + bonusProductionDueDate);
            System.out.println("Days Before Due Date = " + daysBetweenProduction + " Days");
            System.out.println("Calculation Production Cost: Rp " + (long)this.costCalculation);

        } else {
            System.out.println("Please Input valid Production Rate");
        }

    }
}
