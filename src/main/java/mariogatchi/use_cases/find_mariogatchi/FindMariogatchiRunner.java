package mariogatchi.use_cases.find_mariogatchi;

import mariogatchi.entities.Mariogatchi;

import java.util.Iterator;

/**
 * FindMariogatchiRunner: implements input boundary and iterates to next Mariogatchi if possible
 */
public class FindMariogatchiRunner implements FindMariogatchiInputBoundary {
    private final FindMariogatchiOutputBoundary MARIOGATCHI_OUTPUT_BOUNDARY;

    /**
     * Constructs a runner
     * @param mariogatchiOutputBoundary the output boundary the input boundary is connected to
     */
    public FindMariogatchiRunner(FindMariogatchiOutputBoundary mariogatchiOutputBoundary) {
        this.MARIOGATCHI_OUTPUT_BOUNDARY = mariogatchiOutputBoundary;
    }

    /**
     * Overrides response model creations
     * - If the user has no Mariogatchis, they are forced to get the first Mariogatchi they see. We do not iterate to
     *   the next Mariogatchi. The runner notifies the response model of the response model of the Mariogatchi we are
     *   catching and that we are catching it.
     * - If the user chooses not to catch the Mariogatchi at hand (and there is a Mariogatchi after that one), iterate
     *   to the next Mariogatchi and send this to the response model.
     * - If the user chooses not to catch the Mariogatchi at hand (and there is no Mariogatchi after that one), we
     *   set the next Mariogatchi to null and notify the user they are out of Mariogatchis to pick from. We do not
     *   iterate.
     * - If the user chooses to catch the Mariogatchi at hand, we do not iterate, we send the current Mariogatchi to the
     *   response model and notify it that we are catching it.
     */
    @Override
    public FindMariogatchiResponseModel findMariogatchi(FindMariogatchiRequestModel mariogatchiRequestModel) {
        Iterator<Mariogatchi> mariogatchiIterator = mariogatchiRequestModel.getGeneratedMariogatchis().iterator();
        if (!mariogatchiRequestModel.getDecision()){ // if the decision is false -> they don't want to catch the Mariogatchi
            if (mariogatchiRequestModel.getUser().getMariogatchis().size() == 0){
                Mariogatchi mariogatchi = mariogatchiIterator.next();
                FindMariogatchiResponseModel mariogatchiResponseModel = new FindMariogatchiResponseModel(mariogatchi, true);
                return MARIOGATCHI_OUTPUT_BOUNDARY.findMariogatchiPrepareFailureView
                        ("This Mariogatchi was added to your collection!", mariogatchiResponseModel);
            } else {
                if (mariogatchiIterator.hasNext()){
                    Mariogatchi mariogatchi = mariogatchiIterator.next();
                    FindMariogatchiResponseModel mariogatchiResponseModel = new FindMariogatchiResponseModel(mariogatchi, false);
                    return MARIOGATCHI_OUTPUT_BOUNDARY.findMariogatchiPrepareSuccessView(mariogatchiResponseModel);
                } else {
                    FindMariogatchiResponseModel mariogatchiResponseModel = new FindMariogatchiResponseModel(null, false);
                    return MARIOGATCHI_OUTPUT_BOUNDARY.findMariogatchiPrepareFailureView
                            ("There are no more Mariogatchis in the forest!", mariogatchiResponseModel);
                }
            }
        } else {
            Mariogatchi mariogatchi = mariogatchiRequestModel.getCurrMariogatchi();
            FindMariogatchiResponseModel mariogatchiResponseModel = new FindMariogatchiResponseModel(mariogatchi, true);
            return MARIOGATCHI_OUTPUT_BOUNDARY.findMariogatchiPrepareFailureView
                    ("This Mariogatchi was added to your collection!", mariogatchiResponseModel);
        }
    }
}

