package mariogatchi.entities.items;

import mariogatchi.entities.Inventory;
import mariogatchi.entities.Mariogatchi;
import mariogatchi.entities.Statistics;
import mariogatchi.entities.environments.Env;

import java.util.*;

public class Treat extends Item{

        public Treat() {
            super(Items.TREAT,
                    new HashSet<>(List.of(Env.HOME)),
                    new HashMap<>() {{
                        put(ItemEffects.HUNGER, 7);
                        put(ItemEffects.ENERGY, 6);
                        put(ItemEffects.HAPPINESS, 12);
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
