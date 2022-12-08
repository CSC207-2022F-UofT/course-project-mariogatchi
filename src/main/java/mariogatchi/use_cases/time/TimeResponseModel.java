package mariogatchi.use_cases.time;
import mariogatchi.entities.Statistics;
public class TimeResponseModel {
    /**
     * The time that had passed
     */
    private long timeDifference;

    /**
     The Response Model (output data) for the Time Use Case
     @param timeDiff - How much time had elapsed
     */

    public TimeResponseModel(long timeDiff) {
        this.timeDifference = timeDiff;
    }

    public long getTimeDifference(){
        return this.timeDifference;
    }
}
