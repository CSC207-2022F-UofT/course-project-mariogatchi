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
    private final Items NAME;

    // set of Environments that the Item can be used in
    private final Set<Env> ELIGIBLE_ENVIRONMENTS;

    // a mapping of Effects to their corresponding values
    private final Map<ItemEffects, Integer> EFFECT_TO_VALUES;


    public enum Items {
        /*
        enum of types of Items
         */

        // non-reusable
        APPLE,
        BAD_APPLE,
        TREAT,
        STEAK,

        AGILITY_TRAINING_BOOK,

        STRATEGY_TRAINING_BOOK,

        // reusable
        SPONGE,
        BED,
        LEASH,
        COMB,

        SWORD,

    }

    public enum NonReusableItems {
        /*
        enum of non-reusable items (basically just used for the random item generator since it shouldn't
        generate reusable items
         */
        APPLE,
        BAD_APPLE,

        TREAT,

        STEAK,

        AGILITY_TRAINING_BOOK,

        STRATEGY_TRAINING_BOOK,
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
        this.NAME = name;
        this.ELIGIBLE_ENVIRONMENTS = eligibleEnvironments;
        this.EFFECT_TO_VALUES = effectToValues;
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
        return this.NAME;
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
        return this.ELIGIBLE_ENVIRONMENTS.contains(environment);
    }

    /* update the Mariogatchi statistics based on this Item's itemEffects and their corresponding values
    then return a mapping of the Mariogatchi statistics to their updated values.
    */
    protected Map<Statistics.Stats, Integer> updateStatistics(Mariogatchi gatchi) {
        Statistics gatchiStats = gatchi.getStats();
        Map<Statistics.Stats, Integer> statToValue = new HashMap<>();

        for (Map.Entry<ItemEffects, Integer> entry: this.EFFECT_TO_VALUES.entrySet()) {

            ItemEffects itemEffect = entry.getKey();
            Integer value = entry.getValue();
            Statistics.Operator operate = Statistics.Operator.ADD;
            if (value < 0) {
                operate = Statistics.Operator.SUBTRACT;
                value = value * -1;
            }

            Statistics.Stats statEnum = switch (itemEffect) {
                case HUNGER -> Statistics.Stats.HUNGER;
                case ENERGY -> Statistics.Stats.ENERGY;
                case CLEANLINESS -> Statistics.Stats.CLEANLINESS;
                case HAPPINESS -> Statistics.Stats.HAPPINESS;
                case AGILITY -> Statistics.Stats.AGILITY;
                case STRATEGY -> Statistics.Stats.STRATEGY;
            };
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
