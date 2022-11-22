package mariogatchi.removemariogatchi.transfermariogatchi;

import mariogatchi.*;

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
