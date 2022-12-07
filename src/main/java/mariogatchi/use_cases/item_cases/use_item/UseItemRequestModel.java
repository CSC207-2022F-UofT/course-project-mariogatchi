package mariogatchi.use_cases.item_cases.use_item;

import mariogatchi.entities.Inventory;
import mariogatchi.entities.Mariogatchi;
import mariogatchi.entities.User;
import mariogatchi.entities.items.Item;
import mariogatchi.entities.items.ItemFactory;
import mariogatchi.entities.environments.Env;

import java.util.Objects;

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

    public UseItemRequestModel(String itemName, Env environment, String mariogatchi_name, Inventory inventory, User user) {
        ItemFactory itemFactory = new ItemFactory();
        this.ITEM_TO_USE = itemFactory.getItem(Item.Items.valueOf(itemName));
        this.CURRENT_ENVIRONMNENT = environment;
        this.GATCHI = getMariogatchiFromUser(user, mariogatchi_name);
        this.INVENTORY = inventory;
    }

    private Mariogatchi getMariogatchiFromUser(User user, String name) {
        for (Mariogatchi m: user.getMariogatchis()) {
            if (Objects.equals(m.getName(), name)) {
                return m;
            }
        }
        return null;
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
