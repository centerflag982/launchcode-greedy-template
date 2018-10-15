import com.centerflag982.launchcode.changeCalculator.UserInterface;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserInterfaceTest {

    @Test
    public void badInputThrowsException() {
        UserInterface userInterface = new UserInterface();

        boolean testResult = userInterface.validateChangeAmount("$752.0)");

        assertFalse(testResult);
    }

    @Test
    public void goodInputPassesTest() {
        UserInterface userInterface = new UserInterface();

        boolean testResult = userInterface.validateChangeAmount("€30.15");

        assertTrue(testResult);
    }

    @Test
    public void inputProperlyTaken() {
        UserInterface userInterface = new UserInterface();

        String testInput = "$3.60";
        InputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        String testAmount = userInterface.getChangeAmount();

        assertEquals("$3.60", testAmount);
    }

}
