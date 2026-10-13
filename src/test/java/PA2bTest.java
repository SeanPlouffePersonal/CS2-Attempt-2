import org.junit.Test;
import static org.junit.Assert.*;

public class PA2bTest {
    @Test public void testHasSequence() {
        int[] values = {3, 3, 5, 5, 5, 5, 4};
        assertTrue(PA2b.hasSequence(values, 4));
        assertFalse(PA2b.hasSequence(values, 5));
    }

    @Test public void testMaximumLength() {
        assertEquals(4, PA2b.maxConsecutiveLength(new int[]{3, 3, 5, 5, 5, 5, 4}));
    }
}
