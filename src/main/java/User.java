import java.io.Serializable;
import java.util.List;

public class User implements Serializable{
    private String name;
    private List<Inventory> inventory;
    private List<Mariogatchi> mariogatchis;
    private List<User> friends;

    public User(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public List<Inventory> getInventory(){
        return inventory;
    }

    public void setInventory(List<Inventory> inventory){
        this.inventory = inventory;
    }

    public List<Mariogatchi> getMariogatchis(){
        return mariogatchis;
    }

    public void setMariogatchis(List<Mariogatchi> mariogatchis){
        this.mariogatchis = mariogatchis;
    }

    public List<User> getFriends(){
        return friends;
    }

    public void setFriends(List<User> friends){
        this.friends = friends;
    }
}