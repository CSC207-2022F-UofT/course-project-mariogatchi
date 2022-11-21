package mariogatchi;
import java.util.List;

public class Forest extends Environment{
    /**
     * Forest subclass of environment. In this environment a user can catch and
     * release Mariogatchis. This is the only environment in which actions can impact
     * a users Mariogatchi collection.
     */

    // constructor for forest, make a new forest class with its given eligible actions
    public Forest(){
        super("Forest", List.of(Action.CATCH, Action.RELEASE));
    }
}
