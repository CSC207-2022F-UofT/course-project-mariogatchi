package mariogatchi.use_cases.change_environment;
import mariogatchi.entities.environments.Env;
import mariogatchi.entities.environments.Environment;
import mariogatchi.entities.environments.EnvironmentFactory;

public class ChangeEnvironmentRunner implements ChangeEnvironmentInputBoundary {
    private final ChangeEnvironmentPresenter ENVIRONMENT_PRESENTER; // presenter

    /**
     * Request model (input data) for the ChangeEnvironment use case.
     *
     * @param environmentPresenter The implementing class object of the Output Boundary for this Use Case Interactor
     */

    public ChangeEnvironmentRunner(ChangeEnvironmentPresenter environmentPresenter) {
        this.ENVIRONMENT_PRESENTER = environmentPresenter;
    }

    /*
     * Checks weather the user input a valid environment, and if it is, checks weather the user is already in that
     * current environment. If the user is already in the environment the user wants to change to, notify the user,
     * otherwise change the environment of the user by creating a new instance of that environment and change
     * the user classes instance variable representing environment to the users input.
     */

    @Override
    public ChangeEnvironmentResponseModel environmentResponseModel(ChangeEnvironmentRequestModel environmentRequestModel) {
        if (isSame(environmentRequestModel)){
            return ENVIRONMENT_PRESENTER.prepareFailView("Cannot change environment: You are already in that environment!");
        } else {
            EnvironmentFactory environmentFactory = new EnvironmentFactory();
            Environment newEnvironment = environmentFactory.getName(environmentRequestModel.getNEW_ENVIRONMENT());
                environmentRequestModel.getUser().setEnvironment(newEnvironment);
            Env changedEnvironment = environmentRequestModel.getUser().getEnvironment().getName();
            ChangeEnvironmentResponseModel environmentResponseModel = new ChangeEnvironmentResponseModel(changedEnvironment);

            return ENVIRONMENT_PRESENTER.prepareSuccessView(environmentResponseModel);
        }
    }
    private boolean isSame(ChangeEnvironmentRequestModel environmentRequestModel){
        return environmentRequestModel.getNEW_ENVIRONMENT().equals(environmentRequestModel.getCURR_ENVIRONMENT());
    }
}
