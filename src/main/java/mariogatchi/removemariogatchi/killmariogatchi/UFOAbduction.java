package mariogatchi.removemariogatchi.killmariogatchi;

import mariogatchi.Mariogatchi;
import mariogatchi.RemoveMariogatchiPresenter;
import mariogatchi.RemoveMariogatchiPresenterInterface;
import mariogatchi.User;

/**
 * Use case
 * Event where a Mariogatchi is removed from the Users mariogatchi collection due to UFO Abduction
 */
public class UFOAbduction extends KillMariogatchi {

    @Override
    public void execute(User user, Mariogatchi mario, RemoveMariogatchiPresenter presenter) {
        if (Kill(user, mario)) {
            presenter.getKillActionType(RemoveMariogatchiPresenterInterface.KillAction.UFOABDUCTION);
        } else {
            presenter.getKillActionType(RemoveMariogatchiPresenterInterface.KillAction.ERROR);
        }
    }
}
