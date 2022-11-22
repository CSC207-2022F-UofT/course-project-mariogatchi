package Mariogatchi;

public class UseItemRequestModel {
    private Item itemToUse;
    private Env currentEnvironment;
    private Mariogatchi mariogatchi;
    private Inventory inventory;

    /*
    The input data needed for the use item use case
    @param itemToUse - the item to use
    @param currentEnvironment - the current environment that the item is to be used in
    @param mariogatchi - the mariogatchi that the item is to be used on
    @param inventory - the inventory that the item is to be used from
     */

    public UseItemRequestModel(Item item, Env environment, Mariogatchi mariogatchi, Inventory inventory) {
        this.itemToUse = item;
        this.currentEnvironment = environment;
        this.mariogatchi = mariogatchi;
        this.inventory = inventory;
    }

    // returns item
    public Item getItemToUse() {
        return this.itemToUse;
    }

    //returns the currentEnvironment
    public Env getCurrentEnvironment() {
        return this.currentEnvironment;
    }

    //returns mariogatchi
    public Mariogatchi getMariogatchi() {
        return this.mariogatchi;
    }

    //returns inventory
    public Inventory getInventory() {
        return this.inventory;
    }

}
