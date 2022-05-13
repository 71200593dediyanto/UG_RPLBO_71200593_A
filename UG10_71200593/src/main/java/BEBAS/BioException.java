package BEBAS;

public class BioException extends Exception {
    private String errMssg;

    public BioException(int errCode) {
        super();

        switch (errCode) {
            case 1:
                this.errMssg = "Maaf, bio tidak boleh kosong";
                break;
            case 2:
                this.errMssg = "Maaf, bio tidak boleh mengandung karakter spesial selain titik, et (@), serta spasi";
                break;
            case 3:
                this.errMssg = "Maaf bio minimal harus terdiri dari 5 karakter dan maksimal 30 karakter";
                break;
        }

    }

    public String getErrMssg() {
        return errMssg;
    }
}
