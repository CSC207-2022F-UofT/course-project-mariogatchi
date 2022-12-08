package mariogatchi.use_cases.playdate;

import mariogatchi.entities.Mariogatchi;

public class PlaydateResponseModel {
    /**
     * Whether the playdate request/acceptance was successful
     */
    private boolean successful;
    /**
     * String representation of what happened
     */
    private String result;
    /**
     * The mariogatchi involved in the playdate
     */
    private String mariogatchi;

    /**
     The Response Model (output data) for the Playdate Use Case
     @param success - Success flag
     @param result - String description of result
     @param mariogatchi - Mariogatchi from other user, could be null
      */

    public PlaydateResponseModel(boolean success, String result, String mariogatchi) {
        this.successful = success;
        this.result = result;
        this.mariogatchi = mariogatchi;
    }

    public boolean getSuccessful(){
        return this.successful;
    }

    public String getResult(){
        return this.result;
    }

    public String getMariogatchi(){return this.mariogatchi; }
}
