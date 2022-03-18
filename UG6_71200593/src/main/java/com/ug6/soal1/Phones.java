package com.ug6.soal1;

public class Phones
{
    private String phoneCode;
    private String companyCode;
    private String phoneName;
    private String androidType;
    private int ramCapacity;
    private int romCapacity;
    private float screenSize;
    private int cameraResolution;

    public Phones(String phoneName, String phoneCode, String companyCode, String androidCode) {
        this.phoneName = phoneName;
        this.phoneCode = phoneCode;
        this.companyCode = companyCode;
        this.androidType = androidCode;
    }

    public Phones(final String phoneName, final String phoneCode, final String companyCode, final String androidCode, final int ramCapacity, final int romCapacity, final int cameraResolution, final float screenSize) {
        this.phoneName = phoneName;
        this.phoneCode = phoneCode;
        this.companyCode = companyCode;
        this.androidType = androidCode;
        this.ramCapacity = ramCapacity;
        this.romCapacity = romCapacity;
        this.cameraResolution = cameraResolution;
        this.screenSize = screenSize;
    }

    public String getPhoneName() {
        return this.phoneName;
    }

    public String getCompanyCode() {
        return this.companyCode;
    }


    public String getAndroidType() {
        return this.androidType;
    }



    public int getRamCapacity() {
        return this.ramCapacity;
    }


    public int getRomCapacity() {
        return this.romCapacity;
    }


    public int getCameraResolution() {
        return this.cameraResolution;
    }


    public float getScreenSize() {
        return this.screenSize;
    }


    public String getPhoneCode() {
        return this.phoneCode;
    }

}
