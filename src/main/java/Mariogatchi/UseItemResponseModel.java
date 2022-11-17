package Mariogatchi;

public class UseItemResponseModel {

    private int quantityToUpdate;

    private Inventory inventory;

    /*
    The output data for the UseItem use case:
    @param - the quantity of item that was used
    @param - the inventory that the item was used from.
     */
    public UseItemResponseModel(int quantityToUpdate, Inventory inventory) {

        this.quantityToUpdate = quantityToUpdate;
        this.inventory = inventory;
    }

    public int getQuantityToUpdate() {
        return quantityToUpdate;
    }
}
