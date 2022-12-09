package mariogatchi.controllers;

import mariogatchi.use_cases.add_mariogatchi.AddMariogatchiInputBoundary;
import mariogatchi.use_cases.add_mariogatchi.AddMariogatchiPresenter;
import mariogatchi.use_cases.add_mariogatchi.AddMariogatchiRequestModel;
import mariogatchi.use_cases.add_mariogatchi.AddMariogatchiRunner;
import mariogatchi.use_cases.authentication.AuthInputBoundary;
import mariogatchi.use_cases.authentication.AuthenticationPresenter;
import mariogatchi.use_cases.authentication.AuthenticationRequestModel;
import mariogatchi.use_cases.authentication.AuthenticatorRunner;
import mariogatchi.use_cases.change_environment.ChangeEnvironmentInputBoundary;
import mariogatchi.use_cases.change_environment.ChangeEnvironmentPresenter;
import mariogatchi.use_cases.change_environment.ChangeEnvironmentRequestModel;
import mariogatchi.use_cases.change_environment.ChangeEnvironmentRunner;
import mariogatchi.use_cases.games.GameInputBoundary;
import mariogatchi.use_cases.games.GameInteractor;
import mariogatchi.use_cases.games.GamePresenter;
import mariogatchi.use_cases.games.GameRequestModel;
import mariogatchi.use_cases.info_access.InfoAccessInputBoundary;
import mariogatchi.use_cases.info_access.InfoAccessPresenter;
import mariogatchi.use_cases.info_access.InfoAccessRequestModel;
import mariogatchi.use_cases.info_access.InformationAccessRunner;
import mariogatchi.use_cases.item_cases.add_item.AddItemInputBoundary;
import mariogatchi.use_cases.item_cases.add_item.AddItemOutputBoundary;
import mariogatchi.use_cases.item_cases.add_item.AddItemRequestModel;
import mariogatchi.use_cases.item_cases.add_item.AddItemRunner;
import mariogatchi.use_cases.item_cases.add_random_item.AddRandomItemInputBoundary;
import mariogatchi.use_cases.item_cases.add_random_item.AddRandomItemOutputBoundary;
import mariogatchi.use_cases.item_cases.add_random_item.AddRandomItemRequestModel;
import mariogatchi.use_cases.item_cases.add_random_item.AddRandomItemRunner;
import mariogatchi.use_cases.item_cases.remove_item.RemoveItemInputBoundary;
import mariogatchi.use_cases.item_cases.remove_item.RemoveItemOutputBoundary;
import mariogatchi.use_cases.item_cases.remove_item.RemoveItemRequestModel;
import mariogatchi.use_cases.item_cases.remove_item.RemoveItemRunner;
import mariogatchi.use_cases.item_cases.use_item.UseItemInputBoundary;
import mariogatchi.use_cases.item_cases.use_item.UseItemOutputBoundary;
import mariogatchi.use_cases.item_cases.use_item.UseItemRequestModel;
import mariogatchi.use_cases.item_cases.use_item.UseItemRunner;
import mariogatchi.use_cases.time.TimeInputBoundary;
import mariogatchi.use_cases.time.TimePresenter;
import mariogatchi.use_cases.time.TimeRequestModel;
import mariogatchi.use_cases.time.TimeRunner;


import java.time.Instant;
import java.util.List;

import static mariogatchi.use_cases.authentication.AuthenticationRequestModel.AuthActions.LOGIN;
import static mariogatchi.use_cases.authentication.AuthenticationRequestModel.AuthActions.SIGNUP;
import static mariogatchi.use_cases.games.GameRequestModel.GameActions.*;


public class InputController {
    private final AuthenticationPresenter authPresenter;
    private final GamePresenter gamePresenter;
    private final AddRandomItemOutputBoundary addRandomPresenter;
    private final AddItemOutputBoundary addPresenter;
    private final RemoveItemOutputBoundary removePresenter;
    private final UseItemOutputBoundary usePresenter;
    private final TimePresenter timePresenter;
    private final InfoAccessPresenter infoPresenter;
    private final ChangeEnvironmentPresenter movePresenter;
    private final AddMariogatchiPresenter addMarioPresenter;
    private final AuthInputBoundary auth;
    private final GameInputBoundary game;
    private final TimeInputBoundary time;
    private final AddRandomItemInputBoundary addRandom;
    private final AddItemInputBoundary add;
    private final RemoveItemInputBoundary remove;
    private final UseItemInputBoundary use;
    private final InfoAccessInputBoundary info;
    private final ChangeEnvironmentInputBoundary move;
    private final AddMariogatchiInputBoundary addMario;

    public InputController(AuthenticationPresenter authPresenter, GamePresenter gamePresenter,
                           AddItemOutputBoundary addPresenter, RemoveItemOutputBoundary removePresenter,
                           UseItemOutputBoundary usePresenter, TimePresenter timePresenter,
                           InfoAccessPresenter infoPresenter, ChangeEnvironmentPresenter movePresenter,
                           AddMariogatchiPresenter addMarioPresenter, AddRandomItemOutputBoundary addRandomPresenter) {
        this.authPresenter = authPresenter;
        this.gamePresenter = gamePresenter;
        this.addPresenter = addPresenter;
        this.addRandomPresenter = addRandomPresenter;
        this.removePresenter = removePresenter;
        this.usePresenter = usePresenter;
        this.timePresenter = timePresenter;
        this.infoPresenter = infoPresenter;
        this.movePresenter = movePresenter;
        this.addMarioPresenter = addMarioPresenter;
        this.auth = new AuthenticatorRunner(authPresenter);
        this.game = new GameInteractor(authPresenter, gamePresenter);
        this.time = new TimeRunner(timePresenter);
        this.addRandom = new AddRandomItemRunner(addRandomPresenter);
        this.add = new AddItemRunner(addPresenter);
        this.remove = new RemoveItemRunner(removePresenter);
        this.use = new UseItemRunner(usePresenter);
        this.info = new InformationAccessRunner(infoPresenter);
        this.move = new ChangeEnvironmentRunner(movePresenter);
        this.addMario = new AddMariogatchiRunner(addMarioPresenter);
    }

