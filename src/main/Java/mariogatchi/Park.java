package mariogatchi;
import java.util.List;

public class Park extends Environment {
    /**
     * Park subclass of environment. In this environment a user can train and play
     * with their Mariogatchi.
     */

    // constructor for park, make a new park class with its given eligible actions
    public Park() {
        super("Park", List.of(Action.TRAINABLE, Action.PLAYABLE));
    }
}
