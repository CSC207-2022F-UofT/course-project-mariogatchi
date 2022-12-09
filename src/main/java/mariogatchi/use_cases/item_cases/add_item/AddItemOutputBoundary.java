package mariogatchi.use_cases.item_cases.add_item;

public interface AddItemOutputBoundary {
    /*
    Interface for the AddItem use case output boundary
     */
    AddItemResponseModel addItemPrepareSuccessView(AddItemResponseModel responseModel);

    AddItemResponseModel addItemPrepareFailureView(String error, AddItemResponseModel responseModel);

}
