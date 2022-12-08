package mariogatchi.use_cases.find_mariogatchi;

/**
 * FindMariogatchi Input Boundary: Interface for the findMariogatchi use case
 */
public interface FindMariogatchiInputBoundary {
    /**
     * Create a response model given a request model
     */
    FindMariogatchiResponseModel findMariogatchi(FindMariogatchiRequestModel mariogatchiRequestModel);
}
