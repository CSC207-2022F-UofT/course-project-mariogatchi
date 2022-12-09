package mariogatchi.entities;

import mariogatchi.entities.environments.*;
import mariogatchi.entities.environments.Environment;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{
    private String name;
    private Inventory inventory;
    private List<Mariogatchi> mariogatchis;

    private List<User> friends;
    private Environment environment;

    private Environment currentEnvironment;
    private Statistics statistics;
    public User(String name){
        this.name = name;
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
        this.mariogatchis = mariogatchis;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public Environment getCurrentEnvironment() {
        return this.currentEnvironment;
    }

    public void setCurrentEnvironment(Environment environment) {
        this.currentEnvironment = environment;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public void setEnvironment(Env environment){
        switch (environment){
            case HOME -> this.environment = new Home();
            case PARK -> this.environment = new Park();
            case FOREST -> this.environment = new Forest();
        }
    }
}
