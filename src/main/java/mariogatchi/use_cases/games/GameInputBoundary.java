package mariogatchi.use_cases.games;

import mariogatchi.entities.Account;
import mariogatchi.entities.User;
import mariogatchi.use_cases.authentication.AuthenticationResponseModel;

/**
 * Contains the abstract methods for Game related requests
 */
public interface GameInputBoundary {

    void saveRequest(Account account, User user);

    GameResponseModel exitRequest(Account account, User user);

    AuthenticationResponseModel requestAuth(GameRequestModel game, Account account);

    GameResponseModel requestGame(GameRequestModel game, Account account);
}
