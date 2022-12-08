package mariogatchi.use_cases.games;

import mariogatchi.entities.Account;
import mariogatchi.entities.User;
import mariogatchi.use_cases.authentication.AuthenticationResponseModel;

public interface GameInputBoundary {

    void saveRequest(Account account, User user);

    void exitRequest(Account account, User user);

    public AuthenticationResponseModel requestAuth(GameRequestModel game, Account account);

    public GameResponseModel requestGame(GameRequestModel game, Account account);
}
