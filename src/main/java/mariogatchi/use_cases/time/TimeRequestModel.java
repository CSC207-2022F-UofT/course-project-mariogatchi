package mariogatchi.use_cases.time;
import mariogatchi.entities.Statistics;
import mariogatchi.entities.User;

public class TimeRequestModel {
    /**
     * The time right now
     */
    private long currentTime;
    /**
     * A mariogatchi's stats object
     */
    private User user;

    /**
     The input data needed for the Time use case
     @param time - current time
     @param user - User
      */

    public TimeRequestModel (long time, User user) {
        this.currentTime = time;
        this.user = user;
    }

    // return time
    public long getTime() {
        return this.currentTime;
    }

    // return stats
    public User getUser(){ return this.user;}

}
