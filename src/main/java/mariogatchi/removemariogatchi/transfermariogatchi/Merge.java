package mariogatchi.removemariogatchi.transfermariogatchi;

import mariogatchi.Mariogatchi;
import mariogatchi.RemoveMariogatchiPresenterInterface;
import mariogatchi.RemoveMariogatchiPresenter;
import mariogatchi.User;

/**
 * Use case
 * User action to merge two Mariogatchis together
 */
public class Merge extends TransferMariogatchi{
    @Override
    public void execute(User user, Mariogatchi mario, RemoveMariogatchiPresenter presenter) {
        if (Transfer(user, mario)){
            presenter.getTransferActionType(RemoveMariogatchiPresenterInterface.TransferAction.MERGE);
        }
        else {
            presenter.getTransferActionType(RemoveMariogatchiPresenterInterface.TransferAction.ERROR);
        }
    }
}
