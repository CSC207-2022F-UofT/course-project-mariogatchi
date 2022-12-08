package mariogatchi.use_cases.item_cases.add_item;

import mariogatchi.entities.items.Item;
import mariogatchi.entities.items.Reusable;
import mariogatchi.entities.Inventory;

public class AddItemRunner implements AddItemInputBoundary{


    private final AddItemOutputBoundary ADDITEMPRESENTER;

    /*
    Adds an Item to an Inventory

    @param presenter The implementing class object of the Output Boundary for this Use Case Interactor
     */


    public AddItemRunner(AddItemOutputBoundary presenter) {
        this.ADDITEMPRESENTER = presenter;
    }

    /*
    Checks whether the item can be added to the Inventory based on if the item is reusable (and if it already
    exists in the Inventory) and if there is enough space in the inventory.
    If the item can be added, it is added to the given Inventory.
     */
    @Override
    public AddItemResponseModel addItemToInv(AddItemRequestModel requestModel) {
        if (itemInInventory(requestModel.getItem().getName(), requestModel.getInventory())
                && requestModel.getItem() instanceof Reusable) {
            AddItemResponseModel responseModel = new AddItemResponseModel(requestModel.getItem(),
                    requestModel.getInventory(), requestModel.getQuantity(), false);
            return ADDITEMPRESENTER.addItemPrepareFailureView("Item cannot be added: Item is reusable and already exists" +
                    " in your inventory", responseModel);
        } else if (requestModel.getInventory().addItem(requestModel.getItem().getName(), requestModel.getQuantity())) {
            AddItemResponseModel responseModel = new AddItemResponseModel(requestModel.getItem(),
                    requestModel.getInventory(), requestModel.getQuantity(), true);
            return ADDITEMPRESENTER.addItemPrepareSuccessView(responseModel);
        }
        else {
            AddItemResponseModel responseModel = new AddItemResponseModel(requestModel.getItem(),
                    requestModel.getInventory(), requestModel.getQuantity(), false);
            return ADDITEMPRESENTER.addItemPrepareFailureView("Item cannot be added: not enough space in inventory", responseModel);
        }
    }


    // checks whether the item already exists in the Inventory
    private boolean itemInInventory(Item.Items itemName, Inventory inventory) {
        return inventory.itemExists(itemName);
    }
}
