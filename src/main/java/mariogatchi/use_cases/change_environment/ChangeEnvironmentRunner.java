package mariogatchi.use_cases.change_environment;
import mariogatchi.entities.environments.Env;
import mariogatchi.entities.environments.Environment;

public class ChangeEnvironmentRunner implements ChangeEnvironmentInputBoundary {
    private final ChangeEnvironmentPresenter ENVIRONMENTPRESENTER; // presenter

    /**
     * Request model (input data) for the ChangeEnvironment use case.
     *
     * @param environmentPresenter The implementing class object of the Output Boundary for this Use Case Interactor
     */

    public ChangeEnvironmentRunner(ChangeEnvironmentPresenter environmentPresenter) {
        this.ENVIRONMENTPRESENTER = environmentPresenter;
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
            // checks to see whether the user is already in the environment they which to change to
            return ENVIRONMENTPRESENTER.prepareFailView("Cannot change environment: You are already in that environment!");
            // if the user is already in the environment they chose, send error message to FailView notifying them of this
        } else {
            // if the user has not selected the environment they are currently in, change the users environment
            Environment newEnvironment = environmentRequestModel.getEnvironmentInputEnvironment();
            // newEnvironment is the users environment input as an Environment
            environmentRequestModel.getUser().setEnvironment(newEnvironment);
            // set the users environment to be the input from the request model
            Env changedEnvironment = environmentRequestModel.getUser().getEnvironment().getName();
            // changedEnvironment is the users new environment (after the change) as an Env enum
            ChangeEnvironmentResponseModel environmentResponseModel = new ChangeEnvironmentResponseModel(changedEnvironment);
            // use the request models changed environment as the new environment for the response model
            return ENVIRONMENTPRESENTER.prepareSuccessView(environmentResponseModel);
            // the environment was changed, SuccessView
        }
    }

    // check to see weather the user is already in the environment they want to change to (given the information from the request model), return whether input = current environment
    private boolean isSame(ChangeEnvironmentRequestModel environmentRequestModel){
        return environmentRequestModel.getEnvironmentInput().equals(environmentRequestModel.getCurrEnvironment());
    }
}
