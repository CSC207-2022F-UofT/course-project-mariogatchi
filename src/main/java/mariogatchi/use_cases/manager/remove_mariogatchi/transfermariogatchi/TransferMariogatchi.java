package mariogatchi.use_cases.manager.remove_mariogatchi.transfermariogatchi;

import mariogatchi.entities.Mariogatchi;
import mariogatchi.entities.User;
import mariogatchi.use_cases.manager.MariogatchiManager;
import mariogatchi.use_cases.manager.remove_mariogatchi.RemoveMariogatchi;

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
