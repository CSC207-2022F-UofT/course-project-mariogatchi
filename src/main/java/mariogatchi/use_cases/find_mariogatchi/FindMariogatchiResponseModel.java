package mariogatchi.use_cases.find_mariogatchi;

import mariogatchi.entities.Mariogatchi;

/**
 * FindMariogatchiResponseModel: the information the use case sends back to the controller
 */
public class FindMariogatchiResponseModel {
    private final Mariogatchi MARIOGATCHI;
    private final boolean catchTrigger;

    /**
     * Constructs a response model
     * @param mariogatchi the Mariogatchi to be presented to the user
     * @param catchTrigger boolean representing whether we are catching the Mariogatchi at hand
     */
    public FindMariogatchiResponseModel(Mariogatchi mariogatchi, boolean catchTrigger){
        this.MARIOGATCHI = mariogatchi;
        this.catchTrigger = catchTrigger;
    }

    /**
     * Returns the Mariogatchi the response model provides
     * @return the Mariogatchi the response model provides
     */
    public Mariogatchi getMariogatchi(){
        return MARIOGATCHI;
    }

    /**
     * Returns the catch trigger the response model provides
     * @return the catch trigger the response model provides
     */
    public boolean getCatchTrigger(){
        return catchTrigger;
    }
}
