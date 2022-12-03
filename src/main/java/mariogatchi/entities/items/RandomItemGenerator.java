package mariogatchi.entities.items;

import java.util.Random;
/*
Returns a random reusable item
 */
public class RandomItemGenerator {

    private final ItemFactory ITEMFACTORY;

    public RandomItemGenerator() {
        this.ITEMFACTORY = new ItemFactory();
    }

    public Item generateRandomItem() {
        Item.NonReusableItems[] itemEnumSet = Item.NonReusableItems.values();

        Random random_method = new Random();
        // generates a random index for the enum set based on its size
        int index = random_method.nextInt(itemEnumSet.length);
        Item.NonReusableItems newItemName = itemEnumSet[index];

        return this.ITEMFACTORY.getItem(newItemName);
    }
}
