package Mariogatchi;

import java.io.Serializable;

/**
 * Statistics for a Mariogatchi creature
 */
public class Statistics implements Serializable {
    /**
     * The maximum level for any one of this Mariogatchi's stats.
     */
    private int maxLevel;
    /**
     * Mariogatchi's hunger level.
     */
    private int hunger;
    /**
     * Mariogatchi's energy level.
     */
    private int energy;
    /**
     * Mariogatchi's level of cleanliness.
     */
    private int cleanliness;
    /**
     * Mariogatchi's happiness level.
     */
    private int happiness;
    /**
     * Mariogatchi's agility level.
     */
    private int agility;
    /**
     * Mariogatchi's strategy level.
     */
    private int strategy;
    /**
     * The last time this Mariogatchi's stats were checked.
     */
    private long lastCheckTime;


    /**
     * Initiate Stats for a new Mariogatchi.
     * @param mariogatchiKind: This mariogatchi's rarity.
     */
    public Statistics(String mariogatchiKind){
        int startingValue = 50;
        if(mariogatchiKind.equals("rare")) startingValue = 75;
        this.maxLevel = startingValue;
        this.hunger = startingValue;
        this.energy = startingValue;
        this.cleanliness = startingValue;
        this.happiness = startingValue;
        this.agility = startingValue;
        this.strategy = startingValue;
        this.lastCheckTime = System.currentTimeMillis();
    }

    public int getMaxLevel(){
        return this.maxLevel;
    }

    public int getHunger(){
        return this.hunger;
    }

    public int getEnergy(){
        return this.energy;
    }

    public int getCleanliness(){
        return this.cleanliness;
    }

    public int getHappiness(){
        return this.happiness;
    }

    public int getAgility(){
        return this.agility;
    }

    public int getStrategy(){
        return this.strategy;
    }

    public long getLastCheckTime(){
        return this.lastCheckTime;
    }

    public void reduceStat(String stat, int factor){
        /**
         * make sure to check for string errors
         */

        switch (stat.toLowerCase()){//use switch case for efficiency
            case "hunger":
                if(this.hunger >=(factor))
                    this.hunger-=(factor);
                break;
            case "energy":
                if(this.energy >=(factor))
                    this.energy-=(factor);
                break;
            case "cleanliness":
                if(this.cleanliness >=(factor))
                    this.cleanliness-=(factor);
                break;
            case "happiness":
                if(this.happiness >=(factor))
                    this.happiness-=(factor);
                break;
            case "agility":
                if(this.agility >=(factor))
                    this.agility-=(factor);
                break;
            case "strategy":
                if(this.strategy >=(factor))
                    this.strategy-=(factor);
                break;
        }

    }

    public void increaseStat(String stat, int factor){
        /**
         * make sure to check for string errors
         */
        switch (stat.toLowerCase()){
            case "hunger":
                if(this.hunger<=maxLevel-((factor)))
                    this.hunger+=(factor);
                else
                    this.hunger =maxLevel;
                break;
            case "energy":
                if(this.energy<=maxLevel-((factor)))
                    this.energy+=(factor);
                else
                    this.energy =maxLevel;
                break;
            case "cleanliness":
                if(this.cleanliness<=maxLevel-((factor)))
                    this.cleanliness+=(factor);
                else
                    this.cleanliness = maxLevel;
                break;
            case "happiness":
                if(this.happiness <= maxLevel - ((factor)))
                    this.happiness += (factor);
                else
                    this.happiness = maxLevel;
                break;
            case "agility":
                if(this.agility<=maxLevel-((factor)))
                    this.agility+=(factor);
                else
                    this.agility =maxLevel;
                break;
            case "strategy":
                if(this.strategy<=maxLevel-((factor)))
                    this.strategy+=(factor);
                else
                    this.strategy = maxLevel;
                break;
        }
    }

    public int getStat(String stat){
        return switch (stat.toLowerCase()) {
            case "hunger" -> this.hunger;
            case "energy" -> this.energy;
            case "cleanliness" -> this.cleanliness;
            case "happiness" -> this.happiness;
            case "agility" -> this.agility;
            case "strategy" -> this.strategy;
            default -> 0;
        };

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
                this.energy = maxLevel;
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

    /**
     * Decay mariogatchi's stats due to passed time.
     * @param currentTime - current time as millis long
     * @return how much time has elapsed (current - lastCheck)
     */
    public long statDecay(long currentTime){
        long elapsedTime = currentTime - this.lastCheckTime;
        // how many intervals of 30 minutes have passed
        long intervals30min = elapsedTime / (30 * 60 * 1000);
        // decrement stats by 2 for each hour (1 per 30min)
        int reduceBy =  (int) intervals30min;
        reduceStat("hunger", reduceBy);
        reduceStat("energy", reduceBy);
        reduceStat("cleanliness", reduceBy);
        reduceStat("happiness", reduceBy);
        this.lastCheckTime = currentTime;
        return elapsedTime;
    }

}
