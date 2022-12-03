package mariogatchi.use_cases.item_cases.remove_item;

import mariogatchi.entities.Inventory;
import mariogatchi.entities.items.Item;

public class RemoveItemResponseModel {
    private final Item ITEM;
    private final Inventory INVENTORY;
    private final int QUANTITY;

    /*
    The output data needed for the RemoveItem use case
    @param item - the item that was to be removed from the inventory
    @param inventory - the inventory that the item that was to be removed from
    @param quantity - the quantity of item that was to be removed from inventory
     */
    public RemoveItemResponseModel(Item item, Inventory inventory, int quantity) {
        this.ITEM = item;
        this.INVENTORY = inventory;
        this.QUANTITY = quantity;
    }

    // return item
    public Item getItem() {
        return this.ITEM;
    }

    // return inventory
    public Inventory getInventory() {
        return this.INVENTORY;
    }

    // return quantity
    public int getQuantity() {
        return this.QUANTITY;
    }

}
