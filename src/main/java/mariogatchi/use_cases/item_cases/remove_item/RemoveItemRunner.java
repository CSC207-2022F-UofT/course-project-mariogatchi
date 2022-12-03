package mariogatchi.use_cases.item_cases.remove_item;

import mariogatchi.entities.items.Reusable;

public class RemoveItemRunner implements RemoveItemInputBoundary{

    private final RemoveItemOutputBoundary REMOVEITEMPRESENTER;

    /*
    The interactor for the UseItem use case
    @param presenter - the presenter for the RemoveItem use case
     */
    public RemoveItemRunner(RemoveItemOutputBoundary presenter) {
        this.REMOVEITEMPRESENTER = presenter;
    }

    /*
    Removes a specified amount of an item from an inventory
    returns an instance of RemoveItemResponseModel
     */
    @Override
    public RemoveItemResponseModel removeItemFromInv(RemoveItemRequestModel requestModel) {
        if (requestModel.getItem() instanceof Reusable) {
            return REMOVEITEMPRESENTER.removeItemPrepareFailureView("Default item cannot be removed from inventory");
        }
        if (requestModel.getInventory().removeItem(requestModel.getItem().getName(), requestModel.getQuantity())) {
            RemoveItemResponseModel responseModel = new RemoveItemResponseModel(requestModel.getItem(),
                    requestModel.getInventory(), requestModel.getQuantity());
            return REMOVEITEMPRESENTER.removeItemPrepareSuccessView(responseModel);
        }
        else {
            return REMOVEITEMPRESENTER.removeItemPrepareFailureView("You do not have enough of this item to remove");
        }
    }

}
