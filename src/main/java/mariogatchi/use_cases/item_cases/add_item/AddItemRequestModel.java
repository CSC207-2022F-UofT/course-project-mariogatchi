package mariogatchi.use_cases.item_cases.add_item;

import mariogatchi.entities.Inventory;
import mariogatchi.entities.items.Item;
import mariogatchi.entities.items.ItemFactory;

public class AddItemRequestModel {
    private final Item ITEM; // item to add to inventory
    private final Inventory INVENTORY; // inventory that item is to be added to
    private final int QUANTITY; // quantity to add of item to inventory

    /*
    The input data needed for the AddItem use case
    @param item - the item to be added
    @param inventory - the inventory that the item is to be added to
    @param quantity - the quantity of item to be added to the inventory
     */

    public AddItemRequestModel (String itemName, Inventory inventory, int quantity) {
        /*
        Factory design pattern
         */
        ItemFactory itemFactory = new ItemFactory();

        /*
        Dependency Injection design pattern: does not create Items directly (using the new keyword)
         */
        this.ITEM = itemFactory.getItem(Item.Items.valueOf(itemName));

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
