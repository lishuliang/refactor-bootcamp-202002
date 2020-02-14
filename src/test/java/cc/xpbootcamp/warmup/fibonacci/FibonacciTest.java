package cc.xpbootcamp.warmup.fibonacci;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class FibonacciTest {
    @Test
    void should_return_1_when_calculate_given_position_is_1() {
        Fibonacci fibonacci = new Fibonacci(1);

        int calculate = fibonacci.calculate();

        Assert.assertEquals(1, calculate);
    }
}

