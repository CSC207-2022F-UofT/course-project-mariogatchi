package mariogatchi.use_cases.manager;

import mariogatchi.entities.Mariogatchi;
import mariogatchi.entities.User;

import java.util.List;
import java.util.Objects;

/**
 * Use case to manage a Mariogatchi entity
 */
public class MariogatchiManager {
    /**
     * Removes a Mariogatchi from a users collection of Mariogatchis List<Mariogatchi>
     *
     * @param user        a user
     * @param mariogatchi a name of a Mariogatchi entity
     * @return boolean true if the mariogatchi is successfully deleted from the users list and false otherwise
     */
    public boolean ReleaseMariogatchi(User user, Mariogatchi mariogatchi) {
        List<Mariogatchi> lst = user.getMariogatchis();
        if (lst != null) {
            for (Mariogatchi mario : lst) {
                if (mario.equals(mariogatchi)) {
                    lst.remove(mario);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Adds a Mariogatchi to a users collection of Mariogatchis List<Mariogatchi>
     *
     * @param user        a user
     * @param mariogatchi a Mariogatchi entity
     * @return boolean true if the mariogatchi is successfully added from the users list and false otherwise
     */
    public boolean AddMariogatchi(User user, Mariogatchi mariogatchi) {
        List<Mariogatchi> lst = user.getMariogatchis();
        if (lst.size() < 10) {
            lst.add(mariogatchi);
            return true;
        }
        return false;
    }



}
