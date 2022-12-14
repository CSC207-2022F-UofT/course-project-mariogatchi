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
import mariogatchi.use_cases.change_environment.ChangeEnvironmentOutputBoundary;
import mariogatchi.use_cases.change_environment.ChangeEnvironmentRequestModel;
import mariogatchi.use_cases.change_environment.ChangeEnvironmentRunner;
import mariogatchi.use_cases.find_mariogatchi.FindMariogatchiOutputBoundary;
import mariogatchi.use_cases.find_mariogatchi.FindMariogatchiRequestModel;
import mariogatchi.use_cases.find_mariogatchi.FindMariogatchiResponseModel;
import mariogatchi.use_cases.find_mariogatchi.FindMariogatchiRunner;
import mariogatchi.use_cases.games.*;
import mariogatchi.use_cases.info_access.InfoAccessInputBoundary;
import mariogatchi.use_cases.info_access.InfoAccessPresenter;
import mariogatchi.use_cases.info_access.InfoAccessRequestModel;
import mariogatchi.use_cases.info_access.InformationAccessRunner;
import mariogatchi.use_cases.item_cases.add_item.AddItemInputBoundary;
import mariogatchi.use_cases.item_cases.add_item.AddItemOutputBoundary;
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
import mariogatchi.use_cases.remove_mariogatchi.RemoveMariogatchiDisplayerInterface;
import mariogatchi.use_cases.remove_mariogatchi.RemoveMariogatchiPresenterInterface;
import mariogatchi.use_cases.remove_mariogatchi.factories.KillMariogatchiFactory;
import mariogatchi.use_cases.remove_mariogatchi.factories.RemoveMariogatchiFactory;
import mariogatchi.use_cases.remove_mariogatchi.factories.TransferMariogatchiFactory;
import mariogatchi.use_cases.playdate.PlaydateInputBoundary;
import mariogatchi.use_cases.playdate.PlaydatePresenter;
import mariogatchi.use_cases.playdate.PlaydateRequestModel;
import mariogatchi.use_cases.playdate.PlaydateRunner;
import mariogatchi.use_cases.time.TimeInputBoundary;
import mariogatchi.use_cases.time.TimePresenter;
import mariogatchi.use_cases.time.TimeRequestModel;
import mariogatchi.use_cases.time.TimeRunner;
import static mariogatchi.use_cases.authentication.AuthenticationRequestModel.AuthActions.LOGIN;
import static mariogatchi.use_cases.authentication.AuthenticationRequestModel.AuthActions.SIGNUP;
import static mariogatchi.use_cases.games.GameRequestModel.GameActions.*;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

