package mariogatchi.use_cases.authentication;

/**
 * The request model for Authentication Requests
 */
public class AuthenticationRequestModel {
    private final String USERNAME;
    private final String PASSWORD ;
    private final AuthActions TYPE;

    public enum AuthActions {
        LOGIN,
        SIGNUP,
    }
    /**
     The input data needed for the Authentication use case
     @param username - the username input
     @param password - the password input
     @param type - Whether it's a Signup or Login request
     */
    public AuthenticationRequestModel(String username, String password, AuthActions type) {
        this.USERNAME = username;
        this.PASSWORD = password;
        this.TYPE = type;
    }

    public AuthActions getType() {
        return this.TYPE;
    }

    public String getUSERNAME() {
        return this.USERNAME;
        }

    public String getPassword () {
        return this.PASSWORD;
    }

}
