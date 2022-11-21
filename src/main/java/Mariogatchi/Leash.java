package Mariogatchi;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

import static java.util.Map.entry;

public class Leash extends Item implements Reusable{

    public Leash() {
        super(Items.APPLE,
                new HashSet<Env>(Arrays.asList(Env.HOME, Env.FOREST, Env.PARK)),
                Map.ofEntries(
                        entry(ItemEffects.INCREASE_HUNGER, 10),
                        entry(ItemEffects.INCREASE_ENERGY, 5))
        );
    }

    /*
    Use the item.
     */
    @Override
    public void useThisItem(Mariogatchi mariogatchi, Inventory inventory) {
        // update energy, happiness, cleanliness, and hunger statistics
        // TODO
    }
}
