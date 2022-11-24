package mariogatchi.use_cases.manager.remove_mariogatchi;

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
                return "Nature uses wind attack! Your Mariogatchi was blown away.";
            case DROWN:
                return "Your Mariogatchi drowned in a puddle :(";
            case ILLNESS:
                return "Your Mariogatchi is weak and did not wear a mask. Died from illness.";
            case OLDAGE:
                return "Your Mariogatchi expired.";
            case OVERCARE:
                return "Your Mariogatchi was given too much attention and died from execessive nutrients.";
            case PREDATORS:
                return "Your Mariogatchi has merged with the predators, gone wrong. (Eaten).";
            case PROBLEMSET:
                return "UofT uses Final Exam! It was super effective. Your Mariogatchi was crushed by a CS problem set";
            case STARVATION:
                return "Your Mariogatchi died by hunger damage.";
            case UFOABDUCTION:
                return "Your Mariogatchi was abducted by a UFO.";
            case ERROR:
                return "ErrorExecution, unkillable Mariogatchi (cannot kill Mariogatchi, check for wrong keyword or list size)";
            default:
                return null;
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
            case ERROR:
                return "Mariogatchi uses sticky! Status: Undetachable :( (Mariogatchi cannot be transfered, check for wrong keyword or list size)";
            default:
                return null;
        }
    }
}
