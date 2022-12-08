package mariogatchi.entities.environments;

/**
 * Entity
 * This class is used for the simple creation of the subclass environments
 */
public abstract class Environment{
    private final Env NAME;
    /**
     * Constructor:
     * @param name the name of the environment as an enum
     */
    protected Environment(Env name){
        this.NAME = name;
    }
    /**
     * Returns the name of the environment as an enum
     * @return the name of the environment as an enum
     */
    public Env getName(){
        return NAME;
    }
}
