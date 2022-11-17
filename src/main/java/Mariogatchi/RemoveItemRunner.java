package Mariogatchi;

public class RemoveItemRunner implements RemoveItemInputBoundary{

    private final RemoveItemPresenter presenter;

    /*
    The interactor for the UseItem use case
    @param presenter - the presenter for the RemoveItem use case
     */
    public RemoveItemRunner(RemoveItemPresenter presenter) {
        this.presenter = presenter;
    }

    /*
    Removes a specified amount of an item from an inventory
    returns an instance of RemoveItemResponseModel
     */
    @Override
    public RemoveItemResponseModel removeItemFromInv(RemoveItemRequestModel requestModel) {
        if (requestModel.getInventory().removeItem(requestModel.getItem(), requestModel.getQuantity())) {
            RemoveItemResponseModel responseModel = new RemoveItemResponseModel(requestModel.getItem(),
                    requestModel.getInventory(), requestModel.getQuantity());
            return presenter.prepareSuccessView(responseModel);
        }
        else {
            return presenter.prepareFailureView("You do not have enough of this item to remove");
        }
    }

}
