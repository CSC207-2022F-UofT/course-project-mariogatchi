package mariogatchi;

public interface UseItemPresenter {

    UseItemResponseModel prepareSuccessView(UseItemResponseModel requestModel);

    UseItemResponseModel prepareFailView(String error);

}
