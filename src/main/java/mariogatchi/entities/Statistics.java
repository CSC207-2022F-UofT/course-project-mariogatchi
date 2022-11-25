package mariogatchi.entities;

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
     * The starting level for common mariogatchi
     */
    private final int STARTING_LEVEL_COMMON = 50;

    /**
     * The starting level for rare mariogatchi
     */
    private final int STARTING_LEVEL_RARE= 75;
    
    
    public enum Operator{
         ADD,
         SUBTRACT
    }
    public enum Stats{
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
        int startingValue = STARTING_LEVEL_COMMON;
        if(mariogatchiKind.equals("rare")){
            startingValue = STARTING_LEVEL_RARE;
        }
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
                    if(this.hunger<= this.maxLevel-((factor)))
                        this.hunger+=(factor);
                    else
                        this.hunger = this.maxLevel;
                    break;
                case ENERGY:
                    if(this.energy<= this.maxLevel-((factor)))
                        this.energy+=(factor);
                    else
                        this.energy = this.maxLevel;
                    break;
                case CLEANLINESS:
                    if(this.cleanliness<= this.maxLevel -((factor)))
                        this.cleanliness+=(factor);
                    else
                        this.cleanliness = this.maxLevel;
                    break;
                case HAPPINESS:
                    if(this.happiness <= this.maxLevel - ((factor)))
                        this.happiness += (factor);
                    else
                        this.happiness = this.maxLevel;
                    break;
                case AGILITY:
                    if(this.agility<= this.maxLevel -((factor)))
                        this.agility+=(factor);
                    else
                        this.agility = this.maxLevel;
                    break;
                case STRATEGY:
                    if(this.strategy<= this.maxLevel -((factor)))
                        this.strategy+=(factor);
                    else
                        this.strategy = this.maxLevel;
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
