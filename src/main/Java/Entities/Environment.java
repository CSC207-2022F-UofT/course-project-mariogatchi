package Entities;

public abstract class Environment{
    private final String NAME; // the name of the environment as a string

    /**
     * Construct an environment
     *
     * @param name The name of the Environment
     */

    // constructor
    public Environment(String name){
        this.NAME = name;
    }

    // getter function for name, return name
    public String getName(){
        return NAME;
    }
}
