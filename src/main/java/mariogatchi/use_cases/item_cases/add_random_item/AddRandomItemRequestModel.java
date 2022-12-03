package mariogatchi.use_cases.item_cases.add_random_item;

import mariogatchi.entities.Inventory;
import mariogatchi.use_cases.item_cases.add_item.AddItemInputBoundary;

/*
Request Model for the AddRandomItem use case
 */
public class AddRandomItemRequestModel {
    private final Inventory INVENTORY;

    private final AddItemInputBoundary ADD_ITEM_RUNNER;

    public AddRandomItemRequestModel(Inventory inventory, AddItemInputBoundary addItemRunner) {
        this.INVENTORY = inventory;
        this.ADD_ITEM_RUNNER = addItemRunner;
    }

    // return the inventory
    public Inventory getInventory() {
        return this.INVENTORY;
    }

    // return the addItemInputBoundary
    public AddItemInputBoundary getAddItemRunner() {
        return this.ADD_ITEM_RUNNER;
    }
}
