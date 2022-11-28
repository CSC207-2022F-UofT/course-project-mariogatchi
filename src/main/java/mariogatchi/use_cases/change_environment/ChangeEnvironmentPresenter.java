package mariogatchi.use_cases.change_environment;

public interface ChangeEnvironmentPresenter {
    /*
     * Interface for the ChangeEnvironment use case Output Boundary
     */

    // SuccessView for when we are able to successfully change the environment, the input to environmentResponseModel()
    // should be the changed environment.
    ChangeEnvironmentResponseModel prepareSuccessView(ChangeEnvironmentResponseModel environmentResponseModel);

    // FailView for when we are unable to change the environment, the string errorMessage is the message that is relayed
    // to the user as the cause of why we were unable to change the environment.
    ChangeEnvironmentResponseModel prepareFailView(String errorMessage);
}
