package mariogatchi.use_cases.info_access;

import mariogatchi.entities.Statistics;
import mariogatchi.entities.Statistics.Stats;

public class InfoAccessRequestModel {
    /**
     * Stats object this request is about
     */
    private Statistics stats;
    /**
     * Specific stat to check
     */
    private Stats statToCheck;

    /**
     The input data needed for the InfoAccess use case
     @param stats - the stats to check
     @param statsName - the name of the statistic to check
      */

    public InfoAccessRequestModel (Statistics stats, String statName) {
        this.stats = stats;
        this.statToCheck = Stats.valueOf("statName");

    }

    // return stats
    public Statistics getStats() {
        return this.stats;
    }

    // return statToCheck
    public Stats getStatToCheck() {
        return this.statToCheck;
    }



}
