package mariogatchi.use_cases.item_cases.remove_item;

public interface RemoveItemInputBoundary {
    /*
    The input boundary interface for the RemoveItem use case
     */
    RemoveItemResponseModel removeItemFromInv(RemoveItemRequestModel requestModel);
}
