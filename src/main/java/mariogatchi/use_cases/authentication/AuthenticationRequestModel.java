package mariogatchi.use_cases.authentication;

public class AuthenticationRequestModel {
    private String username = new String();
    private String password = new String();
    private AuthActions type;

    public enum AuthActions {
        LOGIN,
        SIGNUP,
    }

    public AuthenticationRequestModel(String username, String password, AuthActions type) {
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public AuthActions getType() {
        return this.type;
    }

    public String getUsername () {
        return this.username;
        }

    public String getPassword () {
        return this.password;
    }

}
