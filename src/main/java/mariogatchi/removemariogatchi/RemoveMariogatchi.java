package mariogatchi.removemariogatchi;

import mariogatchi.RemoveMariogatchiDisplayer;
import mariogatchi.RemoveMariogatchiPresenter;

/**
 * Interface to execute removing a specified Mariogatchi from users collection of mariogatchis and leads into presenter
 */
public interface RemoveMariogatchi {
    void execute(User user, Mariogatchi mario, RemoveMariogatchiPresenter presenter, RemoveMariogatchiDisplayer displayer);
}
