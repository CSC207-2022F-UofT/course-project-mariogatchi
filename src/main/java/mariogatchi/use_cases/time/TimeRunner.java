package mariogatchi.use_cases.time;


import mariogatchi.entities.Mariogatchi;

import java.util.ArrayList;

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
        long timeDiff = 0;
        if (requestModel.getUser().getMariogatchis().size() == 0) {
            return this.PRESENTER.prepareFailView("No Mariogatchis");
        } else {
            for(Mariogatchi m : requestModel.getUser().getMariogatchis()){
                    timeDiff = m.getStats().statDecay(requestModel.getTime());
            }
            return this.PRESENTER.prepareSuccessView(new TimeResponseModel( timeDiff));
        }
    }
}