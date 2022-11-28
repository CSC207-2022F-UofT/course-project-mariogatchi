package mariogatchi.controllers;

import mariogatchi.use_cases.games.GameInteractor;

import java.util.List;

public class InputControllerForest {

    public enum ForestActions {
        SAVE,
        EXIT,

        ADD_ITEM,

        REMOVE_ITEM,

        USE_ITEM,

        HOME,

        PARK;
    }

    public void request(ForestActions action, List<String> inputs) {
        GameInteractor game = new GameInteractor();
        switch(action) {
            case SAVE:
                game.saveRequest();
                break;
            case EXIT: // Saves and exits
                game.exitRequest();
                break;
            case ADD_ITEM:
                break;
            case REMOVE_ITEM:
                break;
            case USE_ITEM:
                break;
            case HOME:
                break;
            case PARK:
                // picks a number between 1 and 10
                // if 1, pick from a list of kill request methods and call that.
                double rand = Math.random();
                if (rand > 0.99) {
                    int cause = (int) (Math.random() * 4);
                    switch(cause) {
                        case 0:
                            break;
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                    }
                }
                //ChangeEnvironmentRunner runner = new ChangeEnvironmentRunner();
                //runner.goToPark(); just psuedocode of sorts
                break;
            default:
                // error
        }
    }
}
