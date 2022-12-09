package mariogatchi.entities.items;

import mariogatchi.entities.Statistics;
import mariogatchi.entities.environments.Env;
import mariogatchi.entities.Inventory;
import mariogatchi.entities.Mariogatchi;

import java.util.*;

public class Leash extends Item implements Reusable{

    public Leash() {
        super(Items.LEASH,
                new HashSet<>(List.of(Env.PARK)),
                new HashMap<>() {{
                    put(ItemEffects.HAPPINESS, 20);
                    put(ItemEffects.ENERGY, -10);
                    put(ItemEffects.CLEANLINESS, -10);
                }}
        );
    }

    /*
    Use the item.
     */
    @Override
    public Map<Statistics.Stats, Integer> useThisItem(Mariogatchi gatchi, Inventory inventory) {
        // update energy, happiness, cleanliness, and hunger statistics

        return super.updateStatistics(gatchi);
    }
}
