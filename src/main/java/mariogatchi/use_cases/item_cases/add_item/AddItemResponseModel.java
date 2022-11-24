package mariogatchi.use_cases.item_cases.add_item;

import mariogatchi.entities.Inventory;
import mariogatchi.entities.items.Item;

public class AddItemResponseModel {
    private Item item;
    private Inventory inventory;
    private int quantity;

    /*
    The Response Model (output data) for the AddItem Use Case
    @param item - The item that was to be added to the inventory
    @param inventory - The inventory that an item was to be added to
    @param quantity - The quantity of the specified item that was to be added to the inventory
     */

    public AddItemResponseModel(Item item, Inventory inventory, int quantity) {
        this.item = item;
        this.inventory = inventory;
        this.quantity = quantity;
    }

    // returns the item
    public Item getItem() {
        return this.item;
    }

    // returns the inventory
    public Inventory getInventory() {
        return this.inventory;
    }

    // returns the quantity
    public int getQuantity() {
        return this.getQuantity();
    }
}
