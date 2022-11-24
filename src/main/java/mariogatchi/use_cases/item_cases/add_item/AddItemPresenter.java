package mariogatchi.use_cases.item_cases.add_item;

public interface AddItemPresenter {
    /*
    Interface for the AddItem use case output boundary
     */
    AddItemResponseModel prepareSuccessView(AddItemResponseModel responseModel);

    AddItemResponseModel prepareFailView(String error);

}
