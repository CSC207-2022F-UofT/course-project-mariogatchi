package Mariogatchi;

public interface UseItemPresenter {

    // the interface of the output boundary for the use item use case
    UseItemResponseModel prepareSuccessView(UseItemResponseModel requestModel);

    UseItemResponseModel prepareFailView(String error);

}
