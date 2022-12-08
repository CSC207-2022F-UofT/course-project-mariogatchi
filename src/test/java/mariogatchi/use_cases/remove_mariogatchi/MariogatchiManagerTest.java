package mariogatchi.use_cases.remove_mariogatchi;

import mariogatchi.entities.Mariogatchi;
import mariogatchi.entities.User;
import mariogatchi.use_cases.manager.MariogatchiManager;
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
        Mariogatchi mariogatchi = new Mariogatchi(10, "Nicolegatchi", null, "Rare");
        MariogatchiManager manager = new MariogatchiManager();
        User user = new User("Test User");
        user.setMariogatchis(new ArrayList<>() {
        });

        Assertions.assertFalse(manager.ReleaseMariogatchi(user, mariogatchi));
    }

    /**
     * AddMariogatchi returns True if method can add a Mariogatchi to users collection
     */
    @Test
    public void AddMariogatchi_thenisTrue() {
        Mariogatchi mariogatchi = new Mariogatchi(10, "Nicolegatchi", null, "Rare");
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
        Mariogatchi mariogatchi = new Mariogatchi(10, "Nicolegatchi", null, "Rare");
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
        Mariogatchi mariogatchi = new Mariogatchi(10, "Nicolegatchi", null, "Rare");
        Mariogatchi mariogatchi2 = new Mariogatchi(10, "Nishigatchi", null, "Rare");
        MariogatchiManager manager = new MariogatchiManager();
        User user = new User("Test User");
        user.setMariogatchis(new ArrayList<>());
        manager.AddMariogatchi(user, mariogatchi);

        Assertions.assertFalse(manager.ReleaseMariogatchi(user, mariogatchi2));
    }

    /**
     * AddMariogatchi returns False if method cannot add a Mariogatchi to a full collection (limit 10)
     */
    @Test
    public void AddEleventhMariogatchi_thenisFalse(){
        Mariogatchi one = new Mariogatchi(1, "Nicolegatchi", null, "Rare");
        Mariogatchi two = new Mariogatchi(2, "Nicolegatchi", null, "Rare");
        Mariogatchi three = new Mariogatchi(3, "Nicolegatchi", null, "Rare");
        Mariogatchi four = new Mariogatchi(4, "Nicolegatchi", null, "Rare");
        Mariogatchi five = new Mariogatchi(5, "Nicolegatchi", null, "Rare");
        Mariogatchi six = new Mariogatchi(6, "Nicolegatchi", null, "Rare");
        Mariogatchi seven = new Mariogatchi(7, "Nicolegatchi", null, "Rare");
        Mariogatchi eight = new Mariogatchi(8, "Nicolegatchi", null, "Rare");
        Mariogatchi nine = new Mariogatchi(9, "Nicolegatchi", null, "Rare");
        Mariogatchi ten = new Mariogatchi(10, "Nicolegatchi", null, "Rare");
        Mariogatchi mariogatchi = new Mariogatchi(11, "Nicolegatchi", null, "Rare");

        MariogatchiManager manager = new MariogatchiManager();
        User user = new User("Test User");

        ArrayList<Mariogatchi> list = new ArrayList<>();
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);
        list.add(five);
        list.add(six);
        list.add(seven);
        list.add(eight);
        list.add(nine);
        list.add(ten);

        user.setMariogatchis(list);
        manager.AddMariogatchi(user, mariogatchi);

        Assertions.assertFalse(manager.ReleaseMariogatchi(user, mariogatchi));
    }

    /**
     * AddMariogatchi returns True if method can add a Mariogatchi to a collection of 9
     */
    @Test
    public void AddTenthMariogatchi_thenisFalse(){
        Mariogatchi one = new Mariogatchi(1, "Nicolegatchi", null, "Rare");
        Mariogatchi two = new Mariogatchi(2, "Nicolegatchi", null, "Rare");
        Mariogatchi three = new Mariogatchi(3, "Nicolegatchi", null, "Rare");
        Mariogatchi four = new Mariogatchi(4, "Nicolegatchi", null, "Rare");
        Mariogatchi five = new Mariogatchi(5, "Nicolegatchi", null, "Rare");
        Mariogatchi six = new Mariogatchi(6, "Nicolegatchi", null, "Rare");
        Mariogatchi seven = new Mariogatchi(7, "Nicolegatchi", null, "Rare");
        Mariogatchi eight = new Mariogatchi(8, "Nicolegatchi", null, "Rare");
        Mariogatchi nine = new Mariogatchi(9, "Nicolegatchi", null, "Rare");
        Mariogatchi mariogatchi = new Mariogatchi(11, "Nicolegatchi", null, "Rare");

        MariogatchiManager manager = new MariogatchiManager();
        User user = new User("Test User");

        ArrayList<Mariogatchi> list = new ArrayList<>();
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);
        list.add(five);
        list.add(six);
        list.add(seven);
        list.add(eight);
        list.add(nine);

        user.setMariogatchis(list);
        manager.AddMariogatchi(user, mariogatchi);

        Assertions.assertTrue(manager.ReleaseMariogatchi(user, mariogatchi));
    }
}