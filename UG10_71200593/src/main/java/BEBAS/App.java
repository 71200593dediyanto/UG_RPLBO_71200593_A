package com.org.ug11;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App 
{
    public static String validUsername;
    public static String validEmail;
    public static String validPassword;

    public static void main( String[] args ) throws UsernameException, EmailException, PasswordException, LoginException {
        validUsername = username();
        validEmail = email();
        validPassword = password();
        User user = new User(validUsername,validEmail,validPassword);
        System.out.println("Akun kamu berhasil didaftarkan!");
        System.out.println("Silahkan login untuk melanjutkan\n");
        login(user);
    }

    public static void login(User user) throws LoginException {
        boolean isValid = false;

        while (!isValid){
            Scanner inp = new Scanner(System.in);
            System.out.print("Username : ");
            String usernameLogin = inp.nextLine();
            System.out.print("Password : ");
            String pwLogin = inp.nextLine();
            try{
                if(usernameLogin.isEmpty()){
                    throw new LoginException(1);
                }
                else if(pwLogin.isEmpty()){
                    throw new LoginException(2);
                }
                else if(!usernameLogin.equals(user.getUsername()) && !pwLogin.equals(user.getPassword())){
                    throw new LoginException(3);
                }else {
                    isValid = true;
                }
            }
            catch (LoginException e){
                System.out.println("Error : " + e.getErrorMessage());
            }
        }
    }

    public static String username() throws UsernameException{
        boolean isValid = false;
        String username = "";

        while (!isValid) {
            Scanner inp = new Scanner(System.in);
            System.out.print("Username\t:");
            username = inp.nextLine();
            try {
                if (username.isEmpty()) {
                    throw new UsernameException(1);
                } else if (username.length() < 6) {
                    throw new UsernameException(2);
                }else {
                    isValid = true;
                }
            } catch (UsernameException e) {
                System.out.println("Error : " + e.getErrorMessage());
            }
        }
        return username;
    }

    public static String email() throws EmailException{
        boolean isValid = false;
        String email = "";

        while(!isValid) {
            Scanner inp = new Scanner(System.in);
            System.out.print("Email\t: ");
            email = inp.nextLine();

            String regex = "^(.+)@(.+)$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);
            boolean isValidPattern = matcher.matches();

            try {
                if (email.isEmpty()) {
                    throw new EmailException(1);
                } else if (!isValidPattern) {
                    throw new EmailException(2);
                }else {
                    isValid = true;
                }

            } catch (EmailException e) {
                System.out.println("Error : " + e.getErrorMessage());
            }
        }
        return email;
    }

    public static String password() throws PasswordException{
        boolean isValid = false;
        String password = "";

        while(!isValid) {
            Scanner inp = new Scanner(System.in);
            System.out.print("Password\t: ");
            password = inp.nextLine();

            try {
                if (password.isEmpty()) {
                    throw new PasswordException(1);
                } else if (password.length() < 7) {
                    throw new PasswordException(2);
                } else if (password.equals(validUsername)) {
                    throw new PasswordException(4);
                } else {
                    boolean flagKecil = false;
                    boolean flagBesar = false;
                    boolean flagAngka = false;
                    boolean flagSymbol = false;
                    for (int i = 0; i < password.length(); i++) {
                        char c = password.charAt(i);
                        int asciiVal = (int) c;
                        if (Character.isLetter(c) && Character.isLowerCase(c)) {
                            flagKecil = true;
                        }
                        if (Character.isLetter(c) && Character.isUpperCase(c)) {
                            flagBesar = true;
                        }
                        if (Character.isDigit(c)) {
                            flagAngka = true;
                        }
                        if ((asciiVal >= 32 && asciiVal <= 47) || (asciiVal >= 58 && asciiVal <= 64)
                                || (asciiVal >= 91 && asciiVal <= 96) || (asciiVal >= 123 && asciiVal <= 126)) {
                            flagSymbol = true;
                        }
                    }
                    if (!(flagKecil && flagAngka && flagBesar && flagSymbol)) {
                        throw new PasswordException(3);
                    }else {
                        isValid = true;
                    }
                    }

                }
            catch (PasswordException e) {
                System.out.println("Error : " + e.getErrorMessage());
            }
        }

        isValid = false;
        String confirmPassword = "";

        while(!isValid) {
            Scanner inp = new Scanner(System.in);
            System.out.print("Konfirmasi Password\t: ");
            confirmPassword = inp.nextLine();

            try {
                if (!confirmPassword.equals(password)) {
                    throw new PasswordException(5);
                }else {
                    isValid = true;
                }
            } catch (PasswordException e) {
                System.out.println("Error : " + e.getErrorMessage());
            }
        }

        return password;
    }
}
