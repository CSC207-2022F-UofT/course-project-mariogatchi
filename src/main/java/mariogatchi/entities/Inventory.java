package mariogatchi.entities;

import mariogatchi.entities.items.Item;

import java.io.Serializable;
import java.util.Map;


public class Inventory implements Serializable {
    private Map<Item.Items, Integer> itemToQuantity;

    // max capacity of the Inventory. The sum of quantities of each item in itemToQuantity should not exceed this amount
    private int capacity;


    // the amount of space occupied in this inventory. The sum of quantities of each item in itemToQuantity.
    private int occupied;

    /**
     * An inventory instance for a user
     * @param defaultItemToQuantity A map of item instances to their quantity
     * @param defaultCapacity The capacity of the inventory
     */
    public Inventory(Map<Item.Items, Integer> defaultItemToQuantity, int defaultCapacity) {
        this.itemToQuantity = defaultItemToQuantity;
        this.capacity = defaultCapacity;
        this.occupied = getInitialOccupied(defaultItemToQuantity, defaultCapacity);
    }



    /**
     *  Decrement the quantity of item in itemToQuantity by the given quantityToRemove.
     * @param itemName name of the item to remove
     * @param quantityToRemove how many to remove
     * @return Return true if this is successfully done, return false otherwise.
     */
    public boolean removeItem(Item.Items itemName, int quantityToRemove) {
        if (itemToQuantity.containsKey(itemName) && quantityToRemove <= itemToQuantity.get(itemName)){
            int newQuantity = itemToQuantity.get(itemName) - quantityToRemove;
            itemToQuantity.replace(itemName, newQuantity);
            if (newQuantity == 0) {
                itemToQuantity.remove(itemName);
            }
            this.occupied = this.occupied - quantityToRemove;
            return true;
        }
        else {
            return false;
        }
    }


    /**
     * Increments the quantity of item in itemToQuantity by quantityToAdd.
     * @param itemName The name of the item to add
     * @param quantityToAdd how many to add
     * @return Return true if this is successfully done, return false otherwise.
     */
    public boolean addItem(Item.Items itemName, int quantityToAdd) {
        if ((quantityToAdd + this.occupied) > this.capacity) {
            return false;
        }
        else {
            if (itemToQuantity.containsKey(itemName)) {
                int new_quantity = itemToQuantity.get(itemName) + quantityToAdd;
                itemToQuantity.replace(itemName, new_quantity);
            }
            else {
                itemToQuantity.put(itemName, quantityToAdd);
            }
            return true;
        }
    }


    /*
    returns whether item exists in itemToQuantity
     */
    public boolean itemExists(Item.Items itemName) {
        return itemToQuantity.containsKey(itemName);
    }


    /*
    returns the quantity value associated with item in itemToQuantity.
    returns null if item is not a key in itemToQuantity.
     */
    public int getQuantity(Item.Items itemName) {
        return itemToQuantity.get(itemName);
    }


    /*
    returns the available space in this mariogatchi.entities.Inventory
     */
    public int getAvailableSpace() {
        return this.capacity - this.occupied;
    }

    /*
    This method assumes that the size of initialItemToQuantity does not exceed the initialCapacity
     */
    private int getInitialOccupied(Map<Item.Items, Integer> initialItemToQuantity, int initialCapacity) {
        int sum = 0;
        for (Map.Entry<Item.Items, Integer> entry: initialItemToQuantity.entrySet()) {
            sum += entry.getValue();
        }
        return sum;
    }

}
