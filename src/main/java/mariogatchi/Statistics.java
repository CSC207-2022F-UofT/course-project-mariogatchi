package mariogatchi;

import java.io.Serializable;

/**
 * Statistics for a mariogatchi.Mariogatchi creature
 */
public class Statistics implements Serializable {
    /**
     * The maximum level for any one of this mariogatchi.Mariogatchi's stats.
     */
    private int maxLevel;
    /**
     * mariogatchi.Mariogatchi's hunger level.
     */
    private int hunger;
    /**
     * mariogatchi.Mariogatchi's energy level.
     */
    private int energy;
    /**
     * mariogatchi.Mariogatchi's level of cleanliness.
     */
    private int cleanliness;
    /**
     * mariogatchi.Mariogatchi's happiness level.
     */
    private int happiness;
    /**
     * mariogatchi.Mariogatchi's agility level.
     */
    private int agility;
    /**
     * mariogatchi.Mariogatchi's strategy level.
     */
    private int strategy;
    /**
     * The last time this mariogatchi.Mariogatchi's stats were checked.
     */
    private long lastCheckTime;


    /**
     * Initiate Stats for a new mariogatchi.Mariogatchi.
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

    public void LevelUp(){
        this.maxLevel += 50;
    }
    public void ResetAgility(){
        if(this.agility > this.maxLevel){
            this.agility = this.agility - this.maxLevel;
        }
        else{
            this.agility = 0;
        }
    }
    public void ResetStrategy(){
        if(this.strategy > this.maxLevel){
            this.strategy = this.strategy - this.maxLevel;
        }
        else{
            this.strategy = 0;
        }
    }


}
