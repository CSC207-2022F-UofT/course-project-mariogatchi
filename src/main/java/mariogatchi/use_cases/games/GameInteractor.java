package mariogatchi.use_cases.games;

import mariogatchi.data_access.DataAccess;
import mariogatchi.entities.Account;
import mariogatchi.entities.Inventory;
import mariogatchi.entities.User;
import mariogatchi.entities.items.Apple;
import mariogatchi.entities.items.Item;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameInteractor implements GameInputBoundary{

    private final Apple APPLE = new Apple();
    private final Map<Item.Items, Integer> DEFAULT_ITENS = Map.of(APPLE.getName(), 1);

    private final Inventory DEFAULT_INVENTORY = new Inventory(DEFAULT_ITENS, 100); // Needs work

    @Override
    public void createRequest(String name) {
        DataAccess data = new DataAccess();
        Serializable serializedAccount = data.loadObject("current\\account.ser"); // Loads the current account
        Account account = (Account) serializedAccount;
        List<User> users = account.getUsers(); // Gets the games in the account
        List<String> names = new ArrayList<>();
        for (User u: users) {
            names.add(u.getName());
        }
        if (names.contains(name)) {
            // Return a game with this name already exists message using the alert boundary
        } else {
            User user = new User(name);
            user.setInventory(DEFAULT_INVENTORY); // Adds the reusable items to the users inventory
            account.addUserInstance(user); // Adds the game to the account
            String username = account.getUsername();
            data.saveObject("current\\account.ser", account); // saves the account to current
            data.saveObject("data\\" + username + ".ser", account); // saves the account to data
        }
    }

    @Override
    public void loadRequest(String name) {
        boolean user_exists = false;
        DataAccess data = new DataAccess();
        Serializable serializedAccount = data.loadObject("current\\account.ser"); // Loads the current account
        Account account = (Account) serializedAccount;
        List<User> users = account.getUsers(); // Gets the games in the account
        for (User u: users) {
            if (u.getName().equals(name)) {
                data.saveObject("current\\user.ser", u); // Saves the user to current
                // Use the output boundary to create the game instance with the given user
                user_exists = true;
                break;
            }
        }
        if (!(user_exists)) {
            // return a game does not exist message, this should never happen
        }
    }

    @Override
    public void saveRequest() {
        DataAccess data = new DataAccess();
        Serializable serializedAccount = data.loadObject("current\\account.ser"); // loads the account from the file
        Account account = (Account) serializedAccount;
        String username = account.getUsername();
        data.saveObject("current\\account.ser", account); // saves the account to current
        data.saveObject("data\\" + username + ".ser", account); // saves the account to data
    }

    @Override
    public void exitRequest() {
        saveRequest();
        DataAccess data = new DataAccess();
        File current_user = data.loadFile("current\\user.ser"); // find the file
        if (data.deleteFile(current_user)) { // deletes the account from current
            // return to the games screen by calling a method from output boundary
        } else {
            // this case should never happen, but if it does there is a problem
        }
    }

    @Override
    public void deleteRequest(String name) {
        DataAccess data = new DataAccess();
        Serializable serializedAccount = data.loadObject("current\\account.ser"); // Loads the current account
        Account account = (Account) serializedAccount;
        List<User> users = account.getUsers(); // Gets the games in the account
        for (User u: users) {
            if (u.getName().equals(name)) {
                account.delUser(u); // delete the user
                data.saveObject("current\\account.ser", account); // saves the account to current
                // Use the alert boundary to notify the user the games been deleted
                break;
            }
        }
    }
}
