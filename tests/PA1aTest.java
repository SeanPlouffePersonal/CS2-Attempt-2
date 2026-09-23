import org.junit.Test;
import static org.junit.Assert.*;
import java.io.*;

public class PA1aTest {

    private String runProgram() {
        // Backup original System.out
        PrintStream originalOut = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        try {
            PA1a.main(new String[0]); // run program
        } finally {
            System.setOut(originalOut); // restore
        }

        return out.toString().replace("\r\n", "\n"); // normalize line endings
    }


    @Test
    public void testHelloWorldPrinted() {
        String output = runProgram().trim(); // trim trailing newline
        assertEquals("Hello World!", output);
    }
}
