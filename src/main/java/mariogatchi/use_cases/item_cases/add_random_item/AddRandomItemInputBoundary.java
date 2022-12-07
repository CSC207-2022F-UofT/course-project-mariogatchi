package mariogatchi.use_cases.item_cases.add_random_item;

/*
Input boundary for the AddRandomItem use case
 */
public interface AddRandomItemInputBoundary {

    AddRandomItemResponseModel addRandomItem(AddRandomItemRequestModel requestModel);
}
