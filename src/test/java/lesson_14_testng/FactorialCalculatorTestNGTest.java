package lesson_14_testng;

import lesson14.FactorialCalculator;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.expectThrows;

public class FactorialCalculatorTestNGTest {

    @Test
    public void testFactorialOfZero() {
        assertEquals(FactorialCalculator.factorial(0), 1);
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        assertEquals(FactorialCalculator.factorial(5), 120);
    }

    @Test
    public void testFactorialOfOne() {
        assertEquals(FactorialCalculator.factorial(1), 1);
    }

    @Test
    public void testFactorialThrowsExceptionForNegativeNumber() {
        expectThrows(IllegalArgumentException.class, () -> FactorialCalculator.factorial(-1));
    }
}
