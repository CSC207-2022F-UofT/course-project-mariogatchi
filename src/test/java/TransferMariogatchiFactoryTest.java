import mariogatchi.*;
import mariogatchi.User;
import mariogatchi.removemariogatchi.factories.RemoveMariogatchiFactory;
import mariogatchi.removemariogatchi.factories.TransferMariogatchiFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class TransferMariogatchiFactoryTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    RemoveMariogatchiPresenterInterface presenter = new RemoveMariogatchiPresenter();
    RemoveMariogatchiDisplayerInterface displayer = new RemoveMariogatchiDisplayer();
    RemoveMariogatchiFactory transferFactory = new TransferMariogatchiFactory();
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
    void Release_PrintToConsole() {
        transferFactory.getAction("release").execute(user, mariogatchi, presenter, displayer);
        Assertions.assertEquals("You successfully released your Mariogatchi into the wild. Good bye Mariogatchi!", outputStreamCaptor.toString().trim());
    }

    @Test
    void ReleaseError_PrintToConsole() {
        transferFactory.getAction("release").execute(user, mario, presenter, displayer);
        Assertions.assertEquals("Mariogatchi uses sticky! Status: Undetachable :( (Mariogatchi cannot be transfered, check for wrong keyword or list size)", outputStreamCaptor.toString().trim());
    }

    @Test
    void Drown_PrintToConsole() {
        transferFactory.getAction("merge").execute(user, mariogatchi, presenter, displayer);
        Assertions.assertEquals("You successfully merged two Mariogatchis together. The Mariogatchi was given updates in stats!", outputStreamCaptor.toString().trim());
    }

    @Test
    void DrownError_PrintToConsole() {
        transferFactory.getAction("merge").execute(user, mario, presenter, displayer);
        Assertions.assertEquals("Mariogatchi uses sticky! Status: Undetachable :( (Mariogatchi cannot be transfered, check for wrong keyword or list size)", outputStreamCaptor.toString().trim());
    }

    @Test
    void Error_PrintToConsole() {
        transferFactory.getAction("error").execute(user, mariogatchi, presenter, displayer);
        Assertions.assertEquals("Mariogatchi uses sticky! Status: Undetachable :( (Mariogatchi cannot be transfered, check for wrong keyword or list size)", outputStreamCaptor.toString().trim());
    }

    @Test
    void ErrorWrongMariogatchi_PrintToConsole() {
        transferFactory.getAction("error").execute(user, mario, presenter, displayer);
        Assertions.assertEquals("Mariogatchi uses sticky! Status: Undetachable :( (Mariogatchi cannot be transfered, check for wrong keyword or list size)", outputStreamCaptor.toString().trim());
    }

    @Test
    void IllegalAction_PrintToConsole() {
        transferFactory.getAction("shouldn't work").execute(user, mariogatchi, presenter, displayer);
        Assertions.assertEquals("Mariogatchi uses sticky! Status: Undetachable :( (Mariogatchi cannot be transfered, check for wrong keyword or list size)", outputStreamCaptor.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
