package mariogatchi;

import mariogatchi.removemariogatchi.RemoveMariogatchi;
import mariogatchi.removemariogatchi.killmariogatchi.KillMariogatchi;

/**
 * Prints the remove Mariogatchi action text to the console
 */
public class RemoveMariogatchiDisplayer extends RemoveMariogatchiPresenter {

    /**
     * Prints the kill action text to the console
     * @param Action the specified action for killing a Mariogatchi
     */
    public void KillMariogatchiTextDisplay(KillAction Action){
        System.out.println(getKillActionType(Action));
    }

    /**
     * Prints the transfer action text to the console
     * @param Action the specified action for transfering a Mariogatchi
     */
    public void TransferMariogatchiTextDisplay(TransferAction Action){
        System.out.println(getTransferActionType(Action));
    }
}
