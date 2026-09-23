import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LA2aTest {
    @Test void countsLettersAndIgnoresSymbols() {
        int[] counts = LA2a.countLetters("A-bA! 9");
        assertEquals(26, counts.length);
        assertEquals(2, counts[0]);
        assertEquals(1, counts[1]);
        assertEquals(0, counts[2]);
    }
    @Test void comparesLengthsAndValuesWithoutBuiltIns() {
        assertTrue(LA2a.sameCounts(new int[]{1, 2}, new int[]{1, 2}));
        assertFalse(LA2a.sameCounts(new int[]{1, 2}, new int[]{2, 1}));
        assertFalse(LA2a.sameCounts(new int[]{1, 2}, new int[]{1, 2, 0}));
    }
    @Test void recognizesAnagramFromCounts() {
        assertTrue(LA2a.sameCounts(LA2a.countLetters("Anagrams!"), LA2a.countLetters("__Ars Magna__")));
        assertFalse(LA2a.sameCounts(LA2a.countLetters("cinema"), LA2a.countLetters("snowman")));
    }
}
