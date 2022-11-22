package mariogatchi.removemariogatchi;

import mariogatchi.Mariogatchi;
import mariogatchi.RemoveMariogatchiDisplayerInterface;
import mariogatchi.RemoveMariogatchiPresenterInterface;
import mariogatchi.User;

/**
 * Use case
 * Interface to execute removing a specified Mariogatchi from users collection of mariogatchis and leads into presenter
 */
public interface RemoveMariogatchi {
    void execute(User user, Mariogatchi mario, RemoveMariogatchiPresenterInterface presenter, RemoveMariogatchiDisplayerInterface displayer);
}
