package mariogatchi;

import java.io.File;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AuthenticatorRunner implements AuthInputBoundary{
    private final Charset CHARS = StandardCharsets.UTF_8;
    private final String HASHTYPE = "SHA-256";

    @Override
    public void loginRequest(String username, String password) {
        //DisplayPresenter display = new DisplayPresenter();
        if (!(uniqueUsername(username))) { // Checks if the username doesn't exist
            DataAccess data = new DataAccess();
            Serializable serializedAccount = data.loadObject("data\\" + username + ".ser"); // Loads the account from data
            Account account = (Account) serializedAccount;
            if (Arrays.equals(account.getHashedPassword(), hasher(password, HASHTYPE))) { // Checks if the password is correct
                // then login by calling a method from output boundary
                //display.updateLoginState(true, "logged In");
                data.saveObject("current\\account.ser", account);
            } else {
                //return a wrong password message by calling a method from alert boundary
                //display.updateLoginState(false, "Wrong Password");
            }
        } else {
            // return an account does not exist message by calling a method from alert boundary
            //display.updateLoginState(false, "Account Does Not Exist");
        }
    }
    @Override
    public void signupRequest(String username, String password) {
        //DisplayPresenter display = new DisplayPresenter();
        if (uniqueUsername(username)) {
            if (validPassword(password)) {
                DataAccess data = new DataAccess();
                Account account = new Account(username, hasher(password, HASHTYPE));
                data.saveObject("data\\" + username + ".ser", account); // saves the account
                data.saveObject("current\\account.ser", account); // saves the account to current
                // return a saved account and login by calling a method from alert boundary
                //display.updateLoginState(true, "Signup Up and Logged In");

            } else {
                // return an invalid password message to the user by calling a method from alert boundary
                //display.updateLoginState(false, "Password Must Contain an Uppercase, a Lowercase, a Number and a Symbol");
            }
        } else {
            // return an invalid username message to the user by calling a method from alert boundary
            //display.updateLoginState(false, "Username is Already In Use");
        }
    }
    @Override
    public void logoutRequest() {
        DataAccess data = new DataAccess();
        File current_account = data.loadFile("current\\account.ser"); // find the file
        Serializable serializedAccount = data.loadObject("current\\account.ser"); // loads the account from the file
        Account account = (Account) serializedAccount;
        String username = account.getUsername();
        data.saveObject("data\\" + username + ".ser", account); // saves the account to data
        if (data.deleteFile(current_account)) { // deletes the account from current
            // return to the login screen by calling a method from output boundary
        } else {
            // this case should never happen, but if it does there is a problem
        }
    }

    @Override
    public void deleteRequest() {
        DataAccess data = new DataAccess();
        File account_current_file = data.loadFile( "current\\account.ser"); // loads the current account file
        Serializable serializedAccount = data.loadObject("current\\account.ser"); // loads the logged in account
        Account account = (Account) serializedAccount;
        String username = account.getUsername();
        File account_data_file = data.loadFile("data\\" + username + ".ser"); // Loads the data account file

        if (data.deleteFile(account_current_file)) { // deletes the current account file
            // return to the login screen by calling a method from output boundary
        } else {
            // this case should never happen, but if it does there is a problem
        }

        if (data.deleteFile(account_data_file)) { // deletes the data account file
            // return an account deleted message by calling a method from alert boundary
        } else {
            // this case should never happen, but if it does there is a problem
        }
    }
    private boolean validPassword(String password) { // Checks if a password is secure
        boolean containsNumber = false;
        boolean containsSymbol = false;
        boolean containsUpper = false;
        boolean containsLower = false;
        for (char n : password.toCharArray()) {
            if (Character.isDigit(n)) { // Checks if a password contains a number
                containsNumber = true;
            } else if (Character.isUpperCase(n)) { // Checks if a password contains a uppercase
                containsUpper = true;
            } else if (Character.isLowerCase(n)) { // Checks if a password contains a lowercase
                containsLower = true;
            } else { // Checks if a password contains a symbol
                containsSymbol = true;
            }
            if (containsNumber && containsSymbol && containsUpper && containsLower){ // early loop exit
                break;
            }
        }
        return (password.length() > 8 && containsNumber && containsSymbol && containsUpper && containsLower); // returns if all are true

    }
    private boolean uniqueUsername(String username) { // Checks whether a given username is unique
        DataAccess data = new DataAccess();
        File folder = data.loadFile("data\\"); // Loads the data folder
        File[] listOfFiles = folder.listFiles(); // Creates a list of files
        List<String> names = new ArrayList<>(); // Creates an empty list of names
        if (listOfFiles != null) { // if the data folder is not empty
            for (File file : listOfFiles) { // iterates through the files
                if (file.isFile()) {
                    names.add(file.getName().substring(0, file.getName().length() - 4)); // gets the name of the file without the extension and adds it to the list of names
                }
            }
            return !(names.contains(username)); // returns if the username is unique
        }
        return true;

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
