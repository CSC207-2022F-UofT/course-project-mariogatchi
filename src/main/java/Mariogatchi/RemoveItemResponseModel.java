package Mariogatchi;

public class RemoveItemResponseModel {
    private Item item;
    private Inventory inventory;
    private int quantity;

    /*
    The output data needed for the RemoveItem use case
    @param item - the item that was to be removed from the inventory
    @param inventory - the inventory that the item that was to be removed from
    @param quantity - the quantity of item that was to be removed from inventory
     */
    public RemoveItemResponseModel(Item item, Inventory inventory, int quantity) {
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
