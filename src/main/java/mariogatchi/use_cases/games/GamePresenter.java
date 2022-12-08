package mariogatchi.use_cases.games;

public interface GamePresenter {

    GameResponseModel prepareExitGame(GameResponseModel responseModel);

    GameResponseModel prepareLoadGame(GameResponseModel responseModel);

}
