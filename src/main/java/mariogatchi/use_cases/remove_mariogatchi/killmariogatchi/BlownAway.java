package mariogatchi.use_cases.remove_mariogatchi.killmariogatchi;

import mariogatchi.entities.Mariogatchi;
import mariogatchi.entities.User;
import mariogatchi.use_cases.remove_mariogatchi.RemoveMariogatchiDisplayerInterface;
import mariogatchi.use_cases.remove_mariogatchi.RemoveMariogatchiPresenterInterface;

/**
 * Use case
 * Event where a Mariogatchi dies by being blown away
 */
public class BlownAway extends KillMariogatchi {

    @Override
    public void execute(User user, Mariogatchi mario, RemoveMariogatchiPresenterInterface presenter, RemoveMariogatchiDisplayerInterface displayer) {
        if (Kill(user, mario)) {
            displayer.removeMariogatchiText(presenter.getKillActionType(RemoveMariogatchiPresenterInterface.KillAction.BLOWNAWAY));
        } else {
            displayer.removeMariogatchiText(presenter.getKillActionType(RemoveMariogatchiPresenterInterface.KillAction.ERROR));
        }
    }
}

