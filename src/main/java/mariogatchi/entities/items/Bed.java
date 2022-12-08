package mariogatchi.entities.items;

import mariogatchi.entities.Inventory;
import mariogatchi.entities.Mariogatchi;
import mariogatchi.entities.Statistics;
import mariogatchi.entities.environments.Env;

import java.util.*;

public class Bed extends Item implements Reusable{

    public Bed() {
        super(Items.BED,
                new HashSet<>(List.of(Env.HOME)),
                new HashMap<>() {{
                    put(ItemEffects.ENERGY, 100);
                }}
        );
    }

    /*
    Use the item. Then return a map of the Mariogatchi updated statistics.
     */
    @Override
    public Map<Statistics.Stats, Integer> useThisItem(Mariogatchi gatchi, Inventory inventory) {
        // update hunger and energy statistics
        return super.updateStatistics(gatchi);
    }

}
