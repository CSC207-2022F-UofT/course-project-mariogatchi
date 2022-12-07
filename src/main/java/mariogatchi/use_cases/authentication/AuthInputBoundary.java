package mariogatchi.use_cases.authentication;

import mariogatchi.entities.Account;
import mariogatchi.entities.Inventory;
import mariogatchi.entities.Statistics;
import mariogatchi.entities.User;
import mariogatchi.entities.environments.Environment;

public interface AuthInputBoundary {
     public AuthenticationResponseModel logoutRequest(Account account);

    public AuthenticationResponseModel deleteRequest(Account account);

    public AuthenticationResponseModel authenticationRequest(AuthenticationRequestModel requestModel);

    public Account getCurrAccount();

    public User getCurrUser();

    public void setCurrAccount(Account account);

    public void setCurrUser(User user);

    public Inventory getCurrUserInventory();

    public Environment getCurrUserEnvironment();

    public Statistics getCurrUserStatistics();
}
