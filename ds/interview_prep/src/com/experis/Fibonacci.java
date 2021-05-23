package com.experis;

public class Fibonacci {
    private static final int[] arr = new int[1000];

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return (arr[n] = 1);
        }

        if (arr[n] != 0) {
            return arr[n];
        }

        // n&1 is 1 if n is odd, else 0.
        int k;
        if ((n & 1) == 1) {
            k = (n + 1) / 2;
        }
        else {
            k = (n / 2);
        }

        arr[n] = (n & 1) == 1? (fibonacci(k) * fibonacci(k) +
                fibonacci(k - 1) * fibonacci(k - 1))
                : (2 * fibonacci(k - 1) + fibonacci(k))
                * fibonacci(k);

        return arr[n];
    }

}
