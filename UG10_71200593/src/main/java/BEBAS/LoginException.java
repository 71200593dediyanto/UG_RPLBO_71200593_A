package BEBAS;

public class LoginException extends Exception{
    private String errMssg;

    public LoginException(int errCode){
        super();

        switch (errCode){
            case 1:
                this.errMssg = "Maaf, Username atau Password tidak boleh kosong";
                break;
            case 2:
                this.errMssg = "Maaf, username atau password salah! Silahkan coba lagi!";
                break;
        }
    }

    public String getErrMssg() {
        return errMssg;
    }
}
