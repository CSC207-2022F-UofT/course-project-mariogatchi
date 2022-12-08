package mariogatchi.use_cases.games;

import mariogatchi.entities.Account;
import mariogatchi.entities.User;
import mariogatchi.entities.environments.Home;
import mariogatchi.use_cases.authentication.AuthenticationPresenter;
import mariogatchi.use_cases.authentication.AuthenticationResponseModel;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class GameInteractorRunnerTest {
    Account account;

    @Before
    public void setup() {
        this.account = new Account("username", "Password1*".getBytes());
    }

    @Test
    void gameInteractorCreateLoadExitDeleteRequest() {

        AuthenticationPresenter authenticationPresenter = new AuthenticationPresenter() {

            @Override
            public AuthenticationResponseModel prepareLoginSuccess(AuthenticationResponseModel responseModel) {
                assertTrue(Objects.equals(responseModel.getMessage(), "Game Created")
                        | Objects.equals(responseModel.getMessage(), "Game Deleted") |
                        Objects.equals(responseModel.getMessage(), "Game already exists"));
                return null;
            }

            @Override
            public AuthenticationResponseModel prepareLoginFailure(AuthenticationResponseModel responseModel) {
                return null;
            }
        };
        GamePresenter gamePresenter = new GamePresenter() {
            @Override
            public GameResponseModel prepareExitGame(GameResponseModel responseModel) {
                assertEquals(responseModel.getMessage(), "exited game");
                return null;
            }

            @Override
            public GameResponseModel prepareLoadGame(GameResponseModel responseModel) {
                assertEquals(responseModel.getMessage(),  "Loaded game");
                return null;
            }
        };
        User user = null;
        GameInteractor game = new GameInteractor(authenticationPresenter, gamePresenter);
        GameRequestModel createReq = new GameRequestModel("GameTest", GameRequestModel.GameActions.CREATE);
        game.requestAuth(createReq, account);
        game.requestAuth(createReq, account); // Duplicate account gets rejected.
        List<User> users = account.getUsers(); // Gets the games in the account
        for (User u: users) {
            if (u.getName().equals("GameTest")) {
                user = u;
                u.setCurrentEnvironment(new Home());
                account.delUser(u);
            }
        }

        GameRequestModel loadReq = new GameRequestModel("GameTest", GameRequestModel.GameActions.LOAD);
        game.requestGame(loadReq, account);
        game.saveRequest(account, user);
        game.exitRequest(account, user);
        GameRequestModel deleteReq = new GameRequestModel("GameTest", GameRequestModel.GameActions.DELETE);
        game.requestAuth(deleteReq, account);
    }
}

