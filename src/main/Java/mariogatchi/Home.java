package mariogatchi;
import java.util.List;
public class Home extends Environment{
    public Home() {
        super("Home", List.of(Action.EDIBLE, Action.CLEANABLE, Action.SLEEP, Action.TEACHABLE));
    }
}
