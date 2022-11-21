package ChangeEnvironmentUseCase;

import Entities.Environment;

public class ChangeEnvironmentResponseModel{
    private final Environment newEnvironment; // the environment of the user after it has been changed

    /**
     * Response model (output data) for the ChangeEnvironment use case.
     * @param newEnvironment The environment the user is now in
     */

    // constructor
    public ChangeEnvironmentResponseModel(Environment newEnvironment){
        this.newEnvironment = newEnvironment;
    }

    // getter for current users changed in-game environment, return newEnvironment
    public Environment getNewEnvironment(){
        return newEnvironment;
    }
}