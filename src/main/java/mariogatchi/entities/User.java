package mariogatchi.entities;

import mariogatchi.entities.environments.Environment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User implements Serializable{
    private String name;

    private Inventory inventory;
    private List<Mariogatchi> mariogatchis;

    private Environment currentEnvironment;

    /**
     * Default user constructor
     * @param name the name of the user
     */
    public User(String name){
        this.name = name;
        this.mariogatchis = new ArrayList<>();
    }


    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Inventory getInventory(){
        return inventory;
    }

    public void setInventory(Inventory inventory){
        this.inventory = inventory;
    }

    public List<Mariogatchi> getMariogatchis(){
        return mariogatchis;
    }

    public void setMariogatchis(List<Mariogatchi> mariogatchis){
        mariogatchis.remove(null);
        this.mariogatchis = mariogatchis;
    }

    public Environment getCurrentEnvironment() {
        return currentEnvironment;
    }

    public void setCurrentEnvironment(Environment environment) {
        this.currentEnvironment = environment;
    }

    public Mariogatchi getMariogatchiFromUser(String name, List<Mariogatchi> mariogatchis) {
        for (Mariogatchi m: mariogatchis) {
            if (Objects.equals(m.getName(), name)) {
                return m;
            }
        }
        return null;
    }
    public Statistics getMariogatchiStatsFromUser(String name) {
        return getMariogatchiFromUser(name, this.getMariogatchis()).getStats();
    }

    public List<String> getMariogatchiNames() {
        List<String> mList = new ArrayList<String>();
        for(Mariogatchi m : mariogatchis){
            mList.add(m.getName());
        }
        return mList;
    }
}