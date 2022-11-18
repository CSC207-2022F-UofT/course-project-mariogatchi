package mariogatchi;
import java.util.List;

public abstract class Environment{
    private final String name;
    private final List<Action> actionList;

    /**
     * Construct a Home, giving them the given name and list of actions. The name and actions are final
     * and cannot be changed unless they are changed in the constructor of Home itself.
     *
     * @param name The name of the Environment, which is always home
     * @param actionList List of the actions that can legally be performed in this environment
     */

    public Environment(String name, List<Action> actionList){
        this.name = name;
        this.actionList = actionList;
    }

    public String getName() {
        return name;
    }

    public List<Action> getActions() {
        return actionList;
    }
}
