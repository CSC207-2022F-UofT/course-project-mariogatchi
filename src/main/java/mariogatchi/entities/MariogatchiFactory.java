package mariogatchi.entities;

/*
 * Entity
 * Concrete factory for the creation of new Mariogatchis to be present during the creation of a new forest class
 */
public class MariogatchiFactory {
    public Mariogatchi getRarity(String rarity){
        /*
         * uses generateMariogatchis method to create one or more Mariogatchis when creating a new instance of forest
         *
         * @param rarity inputs the rarity of a Mariogatchi
         * @return Mariogatchi with the rarity provided in the input
         */
        return switch (rarity) {
            case "common" -> new Mariogatchi("common");
            case "rare" -> new Mariogatchi("rare");
            default -> throw new IllegalArgumentException("This is not a valid rarity");
        };
    }
}