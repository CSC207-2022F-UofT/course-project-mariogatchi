package mariogatchi;
import java.util.List;
public class Home extends Environment{
    /**
     * Home subclass of environment. In this environment a user can feed, clean, teach, and put
     * their Mariogatchi to sleep.
     */

    // constructor for home, make a new home class with its given eligible actions
    public Home() {
        super("Home", List.of(Action.EDIBLE, Action.CLEANABLE, Action.SLEEP, Action.TEACHABLE));
    }
}
