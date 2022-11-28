package mariogatchi.entities.items;

import mariogatchi.entities.environments.Env;
import mariogatchi.entities.Inventory;
import mariogatchi.entities.Mariogatchi;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

public abstract class Item implements Serializable {

    // the name of the Item
    private Items name;

    // set of Environments that the Item can be used in
    private Set<Env> eligibleEnvironments;

    // a mapping of Effects to their corresponding values
    private Map<ItemEffects, Integer> effectToValues;

    public Item(Items name, Set<Env> eligibleEnvironments, Map<ItemEffects, Integer> effectToValues) {
        this.name = name;
        this.eligibleEnvironments = eligibleEnvironments;
        this.effectToValues = effectToValues;
    }


    /*
    return whether the mariogatchi.Item can be used
     */
    public boolean itemCanBeUsed(Item item, Env currentEnv, Inventory inventory) {
        return isEligibleEnvironment(currentEnv) &&
                hasEligibleQuantity(inventory, item);
    }


    /*
    returns the name of this Item
    ABSTRACT
     */
    public Items getName(){
        return this.name;
    }

    /*
    returns the set of environments that the Item can be used in
     */
    public Set<Env> getEligibleEnvironments() {
        return this.eligibleEnvironments;
    }

    /*
    /*
    returns a mapping of the Items effects to their corresponding values
     */
    public Map<ItemEffects, Integer> getEffectValues() {
        return this.effectToValues;
    }

    /*
    return whether there is at least one of this Item in the given Inventory to use.
     */
    private boolean hasEligibleQuantity(Inventory inventory, Item item) {
        return inventory.itemExists(item) &&
                inventory.getQuantity(item) > 0;
    }

    /*
    return whether mariogatchi.Item can be used in the current Environment
     */
    private boolean isEligibleEnvironment(Env environment) {
        return this.eligibleEnvironments.contains(environment);
    }


    /*
    Use the item.
    ABSTRACT
     */
    abstract void useThisItem(Mariogatchi mariogatchi, Inventory inventory);


}
