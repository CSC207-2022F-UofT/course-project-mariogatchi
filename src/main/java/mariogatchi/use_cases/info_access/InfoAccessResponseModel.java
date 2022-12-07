package mariogatchi.use_cases.info_access;

import mariogatchi.entities.Statistics.Stats;

public class InfoAccessResponseModel {
    /**
     * What stat this response is about
     */
    private Stats statType;
    /**
     * The current value of that stat
     */
    private int currentValue;

    /**
     The Response Model (output data) for the InfoAccess Use Case
     @param type - The type of stat we're returning info for
     @param value - the value of that stat
      */

    public InfoAccessResponseModel(Stats type, int value) {
        this.statType = type;
        this.currentValue = value;
    }

    public Stats getStatType(){
        return this.statType;
    }

    public int getCurrentValue(){
        return this.currentValue;
    }
}
