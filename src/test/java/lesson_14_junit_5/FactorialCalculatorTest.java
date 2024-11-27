package lesson_14_junit_5;

import lesson14.FactorialCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

class FactorialCalculatorTest {
    @DisplayName("Тестирование вычисления факториала для нуля")
    @Test
    public void testFactorialOfZero() {
        assertEquals(1, FactorialCalculator.factorial(0));
    }
    @DisplayName("Тестирование вычисления факториала для положительных чисел")
    @Test
    public void testFactorialOfPositiveNumber() {
        assertEquals(120, FactorialCalculator.factorial(5));
    }
    @DisplayName("Тестирование вычисления факториала для еденицы")
    @Test
    public void testFactorialOfOne() {
        assertEquals(1, FactorialCalculator.factorial(1));
    }
    @DisplayName("Тестирование вычисления факториала исключения для отрицательного числа ")
    @Test
    public void testFactorialThrowsExceptionForNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> FactorialCalculator.factorial(-1));
    }
}
