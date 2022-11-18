package mariogatchi;
import java.util.List;

public enum Action {
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

    public boolean getneedsItem(){
        return needsItem;
    }

    public List<String> getstatsEffects(){
        return statEffects;
    }
}
