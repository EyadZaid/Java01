package com.experis;

import org.junit.jupiter.api.Test;

import static com.experis.Fibonacci.fibonacci;
import static org.junit.jupiter.api.Assertions.*;

public class FibonacciTest {

    @Test
    public void testFibonacci() {
        int n = 12;
        assertEquals(144, fibonacci(n));
    }

}