    public enum LoginActions {
        LOGIN,
        SIGNUP,
        EXIT;
    }
    public enum GamesActions {
        LOGOUT,
        DELETE_ACCOUNT,
        CREATE_GAME,
        LOAD_GAME,
        DELETE_GAME;
    }

    public enum Actions {
        SAVE,
        EXIT,
        ADD_ITEM,
        REMOVE_ITEM,
        USE_ITEM,
        HOME,
        FOREST,
        PARK,
        INFO,
        REMOVE_MARIO,
        ADD_MARIO;
    }

    public void loginRequest(LoginActions action, List<String> inputs) {

        switch(action) {
            case LOGIN:
                AuthenticationRequestModel loginReq = new AuthenticationRequestModel(inputs.get(0), inputs.get(1), LOGIN);
                auth.setCurrAccount(auth.authenticationRequest(loginReq).getAccount());
                break;
            case SIGNUP:
                AuthenticationRequestModel signupReq = new AuthenticationRequestModel(inputs.get(0), inputs.get(1), SIGNUP);
                auth.setCurrAccount(auth.authenticationRequest(signupReq).getAccount());
                break;
            case EXIT:
                System.exit(0);
                break;
            default:
                // error
        }
    }

    public void requestGames(GamesActions action, List<String> inputs) {
        switch(action) {
            case LOGOUT:
                auth.logoutRequest(auth.getCurrAccount());
                auth.setCurrAccount(null);
                break;
            case DELETE_ACCOUNT:
                auth.deleteRequest(auth.getCurrAccount());
                auth.setCurrAccount(null);
                break;
            case CREATE_GAME:
                GameRequestModel createReq = new GameRequestModel(inputs.get(0), CREATE);
                game.requestAuth(createReq, auth.getCurrAccount());
                break;
            case LOAD_GAME:
                GameRequestModel loadReq = new GameRequestModel(inputs.get(0), LOAD);
                auth.setCurrUser(game.requestGame(loadReq, auth.getCurrAccount()).getUser());
            case DELETE_GAME:
                GameRequestModel deleteReq = new GameRequestModel(inputs.get(0), DELETE);
                game.requestAuth(deleteReq, auth.getCurrAccount());
            default:
                // error
        }
    }

    public void requestHome(Actions action, List<String> inputs) {
        TimeRequestModel timeReq = new TimeRequestModel((int) Instant.now().getEpochSecond(), auth.getCurrUserStatistics());
        time.checkPassedTime(timeReq);

        switch (action) {
            case SAVE:
                game.saveRequest(auth.getCurrAccount(), auth.getCurrUser());
                break;
            case EXIT:
                game.exitRequest(auth.getCurrAccount(), auth.getCurrUser());
                auth.setCurrUser(null);
                break;
            case ADD_ITEM:
                double rand = Math.random();
                if (rand > 0.99) {
                    int cause = (int) (Math.random() * 4);
                    // get a random mariogatchi
                    // Kill the random mariogatchi
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
                AddRandomItemRequestModel addReq = new AddRandomItemRequestModel(auth.getCurrUserInventory(), add);
                addRandom.addRandomItem(addReq);
                break;
            case REMOVE_ITEM:
                RemoveItemRequestModel removeReq = new RemoveItemRequestModel(inputs.get(0), auth.getCurrUserInventory(), Integer.parseInt(inputs.get(1)));
                remove.removeItemFromInv(removeReq);
                break;
            case USE_ITEM:
                UseItemRequestModel useReq = new UseItemRequestModel(inputs.get(0), auth.getCurrUserEnvironment().getName(), inputs.get(1), auth.getCurrUserInventory(), auth.getCurrUser());
                use.useItem(useReq);
                break;
            case HOME:
                ChangeEnvironmentRequestModel homeReq = new ChangeEnvironmentRequestModel(auth.getCurrUser(), "home");
                move.environmentResponseModel(homeReq);
                break;
            case FOREST:
                ChangeEnvironmentRequestModel forestReq = new ChangeEnvironmentRequestModel(auth.getCurrUser(), "forest");
                move.environmentResponseModel(forestReq);
                break;
            case PARK:
                ChangeEnvironmentRequestModel parkReq = new ChangeEnvironmentRequestModel(auth.getCurrUser(), "park");
                move.environmentResponseModel(parkReq);
                break;
            case INFO:
                InfoAccessRequestModel infoReq = new InfoAccessRequestModel(auth.getCurrUserStatistics(), inputs.get(0));
                info.checkStatistic(infoReq);
                break;
            case ADD_MARIO:
                //AddMariogatchiRequestModel addMarioReq = new AddMariogatchiRequestModel(auth.getCurrUser(), mariogatchi);
                //addMario.addMariogatchiToList(addMarioReq);
                break;
            case REMOVE_MARIO:

                break;
        }
    }
}
