package mariogatchi.use_cases.find_mariogatchi;

/**
 * FindMariogatchi Output Boundary: Interface for the findMariogatchi use case
 */
public interface FindMariogatchiOutputBoundary {
    /**
     * findMariogatchiPrepareSuccessView: we have successfully moved on to the next mariogatchi in the iteration
     */
    FindMariogatchiResponseModel findMariogatchiPrepareSuccessView(FindMariogatchiResponseModel findMariogatchiResponseModel);
    /**
     * findMariogatchiPrepareFailureView: we have not moved onto the next mariogatchi because we either reached the end
     *  of the iteration or we added the Mariogatchi to the users inventory
     */
    FindMariogatchiResponseModel findMariogatchiPrepareFailureView(String errorMessage, FindMariogatchiResponseModel findMariogatchiResponseModel);
}
