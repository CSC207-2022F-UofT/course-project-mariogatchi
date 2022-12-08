package mariogatchi.use_cases.remove_mariogatchi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RemoveMariogatchiPresenterTest{
    /**
     * Checks if the RemoveMariogatchiPresenter will return the correct String
     */
    RemoveMariogatchiPresenter presenter = new RemoveMariogatchiPresenter();

    @Test
    public void BlownAway(){
        String actualOutput = presenter.getKillActionType(RemoveMariogatchiPresenterInterface.KillAction.BLOWNAWAY);
        Assertions.assertEquals("Nature uses wind attack! Your Mariogatchi was blown away.", actualOutput);
    }

    @Test
    public void Drown(){
        String actualOutput = presenter.getKillActionType(RemoveMariogatchiPresenterInterface.KillAction.DROWN);
        Assertions.assertEquals("Your Mariogatchi drowned in a puddle :(", actualOutput);
    }

    @Test
    public void Illess(){
        String actualOutput = presenter.getKillActionType(RemoveMariogatchiPresenterInterface.KillAction.ILLNESS);
        Assertions.assertEquals("Your Mariogatchi is weak and did not wear a mask. Died from illness.", actualOutput);
    }
    @Test
    public void OldAge(){
        String actualOutput = presenter.getKillActionType(RemoveMariogatchiPresenterInterface.KillAction.OLDAGE);
        Assertions.assertEquals("Your Mariogatchi expired.", actualOutput);
    }
    @Test
    public void Overcare(){
        String actualOutput = presenter.getKillActionType(RemoveMariogatchiPresenterInterface.KillAction.OVERCARE);
        Assertions.assertEquals("Your Mariogatchi was given too much attention and died from execessive nutrients.", actualOutput);
    }
    @Test
    public void Predators(){
        String actualOutput = presenter.getKillActionType(RemoveMariogatchiPresenterInterface.KillAction.PREDATORS);
        Assertions.assertEquals("Your Mariogatchi has merged with the predators, gone wrong. (Eaten).", actualOutput);
    }
    @Test
    public void ProblemSet(){
        String actualOutput = presenter.getKillActionType(RemoveMariogatchiPresenterInterface.KillAction.PROBLEMSET);
        Assertions.assertEquals("UofT uses Final Exam! It was super effective. Your Mariogatchi was crushed by a CS problem set", actualOutput);
    }
    @Test
    public void Starvation(){
        String actualOutput = presenter.getKillActionType(RemoveMariogatchiPresenterInterface.KillAction.STARVATION);
        Assertions.assertEquals("Your Mariogatchi died by hunger damage.", actualOutput);
    }
    @Test
    public void UFOAbduction(){
        String actualOutput = presenter.getKillActionType(RemoveMariogatchiPresenterInterface.KillAction.UFOABDUCTION);
        Assertions.assertEquals("Your Mariogatchi was abducted by a UFO.", actualOutput);
    }
    @Test
    public void Error() {
        String actualOutput = presenter.getKillActionType(RemoveMariogatchiPresenterInterface.KillAction.ERROR);
        Assertions.assertEquals("ErrorExecution, unkillable Mariogatchi (cannot kill Mariogatchi, check for wrong keyword or list size)", actualOutput);
    }
    @Test
    public void Release() {
        String actualOutput = presenter.getTransferActionType(RemoveMariogatchiPresenterInterface.TransferAction.RELEASE);
        Assertions.assertEquals("You successfully released your Mariogatchi into the wild. Good bye Mariogatchi!", actualOutput);
    }
    @Test
    public void Merge() {
        String actualOutput = presenter.getTransferActionType(RemoveMariogatchiPresenterInterface.TransferAction.MERGE);
        Assertions.assertEquals("You successfully merged two Mariogatchis together. The Mariogatchi was given updates in stats!", actualOutput);
    }
    @Test
    public void TransferError() {
        String actualOutput = presenter.getTransferActionType(RemoveMariogatchiPresenterInterface.TransferAction.ERROR);
        Assertions.assertEquals("Mariogatchi uses sticky! Status: Undetachable :( (Mariogatchi cannot be transfered, check for wrong keyword or list size)", actualOutput);
    }

}
