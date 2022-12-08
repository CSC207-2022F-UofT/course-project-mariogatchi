package mariogatchi.use_cases.item_cases.use_item;

import mariogatchi.entities.Inventory;
import mariogatchi.entities.Mariogatchi;
import mariogatchi.entities.items.Item;
import mariogatchi.entities.items.ItemFactory;
import mariogatchi.entities.environments.Env;

public class UseItemRequestModel {
    private final Item ITEM_TO_USE;
    private final Env CURRENT_ENVIRONMNENT;
    private final Mariogatchi GATCHI;
    private final Inventory INVENTORY;

    /**
    The input data needed for the use item use case
    @param itemName - the name of the item to use
    @param environment - the current environment that the item is to be used in
    @param mario - the mariogatchi that the item is to be used on
    @param inventory - the inventory that the item is to be used from
     */

    public UseItemRequestModel(String itemName, Env environment, Mariogatchi mario, Inventory inventory) {
        ItemFactory itemFactory = new ItemFactory();

        /*
        Dependency Injection design pattern: does not create Items directly (using the new keyword)
         */
        this.ITEM_TO_USE = itemFactory.getItem(Item.Items.valueOf(itemName));
        this.CURRENT_ENVIRONMNENT = environment;
        this.GATCHI = mario;
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
