package mariogatchi.use_cases.info_access;

import mariogatchi.entities.Statistics;

public class InfoAccessResponseModel {
    /**
     * The statistics object
     */
    private Statistics stats;

    /**
     The Response Model (output data) for the InfoAccess Use Case
     @param stats - The statistics object
      */

    public InfoAccessResponseModel(Statistics stats) {
        this.stats = stats;
    }

    public Statistics getStats(){
        return this.stats;
    }
}
