package mariogatchi.use_cases.time;


import mariogatchi.entities.Mariogatchi;

import java.util.List;

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
            for (Mariogatchi m : requestModel.getUser().getMariogatchis()) {
                timeDiff = m.getStats().statDecay(requestModel.getTime());
            }
            for (Mariogatchi m : requestModel.getUser().getMariogatchis()) {
                timeDiff = m.getStats().statDecay(requestModel.getTime());
                if (m.getStats().checkDeath()) {
                    List<Mariogatchi> lst = requestModel.getUser().getMariogatchis();
                    lst.remove(m);
                    requestModel.getUser().setMariogatchis(lst);
                }
            }
            return this.PRESENTER.prepareSuccessView(new TimeResponseModel(timeDiff));
        }
    }
}