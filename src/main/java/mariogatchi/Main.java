package mariogatchi;

import mariogatchi.controllers.InputController;
import mariogatchi.presenter.DisplayPresenter;
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
import mariogatchi.use_cases.playdate.PlaydatePresenter;
import mariogatchi.use_cases.playdate.PlaydateResponseModel;
import mariogatchi.use_cases.remove_mariogatchi.RemoveMariogatchi;
import mariogatchi.use_cases.remove_mariogatchi.RemoveMariogatchiDisplayerInterface;
import mariogatchi.use_cases.remove_mariogatchi.RemoveMariogatchiPresenterInterface;
import mariogatchi.use_cases.time.TimePresenter;
import mariogatchi.use_cases.time.TimeResponseModel;

public class Main {
    public static void main(String [] args){

        AuthenticationPresenter AUTHENTICATION_PRESENTER = new AuthenticationPresenter() {
            @Override
            public AuthenticationResponseModel prepareLoginSuccess(AuthenticationResponseModel responseModel) {
                return responseModel;
            }

            @Override
            public AuthenticationResponseModel prepareLoginFailure(AuthenticationResponseModel responseModel) {
                return responseModel;
            }
        };
        GamePresenter GAME_PRESENTER = new GamePresenter() {
            @Override
            public GameResponseModel prepareExitGame(GameResponseModel responseModel) {
                return responseModel;
            }

            @Override
            public GameResponseModel prepareLoadGame(GameResponseModel responseModel) {
                return responseModel;
            }
        };
        AddItemOutputBoundary ADD_PRESENTER = new AddItemOutputBoundary() {
            @Override
            public AddItemResponseModel addItemPrepareSuccessView(AddItemResponseModel responseModel) {
                return responseModel;
            }

            @Override
            public AddItemResponseModel addItemPrepareFailureView(String error, AddItemResponseModel responseModel) {
                return responseModel;
            }
        };
        RemoveItemOutputBoundary REMOVE_PRESENTER = new RemoveItemOutputBoundary() {
            @Override
            public RemoveItemResponseModel removeItemPrepareSuccessView(RemoveItemResponseModel responseModel) {
                return responseModel;
            }

            @Override
            public RemoveItemResponseModel removeItemPrepareFailureView(String error, RemoveItemResponseModel responseModel) {
                return null;
            }
        };
       UseItemOutputBoundary USE_PRESENTER = new UseItemOutputBoundary() {
            @Override
            public UseItemResponseModel useItemPrepareSuccessView(UseItemResponseModel responseModel) {
                return responseModel;
            }

            @Override
            public UseItemResponseModel useItemPrepareFailureView(String error, UseItemResponseModel responseModel) {
                return null;
            }
        };
        TimePresenter TIME_PRESENTER = new TimePresenter() {
            @Override
            public TimeResponseModel prepareSuccessView(TimeResponseModel responseModel) {
                return responseModel;
            }

            @Override
            public TimeResponseModel prepareFailView(String error) {
                return null;
            }
        };
        InfoAccessPresenter INFO_PRESENTER = new InfoAccessPresenter() {
            @Override
            public InfoAccessResponseModel prepareSuccessView(InfoAccessResponseModel responseModel) {
                return responseModel;
            }

            @Override
            public InfoAccessResponseModel prepareFailView(String error) {
                return null;
            }
        };
        AddMariogatchiPresenter ADD_MARIO_PRESENTER = new AddMariogatchiPresenter() {
            @Override
            public AddMariogatchiResponseModel prepareSuccessView(AddMariogatchiResponseModel responseModel) {
                return responseModel;
            }

            @Override
            public AddMariogatchiResponseModel prepareFailView(String error) {
                return null;
            }
        };
        AddRandomItemOutputBoundary ADD_RANDOM_ITEM_PRESENTER = new AddRandomItemOutputBoundary() {
            @Override
            public AddRandomItemResponseModel addRandomItemPrepareSuccessView(AddRandomItemResponseModel responseModel) {
                return responseModel;
            }

            @Override
            public AddRandomItemResponseModel addRandomItemPrepareFailureView(String error, AddRandomItemResponseModel responseModel) {
                return responseModel;
            }
        };
        RemoveMariogatchiPresenterInterface REMOVE_MARIOGATCHI_PRESENTER = new RemoveMariogatchiPresenterInterface() {
            @Override
            public String getKillActionType(KillAction type) {
                return null;
            }

            @Override
            public String getTransferActionType(TransferAction type) {
                return null;
            }
        };
       RemoveMariogatchiDisplayerInterface  REMOVE_MARIOGATCHI_DISPLAYER = new RemoveMariogatchiDisplayerInterface() {
            @Override
            public void removeMariogatchiText(String text) {
            }
        };
       PlaydatePresenter PLAYDATE_PRESENTER = new PlaydatePresenter() {
            @Override
            public PlaydateResponseModel prepareSuccessView(PlaydateResponseModel responseModel) {
                return responseModel;
            }

            @Override
            public PlaydateResponseModel prepareFailView(String error) {
                return null;
            }
        };
        FindMariogatchiOutputBoundary FIND_PRESENTER = new FindMariogatchiOutputBoundary() {
            @Override
            public FindMariogatchiResponseModel findMariogatchiPrepareSuccessView(FindMariogatchiResponseModel findMariogatchiResponseModel) {
                return findMariogatchiResponseModel;
            }

            @Override
            public FindMariogatchiResponseModel findMariogatchiPrepareFailureView(String errorMessage, FindMariogatchiResponseModel findMariogatchiResponseModel) {
                return findMariogatchiResponseModel;
            }
        };

        ChangeEnvironmentOutputBoundary MOVE_PRESENTER = new ChangeEnvironmentOutputBoundary() {
            @Override
            public ChangeEnvironmentResponseModel changeEnvPrepareSuccessView(ChangeEnvironmentResponseModel changeEnvironmentResponseModel) {
                return changeEnvironmentResponseModel;
            }

            @Override
            public ChangeEnvironmentResponseModel changeEnvPrepareFailureView(String errorMessage, ChangeEnvironmentResponseModel changeEnvironmentResponseModel) {
                return changeEnvironmentResponseModel;
            }
        };

        DisplayPresenter displayPresenter = new DisplayPresenter();
        InputController input = new InputController(displayPresenter, displayPresenter, displayPresenter,
                REMOVE_PRESENTER, displayPresenter, TIME_PRESENTER, displayPresenter, displayPresenter, ADD_MARIO_PRESENTER,
                displayPresenter, REMOVE_MARIOGATCHI_PRESENTER, REMOVE_MARIOGATCHI_DISPLAYER,
                PLAYDATE_PRESENTER, displayPresenter);

        displayPresenter.startDP(input);

        
    }
}