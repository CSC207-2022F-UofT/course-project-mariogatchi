package mariogatchi.use_cases.item_cases.add_item;

import mariogatchi.entities.Inventory;
import mariogatchi.entities.items.Apple;
import mariogatchi.entities.items.Item;
import mariogatchi.entities.items.Leash;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/*
Unit testing class for the RemoveItem use case
 */
public class AddItemRunnerTest {

    /*
    When AddItem is called with a non-reusable Item with quantity 1 when there is initially none of that Item in the
    Inventory, the Item should be added to Inventory and the quantity of the Item in Inventory should update to 1.
     */
    @Test
    public void nonReusableAddOneFromNoneTest() {
        AddItemOutputBoundary ADDITEMPRESENTER = new AddItemOutputBoundary() {
            @Override
            public AddItemResponseModel addItemPrepareSuccessView(AddItemResponseModel responseModel) {
                assertTrue(responseModel.getInventory().getQuantity(responseModel.getItem().getName()) == 1);
                return null;
            }

            @Override
            public AddItemResponseModel addItemPrepareFailureView(String error, AddItemResponseModel responseModel) {
                fail(error);
                return null;
            }
        };

        // creating Item
        Item apple = new Apple();

        // creating Inventory
        Map<Item.Items, Integer> itemToQuant = new HashMap<Item.Items, Integer>();
        Inventory inventory = new Inventory(itemToQuant, 100);

        // creating quantity
        Integer quantityToAdd = 1;

        // creating the RemoveItemInputBoundary
        AddItemInputBoundary addItemRunner = new AddItemRunner(ADDITEMPRESENTER);

        // creating the RemoveItemRequestModel (input data)
        AddItemRequestModel addItemRequestModel = new AddItemRequestModel(apple, inventory, quantityToAdd);

        // run the use case
        addItemRunner.addItemToInv(addItemRequestModel);
    }

    /*
    When AddItem is called with a non-reusable Item with quantity 1 when there is initially 1 of that Item in the
    Inventory, the quantity of the Item in Inventory should update to 2.
     */
    @Test
    public void nonReusableAddOneFromOneTest() {
        AddItemOutputBoundary ADDITEMPRESENTER = new AddItemOutputBoundary() {
            @Override
            public AddItemResponseModel addItemPrepareSuccessView(AddItemResponseModel responseModel) {
                assertTrue(responseModel.getInventory().getQuantity(responseModel.getItem().getName()) == 2);
                return null;
            }

            @Override
            public AddItemResponseModel addItemPrepareFailureView(String error, AddItemResponseModel responseModel) {
                fail(error);
                return null;
            }
        };

        // creating Item
        Item apple = new Apple();

        // creating Inventory
        Map<Item.Items, Integer> itemToQuant = new HashMap<Item.Items, Integer>();
        itemToQuant.put(new Apple().getName(), 1);
        Inventory inventory = new Inventory(itemToQuant, 100);

        // creating quantity
        Integer quantityToAdd = 1;

        // creating the RemoveItemInputBoundary
        AddItemInputBoundary addItemRunner = new AddItemRunner(ADDITEMPRESENTER);

        // creating the RemoveItemRequestModel (input data)
        AddItemRequestModel addItemRequestModel = new AddItemRequestModel(apple, inventory, quantityToAdd);

        // run the use case
        addItemRunner.addItemToInv(addItemRequestModel);
    }

