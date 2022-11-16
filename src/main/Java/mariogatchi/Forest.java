package mariogatchi;

import java.util.ArrayList;
import java.util.List;

public class Forest extends Environment{
    private final String name;
    private final List<String> actionList;

    /**
     * Construct a Forest, giving them the given name and list of actions. The name and actions are final
     * and cannot be changed unless they are changed in the constructor of Forest itself.
     *
     * @param name The name of the Environment, which is always forest
     * @param actionList List of the actions that can legally be performed in this environment
     */

    public Forest() {
        this.name = "Forest";
        List<String> actionList = new ArrayList<>();
        actionList.add("Catch");
        actionList.add("Release");
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
