import java.io.Serializable;
import java.util.List;

public class User implements Serializable{
    private String name;
    private List<Inventory> inventory;
    private List<Mariogatchi> mariogatchis;
    private List<User> friends;

    /**
     * Creates an User with a name
     * @param name The name of the user
     */
    public User(String name){
        this.name = name;
    }

    /**
     * Gets the name of the user
     * @return The name of the user
     */
    public String getName(){
        return name;
    }

    /**
     * Sets the name of the user
     * @param name The new name of the user
     */
    public void setName(String name){
        this.name = name;
    }

    public List<Inventory> getInventory(){
        return inventory;
    }

    public void setInventory(List<Inventory> inventory){
        this.inventory = inventory;
    }

    /**
     * Gets a list of the Mariogatchis the user has
     * @return The list of Mariogatchis the user has
     */
    public List<Mariogatchi> getMariogatchis(){
        return mariogatchis;
    }

    /**
     * Sets a list of the Mariogatchis the user has
     * @param mariogatchis The new list of Mariogatchis
     */
    public void setMariogatchis(List<Mariogatchi> mariogatchis){
        this.mariogatchis = mariogatchis;
    }

    /**
     * Gets a list of friends the user has
     * @return The list of friends the user has
     */
    public List<User> getFriends(){
        return friends;
    }

    /**
     * Sets a list of friends the user has
     * @param friends The new list of friends
     */
    public void setFriends(List<User> friends){
        this.friends = friends;
    }
}
