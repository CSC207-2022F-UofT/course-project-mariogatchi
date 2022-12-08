package mariogatchi.entities.items;

/*
Returns a non-reusable item
 */
public class ItemFactory {

    // use getItem method to get object of type Item

    public Item getItem(Item.Items itemName) {

        if (itemName.equals(Item.Items.APPLE)) {
            return new Apple();
        } else if (itemName.equals(Item.Items.BAD_APPLE)) {
            return new BadApple();
        } else if (itemName.equals(Item.Items.TREAT)) {
            return new Treat();
        } else if (itemName.equals(Item.Items.STEAK)) {
            return new Steak();
        } else if (itemName.equals(Item.Items.AGILITY_TRAINING_BOOK)) {
            return new AgilityTrainingBook();
        } else if (itemName.equals(Item.Items.STRATEGY_TRAINING_BOOK)) {
            return new StrategyTrainingBook();
        } else if (itemName.equals(Item.Items.SPONGE)) {
            return new Sponge();
        } else if (itemName.equals(Item.Items.BED)) {
            return new Bed();
        } else if (itemName.equals(Item.Items.LEASH)) {
            return new Leash();
        } else if (itemName.equals(Item.Items.COMB)) {
            return new Comb();
        } else if (itemName.equals(Item.Items.SWORD)) {
            return new Sword();
        }
        else {
            System.out.println("A " + itemName + " is not a valid item name");
            return null;
        }
    }
}