/**
 * The controller for all inputs to the program
 */
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
    private final PlaydateInputBoundary PLAY;
    private final RemoveMariogatchiPresenterInterface REMOVE_MARIOGATCHI_PRESENTER;
    private final RemoveMariogatchiDisplayerInterface REMOVE_MARIOGATCHI_DISPLAYER;
    private final RemoveMariogatchiFactory TRANSFER_FACTORY;
    private final RemoveMariogatchiFactory KILL_FACTORY;
    private final FindMariogatchiRunner FIND_MARIOGATCHI;

    public InputController(AuthenticationPresenter authPresenter, GamePresenter gamePresenter,
                           AddItemOutputBoundary addPresenter, RemoveItemOutputBoundary removePresenter,
                           UseItemOutputBoundary usePresenter, TimePresenter timePresenter,
                           InfoAccessPresenter infoPresenter, ChangeEnvironmentOutputBoundary movePresenter,
                           AddMariogatchiPresenter addMarioPresenter, AddRandomItemOutputBoundary addRandomPresenter,
                           RemoveMariogatchiPresenterInterface removeMariogatchiPresenter,
                           RemoveMariogatchiDisplayerInterface removeMariogatchiDisplayer,
                           PlaydatePresenter playdatePresenter, FindMariogatchiOutputBoundary findPresenter) {
        this.AUTH = new AuthenticatorRunner(authPresenter);
        this.GAME = new GameInteractor(authPresenter, gamePresenter);
        this.TIME = new TimeRunner(timePresenter);
        this.ADDRANDOM = new AddRandomItemRunner(addRandomPresenter);
        this.ADD = new AddItemRunner(addPresenter);
        this.REMOVE = new RemoveItemRunner(removePresenter);
        this.USE = new UseItemRunner(usePresenter);
        this.INFO = new InformationAccessRunner(infoPresenter);
        this.MOVE = new ChangeEnvironmentRunner(movePresenter);
        this.PLAY = new PlaydateRunner(playdatePresenter);
        this.ADD_MARIO = new AddMariogatchiRunner(addMarioPresenter);
        this.REMOVE_MARIOGATCHI_PRESENTER = removeMariogatchiPresenter;
        this.REMOVE_MARIOGATCHI_DISPLAYER = removeMariogatchiDisplayer;
        this.TRANSFER_FACTORY = new TransferMariogatchiFactory();
        this.KILL_FACTORY = new KillMariogatchiFactory();
        this.FIND_MARIOGATCHI = new FindMariogatchiRunner(findPresenter);
    }

    /**
     * Actions that can be used from the login screen
     */
    public enum LoginActions {
        LOGIN,
        SIGNUP,
        EXIT
    }

    /**
     * Actions that can be used from the game selector screen
     */
    public enum GamesActions {
        LOGOUT,
        DELETE_ACCOUNT,
        CREATE_GAME,
        LOAD_GAME,
        DELETE_GAME
    }

    /**
     * Actions that can be used from in the game
     */
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
        PLAYDATE_CHECK
    }

    /**
     * Sends the request for login screen actions
     * @param action The action to perform
     * @param inputs The list of inputs for the action
     */
    public void loginRequest(LoginActions action, List<String> inputs) {
        switch (action) {
            case LOGIN: // Pass in username and password
                AuthenticationRequestModel loginReq = new AuthenticationRequestModel(inputs.get(0), inputs.get(1), LOGIN);
                AUTH.setCurrAccount(AUTH.authenticationRequest(loginReq).getAccount());
                break;
            case SIGNUP: // Pass in username and password
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

    /**
     * Sends the request for Game Selector screen actions
     * @param action The action to perform
     * @param inputs The list of inputs for the action
     */
    public void requestGames(GamesActions action, List<String> inputs) {
        switch(action) {
            case LOGOUT: // Pass in nothing
                AUTH.logoutRequest(AUTH.getCurrAccount());
                AUTH.setCurrAccount(null);
                break;
            case DELETE_ACCOUNT: // Pass in nothing
                AUTH.deleteRequest(AUTH.getCurrAccount());
                AUTH.setCurrAccount(null);
                break;
            case CREATE_GAME: // Pass the name of the new game
                GameRequestModel createReq = new GameRequestModel(inputs.get(0), CREATE);
                GAME.requestAuth(createReq, AUTH.getCurrAccount());
                GameResponseModel gameResp = GAME.requestGame(createReq, AUTH.getCurrAccount());
                AUTH.setCurrUser(gameResp.getUser());
                GAME.startGame();
                break;
            case LOAD_GAME: // Pass the name of the game to load
                GameRequestModel loadReq = new GameRequestModel(inputs.get(0), LOAD);
                AUTH.setCurrUser(GAME.requestGame(loadReq, AUTH.getCurrAccount()).getUser());
                break;
            case DELETE_GAME: // Pass in the name of the game to delete
                GameRequestModel deleteReq = new GameRequestModel(inputs.get(0), DELETE);
                GAME.requestAuth(deleteReq, AUTH.getCurrAccount());
            default:
                // error
        }
    }

    /**
     * Sends the request for in game actions
     * @param action The action to perform
     * @param inputs The list of inputs for the action
     */
    public void request(Actions action, List<String> inputs) {
        TimeRequestModel timeReq = new TimeRequestModel((int) Instant.now().getEpochSecond(), AUTH.getCurrUser());
        TIME.checkPassedTime(timeReq);

        switch (action) {
            case SAVE: // pass in nothing
                GAME.saveRequest(AUTH.getCurrAccount(), AUTH.getCurrUser());
                break;
            case EXIT: // pass in nothing
                GAME.exitRequest(AUTH.getCurrAccount(), AUTH.getCurrUser());
                AUTH.setCurrUser(null);
                break;
            case ADD_ITEM: // pass in nothing
                double rand = Math.random();
                if (rand > 0.99) {
                    int cause = (int) (Math.random() * 5);
                    // Kill the random mariogatchi
                    switch(cause) {
                        case 0:
                            KILL_FACTORY.getAction("blown away").execute(AUTH.getCurrUser(), AUTH.getRandomMariogatchiFromUser(), REMOVE_MARIOGATCHI_PRESENTER, REMOVE_MARIOGATCHI_DISPLAYER);
                            break;
                        case 1:
                            KILL_FACTORY.getAction("drown").execute(AUTH.getCurrUser(), AUTH.getRandomMariogatchiFromUser(), REMOVE_MARIOGATCHI_PRESENTER, REMOVE_MARIOGATCHI_DISPLAYER);
                            break;
                        case 2:
                            KILL_FACTORY.getAction("illness").execute(AUTH.getCurrUser(), AUTH.getRandomMariogatchiFromUser(), REMOVE_MARIOGATCHI_PRESENTER, REMOVE_MARIOGATCHI_DISPLAYER);
                            break;
                        case 3:
                            KILL_FACTORY.getAction("old age").execute(AUTH.getCurrUser(), AUTH.getRandomMariogatchiFromUser(), REMOVE_MARIOGATCHI_PRESENTER, REMOVE_MARIOGATCHI_DISPLAYER);
                            break;
                        case 4:
                            KILL_FACTORY.getAction("over care").execute(AUTH.getCurrUser(), AUTH.getRandomMariogatchiFromUser(), REMOVE_MARIOGATCHI_PRESENTER, REMOVE_MARIOGATCHI_DISPLAYER);
                            break;
                        case 5:
                            KILL_FACTORY.getAction("predators").execute(AUTH.getCurrUser(), AUTH.getRandomMariogatchiFromUser(), REMOVE_MARIOGATCHI_PRESENTER, REMOVE_MARIOGATCHI_DISPLAYER);
                            break;
                        case 6:
                            KILL_FACTORY.getAction("problem set").execute(AUTH.getCurrUser(), AUTH.getRandomMariogatchiFromUser(), REMOVE_MARIOGATCHI_PRESENTER, REMOVE_MARIOGATCHI_DISPLAYER);
                            break;
                        case 7:
                            KILL_FACTORY.getAction("starvation").execute(AUTH.getCurrUser(), AUTH.getRandomMariogatchiFromUser(), REMOVE_MARIOGATCHI_PRESENTER, REMOVE_MARIOGATCHI_DISPLAYER);
                            break;
                        case 8:
                            KILL_FACTORY.getAction("ufo abduction").execute(AUTH.getCurrUser(), AUTH.getRandomMariogatchiFromUser(), REMOVE_MARIOGATCHI_PRESENTER, REMOVE_MARIOGATCHI_DISPLAYER);
                            break;
                    }
                }
                AddRandomItemRequestModel addReq = new AddRandomItemRequestModel(AUTH.getCurrUserInventory(), ADD);
                ADDRANDOM.addRandomItem(addReq);
                break;
            case REMOVE_ITEM: // pass in the item name, and the number to remove, as a string
                RemoveItemRequestModel removeReq = new RemoveItemRequestModel(inputs.get(0), AUTH.getCurrUserInventory(), Integer.parseInt(inputs.get(1)));
                REMOVE.removeItemFromInv(removeReq);
                break;
            case USE_ITEM: // pass in the item name and the mariogatchi name
                UseItemRequestModel useReq = new UseItemRequestModel(inputs.get(0).toUpperCase(), AUTH.getCurrUserEnvironment().getName(), AUTH.getMariogatchiFromUser(inputs.get(1)), AUTH.getCurrUserInventory());
                USE.useItem(useReq);
                break;
            case HOME: // pass in nothing
                ChangeEnvironmentRequestModel homeReq = new ChangeEnvironmentRequestModel(AUTH.getCurrUser(), "home");
                MOVE.changeEnvironment(homeReq);
                break;
            case FOREST: // pass in nothing
                ChangeEnvironmentRequestModel forestReq = new ChangeEnvironmentRequestModel(AUTH.getCurrUser(), "forest");
                MOVE.changeEnvironment(forestReq);
                break;
            case PARK: // pass in nothing
                ChangeEnvironmentRequestModel parkReq = new ChangeEnvironmentRequestModel(AUTH.getCurrUser(), "park");
                MOVE.changeEnvironment(parkReq);
                break;
            case INFO: // pass the stat name and the mariogatchi name
                InfoAccessRequestModel infoReq = new InfoAccessRequestModel(inputs.get(0), AUTH.getCurrUser());
                INFO.checkStatistic(infoReq);
                break;
            case FIND_MARIO: // Pass in the choice, either "deny", "accept" or "find mariogatchi"
                if (Objects.equals(inputs.get(0), "deny")) {
                    FindMariogatchiRequestModel denyReq = new FindMariogatchiRequestModel(AUTH.getCurrUser(), "deny", FIND_MARIOGATCHI.getMariogatchiOutput());
                    FIND_MARIOGATCHI.setMariogatchiOutput(FIND_MARIOGATCHI.findMariogatchi(denyReq).getMariogatchi());
                } else {
                    FindMariogatchiRequestModel acceptFindReq;
                    if (Objects.equals(inputs.get(0), "accept")) {
                        acceptFindReq = new FindMariogatchiRequestModel(AUTH.getCurrUser(), inputs.get(0), FIND_MARIOGATCHI.getMariogatchiOutput());
                    } else { // "find mariogatchi"
                        acceptFindReq = new FindMariogatchiRequestModel(AUTH.getCurrUser(), inputs.get(0), new Mariogatchi("common"));
                    }
                    FindMariogatchiResponseModel responseAcceptFind = FIND_MARIOGATCHI.findMariogatchi(acceptFindReq);
                    FIND_MARIOGATCHI.setMariogatchiOutput(responseAcceptFind.getMariogatchi());
                    if (responseAcceptFind.getCatchTrigger()) {
                        AddMariogatchiRequestModel addMarioReq = new AddMariogatchiRequestModel(AUTH.getCurrUser(), responseAcceptFind.getMariogatchi());
                        ADD_MARIO.addMariogatchiToList(addMarioReq);
                    }
                }

                break;
            case REMOVE_MARIO: // Pass in the Mariogatchi name
                MariogatchiManager manager = new MariogatchiManager();
                manager.ReleaseMariogatchi(AUTH.getCurrUser(), AUTH.getMariogatchiFromUser(inputs.get(0)));
                TRANSFER_FACTORY.getAction("release").execute(AUTH.getCurrUser(), AUTH.getMariogatchiFromUser(inputs.get(0)), REMOVE_MARIOGATCHI_PRESENTER, REMOVE_MARIOGATCHI_DISPLAYER);
                break;
            case PLAYDATE_CHECK: // Pass in nothing
                PlaydateRequestModel checkReq = new PlaydateRequestModel(null, null, AUTH.getFriendCodeFromAccount());
                PLAY.checkForMessages(checkReq);
                break;
            case PLAYDATE_REQUEST: // Pass in the friend code input, and the mariogatchi name
                PlaydateRequestModel playReq = new PlaydateRequestModel(inputs.get(0), AUTH.getMariogatchiFromUser(inputs.get(1)), AUTH.getFriendCodeFromAccount());
                PLAY.sendPlaydateReq(playReq);
                break;
            case PLAYDATE_ACCEPT: // Pass in the friend code input and the mariogatchi name
                PlaydateRequestModel acceptReq = new PlaydateRequestModel(inputs.get(0), AUTH.getMariogatchiFromUser(inputs.get(1)), AUTH.getFriendCodeFromAccount());
                PLAY.acceptPlaydateReq(acceptReq);
                break;
        }
    }
}