    /*
    When AddItem is called with a non-reusable Item with quantity 101 when the capacity is 100, the ADDITEMPRESENTER
    should call it's prepareFailureView method with the message "Item cannot be added: not enough space in inventory".
     */
    @Test
    public void nonReusableExceedsCapacityTest() {
        AddItemOutputBoundary ADDITEMPRESENTER = new AddItemOutputBoundary() {
            @Override
            public AddItemResponseModel addItemPrepareSuccessView(AddItemResponseModel responseModel) {
                fail("prepareSuccessView was not supposed to be called");
                return null;
            }

            @Override
            public AddItemResponseModel addItemPrepareFailureView(String error, AddItemResponseModel responseModel) {
                assertSame("Item cannot be added: not enough space in inventory", error);
                return null;
            }
        };

        // creating Item
        Item apple = new Apple();

        // creating Inventory
        Map<Item.Items, Integer> itemToQuant = new HashMap<Item.Items, Integer>();
        Inventory inventory = new Inventory(itemToQuant, 100);

        // creating quantity
        Integer quantityToAdd = 101;

        // creating the RemoveItemInputBoundary
        AddItemInputBoundary addItemRunner = new AddItemRunner(ADDITEMPRESENTER);

        // creating the RemoveItemRequestModel (input data)
        AddItemRequestModel addItemRequestModel = new AddItemRequestModel(apple, inventory, quantityToAdd);

        // run the use case
        addItemRunner.addItemToInv(addItemRequestModel);
    }


    /*
    When AddItem is called with a reusable Item when it does not already exist in the Inventory, the Item should be added to Inventory and
    the quantity of the Item in Inventory should be 1. Note: no more than one of a reusable item should be added to
    an Inventory.
     */
    @Test
    public void reusableAddWhenNotExistInInventoryTest() {
        AddItemOutputBoundary ADDITEMPRESENTER = new AddItemOutputBoundary() {
            @Override
            public AddItemResponseModel addItemPrepareSuccessView(AddItemResponseModel responseModel) {
                assertTrue(responseModel.getInventory().getQuantity(responseModel.getItem().getName()) == 1);
                return null;
            }

            @Override
            public AddItemResponseModel addItemPrepareFailureView(String error, AddItemResponseModel responseModel) {
                fail(error);
                return null;
            }
        };

        // creating Item
        Item leash = new Leash();

        // creating Inventory
        Map<Item.Items, Integer> itemToQuant = new HashMap<Item.Items, Integer>();
        Inventory inventory = new Inventory(itemToQuant, 100);

        // creating quantity
        Integer quantityToAdd = 1;

        // creating the RemoveItemInputBoundary
        AddItemInputBoundary addItemRunner = new AddItemRunner(ADDITEMPRESENTER);

        // creating the RemoveItemRequestModel (input data)
        AddItemRequestModel addItemRequestModel = new AddItemRequestModel(leash, inventory, quantityToAdd);

        // run the use case
        addItemRunner.addItemToInv(addItemRequestModel);
    }

    /*
    When AddItem is called with a reusable Item when it already exists in the Inventory,
    ADDITEMPRESENTER should call it's prepareFailureView method with the message
    ("Item cannot be added: Item is reusable and already exists in your inventory")
     */
    @Test
    public void reusableAddWhenExistsInInventoryTest() {
        AddItemOutputBoundary ADDITEMPRESENTER = new AddItemOutputBoundary() {
            @Override
            public AddItemResponseModel addItemPrepareSuccessView(AddItemResponseModel responseModel) {
                fail("prepareSuccessView was not supposed to be called");
                return null;
            }

            @Override
            public AddItemResponseModel addItemPrepareFailureView(String error, AddItemResponseModel responseModel) {
                assertSame("Item cannot be added: Item is reusable and already exists in your inventory", error);
                return null;
            }
        };

        // creating Item
        Item leash = new Leash();

        // creating Inventory
        Map<Item.Items, Integer> itemToQuant = new HashMap<Item.Items, Integer>();
        itemToQuant.put(new Leash().getName(), 1);
        Inventory inventory = new Inventory(itemToQuant, 100);

        // creating quantity
        Integer quantityToAdd = 1;

        // creating the RemoveItemInputBoundary
        AddItemInputBoundary addItemRunner = new AddItemRunner(ADDITEMPRESENTER);

        // creating the RemoveItemRequestModel (input data)
        AddItemRequestModel addItemRequestModel = new AddItemRequestModel(leash, inventory, quantityToAdd);

        // run the use case
        addItemRunner.addItemToInv(addItemRequestModel);
    }

}