package mariogatchi.use_cases.remove_mariogatchi;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class RemoveMariogatchiDisplayerTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    RemoveMariogatchiDisplayer displayer = new RemoveMariogatchiDisplayer();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void RemoveMariogatchiDisplayer_printTexttoConsole() {
        displayer.removeMariogatchiText("Hello");
        Assertions.assertEquals("Hello", outputStreamCaptor.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
