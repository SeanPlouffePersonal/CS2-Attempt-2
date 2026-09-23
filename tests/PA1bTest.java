import org.junit.Test;
import static org.junit.Assert.*;
import java.io.*;

public class PA1bTest {

    private String runWithInput(String input) {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(out));

        try {
            PA1b.main(new String[0]); // works for non-exiting paths
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        return out.toString().replace("\r\n", "\n");
    }

    @Test
    public void testNormalCase() {
        String input = "6\n2\n0\n1\n";
        String output = runWithInput(input);
        assertTrue(output.contains("You have $1.71 in coins."));
    }

    @Test
    public void testZeroCoins() {
        String input = "0\n0\n0\n0\n";
        String output = runWithInput(input);
        assertTrue(output.contains("You have $0.00 in coins."));
    }

    // Cannot test negative coins due to System.exit
}
