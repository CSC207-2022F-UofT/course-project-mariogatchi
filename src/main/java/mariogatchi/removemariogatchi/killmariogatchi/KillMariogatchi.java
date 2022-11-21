package mariogatchi.removemariogatchi.killmariogatchi;

import mariogatchi.MariogatchiManager;
import mariogatchi.removemariogatchi.RemoveMariogatchi;

/**
 * Abstract class to remove a Mariogatchi from the users collection of Mariogatchis
 */
public abstract class KillMariogatchi implements RemoveMariogatchi {
    protected MariogatchiManager manager = new MariogatchiManager();

    protected boolean Kill(User user, Mariogatchi mario){
        return manager.ReleaseMariogatchi(user, mario);
    }

}
