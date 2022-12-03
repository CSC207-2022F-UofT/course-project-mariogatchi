package mariogatchi.use_cases.item_cases.use_item;
import mariogatchi.entities.items.Item.Items;
import mariogatchi.entities.Inventory;
import mariogatchi.entities.Mariogatchi;
import mariogatchi.entities.Statistics;

import java.util.Map;

public class UseItemResponseModel {
    private Inventory inventory;

    private Items name;

    private Mariogatchi gatchi;
    private Map<Statistics.Stats, Integer> statToValue;



    /*
    The output data for the UseItem use case:
    @param - the quantity of item that was used
    @param - the inventory that the item was used from.
     */
    public UseItemResponseModel(Inventory inventory, Items name, Mariogatchi gatchi,
                                Map<Statistics.Stats, Integer> statToValue) {
        this.inventory = inventory;
        this.name = name;
        this.gatchi = gatchi;
        this.statToValue = statToValue;
    }

    // returns the Inventory
    public Inventory getInventory() {
        return this.inventory;
    }

    // returns the name of the Item
    public Items getName() {
        return this.name;
    }

    // returns the statToValue Map
    public Map<Statistics.Stats, Integer> getStatToValue() {
        return statToValue;
    }
}
