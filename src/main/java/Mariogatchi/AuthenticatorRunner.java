package Mariogatchi;

import java.io.Serializable;
import java.util.Arrays;

public class AuthenticatorRunner {

    private void checkLoginInfo(String username, String password) { //checks if login info is valid and logs in
        Serializer srl = new Serializer();
        Serializable serializedAccount = srl.load(username + ".ser");
        Account account = (Account) serializedAccount;
        if (Arrays.equals(account.getHashedPassword(), password.getBytes())) { // needs to hash the password beforehand, filler code
            // then login
        } else {
            //return a wrong password message
        }
    }

    private void saveSignupInfo(String username, String password) { //saves a new signup
        if (validPassword(password)) {
            Serializer srl = new Serializer();
            srl.save(username + ".ser", new Account(username, password.getBytes())); // needs to hash the password beforehand
        } else {
            // return an invalid password to the user
        }
    }
    private boolean validPassword(String password) { //Checks if a password is secure
        boolean containsNumber = false;
        boolean containsSymbol = false;
        boolean containsUpper = false;
        boolean containsLower = false;
        for (char n : password.toCharArray()) {
            if (Character.isDigit(n)) {
                containsNumber = true;
            } else if (Character.isUpperCase(n)) {
                containsUpper = true;
            } else if (Character.isLowerCase(n)) {
                containsLower = true;
            } else {
                containsSymbol = true;
            }
            if (containsNumber && containsSymbol && containsUpper && containsLower){
                break;
            }
        }
        return (password.length() > 8 && containsNumber && containsSymbol && containsUpper && containsLower);

    }
}
