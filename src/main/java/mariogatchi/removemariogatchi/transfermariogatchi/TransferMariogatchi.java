package mariogatchi.removemariogatchi.transfermariogatchi;

import mariogatchi.MariogatchiManager;
import mariogatchi.removemariogatchi.RemoveMariogatchi;

/**
 * Use case
 * Abstract class to remove a Mariogatchi from the users collection of Mariogatchis
 */
public abstract class TransferMariogatchi implements RemoveMariogatchi {

    protected MariogatchiManager manager = new MariogatchiManager();

    protected boolean Transfer(User user, Mariogatchi mario){
        return manager.ReleaseMariogatchi(user, mario);
    }
}
