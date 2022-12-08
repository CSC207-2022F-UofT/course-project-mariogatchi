package mariogatchi.use_cases.remove_mariogatchi.killmariogatchi;

import mariogatchi.entities.Mariogatchi;
import mariogatchi.use_cases.manager.MariogatchiManager;
import mariogatchi.entities.User;
import mariogatchi.use_cases.remove_mariogatchi.RemoveMariogatchi;

/**
 * Use case
 * Abstract class to remove a Mariogatchi from the users collection of Mariogatchis
 */
public abstract class KillMariogatchi implements RemoveMariogatchi {
    protected MariogatchiManager manager = new MariogatchiManager();

    protected boolean Kill(User user, Mariogatchi mario){
        return manager.ReleaseMariogatchi(user, mario);
    }

}
