package mariogatchi.use_cases.change_environment;

import mariogatchi.entities.environments.Environment;
import mariogatchi.entities.environments.Env;

public class ChangeEnvironmentResponseModel{
    private final Env NEW_ENVIRONMENT; // the environment of the user after it has been changed

    /**
     * Response model (output data) for the ChangeEnvironment use case.
     * @param newEnvironment The environment the user is now in
     */

    // constructor
    public ChangeEnvironmentResponseModel(Env newEnvironment){
        this.NEW_ENVIRONMENT = newEnvironment;
    }

    // getter for current users changed in-game environment, return newEnvironment
    public Env getNEW_ENVIRONMENT(){
        return NEW_ENVIRONMENT;
    }
}