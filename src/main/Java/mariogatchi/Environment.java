package mariogatchi;

public class Environment {
    /*
     * Class that organizes environments that are responsible for
     * dictating Mariogatchi-User interactions. Contains the
     * list of possible actions based on the environment.
     */
    private String name;
    private List<Action> eligbleActions;

    public String getEnvironment(){
        /*
         * Getter function for environment name, will be used when a user wants to use an item.
         */
        return this.name;
    }

    public List<Action> getActions(){
        /*
         * Getter function for environment actions, will be used to check weather a user is making a valid action.
         */
        return this.eligbleActions;
    }
}
