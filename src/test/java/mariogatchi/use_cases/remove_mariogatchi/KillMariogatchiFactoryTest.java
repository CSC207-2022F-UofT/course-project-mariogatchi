package mariogatchi.use_cases.remove_mariogatchi;

import mariogatchi.entities.Mariogatchi;
import mariogatchi.entities.User;
import mariogatchi.use_cases.manager.MariogatchiManager;
import mariogatchi.use_cases.remove_mariogatchi.factories.KillMariogatchiFactory;
import mariogatchi.use_cases.remove_mariogatchi.factories.RemoveMariogatchiFactory;
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
    User mariogatchiless = new User("No Mariogatchis");
    Mariogatchi mariogatchi = new Mariogatchi(10, "Nishigatchi", null, "Rare");
    Mariogatchi mario = new Mariogatchi(10, "Nicolegatchi", null, "Rare");
    MariogatchiManager manager = new MariogatchiManager();

    /**
     * Before each test, we set up the following code.
     */
    @BeforeEach
    public void setUp() {
        mariogatchiless.setMariogatchis(new ArrayList<>());
        user.setMariogatchis(new ArrayList<>());
        manager.AddMariogatchi(user, mariogatchi);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    /**
     * Blown Away action, outputs to console the correct statement
     */
    @Test
    void BlownAway_PrintToConsole() {
        killFactory.getAction("blown away").execute(user, mariogatchi, presenter, displayer);
        Assertions.assertEquals("Nature uses wind attack! Your Mariogatchi was blown away.", outputStreamCaptor.toString().trim());
    }

    /**
     * Blown Away action, outputs to console the error statement if factory cannot kill the correct Mariogatchi
     */
    @Test
    void BlownAwayError_PrintToConsole(){
        killFactory.getAction("blown away").execute(user, mario, presenter, displayer);
        Assertions.assertEquals("ErrorExecution, unkillable Mariogatchi (cannot kill Mariogatchi, check for wrong keyword or list size)", outputStreamCaptor.toString().trim());
    }

    /**
     * Blown Away action, outputs to console the error statement if user has no Mariogatchis
     */
    @Test
    void BlownAwayErrorNoMariogatchi_PrintToConsole(){
        killFactory.getAction("blown away").execute(mariogatchiless, mario, presenter, displayer);
        Assertions.assertEquals("ErrorExecution, unkillable Mariogatchi (cannot kill Mariogatchi, check for wrong keyword or list size)", outputStreamCaptor.toString().trim());
    }

    /**
     * Drown action, outputs to console the correct statement
     */
    @Test
    void Drown_PrintToConsole() {
        killFactory.getAction("drown").execute(user, mariogatchi, presenter, displayer);
        Assertions.assertEquals("Your Mariogatchi drowned in a puddle :(", outputStreamCaptor.toString().trim());
    }

    /**
     * Drown action, outputs to console the error statement if factory cannot kill the correct Mariogatchi
     */
    @Test
    void DrownError_PrintToConsole(){
        killFactory.getAction("drown").execute(user, mario, presenter, displayer);
        Assertions.assertEquals("ErrorExecution, unkillable Mariogatchi (cannot kill Mariogatchi, check for wrong keyword or list size)", outputStreamCaptor.toString().trim());
    }

    /**
     * Drown action, outputs to console the error statement if user has no Mariogatchis
     */
    @Test
    void DrownErrorNoMariogatchi_PrintToConsole(){
        killFactory.getAction("drown").execute(mariogatchiless, mario, presenter, displayer);
        Assertions.assertEquals("ErrorExecution, unkillable Mariogatchi (cannot kill Mariogatchi, check for wrong keyword or list size)", outputStreamCaptor.toString().trim());
    }

    /**
     * Illness action, outputs to console the correct statement
     */
    @Test
    void Illness_PrintToConsole() {
        killFactory.getAction("illness").execute(user, mariogatchi, presenter, displayer);
        Assertions.assertEquals("Your Mariogatchi is weak and did not wear a mask. Died from illness.", outputStreamCaptor.toString().trim());
    }

    /**
     * Illness action, outputs to console the error statement if factory cannot kill the correct Mariogatchi
     */
    @Test
    void IllnessError_PrintToConsole(){
        killFactory.getAction("illness").execute(user, mario, presenter, displayer);
        Assertions.assertEquals("ErrorExecution, unkillable Mariogatchi (cannot kill Mariogatchi, check for wrong keyword or list size)", outputStreamCaptor.toString().trim());
    }

    /**
     * Illness action, outputs to console the error statement if user has no Mariogatchis
     */
    @Test
    void IllnessNoMariogatchi_PrintToConsole(){
        killFactory.getAction("illness").execute(mariogatchiless, mario, presenter, displayer);
        Assertions.assertEquals("ErrorExecution, unkillable Mariogatchi (cannot kill Mariogatchi, check for wrong keyword or list size)", outputStreamCaptor.toString().trim());
    }

    /**
     * Old Age action, outputs to console the correct statement
     */
    @Test
    void OldAge_PrintToConsole() {
        killFactory.getAction("old age").execute(user, mariogatchi, presenter, displayer);
        Assertions.assertEquals("Your Mariogatchi expired.", outputStreamCaptor.toString().trim());
    }

    /**
     * Old Age action, outputs to console the error statement if factory cannot kill the correct Mariogatchi
     */
    @Test
    void OldAgeError_PrintToConsole(){
        killFactory.getAction("old age").execute(user, mario, presenter, displayer);
        Assertions.assertEquals("ErrorExecution, unkillable Mariogatchi (cannot kill Mariogatchi, check for wrong keyword or list size)", outputStreamCaptor.toString().trim());
    }

    /**
     * Old Age action, outputs to console the error statement if user has no Mariogatchis
     */
    @Test
    void OldAgeNoMariogatchi_PrintToConsole(){
        killFactory.getAction("old age").execute(mariogatchiless, mario, presenter, displayer);
        Assertions.assertEquals("ErrorExecution, unkillable Mariogatchi (cannot kill Mariogatchi, check for wrong keyword or list size)", outputStreamCaptor.toString().trim());
    }

    /**
     * Overcare action, outputs to console the correct statement
     */
    @Test
    void Overcare_PrintToConsole() {
        killFactory.getAction("overcare").execute(user, mariogatchi, presenter, displayer);
        Assertions.assertEquals("Your Mariogatchi was given too much attention and died from execessive nutrients.", outputStreamCaptor.toString().trim());
    }

    /**
     * Overcare action, outputs to console the error statement if factory cannot kill the correct Mariogatchi
     */
    @Test
    void OvercareError_PrintToConsole(){
        killFactory.getAction("overcare").execute(user, mario, presenter, displayer);
        Assertions.assertEquals("ErrorExecution, unkillable Mariogatchi (cannot kill Mariogatchi, check for wrong keyword or list size)", outputStreamCaptor.toString().trim());
    }

    /**
     * Overcare action, outputs to console the error statement if user has no Mariogatchis
     */
    @Test
    void OvercareNoMariogatchi_PrintToConsole(){
        killFactory.getAction("overcare").execute(mariogatchiless, mario, presenter, displayer);
        Assertions.assertEquals("ErrorExecution, unkillable Mariogatchi (cannot kill Mariogatchi, check for wrong keyword or list size)", outputStreamCaptor.toString().trim());
    }

    /**
     * Predators action, outputs to console the correct statement
     */
    @Test
    void Predators_PrintToConsole() {
        killFactory.getAction("predators").execute(user, mariogatchi, presenter, displayer);
        Assertions.assertEquals("Your Mariogatchi has merged with the predators, gone wrong. (Eaten).", outputStreamCaptor.toString().trim());
    }

    /**
     * Predators action, outputs to console the error statement if factory cannot kill the correct Mariogatchi
     */
    @Test
    void PredatorsError_PrintToConsole(){
        killFactory.getAction("predators").execute(user, mario, presenter, displayer);
        Assertions.assertEquals("ErrorExecution, unkillable Mariogatchi (cannot kill Mariogatchi, check for wrong keyword or list size)", outputStreamCaptor.toString().trim());
    }

    /**
     * Predators action, outputs to console the error statement if user has no Mariogatchis
     */
    @Test
    void PredatorsNoMariogatchi_PrintToConsole(){
        killFactory.getAction("predators").execute(mariogatchiless, mario, presenter, displayer);
        Assertions.assertEquals("ErrorExecution, unkillable Mariogatchi (cannot kill Mariogatchi, check for wrong keyword or list size)", outputStreamCaptor.toString().trim());
    }

    /**
     * Problem Set action, outputs to console the correct statement
     */
    @Test
    void ProblemSet_PrintToConsole() {
        killFactory.getAction("problem set").execute(user, mariogatchi, presenter, displayer);
        Assertions.assertEquals("UofT uses Final Exam! It was super effective. Your Mariogatchi was crushed by a CS problem set", outputStreamCaptor.toString().trim());
    }

    /**
     * Problem Set action, outputs to console the error statement if factory cannot kill the correct Mariogatchi
     */
    @Test
    void ProblemSetError_PrintToConsole(){
        killFactory.getAction("problem set").execute(user, mario, presenter, displayer);
        Assertions.assertEquals("ErrorExecution, unkillable Mariogatchi (cannot kill Mariogatchi, check for wrong keyword or list size)", outputStreamCaptor.toString().trim());
    }

    /**
     * Problem Set action, outputs to console the error statement if user has no Mariogatchis
     */
    @Test
    void ProblemSetNoMariogatchi_PrintToConsole(){
        killFactory.getAction("problem set").execute(mariogatchiless, mario, presenter, displayer);
        Assertions.assertEquals("ErrorExecution, unkillable Mariogatchi (cannot kill Mariogatchi, check for wrong keyword or list size)", outputStreamCaptor.toString().trim());
    }

    /**
     * Starvation action, outputs to console the correct statement
     */
    @Test
    void Starvation_PrintToConsole() {
        killFactory.getAction("starvation").execute(user, mariogatchi, presenter, displayer);
        Assertions.assertEquals("Your Mariogatchi died by hunger damage.", outputStreamCaptor.toString().trim());
    }

    /**
     * Starvation action, outputs to console the error statement if factory cannot kill the correct Mariogatchi
     */
    @Test
    void StarvationError_PrintToConsole(){
        killFactory.getAction("starvation").execute(user, mario, presenter, displayer);
        Assertions.assertEquals("ErrorExecution, unkillable Mariogatchi (cannot kill Mariogatchi, check for wrong keyword or list size)", outputStreamCaptor.toString().trim());
    }

    /**
     * Starvation action, outputs to console the error statement if user has no Mariogatchis
     */
    @Test
    void StarvationNoMariogatchi_PrintToConsole(){
        killFactory.getAction("starvation").execute(mariogatchiless, mario, presenter, displayer);
        Assertions.assertEquals("ErrorExecution, unkillable Mariogatchi (cannot kill Mariogatchi, check for wrong keyword or list size)", outputStreamCaptor.toString().trim());
    }

    /**
     * UFO Abduction action, outputs to console the correct statement
     */
    @Test
    void UFO_PrintToConsole() {
        killFactory.getAction("ufo abduction").execute(user, mariogatchi, presenter, displayer);
        Assertions.assertEquals("Your Mariogatchi was abducted by a UFO.", outputStreamCaptor.toString().trim());
    }

    /**
     * UFO Abduction action, outputs to console the error statement if factory cannot kill the correct Mariogatchi
     */
    @Test
    void UFOError_PrintToConsole(){
        killFactory.getAction("ufo abduction").execute(user, mario, presenter, displayer);
        Assertions.assertEquals("ErrorExecution, unkillable Mariogatchi (cannot kill Mariogatchi, check for wrong keyword or list size)", outputStreamCaptor.toString().trim());
    }

    /**
     * UFO Abduction action, outputs to console the error statement if user has no Mariogatchis
     */
    @Test
    void UFONoMariogatchi_PrintToConsole(){
        killFactory.getAction("ufo abduction").execute(mariogatchiless, mario, presenter, displayer);
        Assertions.assertEquals("ErrorExecution, unkillable Mariogatchi (cannot kill Mariogatchi, check for wrong keyword or list size)", outputStreamCaptor.toString().trim());
    }

    /**
     * Error to action input, outputs to console the correct statement (error statement)
     */
    @Test
    void Error_PrintToConsole() {
        killFactory.getAction("error").execute(user, mariogatchi, presenter, displayer);
        Assertions.assertEquals("ErrorExecution, unkillable Mariogatchi (cannot kill Mariogatchi, check for wrong keyword or list size)", outputStreamCaptor.toString().trim());
    }

    /**
     * Error to action input, outputs to console the error statement if factory cannot kill the correct Mariogatchi
     */
    @Test
    void ErrorWrongMariogatchi_PrintToConsole() {
        killFactory.getAction("error").execute(user, mario, presenter, displayer);
        Assertions.assertEquals("ErrorExecution, unkillable Mariogatchi (cannot kill Mariogatchi, check for wrong keyword or list size)", outputStreamCaptor.toString().trim());
    }

    /**
     * Error to action input, outputs to console the error statement if user has no Mariogatchis
     */
    @Test
    void ErrorNoMariogatchi_PrintToConsole() {
        killFactory.getAction("error").execute(user, mariogatchi, presenter, displayer);
        Assertions.assertEquals("ErrorExecution, unkillable Mariogatchi (cannot kill Mariogatchi, check for wrong keyword or list size)", outputStreamCaptor.toString().trim());
    }

    /**
     * Invalid action input, outputs to console the error statement
     */
    @Test
    void IllegalAction_PrintToConsole(){
        killFactory.getAction("shouldn't work").execute(user, mariogatchi, presenter, displayer);
        Assertions.assertEquals("ErrorExecution, unkillable Mariogatchi (cannot kill Mariogatchi, check for wrong keyword or list size)", outputStreamCaptor.toString().trim());
    }

    /**
     * Since output stream shared static resource with rest of the system
     * we must return it to original state after termination of all tests in this file
     */
    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
