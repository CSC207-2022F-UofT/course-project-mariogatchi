package mariogatchi.use_cases.change_environment;

/**
 * ChangeEnvironment Output Boundary: Interface for the changeEnvironment use case
 */
public interface ChangeEnvironmentOutputBoundary {
    /**
     * changeEnvPrepareSuccessView: the environment was successfully changed
     */
    ChangeEnvironmentResponseModel changeEnvPrepareSuccessView(ChangeEnvironmentResponseModel changeEnvironmentResponseModel);
    /**
     * changeEnvPrepareFailureView: the environment was not changed, there was an error
     */
    ChangeEnvironmentResponseModel changeEnvPrepareFailureView(String errorMessage, ChangeEnvironmentResponseModel changeEnvironmentResponseModel);
}
