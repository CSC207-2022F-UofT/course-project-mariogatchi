package mariogatchi.use_cases.info_access;

public interface InfoAccessPresenter {
    /*
    Interface for the InfoAccess use case output boundary
     */
    InfoAccessResponseModel prepareSuccessView(InfoAccessResponseModel responseModel);

    InfoAccessResponseModel prepareFailView(String error);

}