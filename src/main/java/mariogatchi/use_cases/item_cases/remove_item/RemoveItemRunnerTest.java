package mariogatchi.use_cases.item_cases.remove_item;

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
public class RemoveItemRunnerTest {

    /*
    When RemoveItem is called with a non-reusable Item, with quantity 1 when there is more than 1 of the Item in the
    Inventory, the quantity of the Item in Inventory should decrease by 1.
     */
    @Test
    public void nonReusableSufficientQuantityRemoveOneTest() {
        RemoveItemOutputBoundary REMOVEITEMPRESENTER = new RemoveItemOutputBoundary() {
            @Override
            public RemoveItemResponseModel removeItemPrepareSuccessView(RemoveItemResponseModel responseModel) {
                assertTrue(responseModel.getInventory().getQuantity(responseModel.getItem().getName()) == 1);
                return null;
            }

            @Override
            public RemoveItemResponseModel removeItemPrepareFailureView(String error) {
                fail(error);
                return null;
            }
        };

        // creating Item
        Item apple = new Apple();

        // creating Inventory
        Map<Item.Items, Integer> itemToQuant = new HashMap<Item.Items, Integer>();
        itemToQuant.put(new Apple().getName(), 2);
        Inventory inventory = new Inventory(itemToQuant, 100);

        // creating quantity
        Integer quantityToRemove = 1;

        // creating the RemoveItemInputBoundary
        RemoveItemInputBoundary removeItemRunner = new RemoveItemRunner(REMOVEITEMPRESENTER);

        // creating the RemoveItemRequestModel (input data)
        RemoveItemRequestModel removeItemRequestModel = new RemoveItemRequestModel(apple, inventory, quantityToRemove);

        // run the use case
        removeItemRunner.removeItemFromInv(removeItemRequestModel);
    }

    /*
    When RemoveItem is called with a non-reusable Item, with quantity 2 when there is more than 2 of the Item in the
    Inventory, the quantity of the Item in Inventory should decrease by 2.
     */
    @Test
    public void nonReusableSufficientQuantityRemoveTwoTest() {
        RemoveItemOutputBoundary REMOVEITEMPRESENTER = new RemoveItemOutputBoundary() {
            @Override
            public RemoveItemResponseModel removeItemPrepareSuccessView(RemoveItemResponseModel responseModel) {
                assertTrue(responseModel.getInventory().getQuantity(responseModel.getItem().getName()) == 1);
                return null;
            }

            @Override
            public RemoveItemResponseModel removeItemPrepareFailureView(String error) {
                fail(error);
                return null;
            }
        };

        // creating Item
        Item apple = new Apple();

        // creating Inventory
        Map<Item.Items, Integer> itemToQuant = new HashMap<Item.Items, Integer>();
        itemToQuant.put(new Apple().getName(), 3);
        Inventory inventory = new Inventory(itemToQuant, 100);

        // creating quantity
        Integer quantityToRemove = 2;

        // creating the RemoveItemInputBoundary
        RemoveItemInputBoundary removeItemRunner = new RemoveItemRunner(REMOVEITEMPRESENTER);

        // creating the RemoveItemRequestModel (input data)
        RemoveItemRequestModel removeItemRequestModel = new RemoveItemRequestModel(apple, inventory, quantityToRemove);

        // run the use case
        removeItemRunner.removeItemFromInv(removeItemRequestModel);
    }

    /*
    When RemoveItem is called with a non-reusable Item, with quantity 1 when there is exactly 1 of the Item in the
    Inventory, the Item key should disappear from the Inventory entirely.
     */
    @Test
    public void nonReusableSufficientQuantityRemoveAllItemTest() {
        RemoveItemOutputBoundary REMOVEITEMPRESENTER = new RemoveItemOutputBoundary() {
            @Override
            public RemoveItemResponseModel removeItemPrepareSuccessView(RemoveItemResponseModel responseModel) {
                assertFalse(responseModel.getInventory().itemExists(new Apple().getName()));
                return null;
            }

            @Override
            public RemoveItemResponseModel removeItemPrepareFailureView(String error) {
                fail(error);
                return null;
            }
        };

        // creating Item
        Item apple = new Apple();

        // creating Inventory
        Map<Item.Items, Integer> itemToQuant = new HashMap<Item.Items, Integer>();
        itemToQuant.put(new Apple().getName(), 3);
        Inventory inventory = new Inventory(itemToQuant, 100);

        // creating quantity
        Integer quantityToRemove = 3;

        // creating the RemoveItemInputBoundary
        RemoveItemInputBoundary removeItemRunner = new RemoveItemRunner(REMOVEITEMPRESENTER);

        // creating the RemoveItemRequestModel (input data)
        RemoveItemRequestModel removeItemRequestModel = new RemoveItemRequestModel(apple, inventory, quantityToRemove);

        // run the use case
        removeItemRunner.removeItemFromInv(removeItemRequestModel);
    }


    /*
    When RemoveItem is called with a non-reusable Item, with quantity 2 when there is exactly 1 of the Item in the
    Inventory, REMOVEITEMPRESENTER should call prepareFailureView with the message ("You do not have enough of this item to
    remove")
     */
    @Test
    public void nonReusableInsufficientQuantityTest() {
        RemoveItemOutputBoundary REMOVEITEMPRESENTER = new RemoveItemOutputBoundary() {
            @Override
            public RemoveItemResponseModel removeItemPrepareSuccessView(RemoveItemResponseModel responseModel) {
                fail("prepareSuccessView is was not supposed to be called");
                return null;
            }

            @Override
            public RemoveItemResponseModel removeItemPrepareFailureView(String error) {
                assertSame("You do not have enough of this item to remove", error);
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
        Integer quantityToRemove = 2;

        // creating the RemoveItemInputBoundary
        RemoveItemInputBoundary removeItemRunner = new RemoveItemRunner(REMOVEITEMPRESENTER);

        // creating the RemoveItemRequestModel (input data)
        RemoveItemRequestModel removeItemRequestModel = new RemoveItemRequestModel(apple, inventory, quantityToRemove);

        // run the use case
        removeItemRunner.removeItemFromInv(removeItemRequestModel);
    }


    /*
    When RemoveItem is called with a reusable Item, REMOVEITEMPRESENTER calls prepareFailureView with the message
    ("Default item cannot be removed from inventory").
     remain unchanged.
     */
    @Test
    public void removeReusableTest() {
        RemoveItemOutputBoundary REMOVEITEMPRESENTER = new RemoveItemOutputBoundary() {
            @Override
            public RemoveItemResponseModel removeItemPrepareSuccessView(RemoveItemResponseModel responseModel) {
                fail("prepareSuccessView is was not supposed to be called");
                return null;
            }

            @Override
            public RemoveItemResponseModel removeItemPrepareFailureView(String error) {
                assertSame("Default item cannot be removed from inventory", error);
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
        Integer quantityToRemove = 1;

        // creating the RemoveItemInputBoundary
        RemoveItemInputBoundary removeItemRunner = new RemoveItemRunner(REMOVEITEMPRESENTER);

        // creating the RemoveItemRequestModel (input data)
        RemoveItemRequestModel removeItemRequestModel = new RemoveItemRequestModel(leash, inventory, quantityToRemove);

        // run the use case
        removeItemRunner.removeItemFromInv(removeItemRequestModel);
    }

}