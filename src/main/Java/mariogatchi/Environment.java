package mariogatchi;

import java.util.ArrayList;
import java.util.List;

public abstract class Environment{
    private final String name;
    private final List<String> actionList;

    /**
     * Abstract environment constructor for the actual environments.
     */

    public Environment(){
        this.name = "";
        this.actionList = new ArrayList<>();
    }

    public abstract String getName();
    public abstract List<String> getActions();
}
