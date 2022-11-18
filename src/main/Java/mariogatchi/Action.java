package mariogatchi;
import java.util.List;

public enum Action {
    /**
     * Action enum containing all the types/categories of actions a user can make
     * needsItem - boolean representing whether an item is needed to perform the type of action
     * statEffects - string representation of the statistics impacted when the type of action is executed
     */
    CATCH (false, List.of()),
    RELEASE (false, List.of()),
    CLEANABLE (true, List.of("Cleanliness")),
    EDIBLE (true, List.of("Hunger")),
    SLEEP (false, List.of("Energy", "Health")),
    TEACHABLE (true, List.of("Agility")),
    PLAYABLE (true, List.of("Happiness")),
    TRAINABLE (true, List.of("Strength"));

    private final boolean needsItem;
    private final List<String> statEffects;

    Action(boolean needsItem, List<String> statEffects) {
        this.needsItem = needsItem;
        this.statEffects = statEffects;
    }

    public boolean getNeedsItem(){
        return needsItem;
    }

    public List<String> getStatsEffects(){
        return statEffects;
    }
}
