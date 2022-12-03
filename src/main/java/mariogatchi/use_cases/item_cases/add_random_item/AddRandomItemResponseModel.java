package mariogatchi.use_cases.item_cases.add_random_item;

import mariogatchi.entities.Inventory;
import mariogatchi.entities.items.Item;

/*
Response model for AddRandomItem use case
 */
public class AddRandomItemResponseModel {
    private Item.Items itemName;
    private Inventory inventory;

    private boolean added;

    public AddRandomItemResponseModel(Item.Items itemName, Inventory inventory, boolean added) {
        this.itemName = itemName;
        this.inventory = inventory;
        this.added = added;
    }

    public Item.Items getItemName() {
        return this.itemName;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public boolean getAdded() {
        return this.added;
    }


}
