package mariogatchi.use_cases.authentication;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticatorRunnerTest {

    @Test
    void authenticationSignupPasswordFailRequest() {
        AuthenticationPresenter AUTHENTICATION_PRESENTER = new AuthenticationPresenter() {
            @Override
            public AuthenticationResponseModel prepareLoginSuccess(AuthenticationResponseModel responseModel) {
                return null;
            }

            @Override
            public AuthenticationResponseModel prepareLoginFailure(AuthenticationResponseModel responseModel) {
                assertEquals(responseModel.getMessage(),"Password Must Contain an Uppercase, a Lowercase, a Number and a Symbol");
                return null;
            }
        };

        AuthenticatorRunner auth = new AuthenticatorRunner(AUTHENTICATION_PRESENTER);
        AuthenticationRequestModel signupReq = new AuthenticationRequestModel("test", "abc1234*", AuthenticationRequestModel.AuthActions.SIGNUP);
        auth.setCurrAccount(auth.authenticationRequest(signupReq).getAccount());
    }
    @Test
    void authenticationSignupRequest() {
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
    void authenticationSignupAccountFailRequest() {
        AuthenticationPresenter AUTHENTICATION_PRESENTER = new AuthenticationPresenter() {
            @Override
            public AuthenticationResponseModel prepareLoginSuccess(AuthenticationResponseModel responseModel) {
                return null;
            }

            @Override
            public AuthenticationResponseModel prepareLoginFailure(AuthenticationResponseModel responseModel) {
                assertEquals(responseModel.getMessage(),"Username is Already In Use");
                return null;
            }
        };

        AuthenticatorRunner auth = new AuthenticatorRunner(AUTHENTICATION_PRESENTER);
        AuthenticationRequestModel signupReq = new AuthenticationRequestModel("test", "Abc1234*", AuthenticationRequestModel.AuthActions.SIGNUP);
        auth.setCurrAccount(auth.authenticationRequest(signupReq).getAccount());


    }

    @Test
    void authenticationLoginPasswordFailRequest() {
        AuthenticationPresenter AUTHENTICATION_PRESENTER = new AuthenticationPresenter() {
            @Override
            public AuthenticationResponseModel prepareLoginSuccess(AuthenticationResponseModel responseModel) {
                assertEquals(responseModel.getMessage(),"Wrong Password");
                return null;
            }

            @Override
            public AuthenticationResponseModel prepareLoginFailure(AuthenticationResponseModel responseModel) {
                return null;
            }
        };

        AuthenticatorRunner auth = new AuthenticatorRunner(AUTHENTICATION_PRESENTER);
        AuthenticationRequestModel loginReq = new AuthenticationRequestModel("test", "AbC1234*", AuthenticationRequestModel.AuthActions.LOGIN);
        auth.setCurrAccount(auth.authenticationRequest(loginReq).getAccount());
    }

    @Test
    void authenticationLoginAccountFailRequest() {
        AuthenticationPresenter AUTHENTICATION_PRESENTER = new AuthenticationPresenter() {
            @Override
            public AuthenticationResponseModel prepareLoginSuccess(AuthenticationResponseModel responseModel) {
                assertEquals(responseModel.getMessage(),"Account Does not Exist");
                return null;
            }

            @Override
            public AuthenticationResponseModel prepareLoginFailure(AuthenticationResponseModel responseModel) {
                return null;
            }
        };

        AuthenticatorRunner auth = new AuthenticatorRunner(AUTHENTICATION_PRESENTER);
        AuthenticationRequestModel loginReq = new AuthenticationRequestModel("test1", "Abc1234*", AuthenticationRequestModel.AuthActions.LOGIN);
        auth.setCurrAccount(auth.authenticationRequest(loginReq).getAccount());
    }

    @Test
    void authenticationLoginLogoutRequest() {
        AuthenticationPresenter AUTHENTICATION_PRESENTER = new AuthenticationPresenter() {
            @Override
            public AuthenticationResponseModel prepareLoginSuccess(AuthenticationResponseModel responseModel) {
                assertEquals(responseModel.getMessage(),"logged in");
                return null;
            }

            @Override
            public AuthenticationResponseModel prepareLoginFailure(AuthenticationResponseModel responseModel) {
                assertEquals(responseModel.getMessage(),"Logged out");
                return null;
            }
        };

        AuthenticatorRunner auth = new AuthenticatorRunner(AUTHENTICATION_PRESENTER);
        AuthenticationRequestModel loginReq = new AuthenticationRequestModel("test", "Abc1234*", AuthenticationRequestModel.AuthActions.LOGIN);
        auth.setCurrAccount(auth.authenticationRequest(loginReq).getAccount());
        auth.logoutRequest(auth.getCurrAccount());
    }

    @Test
    void authenticationLoginDeleteRequest() {
        AuthenticationPresenter AUTHENTICATION_PRESENTER = new AuthenticationPresenter() {
            @Override
            public AuthenticationResponseModel prepareLoginSuccess(AuthenticationResponseModel responseModel) {
                assertEquals(responseModel.getMessage(),"logged in");
                return null;
            }

            @Override
            public AuthenticationResponseModel prepareLoginFailure(AuthenticationResponseModel responseModel) {
                assertEquals(responseModel.getMessage(),"Logged out and deleted account");
                return null;
            }
        };

        AuthenticatorRunner auth = new AuthenticatorRunner(AUTHENTICATION_PRESENTER);
        AuthenticationRequestModel loginReq = new AuthenticationRequestModel("test", "Abc1234*", AuthenticationRequestModel.AuthActions.LOGIN);
        auth.setCurrAccount(auth.authenticationRequest(loginReq).getAccount());
        auth.deleteRequest(auth.getCurrAccount());
    }
}
