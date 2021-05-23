package com.experis.tests;

import org.junit.jupiter.api.Test;

import static com.experis.Fibonacci.fibonacci;
import static org.junit.jupiter.api.Assertions.*;

public class FibonacciTest {

    @Test
    public void testFibonacci() {
        int n = 12;
        assertEquals(144, fibonacci(n));

        n = 0;
        assertEquals(0, fibonacci(n));

        n = 1;
        assertEquals(1, fibonacci(n));
    }

}