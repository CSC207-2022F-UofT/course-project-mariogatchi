package mariogatchi.use_cases.games;

import mariogatchi.entities.Account;
import mariogatchi.entities.User;
import mariogatchi.use_cases.authentication.AuthenticationPresenter;
import mariogatchi.use_cases.authentication.AuthenticationResponseModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameInteractorRunnerTest {

    @Test
    void gameInteractorCreateLoadExitDeleteRequest() {

        AuthenticationPresenter authenticationPresenter = new AuthenticationPresenter() {

            @Override
            public AuthenticationResponseModel prepareLoginSuccess(AuthenticationResponseModel responseModel) {
                return responseModel;
            }

            @Override
            public AuthenticationResponseModel prepareLoginFailure(AuthenticationResponseModel responseModel) {
                return responseModel;
            }
        };
        GamePresenter gamePresenter = new GamePresenter() {
            @Override
            public GameResponseModel prepareExitGame(GameResponseModel responseModel) {
                return responseModel;
            }

            @Override
            public GameResponseModel prepareLoadGame(GameResponseModel responseModel) {
                return responseModel;
            }

            @Override
            public void enterGameFirst() {
                return;
            }
        };
        Account account = new Account("TestGame", "Password1*".getBytes(), "friendcode");
        User user = null;

        GameInteractor game = new GameInteractor(authenticationPresenter, gamePresenter);

        GameRequestModel createReq = new GameRequestModel("GameTest", GameRequestModel.GameActions.CREATE);
        AuthenticationResponseModel responseCreateSuccess = game.requestAuth(createReq, account);
        assertEquals("Game Created", responseCreateSuccess.getMessage());


        AuthenticationResponseModel responseCreateFail = game.requestAuth(createReq, account); // Duplicate account gets rejected.
        assertEquals("Game already exists", responseCreateFail.getMessage());


        for (User u : account.getUsers()) { // Gets the games in the account
            if (u.getName().equals("GameTest")) {
                user = u;

                break;
            }
        }


        GameRequestModel loadReq = new GameRequestModel("GameTest", GameRequestModel.GameActions.LOAD);
        GameResponseModel responseLoadSuccess = game.requestGame(loadReq, account);
        assertEquals("Loaded game", responseLoadSuccess.getMessage());

        game.saveRequest(account, user);

        GameResponseModel responseExitSuccess = game.exitRequest(account, user);
        assertEquals("exited game", responseExitSuccess.getMessage());

        GameRequestModel deleteReq = new GameRequestModel("GameTest", GameRequestModel.GameActions.DELETE);
        AuthenticationResponseModel responseDeleteSuccess = game.requestAuth(deleteReq, account);
        assertEquals("Game Deleted", responseDeleteSuccess.getMessage());

    }


}

