package Mariogatchi;

public class TimeResponseModel {
    /**
     * The new stats object (with decremented values)
     */
    private Statistics newStats;

    /**
     * The time that had passed
     */
    private long timeDifference;

    /**
     The Response Model (output data) for the Time Use Case
     @param stats - The stats object after changes due to time elapsed
     @param timeDiff - How much time had elapsed
     */

    public TimeResponseModel(Statistics stats, long timeDiff) {
        this.newStats = stats;
        this.timeDifference = timeDiff;
    }

    public Statistics getStats(){
        return this.newStats;
    }

    public long getTimeDifference(){
        return this.timeDifference;
    }
}
