package Mariogatchi;

public interface TimePresenter {
    /*
    Interface for the Time use case output boundary
     */
    TimeResponseModel prepareSuccessView(TimeResponseModel responseModel);

    TimeResponseModel prepareFailView(String error);

}