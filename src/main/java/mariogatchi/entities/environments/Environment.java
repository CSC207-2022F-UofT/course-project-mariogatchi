package mariogatchi.entities.environments;

public abstract class Environment{
    private final Env NAME; // the name of the environment as a string

    /**
     * Construct an environment
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
