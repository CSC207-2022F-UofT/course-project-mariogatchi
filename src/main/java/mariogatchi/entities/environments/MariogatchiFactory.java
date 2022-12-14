package mariogatchi.entities.environments;

import mariogatchi.entities.Mariogatchi;

/**
 * Entity (factory)
 * Concrete factory for the creation of new Mariogatchi instances
 */
public class MariogatchiFactory {
    /**
     * Constructs new Mariogacthis with a given rarity
     *
     * @param rarity inputs the rarity of a Mariogatchi
     * @return Mariogatchi with the rarity provided in the input
     */
    public Mariogatchi getRarity(String rarity){
        switch (rarity) {
            case "common":
                return new Mariogatchi("common");
            case "rare":
                return new Mariogatchi("rare");
            default:
                throw new IllegalArgumentException("This is not a valid rarity");
        }
    }
}
