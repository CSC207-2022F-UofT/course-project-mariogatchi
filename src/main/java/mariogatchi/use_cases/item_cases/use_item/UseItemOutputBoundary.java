package mariogatchi.use_cases.item_cases.use_item;

public interface UseItemOutputBoundary {

    // the interface of the output boundary for the use item use case
    UseItemResponseModel useItemPrepareSuccessView(UseItemResponseModel responseModel);

    UseItemResponseModel useItemPrepareFailureView(String error);

}
