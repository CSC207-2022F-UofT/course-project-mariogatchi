package mariogatchi.entities.items;

import mariogatchi.entities.Statistics;
import mariogatchi.entities.environments.Env;
import mariogatchi.entities.Inventory;
import mariogatchi.entities.Mariogatchi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Leash extends Item implements Reusable{

    public Leash() {
        super(Items.LEASH,
                new HashSet<Env>(Arrays.asList(Env.HOME)),
                new HashMap<ItemEffects, Integer>() {{
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
        Map<Statistics.Stats, Integer> updatedStatsMap = super.updateStatistics(gatchi);

        return updatedStatsMap;
    }
}
