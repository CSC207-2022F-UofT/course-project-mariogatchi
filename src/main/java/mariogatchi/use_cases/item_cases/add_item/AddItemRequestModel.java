package mariogatchi.use_cases.item_cases.add_item;

import mariogatchi.entities.Inventory;
import mariogatchi.entities.items.Item;

public class AddItemRequestModel {
    private Item item; // item to add to inventory
    private Inventory inventory; // inventory that item is to be added to
    private int quantity; // quantity to add of item to inventory

    /*
    The input data needed for the AddItem use case
    @param item - the item to be added
    @param inventory - the inventory that the item is to be added to
    @param quantity - the quantity of item to be added to the inventory
     */

    public AddItemRequestModel (Item item, Inventory inventory, int quantity) {
        this.item = item;
        this.inventory = inventory;
        this.quantity = quantity;
    }

    // return item
    public Item getItem() {
        return this.item;
    }

    // return inventory
    public Inventory getInventory() {
        return this.inventory;
    }

    // return quantity
    public int getQuantity() {
        return this.quantity;
    }
}
