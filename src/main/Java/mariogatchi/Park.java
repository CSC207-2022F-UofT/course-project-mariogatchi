package mariogatchi;
import java.util.List;

public class Park extends Environment {
    public Park() {
        super("Park", List.of(Action.TRAINABLE, Action.PLAYABLE));
    }
}
