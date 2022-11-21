package mariogatchi;

/**
 * Input boundary
 * All actions for removing a Mariogatchi
 */
public interface RemoveMariogatchiPresenterInterface {
    String getKillActionType(KillAction type);
    String getTransferActionType(TransferAction type);

    /**
     * The types of kill actions for a Mariogatchi entity
     */
    enum KillAction {
        BLOWNAWAY,
        DROWN,
        ILLNESS,
        OLDAGE,
        OVERCARE,
        PREDATORS,
        PROBLEMSET,
        STARVATION,
        UFOABDUCTION,
        ERROR
    }

    /**
     * The types of transfer actions for a Mariogatchi entity
     */
    enum TransferAction{
        RELEASE,
        MERGE,
        ERROR
    }
}
