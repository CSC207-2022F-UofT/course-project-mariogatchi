package mariogatchi.use_cases.item_cases.add_random_item;

import mariogatchi.entities.Inventory;
import mariogatchi.entities.items.Item;
import mariogatchi.use_cases.item_cases.add_item.AddItemInputBoundary;
import mariogatchi.use_cases.item_cases.add_item.AddItemOutputBoundary;
import mariogatchi.use_cases.item_cases.add_item.AddItemResponseModel;
import mariogatchi.use_cases.item_cases.add_item.AddItemRunner;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/*
Unit testing class for addRandomItem use case
 */
public class AddRandomItemRunnerTest {

    /*
    Test that addRandomItemRunner adds an item to the inventory of a user when there is space in the inventory
     */
    @Test
    public void addsRandomItemTest() {
        AddRandomItemOutputBoundary ADD_RANDOM_ITEM_PRESENTER = new AddRandomItemOutputBoundary() {
            @Override
            public AddRandomItemResponseModel addRandomItemPrepareSuccessView(AddRandomItemResponseModel responseModel) {
                assertEquals(1, responseModel.getInventory().getQuantity(responseModel.getItemName()));
                return null;
            }

            @Override
            public AddRandomItemResponseModel addRandomItemPrepareFailureView(String error, AddRandomItemResponseModel responseModel) {
                fail(error);
                return null;
            }
        };

        // creating Inventory
        Map<Item.Items, Integer> itemToQuant = new HashMap<>();
        Inventory inventory = new Inventory(itemToQuant, 100);

        // creating an addItemOutputBoundary and addItemInputBoundary
        AddItemOutputBoundary ADD_ITEM_PRESENTER = new AddItemOutputBoundary() {
            @Override
            public AddItemResponseModel addItemPrepareSuccessView(AddItemResponseModel responseModel) {
                return responseModel;
            }

            @Override
            public AddItemResponseModel addItemPrepareFailureView(String error, AddItemResponseModel responseModel) {
                return responseModel;
            }
        };

        AddItemInputBoundary addItemRunner = new AddItemRunner(ADD_ITEM_PRESENTER);

        // creating an AddRandomItemRequestModel
        AddRandomItemRequestModel addRandomItemRequestModel = new AddRandomItemRequestModel(inventory, addItemRunner);
        // creating an addRandomItem input boundary
        AddRandomItemInputBoundary addRandomItemRunner = new AddRandomItemRunner(ADD_RANDOM_ITEM_PRESENTER);

        // call the use case
        addRandomItemRunner.addRandomItem(addRandomItemRequestModel);

    }

    /*
    Test that addRandomItemRunner calls its fail view method when addRandomItem is called when there is no more
    space in an inventory and the inventory does not contain the item.
     */
    @Test
    public void doesNotAddItemTest() {
        AddRandomItemOutputBoundary ADD_RANDOM_ITEM_PRESENTER = new AddRandomItemOutputBoundary() {
            @Override
            public AddRandomItemResponseModel addRandomItemPrepareSuccessView(AddRandomItemResponseModel responseModel) {
                fail();
                return null;
            }

            @Override
            public AddRandomItemResponseModel addRandomItemPrepareFailureView(String error, AddRandomItemResponseModel responseModel) {
                assertFalse(responseModel.getInventory().itemExists(responseModel.getItemName()));
                return null;
            }
        };

        // creating Inventory
        Map<Item.Items, Integer> itemToQuant = new HashMap<>();
        Inventory inventory = new Inventory(itemToQuant, 0);

        // creating an addItemOutputBoundary and addItemInputBoundary
        AddItemOutputBoundary ADD_ITEM_PRESENTER = new AddItemOutputBoundary() {
            @Override
            public AddItemResponseModel addItemPrepareSuccessView(AddItemResponseModel responseModel) {
                return responseModel;
            }

            @Override
            public AddItemResponseModel addItemPrepareFailureView(String error, AddItemResponseModel responseModel) {
                return responseModel;
            }
        };

        AddItemInputBoundary addItemRunner = new AddItemRunner(ADD_ITEM_PRESENTER);

        // creating an AddRandomItemRequestModel
        AddRandomItemRequestModel addRandomItemRequestModel = new AddRandomItemRequestModel(inventory, addItemRunner);
        // creating an addRandomItem input boundary
        AddRandomItemInputBoundary addRandomItemRunner = new AddRandomItemRunner(ADD_RANDOM_ITEM_PRESENTER);

        // call the use case
        addRandomItemRunner.addRandomItem(addRandomItemRequestModel);

    }

}