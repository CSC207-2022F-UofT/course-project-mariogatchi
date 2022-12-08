package mariogatchi.use_cases.playdate;

import mariogatchi.entities.Mariogatchi;

public class PlaydateRequestModel {
    /**
     * The friend to send the request/acceptance to
     */
    private String friendCode;
    /**
     * The mariogatchi to send to the playdate
     */
    private Mariogatchi mariogatchi;
    /**
     * User's own username
     */
    private String username;

    /**
     The input data needed for the Playdate use case
     @param friend - the stats to check
     @param mariogatchi - the name of the statistic to check
      */

    public PlaydateRequestModel(String friend, Mariogatchi mariogatchi, String username) {
        this.friendCode = friend;
        this.mariogatchi = mariogatchi;
        this.username = username;
    }

    // return friendCode
    public String getFriendCode() {
        return this.friendCode;
    }

    // return mariogatchi
    public Mariogatchi getMariogatchi() {
        return this.mariogatchi;
    }

    // return username
    public String getUsername() {
        return username;
    }
}
