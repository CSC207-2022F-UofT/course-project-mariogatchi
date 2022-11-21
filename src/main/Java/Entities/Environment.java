package Entities;

public abstract class Environment{
    private final String name; // the name of the environment as a string

    /**
     * Construct an environment
     *
     * @param name The name of the Environment
     */

    // constructor
    public Environment(String name){
        this.name = name;
    }

    // getter function for name, return name
    public String getName(){
        return name;
    }
}
