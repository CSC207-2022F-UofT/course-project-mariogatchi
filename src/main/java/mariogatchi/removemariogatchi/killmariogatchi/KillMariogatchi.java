package mariogatchi.removemariogatchi.killmariogatchi;

import mariogatchi.Mariogatchi;
import mariogatchi.MariogatchiManager;
import mariogatchi.User;
import mariogatchi.removemariogatchi.RemoveMariogatchi;

public abstract class KillMariogatchi implements RemoveMariogatchi {
    protected MariogatchiManager manager = new MariogatchiManager();

    protected boolean Release(User user, Mariogatchi mario){
        return manager.ReleaseMariogatchi(user, mario);
    }

}
