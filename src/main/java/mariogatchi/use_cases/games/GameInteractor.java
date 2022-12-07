package mariogatchi.use_cases.games;

import mariogatchi.data_access.DataAccess;
import mariogatchi.entities.Account;
import mariogatchi.entities.Inventory;
import mariogatchi.entities.User;
import mariogatchi.entities.environments.Forest;
import mariogatchi.entities.environments.Home;
import mariogatchi.entities.items.Apple;
import mariogatchi.entities.items.Item;
import mariogatchi.use_cases.authentication.AuthenticationPresenter;
import mariogatchi.use_cases.authentication.AuthenticationResponseModel;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameInteractor implements GameInputBoundary{

    private final Apple APPLE = new Apple();
    private final Map<Item.Items, Integer> DEFAULT_ITENS = Map.of(APPLE.getName(), 1);

    private final Inventory DEFAULT_INVENTORY = new Inventory(DEFAULT_ITENS, 100); // Needs work
    private final AuthenticationPresenter authPresenter;

    private final GamePresenter gamePresenter;


    public GameInteractor(AuthenticationPresenter authPresenter, GamePresenter gamePresenter) {
        this.authPresenter = authPresenter;
        this.gamePresenter = gamePresenter;
    }

    @Override
    public void saveRequest(Account account, User user) {
        DataAccess data = new DataAccess();
        account.addUserInstance(user);
        String username = account.getUsername();
        data.saveObject("data\\" + username + ".ser", account); // saves the account to data
        account.delUser(user);
    }

    @Override
    public void exitRequest(Account account, User user) {
        saveRequest(account, user);
        account.addUserInstance(user);
        GameResponseModel response= new GameResponseModel(user, "exited game");
        gamePresenter.prepareExitGame(response);

    }

    @Override
    public AuthenticationResponseModel requestAuth(GameRequestModel game, Account account) {
        DataAccess data = new DataAccess();
        List<User> users = account.getUsers(); // Gets the games in the account
        String name = game.getName();
        switch(game.getType()) {
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

    @Override
    public GameResponseModel requestGame(GameRequestModel game, Account account) {
        String name = game.getName();
        boolean user_exists = false;
        DataAccess data = new DataAccess();
        List<User> users = account.getUsers(); // Gets the games in the account
        for (User u: users) {
            if (u.getName().equals(name)) {
                user_exists = true;
                u.setCurrentEnvironment(new Home());
                account.delUser(u);
                GameResponseModel response = new GameResponseModel(u, "Loaded game");
                return gamePresenter.prepareLoadGame(response);
            }
        }
        return null;
    }


}
