package mariogatchi.entities.items;

import mariogatchi.entities.Env;
import mariogatchi.entities.Inventory;
import mariogatchi.entities.Mariogatchi;

import java.util.*;

import static java.util.Map.entry;

public class Apple extends Item{

    public Apple() {
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
        // update hungar and energy statistics
        // TODO

        updateInventory(1, inventory);
    }


    /*
    updates the Inventory of the User who uses this item to reflect the change in quantity of the given Item
     */
    private void updateInventory(int quantity, Inventory inventory){
        inventory.removeItem(this, quantity);
    }
}
