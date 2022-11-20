package mariogatchi.removemariogatchi;

import mariogatchi.Mariogatchi;
import mariogatchi.ReleasePresenter;
import mariogatchi.User;

public interface RemoveMariogatchi {
    void execute(User user, Mariogatchi mario, ReleasePresenter presenter);
}
