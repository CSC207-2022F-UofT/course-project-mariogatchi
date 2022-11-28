import mariogatchi.Mariogatchi;
import mariogatchi.MariogatchiManager;
import mariogatchi.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * Test file for the MariogatchiManager
 * Checks if each method in the MariogatchiManager will run
 */
public class MariogatchiManagerTest {

    /**
     * ReleaseMariogatchi returns False if there are no Mariogatchis to release in Users collection
     */
    @Test
    public void ReleaseMariogatchi_thenisFalse() {
        Mariogatchi mariogatchi = new Mariogatchi();
        MariogatchiManager manager = new MariogatchiManager();
        User user = new User("Test User");
        user.setMariogatchis(new ArrayList<>());

        Assertions.assertFalse(manager.ReleaseMariogatchi(user, mariogatchi));
    }

    /**
     * AddMariogatchi returns True if method can add a Mariogatchi to users collection
     */
    @Test
    public void AddMariogatchi_thenisTrue() {
        Mariogatchi mariogatchi = new Mariogatchi();
        MariogatchiManager manager = new MariogatchiManager();
        User user = new User("Test User");
        user.setMariogatchis(new ArrayList<>());

        Assertions.assertTrue(manager.AddMariogatchi(user, mariogatchi));
    }

    /**
     * ReleaseMariogatchi returns True if method can release a Mariogatchi from users collection
     */
    @Test
    public void ReleaseMariogatchi_thenisTrue() {
        Mariogatchi mariogatchi = new Mariogatchi();
        MariogatchiManager manager = new MariogatchiManager();
        User user = new User("Test User");
        user.setMariogatchis(new ArrayList<>());
        manager.AddMariogatchi(user, mariogatchi);

        Assertions.assertTrue(manager.ReleaseMariogatchi(user, mariogatchi));
    }

    /**
     * ReleaseMariogatchi returns False if method does not release the correct Mariogatchi from users collection
     */
    @Test
    public void ReleaseWrongMariogatchi_thenisFalse(){
        Mariogatchi mariogatchi = new Mariogatchi();
        Mariogatchi mariogatchi2 = new Mariogatchi();
        MariogatchiManager manager = new MariogatchiManager();
        User user = new User("Test User");
        user.setMariogatchis(new ArrayList<>());
        manager.AddMariogatchi(user, mariogatchi);

        Assertions.assertFalse(manager.ReleaseMariogatchi(user, mariogatchi2));
    }
}