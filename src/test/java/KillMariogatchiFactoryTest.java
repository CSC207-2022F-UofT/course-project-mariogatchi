import mariogatchi.*;
import mariogatchi.User;
import mariogatchi.removemariogatchi.factories.KillMariogatchiFactory;
import mariogatchi.removemariogatchi.factories.RemoveMariogatchiFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class KillMariogatchiFactoryTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    RemoveMariogatchiPresenterInterface presenter = new RemoveMariogatchiPresenter();
    RemoveMariogatchiDisplayerInterface displayer = new RemoveMariogatchiDisplayer();
    RemoveMariogatchiFactory killFactory = new KillMariogatchiFactory();
    User user = new User("Test User");
    Mariogatchi mariogatchi = new Mariogatchi();
    Mariogatchi mario = new Mariogatchi();
    MariogatchiManager manager = new MariogatchiManager();

    @BeforeEach
    public void setUp() {
        user.setMariogatchis(new ArrayList<>());
        manager.AddMariogatchi(user, mariogatchi);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void BlownAway_PrintToConsole() {
        killFactory.getAction("blown away").execute(user, mariogatchi, presenter, displayer);
        Assertions.assertEquals("Nature uses wind attack! Your Mariogatchi was blown away.", outputStreamCaptor.toString().trim());
    }

    @Test
    void BlownAwayError_PrintToConsole(){
        killFactory.getAction("blown away").execute(user, mario, presenter, displayer);
        Assertions.assertEquals("ErrorExecution, unkillable Mariogatchi (cannot kill Mariogatchi, check for wrong keyword or list size)", outputStreamCaptor.toString().trim());
    }

    @Test
    void Drown_PrintToConsole() {
        killFactory.getAction("drown").execute(user, mariogatchi, presenter, displayer);
        Assertions.assertEquals("Your Mariogatchi drowned in a puddle :(", outputStreamCaptor.toString().trim());
    }

    @Test
    void DrownError_PrintToConsole(){
        killFactory.getAction("drown").execute(user, mario, presenter, displayer);
        Assertions.assertEquals("ErrorExecution, unkillable Mariogatchi (cannot kill Mariogatchi, check for wrong keyword or list size)", outputStreamCaptor.toString().trim());
    }

    @Test
    void Illness_PrintToConsole() {
        killFactory.getAction("illness").execute(user, mariogatchi, presenter, displayer);
        Assertions.assertEquals("Your Mariogatchi is weak and did not wear a mask. Died from illness.", outputStreamCaptor.toString().trim());
    }

    @Test
    void IllnessError_PrintToConsole(){
        killFactory.getAction("illness").execute(user, mario, presenter, displayer);
        Assertions.assertEquals("ErrorExecution, unkillable Mariogatchi (cannot kill Mariogatchi, check for wrong keyword or list size)", outputStreamCaptor.toString().trim());
    }

    @Test
    void OldAge_PrintToConsole() {
        killFactory.getAction("old age").execute(user, mariogatchi, presenter, displayer);
        Assertions.assertEquals("Your Mariogatchi expired.", outputStreamCaptor.toString().trim());
    }

    @Test
    void OldAgeError_PrintToConsole(){
        killFactory.getAction("old age").execute(user, mario, presenter, displayer);
        Assertions.assertEquals("ErrorExecution, unkillable Mariogatchi (cannot kill Mariogatchi, check for wrong keyword or list size)", outputStreamCaptor.toString().trim());
    }

    @Test
    void Overcare_PrintToConsole() {
        killFactory.getAction("overcare").execute(user, mariogatchi, presenter, displayer);
        Assertions.assertEquals("Your Mariogatchi was given too much attention and died from execessive nutrients.", outputStreamCaptor.toString().trim());
    }

    @Test
    void OvercareError_PrintToConsole(){
        killFactory.getAction("overcare").execute(user, mario, presenter, displayer);
        Assertions.assertEquals("ErrorExecution, unkillable Mariogatchi (cannot kill Mariogatchi, check for wrong keyword or list size)", outputStreamCaptor.toString().trim());
    }

    @Test
    void Predators_PrintToConsole() {
        killFactory.getAction("predators").execute(user, mariogatchi, presenter, displayer);
        Assertions.assertEquals("Your Mariogatchi has merged with the predators, gone wrong. (Eaten).", outputStreamCaptor.toString().trim());
    }

    @Test
    void PredatorsError_PrintToConsole(){
        killFactory.getAction("predators").execute(user, mario, presenter, displayer);
        Assertions.assertEquals("ErrorExecution, unkillable Mariogatchi (cannot kill Mariogatchi, check for wrong keyword or list size)", outputStreamCaptor.toString().trim());
    }

    @Test
    void ProblemSet_PrintToConsole() {
        killFactory.getAction("problem set").execute(user, mariogatchi, presenter, displayer);
        Assertions.assertEquals("UofT uses Final Exam! It was super effective. Your Mariogatchi was crushed by a CS problem set", outputStreamCaptor.toString().trim());
    }

    @Test
    void ProblemSetError_PrintToConsole(){
        killFactory.getAction("problem set").execute(user, mario, presenter, displayer);
        Assertions.assertEquals("ErrorExecution, unkillable Mariogatchi (cannot kill Mariogatchi, check for wrong keyword or list size)", outputStreamCaptor.toString().trim());
    }

    @Test
    void Starvation_PrintToConsole() {
        killFactory.getAction("starvation").execute(user, mariogatchi, presenter, displayer);
        Assertions.assertEquals("Your Mariogatchi died by hunger damage.", outputStreamCaptor.toString().trim());
    }

    @Test
    void StarvationError_PrintToConsole(){
        killFactory.getAction("starvation").execute(user, mario, presenter, displayer);
        Assertions.assertEquals("ErrorExecution, unkillable Mariogatchi (cannot kill Mariogatchi, check for wrong keyword or list size)", outputStreamCaptor.toString().trim());
    }

    @Test
    void UFO_PrintToConsole() {
        killFactory.getAction("ufo abduction").execute(user, mariogatchi, presenter, displayer);
        Assertions.assertEquals("Your Mariogatchi was abducted by a UFO.", outputStreamCaptor.toString().trim());
    }

    @Test
    void UFOError_PrintToConsole(){
        killFactory.getAction("ufo abduction").execute(user, mario, presenter, displayer);
        Assertions.assertEquals("ErrorExecution, unkillable Mariogatchi (cannot kill Mariogatchi, check for wrong keyword or list size)", outputStreamCaptor.toString().trim());
    }

    @Test
    void Error_PrintToConsole() {
        killFactory.getAction("error").execute(user, mariogatchi, presenter, displayer);
        Assertions.assertEquals("ErrorExecution, unkillable Mariogatchi (cannot kill Mariogatchi, check for wrong keyword or list size)", outputStreamCaptor.toString().trim());
    }

    @Test
    void ErrorWrongMariogatchi_PrintToConsole() {
        killFactory.getAction("error").execute(user, mario, presenter, displayer);
        Assertions.assertEquals("ErrorExecution, unkillable Mariogatchi (cannot kill Mariogatchi, check for wrong keyword or list size)", outputStreamCaptor.toString().trim());
    }

    @Test
    void IllegalAction_PrintToConsole(){
        killFactory.getAction("shouldn't work").execute(user, mariogatchi, presenter, displayer);
        Assertions.assertEquals("ErrorExecution, unkillable Mariogatchi (cannot kill Mariogatchi, check for wrong keyword or list size)", outputStreamCaptor.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
