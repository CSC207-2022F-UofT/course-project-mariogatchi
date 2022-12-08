package mariogatchi.use_cases.remove_mariogatchi;

import mariogatchi.entities.Mariogatchi;
import mariogatchi.entities.User;
/**
 * Use case
 * Interface to execute removing a specified Mariogatchi from users collection of mariogatchis and leads into presenter
 */
public interface RemoveMariogatchi {
    void execute(User user, Mariogatchi mario, RemoveMariogatchiPresenterInterface presenter, RemoveMariogatchiDisplayerInterface displayer);
}
