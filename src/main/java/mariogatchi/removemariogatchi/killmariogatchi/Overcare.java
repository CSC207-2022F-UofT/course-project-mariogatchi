package mariogatchi.removemariogatchi.killmariogatchi;

import mariogatchi.Mariogatchi;
import mariogatchi.RemoveMariogatchiPresenterInterface;
import mariogatchi.RemoveMariogatchiPresenter;
import mariogatchi.User;

/**
 * Use case
 * Event where a Mariogatchi dies from User giving Mariogatchi execessive nutrients
 */
public class Overcare extends KillMariogatchi{

    @Override
    public void execute(User user, Mariogatchi mario, RemoveMariogatchiPresenter presenter) {
        if (Kill(user, mario)){
            presenter.getKillActionType(RemoveMariogatchiPresenterInterface.KillAction.OVERCARE);
        }
        else {
            presenter.getKillActionType(RemoveMariogatchiPresenterInterface.KillAction.ERROR);
        }
    }
}
