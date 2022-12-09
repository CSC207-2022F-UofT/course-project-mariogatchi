package mariogatchi.controllers;

import mariogatchi.use_cases.add_mariogatchi.AddMariogatchiPresenter;
import mariogatchi.use_cases.add_mariogatchi.AddMariogatchiResponseModel;
import mariogatchi.use_cases.authentication.AuthenticationPresenter;
import mariogatchi.use_cases.authentication.AuthenticationResponseModel;
import mariogatchi.use_cases.change_environment.ChangeEnvironmentOutputBoundary;
import mariogatchi.use_cases.change_environment.ChangeEnvironmentResponseModel;
import mariogatchi.use_cases.find_mariogatchi.FindMariogatchiOutputBoundary;
import mariogatchi.use_cases.find_mariogatchi.FindMariogatchiResponseModel;
import mariogatchi.use_cases.games.GamePresenter;
import mariogatchi.use_cases.games.GameResponseModel;
import mariogatchi.use_cases.info_access.InfoAccessPresenter;
import mariogatchi.use_cases.info_access.InfoAccessResponseModel;
import mariogatchi.use_cases.item_cases.add_item.AddItemOutputBoundary;
import mariogatchi.use_cases.item_cases.add_item.AddItemResponseModel;
import mariogatchi.use_cases.item_cases.add_random_item.AddRandomItemOutputBoundary;
import mariogatchi.use_cases.item_cases.add_random_item.AddRandomItemResponseModel;
import mariogatchi.use_cases.item_cases.remove_item.RemoveItemOutputBoundary;
import mariogatchi.use_cases.item_cases.remove_item.RemoveItemResponseModel;
import mariogatchi.use_cases.item_cases.use_item.UseItemOutputBoundary;
import mariogatchi.use_cases.item_cases.use_item.UseItemResponseModel;
import mariogatchi.use_cases.remove_mariogatchi.RemoveMariogatchiDisplayerInterface;
import mariogatchi.use_cases.remove_mariogatchi.RemoveMariogatchiPresenterInterface;
import mariogatchi.use_cases.playdate.PlaydatePresenter;
import mariogatchi.use_cases.playdate.PlaydateResponseModel;
import mariogatchi.use_cases.time.TimePresenter;
import mariogatchi.use_cases.time.TimeResponseModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class InputControllerTest {

    AuthenticationPresenter AUTHENTICATION_PRESENTER;
    GamePresenter GAME_PRESENTER;
    AddItemOutputBoundary ADD_PRESENTER;
    RemoveItemOutputBoundary REMOVE_PRESENTER;
    UseItemOutputBoundary USE_PRESENTER;
    TimePresenter TIME_PRESENTER;
    InfoAccessPresenter INFO_PRESENTER;
    ChangeEnvironmentOutputBoundary MOVE_PRESENTER;
    AddMariogatchiPresenter ADD_MARIO_PRESENTER;
    AddRandomItemOutputBoundary ADD_RANDOM_ITEM_PRESENTER;
    RemoveMariogatchiPresenterInterface REMOVE_MARIOGATCHI_PRESENTER;
    RemoveMariogatchiDisplayerInterface REMOVE_MARIOGATCHI_DISPLAYER;
    PlaydatePresenter PLAYDATE_PRESENTER;
    FindMariogatchiOutputBoundary FIND_PRESENTER;

    @BeforeEach
    public void setup(){
        this.AUTHENTICATION_PRESENTER = new AuthenticationPresenter() {
            @Override
            public AuthenticationResponseModel prepareLoginSuccess(AuthenticationResponseModel responseModel) {
                return responseModel;
            }

            @Override
            public AuthenticationResponseModel prepareLoginFailure(AuthenticationResponseModel responseModel) {
                return responseModel;
            }
        };
        this.GAME_PRESENTER = new GamePresenter() {
            @Override
            public GameResponseModel prepareExitGame(GameResponseModel responseModel) {
                return responseModel;
            }

            @Override
            public GameResponseModel prepareLoadGame(GameResponseModel responseModel) {
                return responseModel;
            }
        };
        this.ADD_PRESENTER = new AddItemOutputBoundary() {
            @Override
            public AddItemResponseModel addItemPrepareSuccessView(AddItemResponseModel responseModel) {
                return responseModel;
            }

            @Override
            public AddItemResponseModel addItemPrepareFailureView(String error, AddItemResponseModel responseModel) {
                return responseModel;
            }
        };
        this.REMOVE_PRESENTER = new RemoveItemOutputBoundary() {
            @Override
            public RemoveItemResponseModel removeItemPrepareSuccessView(RemoveItemResponseModel responseModel) {
                return responseModel;
            }

            @Override
            public RemoveItemResponseModel removeItemPrepareFailureView(String error, RemoveItemResponseModel responseModel) {
                return null;
            }
        };
        this.USE_PRESENTER = new UseItemOutputBoundary() {
            @Override
            public UseItemResponseModel useItemPrepareSuccessView(UseItemResponseModel responseModel) {
                return responseModel;
            }

            @Override
            public UseItemResponseModel useItemPrepareFailureView(String error, UseItemResponseModel responseModel) {
                return null;
            }
        };
        this.TIME_PRESENTER = new TimePresenter() {
            @Override
            public TimeResponseModel prepareSuccessView(TimeResponseModel responseModel) {
                return responseModel;
            }

            @Override
            public TimeResponseModel prepareFailView(String error) {
                return null;
            }
        };
        this.INFO_PRESENTER = new InfoAccessPresenter() {
            @Override
            public InfoAccessResponseModel prepareSuccessView(InfoAccessResponseModel responseModel) {
                return responseModel;
            }

            @Override
            public InfoAccessResponseModel prepareFailView(String error) {
                return null;
            }
        };
        this.ADD_MARIO_PRESENTER = new AddMariogatchiPresenter() {
            @Override
            public AddMariogatchiResponseModel prepareSuccessView(AddMariogatchiResponseModel responseModel) {
                return responseModel;
            }

            @Override
            public AddMariogatchiResponseModel prepareFailView(String error) {
                return null;
            }
        };
        this.ADD_RANDOM_ITEM_PRESENTER = new AddRandomItemOutputBoundary() {
            @Override
            public AddRandomItemResponseModel addRandomItemPrepareSuccessView(AddRandomItemResponseModel responseModel) {
                return responseModel;
            }

            @Override
            public AddRandomItemResponseModel addRandomItemPrepareFailureView(String error, AddRandomItemResponseModel responseModel) {
                return responseModel;
            }
        };
        this.REMOVE_MARIOGATCHI_PRESENTER = new RemoveMariogatchiPresenterInterface() {
            @Override
            public String getKillActionType(KillAction type) {
                return null;
            }

            @Override
            public String getTransferActionType(TransferAction type) {
                return null;
            }
        };
        this.REMOVE_MARIOGATCHI_DISPLAYER = new RemoveMariogatchiDisplayerInterface() {
            @Override
            public void removeMariogatchiText(String text) {
            }
        };
        this.PLAYDATE_PRESENTER = new PlaydatePresenter() {
            @Override
            public PlaydateResponseModel prepareSuccessView(PlaydateResponseModel responseModel) {
                return responseModel;
            }

            @Override
            public PlaydateResponseModel prepareFailView(String error) {
                return null;
            }
        };
        this.FIND_PRESENTER = new FindMariogatchiOutputBoundary() {
            @Override
            public FindMariogatchiResponseModel findMariogatchiPrepareSuccessView(FindMariogatchiResponseModel findMariogatchiResponseModel) {
                return findMariogatchiResponseModel;
            }

            @Override
            public FindMariogatchiResponseModel findMariogatchiPrepareFailureView(String errorMessage, FindMariogatchiResponseModel findMariogatchiResponseModel) {
                return findMariogatchiResponseModel;
            }
        };
        this.MOVE_PRESENTER = new ChangeEnvironmentOutputBoundary() {
            @Override
            public ChangeEnvironmentResponseModel changeEnvPrepareSuccessView(ChangeEnvironmentResponseModel changeEnvironmentResponseModel) {
                return changeEnvironmentResponseModel;
            }

            @Override
            public ChangeEnvironmentResponseModel changeEnvPrepareFailureView(String errorMessage, ChangeEnvironmentResponseModel changeEnvironmentResponseModel) {
                return changeEnvironmentResponseModel;
            }
        };

    }



    @Test
    public void inputControllerSignupTest(){ // Just tests that all the controller cases run.
        InputController input = new InputController(AUTHENTICATION_PRESENTER, GAME_PRESENTER, ADD_PRESENTER,
                REMOVE_PRESENTER, USE_PRESENTER, TIME_PRESENTER, INFO_PRESENTER, MOVE_PRESENTER, ADD_MARIO_PRESENTER,
                ADD_RANDOM_ITEM_PRESENTER, REMOVE_MARIOGATCHI_PRESENTER, REMOVE_MARIOGATCHI_DISPLAYER,
                PLAYDATE_PRESENTER, FIND_PRESENTER);

        List<String> inputsSignup = Arrays.asList("controllertest", "Abcd123*");
        input.loginRequest(InputController.LoginActions.SIGNUP, inputsSignup);

        List<String> inputsLogout = List.of();
        input.requestGames(InputController.GamesActions.LOGOUT, inputsLogout);

        List<String> inputsLogin = Arrays.asList("controllertest", "Abcd123*");
        input.loginRequest(InputController.LoginActions.LOGIN, inputsLogin);

        List<String> inputsCreateGame = List.of("testgame");
        input.requestGames(InputController.GamesActions.CREATE_GAME, inputsCreateGame);

        List<String> inputsLoadGame = List.of("testgame");
        input.requestGames(InputController.GamesActions.LOAD_GAME, inputsLoadGame);

        List<String> inputsFind = List.of("find_mariogatchi");
        input.request(InputController.Actions.FIND_MARIO, inputsFind);

        List<String> inputsFindTwo = List.of("find_mariogatchi");
        input.request(InputController.Actions.FIND_MARIO, inputsFindTwo);

        List<String> inputsAddItem = List.of();
        input.request(InputController.Actions.ADD_ITEM, inputsAddItem);
        input.request(InputController.Actions.ADD_ITEM, inputsAddItem);

        List<String> inputsENV = List.of();
        input.request(InputController.Actions.HOME, inputsENV);
        input.request(InputController.Actions.PARK, inputsENV);
        input.request(InputController.Actions.FOREST, inputsENV);

        List<String> inputsSaveGame = List.of();
        input.request(InputController.Actions.SAVE, inputsSaveGame);

        List<String> inputsExitGame = List.of();
        input.request(InputController.Actions.EXIT, inputsExitGame);

        List<String> inputsDeleteGame = List.of("testgame");
        input.requestGames(InputController.GamesActions.DELETE_GAME, inputsDeleteGame);

        List<String> inputsDeleteAccount = List.of();
        input.requestGames(InputController.GamesActions.DELETE_ACCOUNT, inputsLogout);
    }
}
