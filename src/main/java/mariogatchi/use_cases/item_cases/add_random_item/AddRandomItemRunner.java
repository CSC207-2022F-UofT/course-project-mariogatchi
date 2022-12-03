package mariogatchi.use_cases.item_cases.add_random_item;

import mariogatchi.entities.items.Item;
import mariogatchi.entities.items.RandomItemGenerator;
import mariogatchi.use_cases.item_cases.add_item.AddItemInputBoundary;
import mariogatchi.use_cases.item_cases.add_item.AddItemRequestModel;
import mariogatchi.use_cases.item_cases.add_item.AddItemResponseModel;
import mariogatchi.use_cases.item_cases.add_item.AddItemRunner;

/*
Adds a randomly generated item to the users inventory
 */
public class AddRandomItemRunner implements AddRandomItemInputBoundary {

    private final AddRandomItemOutputBoundary ADDRANDOMITEMPRESENTER;

    private final RandomItemGenerator randomItemGenerator;



    public AddRandomItemRunner(AddRandomItemOutputBoundary addRandomItemOutputBoundary) {
        this.ADDRANDOMITEMPRESENTER = addRandomItemOutputBoundary;
        this.randomItemGenerator = new RandomItemGenerator();
    }

    @Override
    public AddRandomItemResponseModel addRandomItem(AddRandomItemRequestModel requestModel) {
        Item randomItem = this.randomItemGenerator.generateRandomItem();
        AddItemRequestModel addItemRequestModel = new AddItemRequestModel(randomItem, requestModel.getInventory(), 1);
        AddItemResponseModel addItemResponseModel = requestModel.getAddItemRunner().addItemToInv(addItemRequestModel);
        if (addItemResponseModel.getAdded()) {
            AddRandomItemResponseModel addRandomItemResponseModel = new AddRandomItemResponseModel(randomItem.getName(), requestModel.getInventory(), true);
            return ADDRANDOMITEMPRESENTER.addRandomItemPrepareSuccessView(addRandomItemResponseModel);
        }
        else {
            AddRandomItemResponseModel addRandomItemResponseModel = new AddRandomItemResponseModel(randomItem.getName(), requestModel.getInventory(), false);
            return ADDRANDOMITEMPRESENTER.addRandomItemPrepareFailureView("Item could not be added", addRandomItemResponseModel);
        }
    }

}
