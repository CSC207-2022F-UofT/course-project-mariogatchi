package mariogatchi.removemariogatchi.killmariogatchi;

import mariogatchi.*;

/**
 * Use case
 * Event where a Mariogatchi dies from illness
 */
public class Illness extends KillMariogatchi{

    @Override
    public void execute(User user, Mariogatchi mario, RemoveMariogatchiPresenter presenter, RemoveMariogatchiDisplayer displayer) {
        if (Kill(user, mario)){
            displayer.removeMariogatchiText(presenter.getKillActionType(RemoveMariogatchiPresenterInterface.KillAction.ILLNESS));
        }
        else {
            displayer.removeMariogatchiText(presenter.getKillActionType(RemoveMariogatchiPresenterInterface.KillAction.ERROR));
        }
    }
}