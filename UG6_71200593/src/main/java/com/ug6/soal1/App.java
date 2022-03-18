package com.ug6.soal1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class App {
    private static String phoneName = "";
    private static String phoneCode = "";
    private static String androidCode = "";
    private static String companyCode = "";
    private static int ramCapacity = 0;
    private static int romCapacity = 0;
    private static int cameraResolution = 0;
    private static float screenSize = 0.0F;
    private static final Scanner scanner;
    private static Production production;
    private static Phones phone;

    public static void main(String[] args) throws InterruptedException {
        TimeUnit time = TimeUnit.SECONDS;
        int index = 0;
        System.out.println("Produce Your Phone");
        System.out.println("\n\n");
        System.out.println("Phone Detail");
        System.out.println("Pick Company Code");

        Iterator var4;
        String compCode;
        for(var4 = Codes.COMPANYCODES.iterator(); var4.hasNext(); ++index) {
            compCode = (String)var4.next();
            System.out.println(index + 1 + ". " + compCode);
        }

        System.out.print("Your choice (1/2/...): ");
        String choice = scanner.nextLine();
        index = Integer.parseInt(choice) - 1;
        setCompanyCode(Codes.COMPANYCODES.get(index));
        System.out.print("Phone Name: ");
        setPhoneName(scanner.nextLine());
        index = 0;
        System.out.print("Configure android level now?\nYes (y) or No (n): ");
        choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("y")) {
            System.out.println("Pick your android level");

            for(var4 = Codes.ANDROIDCODES.iterator(); var4.hasNext(); ++index) {
                compCode = (String)var4.next();
                System.out.println(index + 1 + ". " + compCode);
            }

            System.out.print("Your choice (1/2/...): ");
            choice = scanner.nextLine();
            index = Integer.parseInt(choice) - 1;
            setAndroidCode(Codes.ANDROIDCODES.get(index));
            System.out.println("Generating Phone Code\nPlease Wait a moment");
            time.sleep(3L);
            setPhoneCode(Codes.generatePhoneCode(getCompanyCode(), getAndroidCode()));
            System.out.println("Phone code: " + getPhoneCode());
        } else if (choice.equalsIgnoreCase("n")) {
            System.out.println("Generating Phone Code\nPlease Wait a moment");
            time.sleep(3L);
            setPhoneCode(Codes.generatePhoneCode(getCompanyCode()));
            System.out.println("Phone code: " + getPhoneCode());
        } else {
            System.out.println("Wrong Input");
            main(args);
        }

        System.out.print("Add specification to phone ?\nyes (y) or no (n): ");
        choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("y")) {
            addPhoneSpecification();
            conductProductionMenu();
        } else {
            phone = new Phones(getPhoneName(), getPhoneCode(), getCompanyCode(), getAndroidCode());
            conductProductionMenu();
        }

    }

    private static void conductProductionMenu() {
        ArrayList<Long> productionDueDays = new ArrayList<>();
        ArrayList<LocalDate> productionDate = new ArrayList<>();
        System.out.println("\n\n");
        System.out.println("Begin to Start");
        System.out.print("How much production capacity that can produce: ");
        int productionCapacity = Integer.parseInt(scanner.nextLine());
        production = new Production(productionCapacity, productionDate, productionDueDays);
        System.out.println("Check Specification Requirement");
        checkSpecificationRequirement();
    }

    private static void checkSpecificationRequirement() {
        String choice;
        float productionRate;
        if (phone.getRamCapacity() == 0 && phone.getRomCapacity() == 0 && phone.getScreenSize() == 0.0F && phone.getCameraResolution() == 0) {
            if (production.checkPhonesSpecification(phone.getAndroidType())) {
                System.out.println("Starting To Production");
                System.out.println("Do you want to add production rate (faster production higher cost)");
                System.out.print("Yes (y) or No (n): ");
                choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("y")) {
                    System.out.print("Production rate (0.1 - 2.0): ");
                    productionRate = Float.parseFloat(scanner.nextLine());
                    getProduction().conductProduction(phone, productionRate);
                } else {
                    getProduction().conductProduction(phone);
                }
            } else {
                System.out.println("Failed to pass specification requirement");
            }
        } else if (production.checkPhonesSpecification(phone.getAndroidType(), phone.getRamCapacity(), phone.getRomCapacity())) {
            System.out.println("Starting To Production");
            System.out.println("Do you want to add production rate (faster production higher cost)");
            System.out.print("Yes (y) or No (n): ");
            choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("y")) {
                System.out.print("Production rate (0.1 - 2.0): ");
                productionRate = Float.parseFloat(scanner.nextLine());
                getProduction().conductProduction(phone, productionRate);
            } else {
                getProduction().conductProduction(phone);
            }
        } else {
            System.out.println("Failed to pass specification requirement");
        }

    }

    private static void addPhoneSpecification() {
        System.out.print("RAM Capacity: ");
        int ram = Integer.parseInt(scanner.nextLine());
        System.out.print("ROM Capacity: ");
        int rom = Integer.parseInt(scanner.nextLine());
        System.out.print("Screen Size (Inch): ");
        float screenSize = Float.parseFloat(scanner.nextLine());
        System.out.print("Camera Resolution: ");
        int cameraResolution = Integer.parseInt(scanner.nextLine());
        setRamCapacity(ram);
        setRomCapacity(rom);
        setScreenSize(screenSize);
        setCameraResolution(cameraResolution);
        phone = new Phones(getPhoneName(), getPhoneCode(), getCompanyCode(), getAndroidCode(), getRamCapacity(), getRomCapacity(), getCameraResolution(), getScreenSize());
    }

    public static String getPhoneName() {
        return phoneName;
    }

    public static void setPhoneName(String phoneName) {
        App.phoneName = phoneName;
    }

    public static String getCompanyCode() {
        return companyCode;
    }

    public static void setCompanyCode(String companyCode) {
        App.companyCode = companyCode;
    }

    public static String getAndroidCode() {
        return androidCode;
    }

    public static void setAndroidCode(String androidCode) {
        App.androidCode = androidCode;
    }

    public static String getPhoneCode() {
        return phoneCode;
    }

    public static void setPhoneCode(String phoneCode) {
        App.phoneCode = phoneCode;
    }

    public static int getRomCapacity() {
        return romCapacity;
    }

    public static void setRomCapacity(int romCapacity) {
        App.romCapacity = romCapacity;
    }

    public static int getRamCapacity() {
        return ramCapacity;
    }

    public static void setRamCapacity(int ramCapacity) {
        App.ramCapacity = ramCapacity;
    }

    public static float getScreenSize() {
        return screenSize;
    }

    public static void setScreenSize(float screenSize) {
        App.screenSize = screenSize;
    }

    public static int getCameraResolution() {
        return cameraResolution;
    }

    public static void setCameraResolution(int cameraResolution) {
        App.cameraResolution = cameraResolution;
    }

    public static Production getProduction() {
        return production;
    }

    static {
        scanner = new Scanner(System.in);
    }
}
