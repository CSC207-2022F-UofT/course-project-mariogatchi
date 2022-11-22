package Mariogatchi;


public class TimeRunner implements TimeInputBoundary {

    private final TimePresenter PRESENTER;

    public TimeRunner(TimePresenter presenter) {
        this.PRESENTER = presenter;
    }

    @Override
    /*
      Check how much time has passed since last action and decrement stats
     */
    public TimeResponseModel checkPassedTime(TimeRequestModel requestModel) {
        long timeDiff = requestModel.getStats().statDecay(requestModel.getTime());
        return this.PRESENTER.prepareSuccessView(new TimeResponseModel(requestModel.getStats(), timeDiff));
    }

}