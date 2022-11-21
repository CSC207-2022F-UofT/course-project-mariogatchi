package mariogatchi.removemariogatchi.killmariogatchi;

import mariogatchi.Mariogatchi;
import mariogatchi.RemoveMariogatchiPresenter;
import mariogatchi.RemoveMariogatchiPresenterInterface;
import mariogatchi.User;

/**
 * Use case
 * Event where a Mariogatchi dies by being blown away
 */
public class BlownAway extends KillMariogatchi {

    @Override
    public void execute(User user, Mariogatchi mario, RemoveMariogatchiPresenter presenter) {
        if (Kill(user, mario)) {
            presenter.getKillActionType(RemoveMariogatchiPresenterInterface.KillAction.BLOWNAWAY);
        } else {
            presenter.getKillActionType(RemoveMariogatchiPresenterInterface.KillAction.ERROR);
        }
    }
}

