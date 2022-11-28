package mariogatchi.use_cases.change_environment;

public interface ChangeEnvironmentInputBoundary{
   /*
    * Interface for the ChangeEnvironment use case Input Boundary
    */
    ChangeEnvironmentResponseModel environmentResponseModel(ChangeEnvironmentRequestModel environmentRequestModel);
}
