package mariogatchi.removemariogatchi;

import mariogatchi.Mariogatchi;
import mariogatchi.RemoveMariogatchiDisplayer;
import mariogatchi.RemoveMariogatchiPresenter;
import mariogatchi.User;

/**
 * Interface to execute removing a specified Mariogatchi from users collection of mariogatchis and leads into presenter
 */
public interface RemoveMariogatchi {
    void execute(User user, Mariogatchi mario, RemoveMariogatchiPresenter presenter, RemoveMariogatchiPresenter displayer);
}
