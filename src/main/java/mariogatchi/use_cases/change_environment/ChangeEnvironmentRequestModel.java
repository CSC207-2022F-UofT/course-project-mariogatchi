package mariogatchi.use_cases.change_environment;

import mariogatchi.entities.Environment;
import mariogatchi.entities.User;

public class ChangeEnvironmentRequestModel{
    private final User USER; // the user who wants to change their environment
    private final String ENVIRONMENTINPUT; // the input of the user, taken as a string
    private final Environment CURRENVIRONMENT; // the users current in-game environment, pulled from the user class using user.environment

    /**
     * Request model (input data) for the ChangeEnvironment use case.
     * @param user The user whose environment we want to change
     * @param environmentInput The environment the user wants to go to
     */

    // constructor
    public ChangeEnvironmentRequestModel(User user, String environmentInput) {
        this.USER = user;
        this.ENVIRONMENTINPUT = environmentInput;
        this.CURRENVIRONMENT = user.getEnvironment();
    }

    // getter function for the user, return user
    public User getUser() {
        return USER;
    }

    // getter for user environment input, return environmentInput
    public String getEnvironmentInput(){
        return ENVIRONMENTINPUT;
    }

    // getter for current user in-game environment
    public Environment getCurrEnvironment(){
        return CURRENVIRONMENT;
    }

    // getter for the current user in-game environment as a string
    public String getCurrEnvironmentString() {
        return CURRENVIRONMENT.getName();
    }
}
