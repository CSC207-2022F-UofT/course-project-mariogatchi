package mariogatchi.use_cases.item_cases.use_item;
import mariogatchi.entities.items.Item.Items;
import mariogatchi.entities.Inventory;
import mariogatchi.entities.Mariogatchi;
import mariogatchi.entities.Statistics;

import java.util.Map;

public class UseItemResponseModel {
    private final Inventory INVENTORY;

    private final Items ITEM_NAME;

    private final Mariogatchi GATCHI;
    private final Map<Statistics.Stats, Integer> STAT_TO_VALUE;



    /*
    The output data for the UseItem use case:
    @param - the quantity of item that was used
    @param - the inventory that the item was used from.
     */
    public UseItemResponseModel(Inventory inventory, Items name, Mariogatchi gatchi,
                                Map<Statistics.Stats, Integer> statToValue) {
        this.INVENTORY = inventory;
        this.ITEM_NAME = name;
        this.GATCHI = gatchi;
        this.STAT_TO_VALUE = statToValue;
    }

    // returns the Inventory
    public Inventory getInventory() {
        return this.INVENTORY;
    }

    // returns the name of the Item
    public Items getName() {
        return this.ITEM_NAME;
    }

    // returns the statToValue Map
    public Map<Statistics.Stats, Integer> getStatToValue() {
        return this.STAT_TO_VALUE;
    }

    // returns the Mariogatchi
    public Mariogatchi getMariogatchi() {
        return this.GATCHI;
    }
}
