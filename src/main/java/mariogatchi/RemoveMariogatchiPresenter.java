package mariogatchi;

/**
 * Presenter
 * All responses for removing a Mariogatchi
 */
public class RemoveMariogatchiPresenter implements RemoveMariogatchiPresenterInterface {

    /**
     * @param type kill action
     * @return the message for Mariogatchi death specified by the type
     */
    @Override
    public String getKillActionType(KillAction type) {
        switch(type) {
            case BLOWNAWAY:
                return "Your Mariogatchi was blown away by a gust of wind.";
            case DROWN:
                return "Your Mariogatchi drowned in a pool of water :(";
            case ILLNESS:
                return "Your Mariogatchi was too ill and died from sickness.";
            case OLDAGE:
                return "Your Mariogatchi lived a good life and passed away from old age.";
            case OVERCARE:
                return "Your Mariogatchi was given too much attention and died from execessive nutrients.";
            case PREDATORS:
                return "Your Mariogatchi was killed by wild animals.";
            case PROBLEMSET:
                return "Your Mariogatchi was crushed by a CS problem set";
            case STARVATION:
                return "Your Mariogatchi died by starvation.";
            case UFOABDUCTION:
                return "Your Mariogatchi was abducted by a UFO.";
            default:
                return "Error, invalid" + type;
        }
    }

    /**
     * @param type transfer action
     * @return the message for Mariogatchi transfer specified by the type
     */
    @Override
    public String getTransferActionType(TransferAction type) {
        switch(type){
            case RELEASE:
                return "You successfully released your Mariogatchi into the wild. Good bye Mariogatchi!";
            case MERGE:
                return "You successfully merged two Mariogatchis together. The Mariogatchi was given updates in stats!";
            default:
                return "Error, invalid" + type;
        }
    }
}
