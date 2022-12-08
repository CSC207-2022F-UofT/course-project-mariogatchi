package mariogatchi.use_cases.item_cases.remove_item;

import mariogatchi.entities.items.Reusable;

/*
Interactor for the remove item use case
 */
public class RemoveItemRunner implements RemoveItemInputBoundary{

    private final RemoveItemOutputBoundary REMOVE_ITEM_PRESENTER;

    public RemoveItemRunner(RemoveItemOutputBoundary presenter) {
        this.REMOVE_ITEM_PRESENTER = presenter;
    }

    /*
    Removes a specified amount of an item from an inventory
    returns an instance of RemoveItemResponseModel

    @param requestModel an instance of the request model for the use item use case
     */
    @Override
    public RemoveItemResponseModel removeItemFromInv(RemoveItemRequestModel requestModel) {
        if (requestModel.getItem() instanceof Reusable) {
            return REMOVE_ITEM_PRESENTER.removeItemPrepareFailureView("Default item cannot be removed from inventory");
        }
        if (requestModel.getInventory().removeItem(requestModel.getItem().getName(), requestModel.getQuantity())) {
            RemoveItemResponseModel responseModel = new RemoveItemResponseModel(requestModel.getItem(),
                    requestModel.getInventory(), requestModel.getQuantity());
            return REMOVE_ITEM_PRESENTER.removeItemPrepareSuccessView(responseModel);
        }
        else {
            return REMOVE_ITEM_PRESENTER.removeItemPrepareFailureView("You do not have enough of this item to remove");
        }
    }

}
