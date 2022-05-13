package BEBAS;
import java.sql.SQLOutput;
import java.util.Scanner;

public class App
{
    public static void main( String[] args ) throws UsernameException, LoginException, TweetException, BioException
    {
        User user = new User("u71200593","p71200593");
        checkLogin(user.getUsername(),user.getPassword());
        String newUsername = CheckUser();
        user.setUsername(newUsername);
        System.out.println("Username kamu berhasil diperbaharui, "+newUsername);
        System.out.println("Maaf, "+newUsername+" kamu juga diminta untuk mengisi bio, silahkan masukkan bio kamu");
        String bio = CheckBio();
        System.out.println("Bio kamu berhasil diperbaharui, "+bio);
        System.out.println("Selamat, "+newUsername +" kamu sudah dapat memposting tweet pertama kamu");
        String tweet = CheckTweet();
        System.out.println("@"+newUsername+": "+tweet);
        System.out.println();
        System.out.println("Username: "+user.getUsername());
        System.out.println("Password: "+ user.getPassword());
        System.out.println("Bio: "+bio);
        System.out.println();





    }

    public static void checkLogin(String Username, String Password) throws LoginException{

        while (true){
            Scanner inp = new Scanner(System.in);
            System.out.print("Username : ");
            String uLogin = inp.nextLine();
            System.out.print("Password : ");
            String pLogin = inp.nextLine();

            try {
                if(uLogin.isEmpty() || pLogin.isEmpty()){
                    throw new LoginException(1);
                }else if ( !uLogin.equals(Username) || !pLogin.equals(Password)){
                    throw new LoginException(2);
                }
                System.out.println("Selamat datang di Twitter, " + uLogin);
                System.out.println("Kamu diminta untuk mengganti username, silahkan masukkan username kamu");
                break;
            } catch (LoginException e){
                System.out.println(e.getErrMssg());
            }
        }
    }

    public static String CheckUser() throws UsernameException{
        String username = "";
        boolean isValid = false;
        while (!isValid){
            Scanner inp = new Scanner(System.in);
            System.out.print("Username : ");
            username = inp.nextLine();

            try {
                if (username.isEmpty()){
                    throw new UsernameException(1);
                }else if(username.length() < 6){
                    throw new UsernameException(2);
                }else {
                    boolean huruf = true;
                    boolean angka = true;
                    boolean underscore = true;

                    for (int i = 0; i < username.length(); i++){
                        char c = username.charAt(i);

                        if (!Character.isLetterOrDigit(c)){
                            if(c != '_'){
                                huruf = false;
                                angka = false;
                                underscore = false;
                            }else {
                                underscore = false;
                            }
                        }
                    }
                    try {
                        if (huruf || angka || underscore){
                            isValid = true;
                            return username;
                        }else {
                            throw new UsernameException(3);
                        }

                    }catch (UsernameException e){
                        System.out.println(e.getErrMssg());
                    }
                }
                isValid = true;
            }catch (UsernameException e){
                System.out.println(e.getErrMssg());
            }
        }
        return username;
    }

    public static String CheckBio() throws BioException{
        String bio = "";
        boolean isValid = false;
        while (!isValid){
            Scanner inp = new Scanner(System.in);
            System.out.print("Bio : ");
            bio = inp.nextLine();

            try {
                if (bio.isEmpty()){
                    throw new BioException(1);
                }else if (bio.length()<5 && bio.length()>30){
                    throw new BioException(3);
                }else {
                    boolean validSymbol = true;

                    for(int i = 0; i < bio.length(); i++){
                        char c = bio.charAt(i);

                        if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c) && (c != '.' && c != '@')){
                            throw new BioException(2);
                        }
                    }
                }
                isValid = true;
            }catch (BioException e){
                System.out.println(e.getErrMssg());
            }
        }
        return bio;
    }

    public static String CheckTweet() throws TweetException{
        String tweet = "";
        boolean isValid = false;

        while (!isValid){
            Scanner inp = new Scanner(System.in);
            System.out.println("Tweet : ");
            tweet = inp.nextLine();

            try {
                if(tweet.isEmpty()){
                    throw new TweetException(1);
                }else if(tweet.length() < 8 && tweet.length() > 140){
                    throw new TweetException(2);
                }
            }catch (TweetException e){
                System.out.println(e.getErrMssg());
            }
            break;
        }
        return tweet;
    }
}
