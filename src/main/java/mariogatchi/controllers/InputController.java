package mariogatchi.controllers;

import mariogatchi.entities.Mariogatchi;
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
import mariogatchi.use_cases.manager.MariogatchiManager;
import mariogatchi.use_cases.manager.remove_mariogatchi.RemoveMariogatchiDisplayerInterface;
import mariogatchi.use_cases.manager.remove_mariogatchi.RemoveMariogatchiPresenterInterface;
import mariogatchi.use_cases.manager.remove_mariogatchi.factories.KillMariogatchiFactory;
import mariogatchi.use_cases.manager.remove_mariogatchi.factories.RemoveMariogatchiFactory;
import mariogatchi.use_cases.manager.remove_mariogatchi.factories.TransferMariogatchiFactory;
import mariogatchi.use_cases.time.TimeInputBoundary;
import mariogatchi.use_cases.time.TimePresenter;
import mariogatchi.use_cases.time.TimeRequestModel;
import mariogatchi.use_cases.time.TimeRunner;
import mariogatchi.use_cases.manager.remove_mariogatchi.RemoveMariogatchiPresenter;


import java.time.Instant;
import java.util.List;

import static mariogatchi.use_cases.authentication.AuthenticationRequestModel.AuthActions.LOGIN;
import static mariogatchi.use_cases.authentication.AuthenticationRequestModel.AuthActions.SIGNUP;
import static mariogatchi.use_cases.games.GameRequestModel.GameActions.*;


public class InputController {

    private final AuthInputBoundary AUTH;
    private final GameInputBoundary GAME;
    private final TimeInputBoundary TIME;
    private final AddRandomItemInputBoundary ADDRANDOM;
    private final AddItemInputBoundary ADD;
    private final RemoveItemInputBoundary REMOVE;
    private final UseItemInputBoundary USE;
    private final InfoAccessInputBoundary INFO;
    private final ChangeEnvironmentInputBoundary MOVE;
    private final AddMariogatchiInputBoundary ADD_MARIO;
    private final RemoveMariogatchiPresenterInterface REMOVE_MARIOGATCHI_PRESENTER;
    private final RemoveMariogatchiDisplayerInterface REMOVE_MARIOGATCHI_DISPLAYER;
    private final RemoveMariogatchiFactory TRANSFER_FACTORY;
    private final RemoveMariogatchiFactory KILL_FACTORY;

    public InputController(AuthenticationPresenter authPresenter, GamePresenter gamePresenter,
                           AddItemOutputBoundary addPresenter, RemoveItemOutputBoundary removePresenter,
                           UseItemOutputBoundary usePresenter, TimePresenter timePresenter,
                           InfoAccessPresenter infoPresenter, ChangeEnvironmentPresenter movePresenter,
                           AddMariogatchiPresenter addMarioPresenter, AddRandomItemOutputBoundary addRandomPresenter,
                           RemoveMariogatchiPresenterInterface removeMariogatchiPresenter,
                           RemoveMariogatchiDisplayerInterface removeMariogatchiDisplayer) {
        this.AUTH = new AuthenticatorRunner(authPresenter);
        this.GAME = new GameInteractor(authPresenter, gamePresenter);
        this.TIME = new TimeRunner(timePresenter);
        this.ADDRANDOM = new AddRandomItemRunner(addRandomPresenter);
        this.ADD = new AddItemRunner(addPresenter);
        this.REMOVE = new RemoveItemRunner(removePresenter);
        this.USE = new UseItemRunner(usePresenter);
        this.INFO = new InformationAccessRunner(infoPresenter);
        this.MOVE = new ChangeEnvironmentRunner(movePresenter);
        this.ADD_MARIO = new AddMariogatchiRunner(addMarioPresenter);
        this.REMOVE_MARIOGATCHI_PRESENTER = removeMariogatchiPresenter;
        this.REMOVE_MARIOGATCHI_DISPLAYER = removeMariogatchiDisplayer;
        this.TRANSFER_FACTORY = new TransferMariogatchiFactory();
        this.KILL_FACTORY = new KillMariogatchiFactory();
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
        FIND_MARIO,

        PLAYDATE_REQUEST,
        PLAYDATE_ACCEPT,
        PLAYDATE_CHECK;
    }

