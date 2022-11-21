package mariogatchi.removemariogatchi.transfermariogatchi;

import mariogatchi.*;

/**
 * Use case
 * User action to release a Mariogatchi from their collection of Mariogatchis
 */
public class Release extends TransferMariogatchi {
    @Override
    public void execute(User user, Mariogatchi mario, RemoveMariogatchiPresenterInterface presenter, RemoveMariogatchiDisplayerInterface displayer) {
        if (Transfer(user, mario)) {
            displayer.removeMariogatchiText(presenter.getTransferActionType(RemoveMariogatchiPresenterInterface.TransferAction.RELEASE));
        } else {
            displayer.removeMariogatchiText(presenter.getTransferActionType(RemoveMariogatchiPresenterInterface.TransferAction.ERROR));
        }
    }
}
