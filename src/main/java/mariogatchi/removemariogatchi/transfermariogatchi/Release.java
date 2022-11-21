package mariogatchi.removemariogatchi.transfermariogatchi;

import mariogatchi.Mariogatchi;
import mariogatchi.RemoveMariogatchiPresenter;
import mariogatchi.RemoveMariogatchiPresenterInterface;
import mariogatchi.User;

/**
 * Use case
 * User action to release a Mariogatchi from their collection of Mariogatchis
 */
public class Release extends TransferMariogatchi {
    @Override
    public void execute(User user, Mariogatchi mario, RemoveMariogatchiPresenter presenter) {
        if (Transfer(user, mario)) {
            System.out.println
                    (presenter.getTransferActionType(RemoveMariogatchiPresenterInterface.TransferAction.RELEASE));
        } else {
            System.out.println("Failed to release the Mariogatchi");
        }
    }
}
