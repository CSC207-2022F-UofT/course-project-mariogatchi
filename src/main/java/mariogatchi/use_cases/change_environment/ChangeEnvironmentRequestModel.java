package mariogatchi.use_cases.change_environment;

import mariogatchi.entities.environments.Environment;
import mariogatchi.entities.environments.Env;
import mariogatchi.entities.User;
import mariogatchi.entities.environments.EnvironmentFactory;

/*
 * Output Boundary:
 * Information collected from controller, converted to information that the response model needs
 */
public class ChangeEnvironmentRequestModel{
    private final User USER;
    private final Env CURR_ENVIRONMENT;
    private final Env NEW_ENVIRONMENT;

    /**
     * Request model (input data) for the ChangeEnvironment use case.
     * @param user The user whose environment we want to change
     * @param environmentInput The environment the user wants to go to, as a string
     */
    public ChangeEnvironmentRequestModel(User user, String environmentInput) {
        EnvironmentFactory environmentFactory = new EnvironmentFactory();
        this.USER = user;
        this.CURR_ENVIRONMENT = user.getEnvironment().getName();
        this.NEW_ENVIRONMENT = environmentFactory.getName(environmentInput).getName();
    }

    // getter function for the user, return user
    public User getUser() {
        return USER;
    }

    // getter for user environment input, return environmentInput
    public Env getNEW_ENVIRONMENT(){
        return NEW_ENVIRONMENT;
    }

    // getter for current user in-game environment
    public Env getCURR_ENVIRONMENT(){
        return CURR_ENVIRONMENT;
    }

    public Environment getEnvironmentInputEnvironment(){
        EnvironmentFactory environmentFactory = new EnvironmentFactory();
        return environmentFactory.getName(NEW_ENVIRONMENT);
    }

}
