package mariogatchi.use_cases.item_cases.use_item;

import mariogatchi.entities.Inventory;
import mariogatchi.entities.Mariogatchi;
import mariogatchi.entities.environments.Env;
import mariogatchi.entities.items.Item;

public class UseItemRequestModel {
    private final Item ITEM_TO_USE;
    private final Env CURRENT_ENVIRONMNENT;
    private final Mariogatchi GATCHI;
    private final Inventory INVENTORY;

    /*
    The input data needed for the use item use case
    @param itemToUse - the item to use
    @param currentEnvironment - the current environment that the item is to be used in
    @param mariogatchi - the mariogatchi that the item is to be used on
    @param inventory - the inventory that the item is to be used from
     */

    public UseItemRequestModel(Item item, Env environment, Mariogatchi mariogatchi, Inventory inventory) {
        this.ITEM_TO_USE = item;
        this.CURRENT_ENVIRONMNENT = environment;
        this.GATCHI = mariogatchi;
        this.INVENTORY = inventory;
    }

    // returns item
    public Item getItemToUse() {
        return this.ITEM_TO_USE;
    }

    //returns the currentEnvironment
    public Env getCurrentEnvironment() {
        return this.CURRENT_ENVIRONMNENT;
    }

    //returns mariogatchi
    public Mariogatchi getMariogatchi() {
        return this.GATCHI;
    }

    //returns inventory
    public Inventory getInventory() {
        return this.INVENTORY;
    }

}
