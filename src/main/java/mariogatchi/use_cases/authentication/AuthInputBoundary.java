package mariogatchi.use_cases.authentication;

import mariogatchi.entities.*;
import mariogatchi.entities.environments.Environment;

/**
 * Contains the abstract request methods and getter methods for the entity instances in AuthenticatorRunner
 */
public interface AuthInputBoundary {
    AuthenticationResponseModel logoutRequest(Account account);

    AuthenticationResponseModel deleteRequest(Account account);

    AuthenticationResponseModel authenticationRequest(AuthenticationRequestModel requestModel);

    Account getCurrAccount();

    User getCurrUser();

    void setCurrAccount(Account account);

    void setCurrUser(User user);

    Inventory getCurrUserInventory();

    Environment getCurrUserEnvironment();

    Mariogatchi getMariogatchiFromUser(String mariogatchiName);

    Mariogatchi getRandomMariogatchiFromUser();

    Statistics getMariogatchiStatisticsFromUser(String mariogatchiName);

    String getFriendCodeFromAccount();
}
