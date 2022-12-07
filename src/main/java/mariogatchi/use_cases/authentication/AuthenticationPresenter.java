package mariogatchi.use_cases.authentication;

public interface AuthenticationPresenter {

    AuthenticationResponseModel prepareLoginSuccess(AuthenticationResponseModel responseModel);

    AuthenticationResponseModel prepareLoginFailure(AuthenticationResponseModel responseModel);
}
