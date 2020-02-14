package cc.xpbootcamp.warmup.fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciTest {
    @Test
    void should_return_1_when_calculate_given_position_is_1() {
        Fibonacci fibonacci = new Fibonacci(1);
        fibonacci.calculate();

        long result = fibonacci.getFibonacci();

        assertEquals(1, result);
    }

    @Test
    void should_return_3_when_calculate_given_position_is_4() {
        Fibonacci fibonacci = new Fibonacci(4);
        fibonacci.calculate();

        long result = fibonacci.getFibonacci();

        assertEquals(3, result);
    }

    @Test
    void should_return_144_when_calculate_given_position_is_50() {
        Fibonacci fibonacci = new Fibonacci(50);
        fibonacci.calculate();

        long result = fibonacci.getFibonacci();

        assertEquals(12586269025L, result);
    }

}

