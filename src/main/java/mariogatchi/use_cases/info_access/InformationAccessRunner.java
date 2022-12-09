package mariogatchi.use_cases.info_access;


import mariogatchi.entities.Statistics;

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
        Statistics statValue = requestModel.getUser().getMariogatchiStatsFromUser(requestModel.getMariogatchi());
        return this.PRESENTER.prepareSuccessView(new InfoAccessResponseModel(statValue));
    }

}
