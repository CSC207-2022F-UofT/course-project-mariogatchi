package mariogatchi.use_cases.item_cases.add_random_item;
/*
Output boundary for the AddRandomItem use case
 */
public interface AddRandomItemOutputBoundary {
    AddRandomItemResponseModel addRandomItemPrepareSuccessView(AddRandomItemResponseModel responseModel);

    AddRandomItemResponseModel addRandomItemPrepareFailureView(String error, AddRandomItemResponseModel responseModel);
}
