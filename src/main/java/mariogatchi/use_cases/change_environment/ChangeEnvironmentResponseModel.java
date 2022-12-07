package mariogatchi.use_cases.change_environment;

import mariogatchi.entities.environments.Environment;
import mariogatchi.entities.environments.Env;

public class ChangeEnvironmentResponseModel{
    private final Env NEWENVIRONMENT; // the environment of the user after it has been changed

    /**
     * Response model (output data) for the ChangeEnvironment use case.
     * @param newEnvironment The environment the user is now in
     */

    // constructor
    public ChangeEnvironmentResponseModel(Env newEnvironment){
        this.NEWENVIRONMENT = newEnvironment;
    }

    // getter for current users changed in-game environment, return newEnvironment
    public Env getNewEnvironment(){
        return NEWENVIRONMENT;
    }
}