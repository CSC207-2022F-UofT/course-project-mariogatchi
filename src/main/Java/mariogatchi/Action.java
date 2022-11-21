package mariogatchi;
import java.util.List;

public enum Action{
    // Action is an enum containing the possible "action-types" a user can perform, each Action has two instance variables
    // determining whether it needs an item (needsItem) and which statistic it impacts as a list (statEffects)
    CATCH (false, null),
    RELEASE (false, null),
    CLEANABLE (true, List.of("cleanliness")),
    EDIBLE (true, List.of("hunger")),
    SLEEP (false, List.of("energy")),
    TEACHABLE (true, List.of("agility")),
    PLAYABLE (true, List.of("happiness", "cleanliness")),
    TRAINABLE (true, List.of("strength"));
    private final boolean needsItem; // boolean representing whether the action type needs an item to be performed
    private final List<String> statEffects; // List representing the statistics as string values

    /**
     * Action enum containing all the types/categories of actions a user can make
     * @param needsItem boolean representing whether an item is needed to perform the type of action
     * @param statEffects String representation of the statistics impacted when the type of action is executed
     */

    Action(boolean needsItem, List<String> statEffects) {
        this.needsItem = needsItem;
        this.statEffects = statEffects;
    }

    // getter function for needsItem, return needsItem
    public boolean getNeedsItem(){
        return needsItem;
    }

    // getter function for StatsEffect, return statsEffect
    public List<String> getStatsEffects(){
        return statEffects;
    }
}
