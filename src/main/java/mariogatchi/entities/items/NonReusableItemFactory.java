package mariogatchi.entities.items;

public class NonReusableItemFactory {
    // use getItem method to get object of type Item

    public Item getItem(Item.NonReusableItems itemName) {

        if (itemName.equals(Item.NonReusableItems.APPLE)) {
            return new Apple();
        } else if (itemName.equals(Item.NonReusableItems.BAD_APPLE)) {
            return new BadApple();
        } else if (itemName.equals(Item.NonReusableItems.TREAT)) {
            return new Treat();
        } else if (itemName.equals(Item.NonReusableItems.STEAK)) {
            return new Steak();
        } else if (itemName.equals(Item.NonReusableItems.AGILITY_TRAINING_BOOK)) {
            return new AgilityTrainingBook();
        } else if (itemName.equals(Item.NonReusableItems.STRATEGY_TRAINING_BOOK)) {
            return new StrategyTrainingBook();
        }
        else {
            System.out.println("A " + itemName + " is not a valid non-reusable item name");
            return null;
        }
    }
}
