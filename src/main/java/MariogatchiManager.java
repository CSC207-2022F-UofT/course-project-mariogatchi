import Mariogatchi.Mariogatchi;
import Mariogatchi.User;

import java.util.List;

/**
 * Use case class responsible for interacting with the Mariogatchi entity class
 */

public class MariogatchiManager {
    private static MariogatchiManager instance;
    private List<Mariogatchi> mariogatchis;

    /**
     * Instantiate a new MariogatchiManager
     */
    public MariogatchiManager(User user) {
        mariogatchis = new user.getMariogatchis();
    }

    /**
     * Instantiate a new MariogatchiManager if not created or return the instance
     *
     * @return MariogatchiManager
     */
    public static MariogatchiManager getInstance() {
        if (instance == null) {
            instance = new MariogatchiManager();
        }
        return instance;
    }

    /**
     * Get all Mariogatchis
     *
     * @return all Mariogatchis
     */
    public List<Mariogatchi> getMariogatchis() {
        return mariogatchis;
    }

    /**
     * Set all Mariogatchis
     */
    public void setMariogatchis(List<Mariogatchi> mariogatchis) {
        this.mariogatchis = mariogatchis;
    }

    /**
     * Create a Mariogatchi with the following properties
     *
     * @param name the name of the Mariogatchi
     */
    public void createMariogatchi(Mariogatchi name){
        this.mariogatchis.add(name);
    }

    /**
     * Remove a Mariogatchi from mariogatchi
     *
     * @param name the name of the Mariogatchi
     */
    public void removeMariogatchi(Mariogatchi name){
        this.mariogatchis.remove(name);
    }
}
