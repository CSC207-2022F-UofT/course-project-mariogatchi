package mariogatchi;

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

}
