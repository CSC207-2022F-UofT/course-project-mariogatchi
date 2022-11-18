package mariogatchi;
import java.util.List;

public class Forest extends Environment{
    public Forest() {
        super("Forest", List.of(Action.CATCH, Action.RELEASE));
    }
}
