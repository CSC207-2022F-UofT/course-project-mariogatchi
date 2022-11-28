package mariogatchi.use_cases.item_cases.use_item;
import mariogatchi.entities.items.Items;
import mariogatchi.entities.Inventory;
public class UseItemResponseModel {
    private Inventory inventory;

    private Items name;

    /*
    The output data for the UseItem use case:
    @param - the quantity of item that was used
    @param - the inventory that the item was used from.
     */
    public UseItemResponseModel(Inventory inventory, Items name) {
        this.inventory = inventory;
        this.name = name;
    }

    // returns the Inventory
    public Inventory getInventory() {
        return this.inventory;
    }

    // returns the name of the Item
    public Items getName() {
        return this.name;
    }
}
