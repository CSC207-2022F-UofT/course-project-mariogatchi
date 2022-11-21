package mariogatchi.removemariogatchi.killmariogatchi;

import mariogatchi.*;

/**
 * Use case
 * Event where a Mariogatchi is removed from the Users mariogatchi collection due to UFO Abduction
 */
public class UFOAbduction extends KillMariogatchi {

    @Override
    public void execute(User user, Mariogatchi mario, RemoveMariogatchiPresenter presenter, RemoveMariogatchiDisplayer displayer) {
        if (Kill(user, mario)) {
            displayer.removeMariogatchiText(presenter.getKillActionType(RemoveMariogatchiPresenterInterface.KillAction.UFOABDUCTION));
        } else {
            displayer.removeMariogatchiText(presenter.getKillActionType(RemoveMariogatchiPresenterInterface.KillAction.ERROR));
        }
    }
}
