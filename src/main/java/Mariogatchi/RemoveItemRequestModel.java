package Mariogatchi;

public class RemoveItemRequestModel {
    private Item item;
    private Inventory inventory;

    private int quantity;

    /*
    The input data for the RemoveItem use case
    @param item - The item to be removed from the inventory
    @param inventory - The inventory that the item is to be removed from
    @param quantity - The amoutn of the specified item to be removed from the inventory
     */


    public RemoveItemRequestModel(Item item, Inventory inventory) {
        this.item = item;
        this.inventory = inventory;
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
