package mariogatchi.removemariogatchi.killmariogatchi;

import mariogatchi.*;

/**
 * Use case
 * Event where a Mariogatchi dies by being blown away
 */
public class BlownAway extends KillMariogatchi {

    @Override
    public void execute(User user, Mariogatchi mario, RemoveMariogatchiPresenter presenter, RemoveMariogatchiDisplayer displayer) {
        if (Kill(user, mario)) {
            displayer.removeMariogatchiText(presenter.getKillActionType(RemoveMariogatchiPresenterInterface.KillAction.BLOWNAWAY));
        } else {
            displayer.removeMariogatchiText(presenter.getKillActionType(RemoveMariogatchiPresenterInterface.KillAction.ERROR));
        }
    }
}

