package mariogatchi.entities.environments;

public class Home extends Environment{
    /**
     * Home subclass of environment.
     */

    // constructor for home, make a new home class with its given eligible actions
    public Home() {
        super(Env.valueOf("Home"));
    }
}
