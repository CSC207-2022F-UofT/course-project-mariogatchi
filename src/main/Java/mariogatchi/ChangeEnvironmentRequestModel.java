package mariogatchi;

public class ChangeEnvironmentRequestModel{
    private final User user; // the user who wants to change their environment
    private final String environmentInput; // the input of the user, taken as a string
    private final Environment currEnvironment; // the users current in-game environment, pulled from the user class using user.environment

    /**
     * Request model (input data) for the ChangeEnvironment use case.
     * @param user The user whose environment we want to change
     * @param environmentInput The environment the user wants to go to
     */

    // constructor
    public ChangeEnvironmentRequestModel(User user, String environmentInput) {
        this.user = user;
        this.environmentInput = environmentInput;
        this.currEnvironment = user.getEnvironment();
    }

    // getter function for the user, return user
    public User getUser() {
        return user;
    }

    // getter for user environment input, return environmentInput
    public String getEnvironmentInput(){
        return environmentInput;
    }

    // getter for current user in-game environment
    public Environment getCurrEnvironment(){
        return currEnvironment;
    }

    // check to see weather the user is already in the environment they want to change to, return whether input = current environment
    public boolean isSame(){
        return environmentInput.equalsIgnoreCase(currEnvironment.getName()); // comparing whether the environment is the same as the name of the current environment
    }

    // check to see weather the users environment input is an environment that exists, return whether input = park or home or forest
    public boolean isLegalEnvironment(){
        return environmentInput.equalsIgnoreCase("park") || environmentInput.equalsIgnoreCase("home") || environmentInput.equalsIgnoreCase("forest");
    }
}
