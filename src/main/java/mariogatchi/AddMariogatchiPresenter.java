package mariogatchi;

public interface AddMariogatchiPresenter {
     /*
    Interface for the AddMariogatchi use case output boundary
     */

    AddMariogatchiResponseModel prepareSuccessView(AddMariogatchiResponseModel responseModel);

    AddMariogatchiResponseModel prepareFailView(String error);
}
