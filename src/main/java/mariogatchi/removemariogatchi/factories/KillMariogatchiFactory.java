package mariogatchi.removemariogatchi.factories;

import mariogatchi.removemariogatchi.killmariogatchi.*;

/**
 * Concrete factory for cases to kill a Mariogatchi
 */

public class KillMariogatchiFactory implements RemoveMariogatchiFactory {

    /**
     * uses getAction method to get the specified use case to kill a Mariogatchi
     *
     * @param Action inputs a kill action
     * @return use case for the specified action, otherwise return null if the action cannot be specified
     */
    public KillMariogatchi getAction(String Action) {
        switch (Action) {
            case "starvation":
                return new Starvation();
            case ("blown away"):
                return new BlownAway();
            case "drown":
                return new Drown();
            case ("illness"):
                return new Illness();
            case "old age":
                return new OldAge();
            case ("overcare"):
                return new Overcare();
            case "predators":
                return new Predators();
            case ("problem set"):
                return new ProblemSet();
            case "ufo abduction":
                return new UFOAbduction();

            default:
                System.out.println("Action " + Action + " cannot be specified and does not run.");
                return null;
        }
    }
}
