package BEBAS;

public class TweetException extends Exception{
    private String errMssg;

    public TweetException(int errCode){
        super();
        switch (errCode){
            case 1:
                this.errMssg = "Maaf, tweet tidak boleh kosong";
                break;
            case 2:
                this.errMssg = "Maaf, tweet minimal harus terdiri dari 8 karakter dan maksimal 140 karakter";
                break;
        }
    }

    public String getErrMssg() {
        return errMssg;
    }

}
