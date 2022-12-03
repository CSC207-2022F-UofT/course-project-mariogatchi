package mariogatchi.entities.items;

import mariogatchi.entities.environments.Env;
import mariogatchi.entities.Inventory;
import mariogatchi.entities.Mariogatchi;
import mariogatchi.entities.Statistics;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class Item implements Serializable {
    // the name of the Item
    private Items name;

    // set of Environments that the Item can be used in
    private Set<Env> eligibleEnvironments;

    // a mapping of Effects to their corresponding values
    private Map<ItemEffects, Integer> effectToValues;

    public enum Items {
        /*
        enum of types of Items
         */

        // non-reusable
        APPLE,
        BADAPPLE,
        TREAT,

        // reusable
        SPONGE,
        BED,
        LEASH,
        COMB
    }

    public enum NonReusableItems {
        /*
        enum of non-reusable items (basically just used for the random item generator since it shouldn't
        generate reusable items
         */
        APPLE,
        BADAPPLE,
        TREAT
    }

    public enum ItemEffects {

        /*
        enum of Item effects
         */
        HUNGER,
        ENERGY,
        CLEANLINESS,
        HAPPINESS,
        AGILITY,
        STRATEGY
    }

    public Item(Items name, Set<Env> eligibleEnvironments, Map<ItemEffects, Integer> effectToValues) {
        this.name = name;
        this.eligibleEnvironments = eligibleEnvironments;
        this.effectToValues = effectToValues;
    }


    /*
    return whether the mariogatchi.Item can be used
     */
    public boolean itemCanBeUsed(Item.Items itemName, Env currentEnv, Inventory inventory) {
        return isEligibleEnvironment(currentEnv) &&
                hasEligibleQuantity(inventory, itemName);
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
    private boolean hasEligibleQuantity(Inventory inventory, Item.Items itemName) {
        return inventory.itemExists(itemName) &&
                inventory.getQuantity(itemName) > 0;
    }

    /*
    return whether mariogatchi.Item can be used in the current Environment
     */
    private boolean isEligibleEnvironment(Env environment) {
        return this.eligibleEnvironments.contains(environment);
    }

    /* update the mariogatchi's statistics based on this Items' itemEffects and their corresponding values
    then return a mapping of the mariogatchi's statistics to their updated values.
    */
    protected Map<Statistics.Stats, Integer> updateStatistics(Mariogatchi gatchi) {
        Statistics gatchiStats = gatchi.getGatchiStats();
        Map<Statistics.Stats, Integer> statToValue = new HashMap<>();

        for (Map.Entry<ItemEffects, Integer> entry: this.effectToValues.entrySet()) {

            ItemEffects itemEffect = entry.getKey();
            Integer value = entry.getValue();
            Statistics.Operator operate = Statistics.Operator.ADD;
            if (value < 0) {
                operate = Statistics.Operator.SUBTRACT;
                value = value * -1;
            }

            Statistics.Stats statEnum= null;
                switch (itemEffect) {
                    case HUNGER:
                        statEnum = Statistics.Stats.HUNGER;
                        break;
                    case ENERGY:
                        statEnum = Statistics.Stats.ENERGY;
                        break;
                    case CLEANLINESS:
                        statEnum = Statistics.Stats.CLEANLINESS;
                        break;
                    case HAPPINESS:
                        statEnum = Statistics.Stats.HAPPINESS;
                        break;
                    case AGILITY:
                        statEnum = Statistics.Stats.AGILITY;
                        break;
                    case STRATEGY:
                        statEnum = Statistics.Stats.STRATEGY;
                        break;
                }
            gatchiStats.changeStat(statEnum, value, operate);
            }

        statToValue.put(Statistics.Stats.HUNGER, gatchiStats.getHunger());
        statToValue.put(Statistics.Stats.ENERGY, gatchiStats.getEnergy());
        statToValue.put(Statistics.Stats.CLEANLINESS, gatchiStats.getCleanliness());
        statToValue.put(Statistics.Stats.HAPPINESS, gatchiStats.getHappiness());
        statToValue.put(Statistics.Stats.AGILITY, gatchiStats.getAgility());
        statToValue.put(Statistics.Stats.STRATEGY, gatchiStats.getStrategy());

        return statToValue;
        }
    /*
    Use the item.
    ABSTRACT
     */
    public abstract Map<Statistics.Stats, Integer> useThisItem(Mariogatchi gatchi, Inventory inventory);


}
