package mariogatchi.controllers;

import mariogatchi.use_cases.games.GameInteractor;

import java.util.List;

public class InputControllerPark {
    public enum ParkActions {
        SAVE,
        EXIT,

        ADD_ITEM,

        REMOVE_ITEM,

        USE_ITEM,

        HOME,

        FOREST;
    }

    public void request(ParkActions action, List<String> inputs) {
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
            case FOREST:
                break;
            default:
                // error
        }
    }
}

