package Mariogatchi;

public class InfoAccessResponseModel {
    /**
     * What stat this response is about
     */
    private String statType;
    /**
     * The current value of that stat
     */
    private int currentValue;

    /**
     The Response Model (output data) for the InfoAccess Use Case
     @param type - The type of stat we're returning info for
     @param value - the value of that stat
      */

    public InfoAccessResponseModel(String type, int value) {
        this.statType = type;
        this.currentValue = value;
    }

    public String getStatType(){
        return this.statType;
    }

    public int getCurrentValue(){
        return this.currentValue;
    }
}
