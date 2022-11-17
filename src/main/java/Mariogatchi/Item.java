package Mariogatchi;

import java.io.Serializable;

public abstract class Item implements Serializable {

    // set of Environments that the mariogatchi.Item can be used in
    private Set<Environment> eligibleAreas = new Set<Environment>;

    // a mapping of Effects to their corresponding values
    private Map<Effect, Integer> effectValues = new Map<Effect, Integer>;




    /*
    Use the item.
    ABSTRACT
     */
    abstract void useThisItem(Item item, Environment currentEnv, Mariogatchi mariogatchi, Inventory inventory);


    /*
    return whether the mariogatchi.Item can be used
     */
    public boolean itemCanBeUsed(Item item, Environment currentEnv, Mariogatchi mariogatchi, Inventory inventory) {
        return isEligibleEnvironment(currentEnv) &&
                hasEligibleQuantity(inventory, item) &&
                isEligibleMariogatchi(mariogatchi);
    }




    /*
    return whether mariogatchi.Item can be used in the current Environment
     */
    private boolean isEligibleEnvironment(Environment environment) {
        return eligibleAreas.contains(environment);
    }

    /*
    return whether mariogatchi.Item can be used on the given Mariogatchi
    ABSTRACT
     */
    abstract boolean isEligibleMariogatchi(Mariogatchi mariogatchi);


    /*
    return whether there is at least one of this mariogatchi.Item in the given mariogatchi.Inventory to use.
     */
    private boolean hasEligibleQuantity(Inventory inventory, Item item) {
        return inventory.itemExists(item) &&
                inventory.getQuantity(item) > 0;
    }




    /*
    updates the mariogatchi.Inventory of the User who uses this item to reflect the change in quantity of the given mariogatchi.Item
    ABSTRACT
     */
    abstract void updateInventory(UseItemRequestModel request);


}
