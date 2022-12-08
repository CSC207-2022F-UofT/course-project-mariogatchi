package mariogatchi.use_cases.info_access;

import mariogatchi.entities.Statistics;
import mariogatchi.entities.Statistics.Stats;
import mariogatchi.entities.User;

public class InfoAccessRequestModel {
    /**
     * Mariogatchi to access the stats before
     */
    private String mariogatchi;
    /**
     * The user
     */
    private User user;

    /**
     The input data needed for the InfoAccess use case
     @param mariogatchi - the stats to check
      */

    public InfoAccessRequestModel (String mariogatchi, User user) {
        this.mariogatchi = mariogatchi;
        this.user = user;
    }

    // return mariogatchi
    public String getMariogatchi() {
        return this.mariogatchi;
    }

    // return user
    public User getUser() {
        return this.user;
    }

}
