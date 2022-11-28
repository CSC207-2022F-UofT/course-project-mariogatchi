package mariogatchi.use_cases.item_cases.remove_item;

public interface RemoveItemPresenter {
    /*
    The interface of the presenter for the RemoveItem use case
     */
    RemoveItemResponseModel prepareSuccessView(RemoveItemResponseModel responseModel);

    RemoveItemResponseModel prepareFailureView(String error);
}
