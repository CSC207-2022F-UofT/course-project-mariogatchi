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
        } else if (itemName.equals(Item.Items.LEASH)) {
            return new Leash();
        }
        else {
            System.out.println("A " + itemName + " is not a valid item name");
            return null;
        }
    }
}
