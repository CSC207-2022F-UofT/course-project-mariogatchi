package mariogatchi.use_cases.change_environment;

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
        String lowerEnvironment = environmentRequestModel.getEnvironmentInput().toLowerCase(); // lowerEnvironment is the input of the user as a lower case string
        if (isSame(environmentRequestModel)){ // checks to see whether the user is already in the environment they which to change to
            return ENVIRONMENTPRESENTER.prepareFailView("Cannot change environment: You are already in that environment!"); // sends error message to FailView
        } else if (isLegalEnvironment(environmentRequestModel)) { // checks to see whether the input is a valid environment
            environmentRequestModel.getUser().setCurrentEnvironment(lowerEnvironment); // changing the environment of the user by using the request model user and user input
            ChangeEnvironmentResponseModel environmentResponseModel = new ChangeEnvironmentResponseModel(environmentRequestModel.getUser().getCurrentEnvironment()); // use the request models changed environment as the new environment for the response model
            return ENVIRONMENTPRESENTER.prepareSuccessView(environmentResponseModel); // the environment was changed, SuccessView
        } else { // the environment is not a valid environment input
            return ENVIRONMENTPRESENTER.prepareFailView("Cannot change environment: That is not a valid environment input!"); // sends error message to FailView
        }
    }

    // check to see weather the user is already in the environment they want to change to (given the information from the request model), return whether input = current environment
    private boolean isSame(ChangeEnvironmentRequestModel environmentRequestModel){
        return environmentRequestModel.getEnvironmentInput().equalsIgnoreCase(environmentRequestModel.getCurrEnvironmentString());
    }

    // check to see weather the users environment input is an environment that exists (given the information from the request model), return whether input = park or home or forest
    private boolean isLegalEnvironment(ChangeEnvironmentRequestModel environmentRequestModel){
        String lower = environmentRequestModel.getEnvironmentInput();
        return lower.equalsIgnoreCase("park") || lower.equalsIgnoreCase("home") || lower.equalsIgnoreCase("forest");
    }
}
