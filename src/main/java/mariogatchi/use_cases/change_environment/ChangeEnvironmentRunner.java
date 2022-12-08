package mariogatchi.use_cases.change_environment;
import mariogatchi.entities.environments.Env;
import mariogatchi.entities.environments.Environment;
import mariogatchi.entities.environments.EnvironmentFactory;

/**
 * ChangeEnvironmentRunner: implements input boundary and changes environment if possible
 */
public class ChangeEnvironmentRunner implements ChangeEnvironmentInputBoundary {
    private final ChangeEnvironmentOutputBoundary ENVIRONMENT_OUTPUT_BOUNDARY;

    /**
     * Constructs a runner
     * @param environmentOutputBoundary the output boundary the input boundary is connected to
     */
    public ChangeEnvironmentRunner(ChangeEnvironmentOutputBoundary environmentOutputBoundary) {
        this.ENVIRONMENT_OUTPUT_BOUNDARY = environmentOutputBoundary;
    }

    /**
     * Overrides response model creations
     * - If the user is currently in the environment they choose to go to, the environment is not changed. The current
     *   environment of the user is passed to the response model along with an error message.
     * - If the user chooses to go to an environment they are currently not in, by using an EnvironmentFactory, a new
     *   instance of that environment class is created and is set as the users current environment, the environment
     *   has changed. The environment in which the user is now in is passed to the response model.
     */
    @Override
    public ChangeEnvironmentResponseModel changeEnvironment(ChangeEnvironmentRequestModel environmentRequestModel) {
        if (isSame(environmentRequestModel)){
            Env currEnvironment = environmentRequestModel.getNewEnvironment();
            ChangeEnvironmentResponseModel environmentResponseModel = new ChangeEnvironmentResponseModel(currEnvironment);
            return ENVIRONMENT_OUTPUT_BOUNDARY.changeEnvPrepareFailureView
                    ("Cannot change environment: You are already in that environment!", environmentResponseModel);
        } else {
            EnvironmentFactory environmentFactory = new EnvironmentFactory();
            Environment newEnvironment = environmentFactory.getName(environmentRequestModel.getNEW_ENVIRONMENT());
                environmentRequestModel.getUser().setCurrentEnvironment(newEnvironment);
            Env changedEnvironment = environmentRequestModel.getUser().getCurrentEnvironment().getName();
            Environment newEnvironment = environmentFactory.getName(environmentRequestModel.getNewEnvironment());
                environmentRequestModel.getUser().setEnvironment(newEnvironment);
            Env changedEnvironment = environmentRequestModel.getUser().getEnvironment().getName();
            ChangeEnvironmentResponseModel environmentResponseModel = new ChangeEnvironmentResponseModel(changedEnvironment);
            return ENVIRONMENT_OUTPUT_BOUNDARY.changeEnvPrepareSuccessView(environmentResponseModel);
        }
    }

    /**
     * Returns whether the user is in the environment they want to go to
     * @return whether the user is in the environment they want to go to
     */
    private boolean isSame(ChangeEnvironmentRequestModel environmentRequestModel){
        return environmentRequestModel.getNewEnvironment().equals(environmentRequestModel.getCurrEnvironment());
    }
}
