package Mariogatchi;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class AuthenticatorRunner {
    private final Charset CHARS = StandardCharsets.UTF_8;
    private final String HASHTYPE = "SHA-256";

    private void checkLoginInfo(String username, String password) { //checks if login info is valid and logs in
        Serializer srl = new Serializer();
        Serializable serializedAccount = srl.load(username + ".ser");
        Account account = (Account) serializedAccount;
        if (Arrays.equals(account.getHashedPassword(), hasher(password, HASHTYPE))) {
            // then login
        } else {
            //return a wrong password message
        }
    }

    private void saveSignupInfo(String username, String password) { //saves a new signup
        if (validPassword(password)) {
            Serializer srl = new Serializer();
            srl.save(username + ".ser", new Account(username, hasher(password, HASHTYPE)));
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

    private byte[] hasher(final String txt, final String hashType){
        MessageDigest digest;
        byte[] encodedHash = null;
        try{
            digest = MessageDigest.getInstance(hashType);
            encodedHash = digest.digest(txt.getBytes(CHARS));
        }catch(NoSuchAlgorithmException e){
            System.out.println(e.getMessage());
        }
        return encodedHash;
    }
}
