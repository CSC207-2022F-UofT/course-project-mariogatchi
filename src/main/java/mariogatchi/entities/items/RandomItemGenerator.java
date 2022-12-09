package mariogatchi.entities.items;

import java.util.Random;
/*
Returns a random reusable item
 */
public class RandomItemGenerator {

    private final NonReusableItemFactory NON_REUSABLE_ITEM_FACTORY;

    public RandomItemGenerator() {
        this.NON_REUSABLE_ITEM_FACTORY = new NonReusableItemFactory();
    }

    public Item generateRandomItem() {
        Item.NonReusableItems[] itemEnumSet = Item.NonReusableItems.values();

        Random random_method = new Random();
        // generates a random index for the enum set based on its size
        int index = random_method.nextInt(itemEnumSet.length);
        Item.NonReusableItems newItemName = itemEnumSet[index];

        return this.NON_REUSABLE_ITEM_FACTORY.getItem(newItemName);
    }
}
