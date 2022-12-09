package mariogatchi.use_cases.authentication;

import mariogatchi.entities.Account;

/**
 * The response model for authentication requests
 */
public class AuthenticationResponseModel {
    private final Account ACCOUNT;
    private final String MESSAGE;

    /**
     *
     * @param account The account returned by logging in or signing up
     * @param message The message for testing and presenting
     */
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
