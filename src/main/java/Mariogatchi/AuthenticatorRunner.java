package Mariogatchi;

import java.io.Serializable;
import java.util.Arrays;

public class AuthenticatorRunner {

    private void checkLoginInfo(String username, String password) { //checks if login info is valid and logs in
        Serializer srl = new Serializer();
        Serializable serializedAccount = srl.load(username + ".ser");
        Account account = (Account) serializedAccount;
        if (Arrays.equals(account.getHashedPassword(), password.getBytes())) { // needs to unhash the password beforehand, filler code
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
            // return an error message to the user
        }
    }
    private boolean validPassword(String password) { //Checks if a password is secure
        boolean contains_number = false;
        boolean contains_symbol = false;
        boolean contains_upper = false;
        boolean contains_lower = false;
        for (char n : password.toCharArray()) {
            if (Character.isDigit(n)) {
                contains_number = true;
            } else if (Character.isUpperCase(n)) {
                contains_upper = true;
            } else if (Character.isLowerCase(n)) {
                contains_lower = true;
            } else {
                contains_symbol = true;
            }
            if (contains_number && contains_symbol && contains_upper && contains_lower){
                break;
            }
        }
        return (password.length() > 8 && contains_number && contains_symbol && contains_upper && contains_lower);

    }
}
