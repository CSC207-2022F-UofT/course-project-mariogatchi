package mariogatchi.use_cases.manager.remove_mariogatchi.factories;

import mariogatchi.use_cases.manager.remove_mariogatchi.RemoveMariogatchi;

/**
 * Use case
 * Abstract factory interface for a method to transfer or kill a Mariogatchi
 */
public interface RemoveMariogatchiFactory {
    /**
     * @param action inputs a type of Action
     */
    RemoveMariogatchi getAction(String action);
}
