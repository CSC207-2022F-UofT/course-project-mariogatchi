package mariogatchi;
import java.util.List;

public abstract class Environment{
    private final String name; // the name of the environment as a string
    private final List<Action> actionList; // the list of the possible action types executable in the environment

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

    // getter function for name, return name
    public String getName(){
        return name;
    }

    // getter function for actionList, return list
    public List<Action> getActions(){
        return actionList;
    }
}
