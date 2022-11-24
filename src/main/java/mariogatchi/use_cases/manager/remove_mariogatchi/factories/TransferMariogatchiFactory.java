package mariogatchi.use_cases.manager.remove_mariogatchi.factories;


import mariogatchi.use_cases.manager.remove_mariogatchi.transfermariogatchi.ErrorExecution;
import mariogatchi.use_cases.manager.remove_mariogatchi.transfermariogatchi.Merge;
import mariogatchi.use_cases.manager.remove_mariogatchi.transfermariogatchi.Release;
import mariogatchi.use_cases.manager.remove_mariogatchi.transfermariogatchi.TransferMariogatchi;

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
