package mariogatchi;

import java.io.*;
import java.util.ArrayList;
import mariogatchi.Serializer.*;
public class Statistics implements Serializable {
    public ArrayList<Long> checkTimes = new ArrayList<>();
    private int max;//increases with the level
    private int hunger; //higher indicates less hunger craving, lower indicates more hungry craving
    private int energy; //higher indicates more energy and excitment, lower indicates less energy and fatigue
    private int cleanliness; //higher indicates  clean, lower indicates dirty
    private int happiness;//higher indicates happy, lower indicates sad
    private int agility;//higher indicates agile, lower indicates sad
    private int strategy;//higher indicates strategic, lower indicates less strategic
    private long lastCheckTime;

    public enum Actions{
        WALK, SLEEP, BATHE, TRAIN, PLAY
    }
    public enum Stats{
        HUNGER, ENERGY, CLEANLINESS, HAPPINESS, AGILITY, STRATEGY, LASTCHECKTIME
    }
    public Statistics(String mariogatchiKind){
        int startingValue = 50;
        if(mariogatchiKind.equals("rare")) startingValue = 75;
        this.hunger = startingValue;
        this.energy = startingValue;
        this.cleanliness = startingValue;
        this.happiness = startingValue;
        this.agility = startingValue;
        this.strategy = startingValue;
        this.max=100;
        this.lastCheckTime = (long) getLastCheckTime();
    }

    public void reduceStat(String stat, int factor){
        /**
         * make sure to check for string errors
         */

        switch (stat.toLowerCase()){//use switch case for efficiency
            case "hunger":
                if(this.hunger >=(10*factor))
                    this.hunger-=(10*factor);
                break;
            case "energy":
                if(this.energy >=(10*factor))
                    this.energy-=(10*factor);
                break;
            case "cleanliness":
                if(this.cleanliness >=(10*factor))
                    this.cleanliness-=(10 * factor);
                break;
            case "happiness":
                if(this.happiness >=(10*factor))
                    this.happiness-=(10 * factor);
                break;
            case "agility":
                if(this.agility >=(10*factor))
                    this.agility-=(10 * factor);
                break;
            case "strategy":
                if(this.strategy >=(10*factor))
                    this.strategy-=(10 * factor);
                break;
        }

    }

    public void residualChange(){

    }

    public void increaseStat(String stat, int factor){
        /**
         * make sure to check for string errors
         */
        switch (stat.toLowerCase()){
            case "hunger":
                if(this.hunger<=max-((10*factor)))
                    this.hunger+=(10*factor);
                else
                    this.hunger =max;
                break;
            case "energy":
                if(this.energy<=max-((10*factor)))
                    this.energy+=(10*factor);
                else
                    this.energy =max;
                break;
            case "cleanliness":
                if(this.cleanliness<=max-((10*factor)))
                    this.cleanliness+=(10*factor);
                else
                    this.cleanliness = max;
                break;
            case "happiness":
                if(this.happiness <= max - ((10*factor)))
                    this.happiness += (10*factor);
                else
                    this.happiness = max;
                break;
            case "agility":
                if(this.agility<=max-((10*factor)))
                    this.agility+=(10*factor);
                else
                    this.agility =max;
                break;
            case "strategy":
                if(this.strategy<=max-((10*factor)))
                    this.strategy+=(10*factor);
                else
                    this.strategy = max;
                break;
        }
    }

    public int getStat(String stat){
        switch (stat.toLowerCase()){
            case "hunger":
                return this.hunger;
            case "energy":
                return this.energy;
            case "cleanliness":
                return this.cleanliness;
            case "happiness":
                return this.happiness;
            case "agility":
                return this.agility;
            case "strategy":
                return this.strategy;
            default:
                return 0;

        }

    }


    public void statChange(String func){

        switch(func.toLowerCase()){
            case "decay":
                reduceStat("hunger",1);
                reduceStat("energy", 1);
                reduceStat("cleanliness", 1);
                reduceStat("happiness", 1);
                reduceStat("agility", 1);
                reduceStat("strategy", 1);
                break;
            case "feed":
                increaseStat("happiness", 1);
                increaseStat("energy", 1);
                increaseStat("hunger", 2);

            case "bathe":
                increaseStat("happiness", 1);
                increaseStat("cleanliness", 1);

                break;
            case "walk":
                increaseStat("happiness", 1);
                reduceStat("energy", 1);
                reduceStat("cleanliness", 1);
                break;
            case "sleep":
                increaseStat("happiness", 2);
                this.energy = max;
                reduceStat("cleanliness", 1);
                reduceStat("hunger", 1);
                break;
            case "train":
                increaseStat("agility", 1);
                increaseStat("strategy", 1);
                reduceStat("energy",1 );
                reduceStat("cleanliness", 1);
                break;
            case "play":
                increaseStat("happiness", 1);
                reduceStat("energy", 1);
                break;


        }
    }

    public void saveCheckTime(){
        /**
         * Checks the last date and loads it
         */
        try{
            FileOutputStream fos = new FileOutputStream("times.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(System.currentTimeMillis());
            oos.close();
            fos.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

    }


    public Serializable getLastCheckTime(){
        /**
         * Checks the last date and loads it
         */
        Serializable obj = null;
        try{
            FileInputStream fis = new FileInputStream("times.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            try{
                obj = (Serializable) ois.readObject();
            }catch(ClassNotFoundException e){
                System.out.println(e.getMessage());
            }
            ois.close();
            fis.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

        return obj;
    }

    public void levelUp(){
        this.max+=10;
    }


}