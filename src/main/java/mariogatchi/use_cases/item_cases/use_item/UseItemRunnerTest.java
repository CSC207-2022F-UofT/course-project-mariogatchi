package mariogatchi.use_cases.item_cases.use_item;

import mariogatchi.entities.Inventory;
import mariogatchi.entities.Mariogatchi;
import mariogatchi.entities.Statistics;
import mariogatchi.entities.environments.Env;
import mariogatchi.entities.items.BadApple;
import mariogatchi.entities.items.Item;
import mariogatchi.entities.items.Apple;
import mariogatchi.entities.items.Leash;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/*
Unit testing class for the UseItem use case
 */
public class UseItemRunnerTest {


    /*
    For a non-reusable item for which there is at least one already
    existing in the user's inventory, when UseItemRunner is called, USEITEMPRESENTER
    should call it's prepareSuccess view method,
    the stats should update appropriately and 1 quantity of the
    item is removed from the inventory.
     */
    @Test
    public void nonReusableItemTest() {
        UseItemOutputBoundary USEITEMPRESENTER = new UseItemOutputBoundary() {
            @Override
            public UseItemResponseModel useItemPrepareSuccessView(UseItemResponseModel responseModel) {
                // check that stats for HUNGER is 40, ENERGY is 45
                assertTrue(responseModel.getStatToValue().get(Statistics.Stats.HUNGER) == 40);
                assertTrue(responseModel.getStatToValue().get(Statistics.Stats.ENERGY) == 45);
                // check that quantity of badApple in inventory is 1
                assertTrue(responseModel.getInventory().getQuantity(new BadApple().getName()) == 1);
                return null;
            }

            @Override
            public UseItemResponseModel useItemPrepareFailureView(String error) {
                fail(error);
                return null;
            }
        };

        // creating Item
        Item badApple = new BadApple();

        // creating Inventory
        Map<Item.Items, Integer> itemToQuant = new HashMap<Item.Items, Integer>();
        itemToQuant.put(Item.Items.APPLE, 2);
        Inventory inventory = new Inventory(itemToQuant, 100);

        // creating Mariogatchi
        Mariogatchi gatchi = new Mariogatchi();

        // creating currentEnvironment
        Env home = Env.HOME;


        // creating the UseItemInputBoundary
        UseItemInputBoundary useItemRunner = new UseItemRunner(USEITEMPRESENTER);

        // creating the UseItemRequestModel (input data)
        UseItemRequestModel useItemRequestModel = new UseItemRequestModel(badApple, home, gatchi, inventory);

        // run the use case
        useItemRunner.useItem(useItemRequestModel);
    }

    /*
    For a reusable item for which there is one already existing in the user's inventory,
    when UseItemRunner is called, USEITEMPRESENTER should call it's prepareSuccess view method,
    the stats should update appropriately and the user's inventory should remain unchanged.
     */
    @Test
    public void ReusableItemTest() {
        UseItemOutputBoundary USEITEMPRESENTER = new UseItemOutputBoundary() {
            @Override
            public UseItemResponseModel useItemPrepareSuccessView(UseItemResponseModel responseModel) {
                // check that stats for HAPPINESS is still 50, ENERGY is 40, CLEANLINESS is 40
                assertTrue(responseModel.getStatToValue().get(Statistics.Stats.HAPPINESS) == 50);
                assertTrue(responseModel.getStatToValue().get(Statistics.Stats.ENERGY) == 40);
                assertTrue(responseModel.getStatToValue().get(Statistics.Stats.CLEANLINESS) == 40);
                // check that quantity of apple in inventory is 1
                assertTrue(responseModel.getInventory().getQuantity(new Leash().getName()) == 1);
                return null;
            }

            @Override
            public UseItemResponseModel useItemPrepareFailureView(String error) {
                fail(error);
                return null;
            }
        };

        // creating Item
        Item leash = new Leash();

        // creating Inventory
        Map<Item.Items, Integer> itemToQuant = new HashMap<Item.Items, Integer>();
        itemToQuant.put(new Leash().getName(), 1);
        Inventory inventory = new Inventory(itemToQuant, 100);

        // creating Mariogatchi
        Mariogatchi gatchi = new Mariogatchi();

        // creating currentEnvironment
        Env home = Env.HOME;


        // creating the UseItemInputBoundary
        UseItemInputBoundary useItemRunner = new UseItemRunner(USEITEMPRESENTER);

        // creating the UseItemRequestModel (input data)
        UseItemRequestModel useItemRequestModel = new UseItemRequestModel(leash, home, gatchi, inventory);

        // run the use case
        useItemRunner.useItem(useItemRequestModel);
    }


    /*
    If the User does not have at least one instance of the Item in their Inventory,
    USEITEMPRESENTER should call it's prepareFailView method.
     */
    @Test
    public void insufficientQuantityTest() {
        UseItemOutputBoundary USEITEMPRESENTER = new UseItemOutputBoundary() {
            @Override
            public UseItemResponseModel useItemPrepareSuccessView(UseItemResponseModel responseModel) {
                // check that this method was not called
                fail("prepareSuccessView is not supposed to be called");
                return null;
            }

            @Override
            public UseItemResponseModel useItemPrepareFailureView(String error) {
                System.out.println(error + ": This was supposed to happen");
                return null;
            }
        };

        // creating Item
        Item apple = new Apple();

        // creating Inventory
        Map<Item.Items, Integer> itemToQuant = new HashMap<Item.Items, Integer>();
        itemToQuant.put(new Apple().getName(), 0);
        Inventory inventory = new Inventory(itemToQuant, 100);

        // creating Mariogatchi
        Mariogatchi gatchi = new Mariogatchi();

        // creating currentEnvironment
        Env home = Env.HOME;


        // creating the UseItemInputBoundary
        UseItemInputBoundary useItemRunner = new UseItemRunner(USEITEMPRESENTER);

        // creating the UseItemRequestModel (input data)
        UseItemRequestModel useItemRequestModel = new UseItemRequestModel(apple, home, gatchi, inventory);

        // run the use case
        useItemRunner.useItem(useItemRequestModel);
    }

    /*
    If the Environment that the Item is being called used from does not belong to the Item's
    eligibleEnvironments, then USEITEMPRESENTER should call it's prepareFailView method.
     */

    @Test
    public void notEligibleEnvironmentTest() {
        UseItemOutputBoundary USEITEMPRESENTER = new UseItemOutputBoundary() {
            @Override
            public UseItemResponseModel useItemPrepareSuccessView(UseItemResponseModel responseModel) {
                fail("prepareSuccessView is not supposed to be called");
                return null;
            }

            @Override
            public UseItemResponseModel useItemPrepareFailureView(String error) {
                System.out.println(error + ": This was supposed to happen");
                return null;
            }
        };

        // creating Item
        Item apple = new Leash();

        // creating Inventory
        Map<Item.Items, Integer> itemToQuant = new HashMap<Item.Items, Integer>();
        itemToQuant.put(new Leash().getName(), 1);
        Inventory inventory = new Inventory(itemToQuant, 100);

        // creating Mariogatchi
        Mariogatchi gatchi = new Mariogatchi();

        // creating currentEnvironment
        Env forest = Env.FOREST;

        // creating the UseItemInputBoundary
        UseItemInputBoundary useItemRunner = new UseItemRunner(USEITEMPRESENTER);

        // creating the UseItemRequestModel (input data)
        UseItemRequestModel useItemRequestModel = new UseItemRequestModel(apple, forest, gatchi, inventory);

        // run the use case
        useItemRunner.useItem(useItemRequestModel);
    }
}