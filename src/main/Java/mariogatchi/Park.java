package mariogatchi;

import java.util.ArrayList;
import java.util.List;

public class Park extends Environment {
    private String name;
    private List<String> actionList;

    /**
     * Construct a Park, giving them the given name and list of actions. The name and actions are final
     * and cannot be changed unless they are changed in the constructor of Park itself.
     *
     * @param name The name of the Environment, which is always park
     * @param actionList List of the actions that can legally be performed in this environment
     */

    public Park() {
        this.name = "Park";
        List<String> actionList = new ArrayList<>();
        actionList.add("Trainable");
        actionList.add("Playable");
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
