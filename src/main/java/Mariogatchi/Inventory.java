package Mariogatchi;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class Inventory {
    private Map<Item, Integer> itemToQuantity;

    // max capacity of the mariogatchi.Inventory. The sum of quantities of each item in itemToQuantity should not exceed this amount
    private int capacity;


    // the amount of space occupied in this inventory. The sum of quantities of each item in itemToQuantity.
    private int occupied;


    public Inventory(Map<Item, Integer> defaultItemToQuantity) {
        this.itemToQuantity = defaultItemToQuantity;
    }


    /*
    Decrement the quantity of item in itemToQuantity by the given quantityToRemove.
    Return true if this is successfully done, return false otherwise.
     */
    public boolean removeItem(Item item, int quantityToRemove) {
        if (itemToQuantity.containsKey(item) && quantityToRemove <= itemToQuantity.get(item)){
            int new_quantity = itemToQuantity.get(item) - quantityToRemove;
            itemToQuantity.replace(item, new_quantity);

            this.occupied = this.occupied - quantityToRemove;
            return true;
        }
        else {
            return false;
        }
    }




    /*
    Increments the quantity of item in itemToQuantity by quantityToAdd.
    Return true if this is successfully done, return false otherwise.
     */
    public boolean addItem(Item item, int quantityToAdd) {
        if (itemToQuantity.containsKey(item) && ((quantityToAdd + this.occupied) <= this.capacity)) {
            int new_quantity = itemToQuantity.get(item) + quantityToAdd;
            itemToQuantity.replace(item, new_quantity);

            this.occupied = this.occupied + quantityToAdd;
            return true;
        } else if (quantityToAdd + this.occupied <= this.capacity) {
            itemToQuantity.put(item, quantityToAdd);

            this.occupied = this.occupied + quantityToAdd;
            return true;

        } else {
            return false;
        }
    }


    /*
    returns whether item exists in itemToQuantity
     */
    public boolean itemExists(Item item) {
        return itemToQuantity.containsKey(item);
    }


    /*
    returns the quantity value associated with item in itemToQuantity.
    returns null if item is not a key in itemToQuantity.
     */
    public int getQuantity(Item item) {
        return itemToQuantity.get(item);
    }


    /*
    returns the available space in this mariogatchi.Inventory
     */
    public int getAvailableSpace() {
        return this.capacity - this.occupied;
    }


    public List<Item> sortedByQuantity() {
        // returns a sorted list of the Items in itemToQuantity according to quantity value in ascending order
        Set<Map.Entry<Item, Integer>> entrySet = itemToQuantity.entrySet();
        Stream<Map.Entry<Item, Integer>> entryStream = entrySet.stream();
        Stream<Map.Entry<Item, Integer>> sortedEntryStream = entryStream.sorted();
        Object[] sortedEntryArray = sortedEntryStream.toArray();
        // this does not work
    }



}
