package Mariogatchi;

import mariogatchi.Statistics;

public class InfoAccessRequestModel {
    /**
     * Stats object this request is about
     */
    private Statistics stats;
    /**
     * Specific stat to check
     */
    private String statToCheck;

    /**
     The input data needed for the InfoAccess use case
     @param stats - the stats to check
     @param statsName - the name of the statistic to check
      */

    public InfoAccessRequestModel (Statistics stats, String statName) {
        this.stats = stats;
        this.statToCheck = statName;
    }

    // return stats
    public Statistics getStats() {
        return this.stats;
    }

    // return statToCheck
    public String getStatToCheck() {
        return this.statToCheck;
    }

}
