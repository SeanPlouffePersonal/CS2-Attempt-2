import org.junit.Test;
import static org.junit.Assert.*;
import java.io.*;

public class PA1dTest {

    // Helper to run main with given input
    private String runWithInput(String input) {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(out));

        try {
            PA1d.main(new String[0]); // safe only for valid input
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        return out.toString().replace("\r\n", "\n"); // normalize line endings
    }

    @Test
    public void testShippingCost() {
        assertEquals(3.5, PA1d.shippingCost(0.5), 0.01);
        assertEquals(3.5, PA1d.shippingCost(1.0), 0.01);
        assertEquals(5.5, PA1d.shippingCost(2.0), 0.01);
        assertEquals(8.5, PA1d.shippingCost(5.0), 0.01);
        assertEquals(10.5, PA1d.shippingCost(15.0), 0.01);
        assertEquals(10.5, PA1d.shippingCost(20.0), 0.01);
    }

    @Test
    public void testMainValidWeight() {
        String input = "2.5\n"; // valid weight
        String output = runWithInput(input);
        assertTrue(output.contains("It will cost $5.50 to ship this package."));
    }

    @Test
    public void testMainEdgeWeight() {
        String input = "1\n"; // edge of first cost bracket
        String output = runWithInput(input);
        assertTrue(output.contains("It will cost $3.50 to ship this package."));
    }

    // Cannot test negative or >20 weight because System.exit stops JVM
}
