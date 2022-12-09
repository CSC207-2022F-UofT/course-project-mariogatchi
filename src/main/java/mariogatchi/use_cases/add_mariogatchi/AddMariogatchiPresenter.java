package mariogatchi.use_cases.add_mariogatchi;

public interface AddMariogatchiPresenter {
     /*
    Interface for the AddMariogatchi use case output boundary
     */

    AddMariogatchiResponseModel prepareSuccessView(AddMariogatchiResponseModel responseModel);

    AddMariogatchiResponseModel prepareFailView(String error);
}
