package mariogatchi.removemariogatchi.killmariogatchi;

import mariogatchi.Mariogatchi;
import mariogatchi.RemoveMariogatchiPresenterInterface;
import mariogatchi.RemoveMariogatchiPresenter;
import mariogatchi.User;

/**
 * Use case
 * Event where a Mariogatchi is killed by wild animals
 */
public class Predators extends KillMariogatchi{

    @Override
    public void execute(User user, Mariogatchi mario, RemoveMariogatchiPresenter presenter) {
        if (Kill(user, mario)){
            presenter.getKillActionType(RemoveMariogatchiPresenterInterface.KillAction.PREDATORS);
        }
        else {
            presenter.getKillActionType(RemoveMariogatchiPresenterInterface.KillAction.ERROR);
        }
    }
}
