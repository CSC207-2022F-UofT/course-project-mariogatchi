package mariogatchi.controllers;

import mariogatchi.use_cases.authentication.AuthenticatorRunner;

import java.util.List;

public class InputControllerLogin {

    public enum LoginActions {
        LOGIN,
        SIGNUP,
        EXIT;
    }

    public void request(LoginActions action, List<String> inputs) {
        AuthenticatorRunner auth = new AuthenticatorRunner();
        switch(action) {
            case LOGIN:
                auth.loginRequest(inputs.get(0), inputs.get(1));
                break;
            case SIGNUP:
                auth.signupRequest(inputs.get(0), inputs.get(1));
                break;
            case EXIT:
                System.exit(0);
                break;
            default:
                // error
        }
    }
}
