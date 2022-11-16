package mariogatchi;

import java.util.ArrayList;
import java.util.List;
public class Home extends Environment{
    private final String name;
    private final List<String> actionList;

    /**
     * Construct a Home, giving them the given name and list of actions. The name and actions are final
     * and cannot be changed unless they are changed in the constructor of Home itself.
     *
     * @param name The name of the Environment, which is always home
     * @param actionList List of the actions that can legally be performed in this environment
     */

    public Home() {
        this.name = "Home";
        List<String> actionList = new ArrayList<>();
        actionList.add("Edible");
        actionList.add("Sleep");
        actionList.add("Teachable");
        actionList.add("Cleanable");
        this.actionList = actionList;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public List<String> getActions(){
        return actionList;
    }
}
