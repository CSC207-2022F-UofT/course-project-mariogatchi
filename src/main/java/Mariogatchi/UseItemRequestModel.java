package Mariogatchi;

public class UseItemRequestModel {
    private Item itemToUse;
    private Environment currentEnvironment;
    private Mariogatchi mariogatchi;
    private Inventory inventory;

    public UseItemRequestModel(Item item, Environment environment, Mariogatchi mariogatchi, Inventory inventory) {
        this.itemToUse = item;
        this.currentEnvironment = environment;
        this.mariogatchi = mariogatchi;
        this.inventory = inventory;
    }

    public Item getItemToUse() {
        return this.itemToUse;
    }

    public Environment getCurrentEnvironment() {
        return this.currentEnvironment;
    }

    public Mariogatchi getMariogatchi() {
        return this.mariogatchi;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

}
