package BEBAS;

public class UsernameException extends Exception{
    private String errMssg;

    public UsernameException(int errCode){
        super();
        switch (errCode){
            case 1:
                this.errMssg = "Maaf, Username tidak boleh kosong";
                break;
            case 2:
                this.errMssg = "Maaf, Username minimal harus terdiri dari 6 karakter";
                break;
            case 3:
                this.errMssg = "Maaf, username hanya boleh mengandung huruf, angka, dan _ (underscore)";
                break;
        }
    }

    public String getErrMssg() {
        return errMssg;
    }
}
