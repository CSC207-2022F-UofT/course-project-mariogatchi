package mariogatchi.use_cases.manager.remove_mariogatchi.killmariogatchi;

import mariogatchi.entities.Mariogatchi;
import mariogatchi.entities.User;
import mariogatchi.use_cases.manager.remove_mariogatchi.RemoveMariogatchiDisplayerInterface;
import mariogatchi.use_cases.manager.remove_mariogatchi.RemoveMariogatchiPresenterInterface;

/**
 * Use case
 * Event where a Mariogatchi dies from drowning
 */
public class Drown extends KillMariogatchi {

    @Override
    public void execute(User user, Mariogatchi mario, RemoveMariogatchiPresenterInterface presenter, RemoveMariogatchiDisplayerInterface displayer) {
        if (Kill(user, mario)) {
            displayer.removeMariogatchiText(presenter.getKillActionType(RemoveMariogatchiPresenterInterface.KillAction.DROWN));
        } else {
            displayer.removeMariogatchiText(presenter.getKillActionType(RemoveMariogatchiPresenterInterface.KillAction.ERROR));
        }
    }
}