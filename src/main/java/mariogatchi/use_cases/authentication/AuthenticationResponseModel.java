package mariogatchi.use_cases.authentication;

import mariogatchi.entities.Account;

public class AuthenticationResponseModel {
    private Account account;

    private String message;

    public AuthenticationResponseModel(Account account, String message){
        this.account = account;
        this.message = message;

    }

    public Account getAccount() {
        return this.account;
    }

    public String getMessage() {
        return this.message;
    }
}
