package mariogatchi.use_cases.time;
import mariogatchi.entities.Statistics;
public class TimeRequestModel {
    /**
     * The time right now
     */
    private int currentTime;
    /**
     * A mariogatchi's stats object
     */
    private Statistics stats;

    /**
     The input data needed for the Time use case
     @param time - current time
     @param stats - User's stats
      */

    public TimeRequestModel ( int time, Statistics stats) {
        this.currentTime = time;
        this.stats = stats;
    }

    // return time
    public int getTime() {
        return this.currentTime;
    }

    // return stats
    public Statistics getStats(){ return this.stats;}

}
