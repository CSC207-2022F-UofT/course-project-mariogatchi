package mariogatchi.use_cases.change_environment;

import mariogatchi.entities.environments.Env;
import mariogatchi.entities.User;
import mariogatchi.entities.environments.EnvironmentFactory;

/**
 * ChangeEnvironmentRequestModel: the information the use case requests from the controller
 */
public class ChangeEnvironmentRequestModel{
    private final User USER;
    private final Env CURR_ENVIRONMENT;
    private final Env NEW_ENVIRONMENT;

    /**
     * Constructs a request model
     * @param user the user whose environment we want to change
     * @param environmentInput the environment the user wants to go to, as a string
     */
    public ChangeEnvironmentRequestModel(User user, String environmentInput) {
        EnvironmentFactory environmentFactory = new EnvironmentFactory();
        this.USER = user;
        this.CURR_ENVIRONMENT = user.getCurrentEnvironment().getName();
        this.NEW_ENVIRONMENT = environmentFactory.getName(environmentInput).getName();
    }

    /**
     * Returns the user the request model provides
     * @return the user the request model provides
     */
    public User getUser(){
        return USER;
    }

    /**
     * Returns the environment input the request model provides
     * @return the environment input the request model provides
     */
    public Env getNewEnvironment(){
        return NEW_ENVIRONMENT;
    }

    /**
     * Returns the current environment of the user the request model provides
     * @return the current environment of the user the request model provides
     */
    public Env getCurrEnvironment(){
        return CURR_ENVIRONMENT;
    }
}
