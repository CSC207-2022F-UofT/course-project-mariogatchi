package mariogatchi.entities.items;

import mariogatchi.entities.Inventory;
import mariogatchi.entities.Mariogatchi;
import mariogatchi.entities.Statistics;
import mariogatchi.entities.environments.Env;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class BadApple extends Item{

    public BadApple() {
        super(Items.APPLE,
                new HashSet<>(Arrays.asList(Env.HOME, Env.FOREST, Env.PARK)),
                new HashMap<>() {{
                    put(ItemEffects.HUNGER, -10);
                    put(ItemEffects.ENERGY, -5);
                }}
        );
    }

    /*
    Use the item. Then return a map of the Mariogatchi updated statistics.
     */
    @Override
    public Map<Statistics.Stats, Integer> useThisItem(Mariogatchi gatchi, Inventory inventory) {
        // update hunger and energy statistics
        Map<Statistics.Stats, Integer> updatedStatsMap = super.updateStatistics(gatchi);

        updateInventory(inventory);

        return updatedStatsMap;
    }


    /*
    updates the Inventory of the User who uses this item to reflect the change in quantity of the given Item
     */
    private void updateInventory(Inventory inventory){
        inventory.removeItem(this.getName(), 1);
    }
}
