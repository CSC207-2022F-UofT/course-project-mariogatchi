package mariogatchi.use_cases.change_environment;

import mariogatchi.entities.environments.Env;

/**
 * ChangeEnvironmentResponseModel: the information the use case sends back to the controller
 */
public class ChangeEnvironmentResponseModel{
    private final Env NEW_ENVIRONMENT;

    /**
     * Constructs a response model
     * @param newEnvironment the environment the user is now in
     */
    public ChangeEnvironmentResponseModel(Env newEnvironment){
        this.NEW_ENVIRONMENT = newEnvironment;
    }

    /**
     * Returns the environment the response model provides
     * @return the environment the response model provides
     */
    public Env getNewEnvironment(){
        return NEW_ENVIRONMENT;
    }
}