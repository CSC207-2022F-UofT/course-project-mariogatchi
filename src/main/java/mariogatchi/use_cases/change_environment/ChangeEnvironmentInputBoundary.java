package mariogatchi.use_cases.change_environment;

/**
 * ChangeEnvironment Input Boundary: Interface for the changeEnvironment use case
 */
public interface ChangeEnvironmentInputBoundary{
    /**
     * Create a response model given a request model
     */
    ChangeEnvironmentResponseModel changeEnvironment(ChangeEnvironmentRequestModel environmentRequestModel);
}