    public void loginRequest(LoginActions action, List<String> inputs) {

        switch(action) {
            case LOGIN:
                AuthenticationRequestModel loginReq = new AuthenticationRequestModel(inputs.get(0), inputs.get(1), LOGIN);
                AUTH.setCurrAccount(AUTH.authenticationRequest(loginReq).getAccount());
                break;
            case SIGNUP:
                AuthenticationRequestModel signupReq = new AuthenticationRequestModel(inputs.get(0), inputs.get(1), SIGNUP);
                AUTH.setCurrAccount(AUTH.authenticationRequest(signupReq).getAccount());
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
                AUTH.logoutRequest(AUTH.getCurrAccount());
                AUTH.setCurrAccount(null);
                break;
            case DELETE_ACCOUNT:
                AUTH.deleteRequest(AUTH.getCurrAccount());
                AUTH.setCurrAccount(null);
                break;
            case CREATE_GAME:
                GameRequestModel createReq = new GameRequestModel(inputs.get(0), CREATE);
                GAME.requestAuth(createReq, AUTH.getCurrAccount());
                break;
            case LOAD_GAME:
                GameRequestModel loadReq = new GameRequestModel(inputs.get(0), LOAD);
                AUTH.setCurrUser(GAME.requestGame(loadReq, AUTH.getCurrAccount()).getUser());
            case DELETE_GAME:
                GameRequestModel deleteReq = new GameRequestModel(inputs.get(0), DELETE);
                GAME.requestAuth(deleteReq, AUTH.getCurrAccount());
            default:
                // error
        }
    }

    public void requestHome(Actions action, List<String> inputs) {
        TimeRequestModel timeReq = new TimeRequestModel((int) Instant.now().getEpochSecond(), AUTH.getCurrUser().getMariogatchiStatsFromUser(inputs.get(0)));
        TIME.checkPassedTime(timeReq);

        switch (action) {
            case SAVE:
                GAME.saveRequest(AUTH.getCurrAccount(), AUTH.getCurrUser());
                break;
            case EXIT:
                GAME.exitRequest(AUTH.getCurrAccount(), AUTH.getCurrUser());
                AUTH.setCurrUser(null);
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
                AddRandomItemRequestModel addReq = new AddRandomItemRequestModel(AUTH.getCurrUserInventory(), ADD);
                ADDRANDOM.addRandomItem(addReq);
                break;
            case REMOVE_ITEM:
                RemoveItemRequestModel removeReq = new RemoveItemRequestModel(inputs.get(0), AUTH.getCurrUserInventory(), Integer.parseInt(inputs.get(1)));
                REMOVE.removeItemFromInv(removeReq);
                break;
            case USE_ITEM:
                UseItemRequestModel useReq = new UseItemRequestModel(inputs.get(0), AUTH.getCurrUserEnvironment().getName(), AUTH.getMariogatchiFromUser(inputs.get(0)), AUTH.getCurrUserInventory());
                USE.useItem(useReq);
                break;
            case HOME:
                ChangeEnvironmentRequestModel homeReq = new ChangeEnvironmentRequestModel(AUTH.getCurrUser(), "home");
                MOVE.environmentResponseModel(homeReq);
                break;
            case FOREST:
                ChangeEnvironmentRequestModel forestReq = new ChangeEnvironmentRequestModel(AUTH.getCurrUser(), "forest");
                MOVE.environmentResponseModel(forestReq);
                break;
            case PARK:
                ChangeEnvironmentRequestModel parkReq = new ChangeEnvironmentRequestModel(AUTH.getCurrUser(), "park");
                MOVE.environmentResponseModel(parkReq);
                break;
            case INFO:
                InfoAccessRequestModel infoReq = new InfoAccessRequestModel(AUTH.getCurrUser().getMariogatchiStatsFromUser(inputs.get(0)), inputs.get(1));
                INFO.checkStatistic(infoReq);
                break;
            case FIND_MARIO:
                //AddMariogatchiRequestModel addMarioReq = new AddMariogatchiRequestModel(auth.getCurrUser(), mariogatchi);
                //addMario.addMariogatchiToList(addMarioReq);
                break;
            case REMOVE_MARIO:
                MariogatchiManager manager = new MariogatchiManager();
                manager.ReleaseMariogatchi(AUTH.getCurrUser(), AUTH.getMariogatchiFromUser(inputs.get(0)));
                TRANSFER_FACTORY.getAction("release").execute(AUTH.getCurrUser(), AUTH.getMariogatchiFromUser(inputs.get(0)), REMOVE_MARIOGATCHI_PRESENTER, REMOVE_MARIOGATCHI_DISPLAYER);
                break;
            case PLAYDATE_CHECK:
                break;
            case PLAYDATE_REQUEST:
                break;
            case PLAYDATE_ACCEPT:
                break;
        }
    }
}
