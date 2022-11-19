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
    public MariogatchiManager() {
        mariogatchis = new List<>();
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
    public void createMariogatchi(String name) {
    }

    /**
     * Remove a Mariogatchi
     *
     * @param name the name of the Mariogatchi
     */
    public void removeMariogatchi(String name){}

    /**
     * Return a Mariogatchi
     *
     * @param name the name of the Mariogatchi
     * @return the information of the Mariogatchi
     */
    public String returnMariogatchi(String name){
        return name;
    }
}
