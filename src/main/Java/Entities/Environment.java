package Entities;

public abstract class Environment{
    private final Env NAME; // the name of the environment as an enum
    /**
     * Abstract Constructor
     *
     * @param name The name of the Environment
     */
    // constructor
    public Environment(Env name){
        this.NAME = name;
    }

    // getter function for name, return name
    public Env getName(){
        return NAME;
    }
}