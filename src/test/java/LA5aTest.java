import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LA5aTest {

    @Test
    void addSimplifiesResult() {
        assertArrayEquals(new int[]{0, 1}, LA5a.add(new int[]{1, 2}, new int[]{-4, 8}));
    }

    @Test
    void subtractsFractions() {
        assertArrayEquals(new int[]{13, 24}, LA5a.subtract(new int[]{7, 8}, new int[]{1, 3}));
    }

    @Test
    void multipliesAndSimplifiesFractions() {
        assertArrayEquals(new int[]{1, 2}, LA5a.multiply(new int[]{2, 3}, new int[]{3, 4}));
    }

    @Test
    void dividesAndSimplifiesFractions() {
        assertArrayEquals(new int[]{3, 2}, LA5a.divide(new int[]{3, 4}, new int[]{1, 2}));
    }

    @Test
    void normalizesNegativeDenominator() {
        assertArrayEquals(new int[]{-1, 2}, LA5a.simplify(new int[]{1, -2}));
    }

    @Test
    void formatsWholeNumbersWithoutDenominator() {
        assertEquals("3", LA5a.formatFraction(new int[]{3, 1}));
        assertEquals("3/4", LA5a.formatFraction(new int[]{3, 4}));
    }

    @Test
    void rejectsDivisionByZero() {
        assertThrows(IllegalArgumentException.class,
                () -> LA5a.divide(new int[]{1, 2}, new int[]{0, 5}));
    }
}
