package mariogatchi.removemariogatchi.killmariogatchi;

import mariogatchi.Mariogatchi;
import mariogatchi.ReleasePresenter;
import mariogatchi.User;

public class Starvation extends KillMariogatchi {

    @Override
    public void execute(User user, Mariogatchi mario, ReleasePresenter presenter) {
        if(Release(user, mario)){
            presenter.DisplayText();
        } else {
            // Return error text
            System.out.println("Failed to release"); // todo
        }

    }
}
