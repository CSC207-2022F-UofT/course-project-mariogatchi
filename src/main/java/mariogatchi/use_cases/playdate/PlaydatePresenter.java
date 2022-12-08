package mariogatchi.use_cases.playdate;

public interface PlaydatePresenter {
    /*
    Interface for the Playdate use case output boundary
     */
    PlaydateResponseModel prepareSuccessView(PlaydateResponseModel responseModel);

    PlaydateResponseModel prepareFailView(String error);

}