package mariogatchi.use_cases.add_mariogatchi;

public interface AddMariogatchiPresenter {
     /*
    Interface for the AddMariogatchi use case output boundary
     */

    AddMariogatchiResponseModel prepareAddSuccessView(AddMariogatchiResponseModel responseModel);

    AddMariogatchiResponseModel prepareAddFailView(String error);
}
