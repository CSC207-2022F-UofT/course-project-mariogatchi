package mariogatchi.use_cases.change_environment;

import mariogatchi.entities.environments.Environment;
import mariogatchi.entities.environments.Env;
import mariogatchi.entities.User;

public class ChangeEnvironmentRequestModel{
    private final User USER;
    private final Env CURR_ENVIRONMENT;
    private final Env NEWENVIRONMENT;

    /**
     * Request model (input data) for the ChangeEnvironment use case.
     * @param user The user whose environment we want to change
     * @param environmentInput The environment the user wants to go to
     */

    // constructor
    public ChangeEnvironmentRequestModel(User user, String environmentInput) {
        EnvironmentFactory environmentFactory = new EnvironmentFactory();
        this.USER = user;
        this.CURR_ENVIRONMENT = user.getEnvironment().getName();
        this.NEWENVIRONMENT = environmentFactory.getName(environmentInput).getName();
    }

    // getter function for the user, return user
    public User getUser() {
        return USER;
    }

    // getter for user environment input, return environmentInput
    public Env getEnvironmentInput(){
        return NEWENVIRONMENT;
    }

    // getter for current user in-game environment
    public Env getCurrEnvironment(){
        return CURR_ENVIRONMENT;
    }

    public Environment getEnvironmentInputEnvironment(){
        if (NEWENVIRONMENT.equals(Env.HOME)){
            return new Environment(Env.HOME) {};
        } else if (NEWENVIRONMENT.equals(Env.PARK)) {
            return new Environment(Env.PARK) {};
        } else {
            return new Environment(Env.FOREST) {};
        }
    }

}
