package mariogatchi.removemariogatchi.killmariogatchi;

import mariogatchi.*;

/**
 * Use case
 * Event where Mariogatchi dies from Starvation
 */
public class Starvation extends KillMariogatchi {

    @Override
    public void execute(User user, Mariogatchi mario, RemoveMariogatchiPresenter presenter, RemoveMariogatchiDisplayer displayer) {
        if(Kill(user, mario)){
            displayer.removeMariogatchiText(presenter.getKillActionType(RemoveMariogatchiPresenterInterface.KillAction.STARVATION));
        } else {
            // Return error text
            displayer.removeMariogatchiText(presenter.getKillActionType(RemoveMariogatchiPresenterInterface.KillAction.ERROR));
        }

    }
}
