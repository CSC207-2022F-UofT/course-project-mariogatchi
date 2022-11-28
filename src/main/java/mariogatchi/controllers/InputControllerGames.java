package mariogatchi.controllers;

import mariogatchi.use_cases.authentication.AuthenticatorRunner;
import mariogatchi.use_cases.games.GameInteractor;

import java.util.List;

public class InputControllerGames {

    public enum GamesActions {
        LOGOUT,
        DELETE_ACCOUNT,
        CREATE_GAME,
        LOAD_GAME,
        DELETE_GAME
    }

    public void request(GamesActions action, List<String> inputs) {
        AuthenticatorRunner auth = new AuthenticatorRunner();
        GameInteractor game = new GameInteractor();
        switch(action) {
            case LOGOUT:
                auth.logoutRequest();
                break;
            case DELETE_ACCOUNT:
                auth.deleteRequest();
                break;
            case CREATE_GAME:
                game.createRequest(inputs.get(0));
                break;
            case LOAD_GAME:
                game.loadRequest(inputs.get(0));
            case DELETE_GAME:
                game.deleteRequest(inputs.get(0));
            default:
                // error
        }
    }
}
