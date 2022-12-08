package mariogatchi.use_cases.item_cases.add_random_item;

import mariogatchi.entities.Inventory;
import mariogatchi.entities.items.Item;

/*
Response model for AddRandomItem use case
 */
public class AddRandomItemResponseModel {
    private final Item.Items ITEM_NAME;
    private final Inventory INVENTORY;

    private final boolean ADDED;

    public AddRandomItemResponseModel(Item.Items itemName, Inventory inventory, boolean added) {
        this.ITEM_NAME = itemName;
        this.INVENTORY = inventory;
        this.ADDED = added;
    }

    public Item.Items getItemName() {
        return this.ITEM_NAME;
    }

    public Inventory getInventory() {
        return this.INVENTORY;
    }

    public boolean getAdded() {
        return this.ADDED;
    }


}
