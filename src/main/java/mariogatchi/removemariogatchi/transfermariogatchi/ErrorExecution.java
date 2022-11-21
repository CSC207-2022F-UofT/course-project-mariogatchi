package mariogatchi.removemariogatchi.transfermariogatchi;

import mariogatchi.*;

/**
 * Use case
 * Error from execute error
 */
public class ErrorExecution extends TransferMariogatchi {
    @Override
    public void execute(User user, Mariogatchi mario, RemoveMariogatchiPresenterInterface presenter, RemoveMariogatchiDisplayerInterface displayer) {
        displayer.removeMariogatchiText(presenter.getTransferActionType(RemoveMariogatchiPresenterInterface.TransferAction.ERROR));

    }
}
