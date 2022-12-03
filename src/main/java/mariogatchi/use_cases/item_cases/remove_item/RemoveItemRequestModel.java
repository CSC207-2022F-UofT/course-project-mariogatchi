package mariogatchi.use_cases.item_cases.remove_item;

import mariogatchi.entities.Inventory;
import mariogatchi.entities.items.Item;

public class RemoveItemRequestModel {
    private final Item ITEM;
    private final Inventory INVENTORY;
    private final int QUANTITY;


    /*
    The input data for the RemoveItem use case
    @param item - The item to be removed from the inventory
    @param inventory - The inventory that the item is to be removed from
    @param quantity - The amount of the specified item to be removed from the inventory
     */


    public RemoveItemRequestModel(Item item, Inventory inventory, Integer quantity) {
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
