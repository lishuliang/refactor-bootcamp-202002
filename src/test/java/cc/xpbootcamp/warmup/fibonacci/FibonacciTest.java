package cc.xpbootcamp.warmup.fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciTest {
    @Test
    void should_return_1_when_calculate_given_position_is_1() {
        Fibonacci fibonacci = new Fibonacci(1);
        fibonacci.calculate();

        int result = fibonacci.getFibonacci();

        assertEquals(1, result);
    }

    @Test
    void should_return_3_when_calculate_given_position_is_4() {
        Fibonacci fibonacci = new Fibonacci(4);
        fibonacci.calculate();

        int result = fibonacci.getFibonacci();

        assertEquals(3, result);
    }

}

