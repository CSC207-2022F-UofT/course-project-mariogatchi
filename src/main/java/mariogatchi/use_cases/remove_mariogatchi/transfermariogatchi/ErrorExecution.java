package mariogatchi.use_cases.remove_mariogatchi.transfermariogatchi;

import mariogatchi.entities.Mariogatchi;
import mariogatchi.entities.User;
import mariogatchi.use_cases.remove_mariogatchi.RemoveMariogatchiDisplayerInterface;
import mariogatchi.use_cases.remove_mariogatchi.RemoveMariogatchiPresenterInterface;

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
