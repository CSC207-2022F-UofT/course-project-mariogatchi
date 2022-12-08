package mariogatchi.use_cases.authentication;

import mariogatchi.entities.Account;

public class AuthenticationResponseModel {
    private final Account ACCOUNT;
    private final String MESSAGE;

    public AuthenticationResponseModel(Account account, String message){
        this.ACCOUNT = account;
        this.MESSAGE = message;
    }

    public Account getAccount() {
        return this.ACCOUNT;
    }

    public String getMessage() {
        return this.MESSAGE;
    }
}
