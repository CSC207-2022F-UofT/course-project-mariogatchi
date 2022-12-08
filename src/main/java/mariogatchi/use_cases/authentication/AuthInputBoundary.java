package mariogatchi.use_cases.authentication;

import mariogatchi.entities.*;
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

    public Mariogatchi getMariogatchiFromUser(String mariogatchiName);

    public Statistics getMariogatchiStatisticsFromUser(String mariogatchiName);
}
