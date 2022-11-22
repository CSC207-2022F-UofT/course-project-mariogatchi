package Mariogatchi;

public interface RemoveItemPresenter {
    /*
    The interface of the presenter for the RemoveItem use case
     */
    RemoveItemResponseModel prepareSuccessView(RemoveItemResponseModel responseModel);

    RemoveItemResponseModel prepareFailureView(String error);
}
