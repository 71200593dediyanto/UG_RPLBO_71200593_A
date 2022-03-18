package com.ug6.soal1;

import java.util.Arrays;
import java.util.ArrayList;

public class Codes {

    public static ArrayList<String> COMPANYCODES = new ArrayList<String>(Arrays.asList("XM", "SG", "AP",
            "RM", "OP", "VV"));
    public static ArrayList<String> ANDROIDCODES = new ArrayList<String>(Arrays.asList("Lollipop", "Marshmallow",
            "Nougat", "Oreo", "Pie", "10 Q", "Red Velvet Cake",
            "Snow Cone", "Tiramisu"));

    public static String generatePhoneCode(String companyCode) {
        final int min = 1;
        final int max = 20;
        final int random = (int)Math.floor(Math.random()*(max-min+1)+min);
        return companyCode + "X" + random;
    }

    public static String generatePhoneCode(String companyCode, String androidCode) {
        final int min = 1;
        final int max = 20;
        final int random = (int)Math.floor(Math.random()*(max-min+1)+min);
        int StringLength = androidCode.length();
        String first = String.valueOf(androidCode.charAt(0));
        String last = String.valueOf(androidCode.charAt(StringLength-1));

        return companyCode + first + last + random;
    }

}
