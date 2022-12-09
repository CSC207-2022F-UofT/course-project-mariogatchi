package mariogatchi.use_cases.authentication;



import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AuthenticatorRunnerTest {

    AuthenticationPresenter AUTHENTICATION_PRESENTER;

    @BeforeEach
    public void setup() {
            this.AUTHENTICATION_PRESENTER = new AuthenticationPresenter() {
                @Override
                public AuthenticationResponseModel prepareLoginSuccess(AuthenticationResponseModel responseModel) {
                    return responseModel;
                }

                @Override
                public AuthenticationResponseModel prepareLoginFailure(AuthenticationResponseModel responseModel) {
                    return responseModel;
                }
            };
    }

    @Test
    @Order(1)
    public void authenticationSignupPasswordFailRequest() {

        AuthenticatorRunner auth = new AuthenticatorRunner(AUTHENTICATION_PRESENTER);
        AuthenticationRequestModel signupReq = new AuthenticationRequestModel("test", "abc1234*", AuthenticationRequestModel.AuthActions.SIGNUP);
        AuthenticationResponseModel response = auth.authenticationRequest(signupReq);
        auth.setCurrAccount(response.getAccount());
        assertEquals("Password Must Contain an Uppercase, a Lowercase, a Number and a Symbol", response.getMessage());
    }
    @Test
    @Order(2)
    public void authenticationSignupRequest() {

        AuthenticatorRunner auth = new AuthenticatorRunner(AUTHENTICATION_PRESENTER);
        AuthenticationRequestModel signupReq = new AuthenticationRequestModel("test", "Abc1234*", AuthenticationRequestModel.AuthActions.SIGNUP);
        AuthenticationResponseModel response = auth.authenticationRequest(signupReq);
        auth.setCurrAccount(response.getAccount());
        assertEquals("Signed up and Logged in", response.getMessage());
    }

    @Test
    @Order(3)
    public void authenticationSignupAccountFailRequest() {

        AuthenticatorRunner auth = new AuthenticatorRunner(AUTHENTICATION_PRESENTER);
        AuthenticationRequestModel signupReq = new AuthenticationRequestModel("test", "Abc1234*", AuthenticationRequestModel.AuthActions.SIGNUP);
        AuthenticationResponseModel response = auth.authenticationRequest(signupReq);
        auth.setCurrAccount(response.getAccount());
        assertEquals("Username is Already In Use", response.getMessage());

    }

    @Test
    @Order(4)
    public void authenticationLoginPasswordFailRequest() {

        AuthenticatorRunner auth = new AuthenticatorRunner(AUTHENTICATION_PRESENTER);
        AuthenticationRequestModel loginReq = new AuthenticationRequestModel("test", "AbC1234*", AuthenticationRequestModel.AuthActions.LOGIN);
        AuthenticationResponseModel response = auth.authenticationRequest(loginReq);
        auth.setCurrAccount(response.getAccount());
        assertEquals("Wrong Password", response.getMessage());
    }

    @Test
    @Order(5)
    public void authenticationLoginAccountFailRequest() {

        AuthenticatorRunner auth = new AuthenticatorRunner(AUTHENTICATION_PRESENTER);
        AuthenticationRequestModel loginReq = new AuthenticationRequestModel("test1", "Abc1234*", AuthenticationRequestModel.AuthActions.LOGIN);
        AuthenticationResponseModel response = auth.authenticationRequest(loginReq);
        auth.setCurrAccount(response.getAccount());
        assertEquals("Account Does not Exist", response.getMessage());
    }

    @Test
    @Order(6)
    public void authenticationLoginLogoutRequest() {

        AuthenticatorRunner auth = new AuthenticatorRunner(AUTHENTICATION_PRESENTER);
        AuthenticationRequestModel loginReq = new AuthenticationRequestModel("test", "Abc1234*", AuthenticationRequestModel.AuthActions.LOGIN);
        auth.setCurrAccount(auth.authenticationRequest(loginReq).getAccount());
        AuthenticationResponseModel response = auth.logoutRequest(auth.getCurrAccount());
        assertEquals("Logged out",response.getMessage());
    }

    @Test
    @Order(7)
    public void authenticationLoginDeleteRequest() {

        AuthenticatorRunner auth = new AuthenticatorRunner(AUTHENTICATION_PRESENTER);
        AuthenticationRequestModel loginReq = new AuthenticationRequestModel("test", "Abc1234*", AuthenticationRequestModel.AuthActions.LOGIN);
        auth.setCurrAccount(auth.authenticationRequest(loginReq).getAccount());
        AuthenticationResponseModel response = auth.deleteRequest(auth.getCurrAccount());
        assertEquals("Logged out and deleted account", response.getMessage());
    }
}
