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
    
    
    enum Operator{
         ADD,
         SUBTRACT
    }
     enum Stats{
         HUNGER,
         ENERGY,
         CLEANLINESS,
         HAPPINESS,
         AGILITY,
         STRATEGY,
         LASTCHECKTIME
    }

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
    
    public void LevelUp(){
        this.maxLevel += 10;
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

    public boolean changeStat(Stats stat, int factor, Operator operate){
        /**
         * make sure to check for string errors
         */
        boolean changed = true;
        if(operate == Operator.SUBTRACT && factor > 0) {
            switch (stat) {//use switch case for efficiency
                case HUNGER:
                    if (this.hunger >= (factor))
                        this.hunger -= (factor);
                    break;
                case ENERGY:
                    if (this.energy >= (factor))
                        this.energy -= (factor);
                    break;
                case CLEANLINESS:
                    if (this.cleanliness >= (factor))
                        this.cleanliness -= (factor);
                    break;
                case HAPPINESS:
                    if (this.happiness >= (factor))
                        this.happiness -= (factor);
                    break;
                case AGILITY:
                    if (this.agility >= (factor))
                        this.agility -= (factor);
                    break;
                case STRATEGY:
                    if (this.strategy >= (factor))
                        this.strategy -= (factor);
                    break;
            }
        }
        if(operate == Operator.SUBTRACT && factor > 0){
            switch (stat){
                case HUNGER:
                    if(this.hunger<=max-((factor)))
                        this.hunger+=(factor);
                    else
                        this.hunger =max;
                    break;
                case ENERGY:
                    if(this.energy<=max-((factor)))
                        this.energy+=(factor);
                    else
                        this.energy =max;
                    break;
                case CLEANLINESS:
                    if(this.cleanliness<=max-((factor)))
                        this.cleanliness+=(factor);
                    else
                        this.cleanliness = max;
                    break;
                case HAPPINESS:
                    if(this.happiness <= max - ((factor)))
                        this.happiness += (factor);
                    else
                        this.happiness = max;
                    break;
                case AGILITY:
                    if(this.agility<=max-((factor)))
                        this.agility+=(factor);
                    else
                        this.agility =max;
                    break;
                case STRATEGY:
                    if(this.strategy<=max-((factor)))
                        this.strategy+=(factor);
                    else
                        this.strategy = max;
                    break;
            }
        }
        else
            changed = false;


        return changed;
    }

    public int getStat(Stats stat){
        return switch (stat) {
            case HUNGER -> this.hunger;
            case ENERGY-> this.energy;
            case CLEANLINESS-> this.cleanliness;
            case HAPPINESS -> this.happiness;
            case AGILITY -> this.agility;
            case STRATEGY -> this.strategy;
            default -> 0;
        };

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
        changeStat(Stats.HUNGER, reduceBy, Operator.SUBTRACT);
        changeStat(Stats.ENERGY, reduceBy, Operator.SUBTRACT);
        changeStat(Stats.CLEANLINESS, reduceBy, Operator.SUBTRACT);
        changeStat(Stats.HAPPINESS, reduceBy, Operator.SUBTRACT);
        this.lastCheckTime = currentTime;
        return elapsedTime;
    }

}
