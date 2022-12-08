package mariogatchi.use_cases.authentication;

import com.harium.postgrest.Insert;
import mariogatchi.data_access.DataAccess;
import mariogatchi.entities.Account;
import mariogatchi.entities.Inventory;
import mariogatchi.entities.Statistics;
import mariogatchi.entities.User;
import mariogatchi.entities.environments.Environment;

import java.io.File;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class AuthenticatorRunner implements AuthInputBoundary{
    private final Charset CHARS = StandardCharsets.UTF_8;
    private final String HASHTYPE = "SHA-256";

    private final AuthenticationPresenter presenter;

    private Account currAccount = null;

    private User currUser = null;

    public AuthenticatorRunner(AuthenticationPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public AuthenticationResponseModel logoutRequest(Account account) {
        DataAccess data = new DataAccess();
        String username = account.getUsername();
        data.saveObject("data\\" + username + ".ser", account); // saves the account to data
        AuthenticationResponseModel response = new AuthenticationResponseModel(account, "Logged out");
        return presenter.prepareLoginFailure(response);
    }

    @Override
    public AuthenticationResponseModel deleteRequest(Account account) {
        DataAccess data = new DataAccess();
        String username = account.getUsername();
        File account_data_file = data.loadFile("data\\" + username + ".ser"); // Loads the data account file
        if (data.deleteFile(account_data_file)) { // deletes the data account file
            AuthenticationResponseModel response = new AuthenticationResponseModel(account, "Logged out and deleted account");
            return presenter.prepareLoginFailure(response);
        } else {
            // this case should never happen, but if it does there is a problem
        }
        return null;
    }

    @Override
    public AuthenticationResponseModel authenticationRequest(AuthenticationRequestModel requestModel) {
        String username = requestModel.getUsername();
        String password = requestModel.getPassword();
        switch (requestModel.getType()) {
            case LOGIN:
                //DisplayPresenter display = new DisplayPresenter();
                if (!(uniqueUsername(username))) { // Checks if the username doesn't exist
                    DataAccess data = new DataAccess();
                    Serializable serializedAccount = data.loadObject("data\\" + username + ".ser"); // Loads the account from data
                    Account account = (Account) serializedAccount;
                    if (Arrays.equals(account.getHashedPassword(), hasher(password, HASHTYPE))) { // Checks if the password is correct
                        // then login by calling a method from output boundary
                        AuthenticationResponseModel response = new AuthenticationResponseModel(account, "logged in");
                        return presenter.prepareLoginSuccess(response);
                        //display.updateLoginState(true, "logged In");

                    } else {
                        //return a wrong password message by calling a method from alert boundary
                        //display.updateLoginState(false, "Wrong Password");
                        AuthenticationResponseModel response = new AuthenticationResponseModel(null, "Wrong Password");
                        return presenter.prepareLoginFailure(response);
                    }
                } else {
                    // return an account does not exist message by calling a method from alert boundary
                    //display.updateLoginState(false, "Account Does Not Exist");
                    AuthenticationResponseModel response = new AuthenticationResponseModel(null, "Account Does not Exist");
                    return presenter.prepareLoginFailure(response);
                }

            case SIGNUP:
                //DisplayPresenter display = new DisplayPresenter();
                if (uniqueUsername(username)) {
                    if (validPassword(password)) {
                        DataAccess data = new DataAccess();
                        String randomFriendCode = UUID.randomUUID().toString();
                        Account account = new Account(username, hasher(password, HASHTYPE), randomFriendCode);
                        data.saveObject("data\\" + username + ".ser", account); // saves the account
                        data.insertDBRow("users", Insert.row().column("code", randomFriendCode));
                        // return a saved account and login by calling a method from alert boundary
                        AuthenticationResponseModel response = new AuthenticationResponseModel(account, "Signed up and Logged in");
                        return presenter.prepareLoginSuccess(response);
                        //display.updateLoginState(true, "Signup Up and Logged In");

                    } else {
                        // return an invalid password message to the user by calling a method from alert boundary
                        //display.updateLoginState(false, "Password Must Contain an Uppercase, a Lowercase, a Number and a Symbol");
                        AuthenticationResponseModel response = new AuthenticationResponseModel(null,
                                "Password Must Contain an Uppercase, a Lowercase, a Number and a Symbol");
                        return presenter.prepareLoginFailure(response);
                    }
                } else {
                    // return an invalid username message to the user by calling a method from alert boundary
                    //display.updateLoginState(false, "Username is Already In Use");
                    AuthenticationResponseModel response = new AuthenticationResponseModel(null, "Username is Already In Use");
                    return presenter.prepareLoginFailure(response);
                }
        }

        return null;
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

    @Override
    public Account getCurrAccount() {
        return this.currAccount;
    }

    @Override
    public User getCurrUser() {
        return this.currUser;
    }

    @Override
    public void setCurrAccount(Account account) {
        this.currAccount = account;
    }

    @Override
    public void setCurrUser(User user) {
        this.currUser = user;
    }

    @Override
    public Inventory getCurrUserInventory() {
        return this.currUser.getInventory();
    }

    @Override
    public Environment getCurrUserEnvironment() {
        return this.currUser.getCurrentEnvironment();
    }
    @Override
    public Statistics getCurrUserStatistics() {
        return this.currUser.getStatistics();
    }


}
