import org.junit.Test;
import static org.junit.Assert.*;

public class PA2aTest {
    @Test public void testGetDigit() {
        assertEquals(7, PA2a.getDigit(7));
        assertEquals(7, PA2a.getDigit(16));
    }

    @Test public void testKnownCardNumbers() {
        assertTrue(PA2a.isValid("4388576018410707"));
        assertFalse(PA2a.isValid("4388576018402626"));
    }
}
