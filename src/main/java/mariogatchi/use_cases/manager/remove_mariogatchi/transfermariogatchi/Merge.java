package mariogatchi.use_cases.manager.remove_mariogatchi.transfermariogatchi;

import mariogatchi.entities.Mariogatchi;
import mariogatchi.entities.User;
import mariogatchi.use_cases.manager.remove_mariogatchi.RemoveMariogatchiDisplayerInterface;
import mariogatchi.use_cases.manager.remove_mariogatchi.RemoveMariogatchiPresenterInterface;

/**
 * Use case
 * User action to merge two Mariogatchis together
 */
public class Merge extends TransferMariogatchi {
    @Override
    public void execute(User user, Mariogatchi mario, RemoveMariogatchiPresenterInterface presenter, RemoveMariogatchiDisplayerInterface displayer) {
        if (Transfer(user, mario)) {
            displayer.removeMariogatchiText(presenter.getTransferActionType(RemoveMariogatchiPresenterInterface.TransferAction.MERGE));
        } else {
            displayer.removeMariogatchiText(presenter.getTransferActionType(RemoveMariogatchiPresenterInterface.TransferAction.ERROR));
        }
    }
}
