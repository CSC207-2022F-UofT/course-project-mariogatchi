package mariogatchi.entities.items;

/*
Returns a non-reusable item
 */
public class ItemFactory {

    // use getItem method to get object of type Item

    public Item getItem(Item.NonReusableItems itemName) {

        if (itemName.equals(Item.NonReusableItems.APPLE)) {
            return new Apple();
        } else if (itemName.equals(Item.NonReusableItems.BAD_APPLE)) {
            return new BadApple();
        } else {
            System.out.println("A " + itemName + " is not a valid non-reusable item name");
            return null;
        }
    }
}
