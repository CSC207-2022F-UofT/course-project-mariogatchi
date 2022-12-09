package mariogatchi.use_cases.games;

import mariogatchi.data_access.DataAccess;
import mariogatchi.entities.Account;
import mariogatchi.entities.Inventory;
import mariogatchi.entities.User;
import mariogatchi.entities.environments.Forest;
import mariogatchi.entities.items.Apple;
import mariogatchi.entities.items.Item;
import mariogatchi.use_cases.authentication.AuthenticationPresenter;
import mariogatchi.use_cases.authentication.AuthenticationResponseModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Used for handling all game related requests
 */
public class GameInteractor implements GameInputBoundary{

    private final Item APPLE = new Apple();

    /**
     * The default items that the user starts with
     */
    private final HashMap<Item.Items, Integer> DEFAULT_ITEMS = new HashMap<>() {{
        put(APPLE.getName(), 1);
    }};

    /**
     * The default inventory that the user starts with
     */
    private final Inventory DEFAULT_INVENTORY = new Inventory(DEFAULT_ITEMS, 100); // Needs work
    private final AuthenticationPresenter authPresenter;
    private final GamePresenter gamePresenter;


    /**
     * The main constructor for the class
     * @param authPresenter The presenter instance to be passed in
     * @param gamePresenter The presenter instance to be passed in
     */
    public GameInteractor(AuthenticationPresenter authPresenter, GamePresenter gamePresenter) {
        this.authPresenter = authPresenter;
        this.gamePresenter = gamePresenter;
    }

    /**
     * Used to save the currently loaded game
     * @param account the current loaded account
     * @param user the current loaded user
     */
    @Override
    public void saveRequest(Account account, User user) {
        DataAccess data = new DataAccess();
        account.addUserInstance(user);
        String username = account.getUsername();
        data.saveObject("data\\" + username + ".ser", account); // saves the account to data
        account.delUser(user);
    }

    /**
     * Used to save and exit the currently loaded game
     * @param account the current loaded account
     * @param user the current loaded user
     * @return The response model containing the user and message
     */
    @Override
    public GameResponseModel exitRequest(Account account, User user) {
        saveRequest(account, user);
        account.addUserInstance(user);
        GameResponseModel response= new GameResponseModel(user, "exited game");
        return gamePresenter.prepareExitGame(response);
    }

    /**
     * Used for Create and delete game requests
     * @param game The request model containing the input information
     * @param account The currently loaded account
     * @return The response model containing the user and message
     */
    @Override
    public AuthenticationResponseModel requestAuth(GameRequestModel game, Account account) {
        DataAccess data = new DataAccess();
        List<User> users = account.getUsers(); // Gets the games in the account
        String name = game.getNAME();
        switch(game.getTYPE()) {
            case CREATE:
                List<String> names = new ArrayList<>();
                for (User u : users) {
                    names.add(u.getName());
                }
                if (names.contains(name)) {
                    // Return a game with this name already exists message using the alert boundary
                    AuthenticationResponseModel response = new AuthenticationResponseModel(account, "Game already exists");
                    return authPresenter.prepareLoginSuccess(response);
                } else {
                    User user = new User(name);
                    user.setInventory(DEFAULT_INVENTORY); // Adds the reusable items to the users inventory
                    user.setCurrentEnvironment(new Forest());
                    account.addUserInstance(user); // Adds the game to the account
                    String username = account.getUsername();
                    data.saveObject("data\\" + username + ".ser", account); // saves the account to data
                    AuthenticationResponseModel response = new AuthenticationResponseModel(account, "Game Created");
                    return authPresenter.prepareLoginSuccess(response);
                }
            case DELETE:
                for (User u : users) {
                    if (u.getName().equals(name)) {
                        account.delUser(u); // delete the user
                        AuthenticationResponseModel response = new AuthenticationResponseModel(account, "Game Deleted");
                        return authPresenter.prepareLoginSuccess(response);
                    }
                }

        }
        return null;
    }

    /**
     * Used for game loading requests
     * @param game the name of the user to be loaded
     * @param account the currently loaded account
     * @return The response model containing the user and message.
     */
    @Override
    public GameResponseModel requestGame(GameRequestModel game, Account account) {
        String name = game.getNAME();
        for (User u : account.getUsers()) { // Gets the games in the account
            if (u.getName().equals(name)) {
                account.delUser(u);
                GameResponseModel response = new GameResponseModel(u, "Loaded game");
                return gamePresenter.prepareLoadGame(response);
            }
        }
        return null;
    }


}
