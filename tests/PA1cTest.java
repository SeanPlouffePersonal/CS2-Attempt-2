import org.junit.Test;
import static org.junit.Assert.*;
import java.io.*;

public class PA1cTest {

    @Test
    public void testConvertToInt() {
        assertEquals(0, PA1c.convertToInt(0.0));
        assertEquals(1, PA1c.convertToInt(1.2));
        assertEquals(2, PA1c.convertToInt(1.5)); // rounds
        assertEquals(-1, PA1c.convertToInt(-1.4));
        assertEquals(-1, PA1c.convertToInt(-1.5));
    }

    @Test
    public void testMainPositiveAmount() {
        String input = "1.41\n"; // $1.41
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        PA1c.main(new String[0]);

        String output = out.toString();
        assertTrue(output.contains("You have 5 quarters, 1 dime, 1 nickel, and 1 penny."));
    }
}
