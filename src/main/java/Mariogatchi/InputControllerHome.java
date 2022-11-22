package mariogatchi;

import java.util.List;

public class InputControllerHome {

    public enum HomeActions {
        SAVE,
        EXIT,

        ADD_ITEM,

        REMOVE_ITEM,

        USE_ITEM,

        FOREST,

        PARK;
    }

    public void request(HomeActions action, List<String> inputs) {
        GameInteractor game = new GameInteractor();
        switch(action) {
            case SAVE:
                game.saveRequest();
                break;
            case EXIT: // Saves and exits
                game.exitRequest();
                break;
            case ADD_ITEM:
                // The code to generate a random item and find the current users inventory should be in the request model itself
                //ItemFactory random = new ItemFactory();
                //Item item = random.generateItem();
                //Inventory inventory = load the current user file and get its inventory
                //AddItemRunner runner = new AddItemRunner(item, inventory, 1); //
                //AddItemRequestModel model = new AddItemRequestModel();
                //runner.addItemToInv(model);
                break;
            case REMOVE_ITEM:
                //RemoveItemRunner runner = new RemoveItemRunner(); // Will have to call some sort of random item chooser
                //runner.removeItemFromInv
                break;
            case USE_ITEM:
                break;
            case FOREST:
                break;
            case PARK:
                break;
            default:
                // error
        }
    }
}
