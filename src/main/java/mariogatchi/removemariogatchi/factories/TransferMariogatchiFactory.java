package mariogatchi.removemariogatchi.factories;


import mariogatchi.removemariogatchi.transfermariogatchi.ErrorExecution;
import mariogatchi.removemariogatchi.transfermariogatchi.Merge;
import mariogatchi.removemariogatchi.transfermariogatchi.Release;
import mariogatchi.removemariogatchi.transfermariogatchi.TransferMariogatchi;

/**
 * Use case
 * Concrete factory for cases to transfer a Mariogatchi
 */
public class TransferMariogatchiFactory implements RemoveMariogatchiFactory {

    /**
     * uses getAction method to get the specified use case to transfer a Mariogatchi
     *
     * @param Action inputs a transfer action
     * @return use case for the specified action, otherwise return null if the action cannot be specified
     */
    public TransferMariogatchi getAction(String Action) {
        switch (Action) {
            case "release":
                return new Release();
            case "merge":
                return new Merge();

            default:
                return new ErrorExecution();
        }
    }
}