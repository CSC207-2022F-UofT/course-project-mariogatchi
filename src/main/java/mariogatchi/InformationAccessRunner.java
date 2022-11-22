package Mariogatchi;


public class InformationAccessRunner implements InfoAccessInputBoundary {

    private final InfoAccessPresenter PRESENTER;

    public InformationAccessRunner(InfoAccessPresenter presenter) {
        this.PRESENTER = presenter;
    }

    @Override
    /*
      Check a specific statistic for a mariogatchi
     */
    public InfoAccessResponseModel checkStatistic(InfoAccessRequestModel requestModel) {
        int statValue = requestModel.getStats().getStat(requestModel.getStatToCheck());
        return this.PRESENTER.prepareSuccessView(
                new InfoAccessResponseModel(requestModel.getStatToCheck(), statValue)
                );
    }

}
