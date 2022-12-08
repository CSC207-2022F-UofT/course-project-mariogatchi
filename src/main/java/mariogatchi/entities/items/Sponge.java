package mariogatchi.entities.items;

import mariogatchi.entities.Inventory;
import mariogatchi.entities.Mariogatchi;
import mariogatchi.entities.Statistics;
import mariogatchi.entities.environments.Env;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Sponge extends Item implements Reusable{

    public Sponge() {
        super(Items.SPONGE,
                new HashSet<>(List.of(Env.HOME)),
                new HashMap<>() {{
                    put(ItemEffects.CLEANLINESS, 50);
                    put(ItemEffects.HAPPINESS, 2);
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
