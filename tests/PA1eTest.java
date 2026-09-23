import org.junit.Test;
import static org.junit.Assert.*;
import java.io.*;

public class PA1eTest {

    // -------------------
    // Test the utility method
    // -------------------
    @Test
    public void testNumUpperCase() {
        assertEquals(0, PA1e.numUpperCase(""));              // empty string
        assertEquals(0, PA1e.numUpperCase("hello world"));   // all lowercase
        assertEquals(1, PA1e.numUpperCase("Hello world"));   // one uppercase
        assertEquals(6, PA1e.numUpperCase("HeLLo WoRLd"));   // mixed
        assertEquals(0, PA1e.numUpperCase("1234!@#"));       // no letters
        assertEquals(4, PA1e.numUpperCase("ABcdEF"));        // two uppercase letters
    }

    // -------------------
    // Helper to run main with input
    // -------------------
    private String runWithInput(String input) {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(out));

        try {
            PA1e.main(new String[0]);
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        return out.toString().replace("\r\n", "\n"); // normalize line endings
    }

    // -------------------
    // Test main() output
    // -------------------
    @Test
    public void testMainNoUpperCase() {
        String input = "hello world\n";
        String output = runWithInput(input);
        assertTrue(output.contains("There are no uppercase characters."));
    }

    @Test
    public void testMainOneUpperCase() {
        String input = "Hello world\n";
        String output = runWithInput(input);
        assertTrue(output.contains("There is 1 uppercase character in the string."));
    }

//    @Test
//    public void testMainMultipleUpperCase() {
//        String input = "HeLLo WoRLd\n";
//        String output = runWithInput(input);
//        assertTrue(output.contains("There are 8 uppercase characters in the string."));
//    }

    @Test
    public void testMainAllUpperCase() {
        String input = "ABCDEFG\n";
        String output = runWithInput(input);
        assertTrue(output.contains("There are 7 uppercase characters in the string."));
    }
}
