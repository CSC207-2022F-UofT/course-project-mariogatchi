package mariogatchi.use_cases.item_cases.use_item;

import mariogatchi.entities.Inventory;
import mariogatchi.entities.Mariogatchi;
import mariogatchi.entities.Statistics;
import mariogatchi.entities.environments.Env;
import mariogatchi.entities.items.Apple;
import mariogatchi.entities.items.BadApple;
import mariogatchi.entities.items.Item;
import mariogatchi.entities.items.Leash;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/*
Unit testing class for the UseItem use case
 */
public class UseItemRunnerTest {

    Map<Item.Items, Integer> itemToQuant;

    Env currentEnvironment;

    Mariogatchi gatchi;

    @BeforeEach
    void setup() throws IOException {

        // creating default itemToQuantity map
        this.itemToQuant = new HashMap<>();

        // creating default currentEnvironment
        this.currentEnvironment = Env.HOME;

        // creating default Mariogatchi
        String imagePath = "mariogatchi/use_cases/item_cases/use_item/mariogatchi_image.png";
        BufferedImage mariogatchiImage = ImageIO.read(new File(imagePath));

        this.gatchi = new Mariogatchi(0, "mario", mariogatchiImage, "common");
    }
    /*
    For a non-reusable item for which there is at least one already
    existing in the user's inventory, when UseItemRunner is called, USE_ITEM_PRESENTER
    should call it's prepareSuccess view method,
    the stats should update appropriately and 1 quantity of the
    item is removed from the inventory.
     */
    @Test
    public void nonReusableItemTest() {
        UseItemOutputBoundary USE_ITEM_PRESENTER = new UseItemOutputBoundary() {
            @Override
            public UseItemResponseModel useItemPrepareSuccessView(UseItemResponseModel responseModel) {
                // check that stats for HUNGER is 40, ENERGY is 45
                assertEquals(40, (int) responseModel.getStatToValue().get(Statistics.Stats.HUNGER));
                assertEquals(45, (int) responseModel.getStatToValue().get(Statistics.Stats.ENERGY));
                // check that quantity of badApple in inventory is 1
                assertEquals(1, responseModel.getInventory().getQuantity(new BadApple().getName()));
                return null;
            }

            @Override
            public UseItemResponseModel useItemPrepareFailureView(String error, UseItemResponseModel responseModel) {
                fail(error);
                return null;
            }
        };


        // creating Inventory
        this.itemToQuant.put(Item.Items.APPLE, 2);
        Inventory inventory = new Inventory(this.itemToQuant, 100);


        // creating the UseItemInputBoundary
        UseItemInputBoundary useItemRunner = new UseItemRunner(USE_ITEM_PRESENTER);

        // creating the UseItemRequestModel (input data)
        UseItemRequestModel useItemRequestModel = new UseItemRequestModel("BAD_APPLE", this.currentEnvironment, this.gatchi, inventory);

        // run the use case
        useItemRunner.useItem(useItemRequestModel);
    }

    /*
    For a reusable item for which there is one already existing in the user's inventory,
    when UseItemRunner is called, USE_ITEM_PRESENTER should call it's prepareSuccess view method,
    the stats should update appropriately and the user's inventory should remain unchanged.
     */
    @Test
    public void ReusableItemTest() {
        UseItemOutputBoundary USE_ITEM_PRESENTER = new UseItemOutputBoundary() {
            @Override
            public UseItemResponseModel useItemPrepareSuccessView(UseItemResponseModel responseModel) {
                // check that stats for HAPPINESS is still 50, ENERGY is 40, CLEANLINESS is 40
                assertEquals(50, (int) responseModel.getStatToValue().get(Statistics.Stats.HAPPINESS));
                assertEquals(40, (int) responseModel.getStatToValue().get(Statistics.Stats.ENERGY));
                assertEquals(40, (int) responseModel.getStatToValue().get(Statistics.Stats.CLEANLINESS));
                // check that quantity of apple in inventory is 1
                assertEquals(1, responseModel.getInventory().getQuantity(new Leash().getName()));
                return null;
            }

            @Override
            public UseItemResponseModel useItemPrepareFailureView(String error, UseItemResponseModel responseModel) {
                fail(error);
                return null;
            }
        };

        // creating Inventory
        this.itemToQuant.put(new Leash().getName(), 1);
        Inventory inventory = new Inventory(this.itemToQuant, 100);


        // creating the UseItemInputBoundary
        UseItemInputBoundary useItemRunner = new UseItemRunner(USE_ITEM_PRESENTER);

        // creating the UseItemRequestModel (input data)
        UseItemRequestModel useItemRequestModel = new UseItemRequestModel("LEASH", this.currentEnvironment, this.gatchi, inventory);

        // run the use case
        useItemRunner.useItem(useItemRequestModel);
    }


    /*
    If the User does not have at least one instance of the Item in their Inventory,
    USE_ITEM_PRESENTER should call it's prepareFailView method.
     */
    @Test
    public void insufficientQuantityTest() {
        UseItemOutputBoundary USE_ITEM_PRESENTER = new UseItemOutputBoundary() {
            @Override
            public UseItemResponseModel useItemPrepareSuccessView(UseItemResponseModel responseModel) {
                // check that this method was not called
                fail("prepareSuccessView is not supposed to be called");
                return null;
            }

            @Override
            public UseItemResponseModel useItemPrepareFailureView(String error, UseItemResponseModel responseModel) {
                System.out.println(error + ": This was supposed to happen");
                return null;
            }
        };


        // creating Inventory
        this.itemToQuant.put(new Apple().getName(), 0);
        Inventory inventory = new Inventory(this.itemToQuant, 100);


        // creating the UseItemInputBoundary
        UseItemInputBoundary useItemRunner = new UseItemRunner(USE_ITEM_PRESENTER);

        // creating the UseItemRequestModel (input data)
        UseItemRequestModel useItemRequestModel = new UseItemRequestModel("APPLE", this.currentEnvironment, this.gatchi, inventory);

        // run the use case
        useItemRunner.useItem(useItemRequestModel);
    }

    /*
    If the Environment that the Item is being called used from does not belong to the Item's
    eligibleEnvironments, then USE_ITEM_PRESENTER should call it's prepareFailView method.
     */

    @Test
    public void notEligibleEnvironmentTest() {
        UseItemOutputBoundary USE_ITEM_PRESENTER = new UseItemOutputBoundary() {
            @Override
            public UseItemResponseModel useItemPrepareSuccessView(UseItemResponseModel responseModel) {
                fail("prepareSuccessView is not supposed to be called");
                return null;
            }

            @Override
            public UseItemResponseModel useItemPrepareFailureView(String error, UseItemResponseModel responseModel) {
                System.out.println(error + ": This was supposed to happen");
                return null;
            }
        };

        this.itemToQuant.put(new Leash().getName(), 1);
        Inventory inventory = new Inventory(this.itemToQuant, 100);

        // creating currentEnvironment
        this.currentEnvironment = Env.FOREST;

        // creating the UseItemInputBoundary
        UseItemInputBoundary useItemRunner = new UseItemRunner(USE_ITEM_PRESENTER);

        // creating the UseItemRequestModel (input data)
        UseItemRequestModel useItemRequestModel = new UseItemRequestModel("LEASH", this.currentEnvironment, this.gatchi, inventory);

        // run the use case
        useItemRunner.useItem(useItemRequestModel);
    }
}