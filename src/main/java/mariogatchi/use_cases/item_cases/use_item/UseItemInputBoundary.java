package mariogatchi.use_cases.item_cases.use_item;

public interface UseItemInputBoundary {
    /*
    the interface of the input boundary for the use item use case
     */
    public UseItemResponseModel useItem(UseItemRequestModel requestModel);
}
