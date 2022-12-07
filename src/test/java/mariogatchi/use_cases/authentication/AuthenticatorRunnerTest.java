package mariogatchi.use_cases.authentication;

import mariogatchi.controllers.InputController;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticatorRunnerTest {

    private static AuthenticationPresenter AUTHENTICATION_PRESENTER_BLANK;


    @Test
    void authenticationRequestSignupRequest() {
        AuthenticationPresenter AUTHENTICATION_PRESENTER = new AuthenticationPresenter() {
            @Override
            public AuthenticationResponseModel prepareLoginSuccess(AuthenticationResponseModel responseModel) {
                assertEquals(responseModel.getMessage(),"Signed up and Logged in");
                return null;
            }

            @Override
            public AuthenticationResponseModel prepareLoginFailure(AuthenticationResponseModel responseModel) {
                return null;
            }
        };

        AuthenticatorRunner auth = new AuthenticatorRunner(AUTHENTICATION_PRESENTER);
        AuthenticationRequestModel signupReq = new AuthenticationRequestModel("test", "Abc1234*", AuthenticationRequestModel.AuthActions.SIGNUP);
        auth.setCurrAccount(auth.authenticationRequest(signupReq).getAccount());


    }

    @Test
    void deleteRequest() {
    }

    @Test
    void authenticationRequest() {
    }
}