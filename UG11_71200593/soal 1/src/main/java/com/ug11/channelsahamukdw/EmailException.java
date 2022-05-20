package com.ug11.channelsahamukdw;

public class EmailException extends Throwable {
    private String errorMessage;
    private int errorCode;

    public EmailException(int errorCode){
        super();

        switch (errorCode){
            case 1:
                this.errorMessage = "Login gagal! Email Anda tidak terdaftar dalam UKDW.";
                this.errorCode = errorCode;
                break;
            case 2:
                this.errorCode = errorCode;
                this.errorMessage = "Login gagal! Email UKDW Anda tidak valid.";
                break;
        }

    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
