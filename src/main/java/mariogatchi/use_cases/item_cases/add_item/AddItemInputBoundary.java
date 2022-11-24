package mariogatchi.use_cases.item_cases.add_item;

public interface AddItemInputBoundary {

    /*
    Interface for the AddItem use case Input Boundary
     */
    AddItemResponseModel addItemToInv(AddItemRequestModel requestModel);
}
