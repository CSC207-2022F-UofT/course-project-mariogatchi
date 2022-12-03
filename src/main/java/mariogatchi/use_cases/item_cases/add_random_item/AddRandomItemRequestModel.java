package mariogatchi.use_cases.item_cases.add_random_item;

import mariogatchi.entities.Inventory;
import mariogatchi.use_cases.item_cases.add_item.AddItemInputBoundary;

/*
Request Model for the AddRandomItem use case
 */
public class AddRandomItemRequestModel {
    private Inventory inventory;

    private AddItemInputBoundary addItemRunner;

    public AddRandomItemRequestModel(Inventory inventory, AddItemInputBoundary addItemRunner) {
        this.inventory = inventory;
        this.addItemRunner = addItemRunner;
    }

    // return the inventory
    public Inventory getInventory() {
        return inventory;
    }

    // return the addItemInputBoundary
    public AddItemInputBoundary getAddItemRunner() {
        return this.addItemRunner;
    }
}
