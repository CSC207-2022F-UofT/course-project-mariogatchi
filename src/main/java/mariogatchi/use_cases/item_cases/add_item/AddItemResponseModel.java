package mariogatchi.use_cases.item_cases.add_item;

import mariogatchi.entities.Inventory;
import mariogatchi.entities.items.Item;

public class AddItemResponseModel {
    private final Item ITEM;
    private final Inventory INVENTORY;
    private final int QUANTITY;
    private final boolean ADDED;

    /*
    The Response Model (output data) for the AddItem Use Case
    @param item - The item that was to be added to the inventory
    @param inventory - The inventory that an item was to be added to
    @param quantity - The quantity of the specified item that was to be added to the inventory
     */

    public AddItemResponseModel(Item item, Inventory inventory, int quantity, boolean added) {
        this.ITEM = item;
        this.INVENTORY = inventory;
        this.QUANTITY = quantity;
        this.ADDED = added;
    }

    // returns the item
    public Item getItem() {
        return this.ITEM;
    }

    // returns the inventory
    public Inventory getInventory() {
        return this.INVENTORY;
    }

    // returns the quantity
    public int getQuantity() {
        return this.QUANTITY;
    }

    // return added
    public boolean getAdded() {
        return this.ADDED;
    }
}
