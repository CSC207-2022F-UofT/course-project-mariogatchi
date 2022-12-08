package mariogatchi.use_cases.item_cases.remove_item;

public interface RemoveItemOutputBoundary {
    /*
    The interface of the presenter for the RemoveItem use case
     */
    RemoveItemResponseModel removeItemPrepareSuccessView(RemoveItemResponseModel responseModel);

    RemoveItemResponseModel removeItemPrepareFailureView(String error, RemoveItemResponseModel responseModel);
}
