import org.junit.Test;
import java.util.Scanner;
import static org.junit.Assert.*;

public class PA2cTest {
    @Test public void testCanMultiply() {
        assertTrue(PA2c.canMultiply(new int[2][3], new int[3][4]));
        assertFalse(PA2c.canMultiply(new int[3][3], new int[2][3]));
    }

    @Test public void testReadMatrix() {
        int[][] matrix = PA2c.readMatrix(new Scanner("2 3 1 2 3 4 5 6"));
        assertArrayEquals(new int[][]{{1, 2, 3}, {4, 5, 6}}, matrix);
    }
}
